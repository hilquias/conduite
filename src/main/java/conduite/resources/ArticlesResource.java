package conduite.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import conduite.core.Article;
import conduite.db.ArticleDao;

@Path("/articles")
@Produces(MediaType.APPLICATION_JSON)
public class ArticlesResource {

    private final ArticleDao articlesDao;

    public ArticlesResource(ArticleDao articlesDao) {
        this.articlesDao = articlesDao;
    }

    @GET
    public List<Article> listArticles() {
        return articlesDao.findAll();
    }

}
