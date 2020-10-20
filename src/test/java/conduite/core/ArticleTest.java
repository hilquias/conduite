package conduite.core;

import static io.dropwizard.testing.FixtureHelpers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.dropwizard.jackson.Jackson;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ArticleTest {

	private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

	@Test
	public void toJson() throws Exception {
		final Article article = new Article("first-post", "First Post", "Hello, world!");
		final String expected = MAPPER.writeValueAsString(MAPPER.readValue(fixture("fixtures/article.json"), Article.class));
		assertEquals(expected, MAPPER.writeValueAsString(article));
	}

	@Test
	public void fromJson() throws Exception {
		final Article article = new Article("first-post", "First Post", "Hello, world!");
		final Article expected = MAPPER.readValue(fixture("fixtures/article.json"), Article.class);
		assertEquals(expected, article);
	}

}
