package amdocs.challenge.challenge4;

import amdocs.challenge.challenge4.beans.Article;
import amdocs.challenge.challenge4.controller.ArticleRepo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {
  private static List<Article> articles = new ArrayList<>();
  //private static ArticleService service = new ArticleService();

  @MockBean
  private ArticleRepo articleRepo;

  @Autowired
  private MockMvc mockMvc;

  @BeforeClass
  public static void populateArticles() {
    articles.add(new Article(1, "10 things that you thought were unhealthy"));
    articles.add(new Article(2, "You won't sleep until you read this"));
    articles.add(new Article(3, "I ran out of catchy titles"));
  }

  @Before
  public void clearDB() {
    //service.clear();
    // Add here that dont base on temporary code in ArticleRepo
    Mockito.when(articleRepo.getAll()).thenReturn(new ArrayList<>());
  }

  public void addArticles() {
    Mockito.when(articleRepo.getAll()).thenReturn(articles);

    Mockito.when(articleRepo.findById(Mockito.anyInt())).thenAnswer(invocation -> {
      Integer id = invocation.getArgument(0);
      return articles.stream().filter(article -> article.getId() == id).findFirst();
    });
  }

  @Test
  public void shouldRetrieveNothingFromEmptyDatabase() throws Exception {
    this.mockMvc.perform(get("/articles"))
      .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
      .andExpect(jsonPath("$", hasSize(0)));
  }

  @Test
  public void shouldRetrievePostedArticles() throws Exception {
    addArticles();

    this.mockMvc.perform(get("/articles"))
      .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$", hasSize(articles.size())));
  }

  @Test
  public void shouldAllowUsToFindArticles() throws Exception {
    addArticles();
    Article article = articles.get(0);
    this.mockMvc.perform(get("/articles/" + article.getId()))
      .andExpect(status().isOk())
      .andExpect(jsonPath("id", is(article.getId())))
    ;
  }

  @Test
  public void shouldHandleGetNotFound() throws Exception {
    System.out.println("<PROP::hidden>true");
    this.mockMvc.perform(get("/articles/10"))
      .andExpect(status().isNotFound());
  }

//  public static String asJsonString(final Object obj) {
//    try {
//      final ObjectMapper mapper = new ObjectMapper();
//      final String jsonContent = mapper.writeValueAsString(obj);
//      return jsonContent;
//    } catch (Exception e) {
//      throw new RuntimeException(e);
//    }
//  }

}
