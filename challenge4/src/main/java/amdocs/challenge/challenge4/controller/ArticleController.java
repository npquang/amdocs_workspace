package amdocs.challenge.challenge4.controller;

import amdocs.challenge.challenge4.beans.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Date: 08/08/2019
 *
 * @author qpnguyen
 */
@RestController
public class ArticleController {
  @Autowired
  private ArticleService articleService;

  @GetMapping("/articles")
  public List<Article> getArticles() {
    return articleService.getAll();
  }

  @GetMapping("/articles/{articleId}")
  public Article getArticles(@PathVariable int articleId) {
    Article article = articleService.findById(articleId);
    if (article != null) {
      return article;
    }

    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "article not found");
  }
}
