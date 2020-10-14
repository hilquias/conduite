package conduite;

import org.jdbi.v3.core.Jdbi;

import conduite.db.ArticleDao;
import conduite.resources.ArticlesResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ConduitApplication extends Application<ConduitConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ConduitApplication().run(args);
    }

    @Override
    public String getName() {
        return "Conduit";
    }

    @Override
    public void initialize(final Bootstrap<ConduitConfiguration> bootstrap) {
		bootstrap.addBundle(new MigrationsBundle<ConduitConfiguration>() {
				@Override
				public DataSourceFactory getDataSourceFactory(ConduitConfiguration configuration) {
					return configuration.getDataSourceFactory();
				}
			});
    }

    @Override
    public void run(final ConduitConfiguration config, final Environment environment) {
		final JdbiFactory factory = new JdbiFactory();
		final Jdbi jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");

		final ArticleDao articleDao = jdbi.onDemand(ArticleDao.class);

		environment.jersey().register(new ArticlesResource(articleDao));
    }

}
