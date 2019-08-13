package amdocs.challenge.challenge4.controller;

import amdocs.challenge.challenge4.beans.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 08/08/2019
 *
 * @author qpnguyen
 */
@Service
public class ArticleService {
  @Autowired
  private ArticleRepo articleRepo;

  // will retrieve all articles stored
  public List<Article> getAll() {
    return articleRepo.getAll();
  }

  // will use the id to find an article with the same id
  // if none is found, it will return null
  public Article findById(int id) {
    return articleRepo.findById(id).orElse(null);
  }
}
