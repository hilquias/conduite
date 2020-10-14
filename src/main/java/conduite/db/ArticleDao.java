package conduite.db;

import conduite.core.Article;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface ArticleDao {

	@SqlQuery("SELECT * FROM article")
	@RegisterBeanMapper(Article.class)
	List<Article> findAll();

}
