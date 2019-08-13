package amdocs.challenge.challenge4.beans;

/**
 * Date: 08/08/2019
 *
 * @author qpnguyen
 */
public class Article {
  private String title;
  private String body;
  private int id;

  public Article() {

  }

  public Article(int id, String title) {
    this.id = id;
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
