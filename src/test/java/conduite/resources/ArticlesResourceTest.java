package conduite.resources;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.GenericType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import conduite.core.Article;
import conduite.db.ArticleDao;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;

@ExtendWith(DropwizardExtensionsSupport.class)
public class ArticlesResourceTest {

	private static final ArticleDao DAO = mock(ArticleDao.class);

	private static final ResourceExtension EXT = ResourceExtension.builder().addResource(new ArticlesResource(DAO))
			.build();

	private GenericType<List<Article>> listArticleType = new GenericType<List<Article>>() {
	};

	@AfterEach
	public void tearDown() {
		reset(DAO);
	}

	@Test
	public void listArticles() {
		List<Article> expected = new ArrayList<Article>();
		expected.add(new Article("first-post", "First Post", "Hello, world"));

		when(DAO.findAll()).thenReturn(expected);

		List<Article> articles = EXT.target("/articles").request().get(listArticleType);

		assertIterableEquals(expected, articles);

		verify(DAO).findAll();
	}
}
