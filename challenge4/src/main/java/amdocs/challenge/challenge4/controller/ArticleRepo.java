package amdocs.challenge.challenge4.controller;

import amdocs.challenge.challenge4.beans.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Date: 08/08/2019
 *
 * @author qpnguyen
 */
@Repository
public class ArticleRepo {

  public List<Article> getAll() {
    return new ArrayList<>();
  }

  public Optional<Article> findById(int id) {
    return Optional.empty();
  }
}
