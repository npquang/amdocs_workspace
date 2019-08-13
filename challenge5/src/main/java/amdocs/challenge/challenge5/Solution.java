package amdocs.challenge.challenge5;

import java.util.Date;

/**
 * Date: 08/08/2019
 *
 * @author qpnguyen
 */
public class Solution {
  public static class User {
    private String name;
    private boolean loggedIn;
    private Date lastLoggedInAt;

    public User(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public boolean isLoggedIn() {
      return loggedIn;
    }

    public Date getLastLoggedInAt() {
      return lastLoggedInAt;
    }

    public void logIn() {
      loggedIn = true;
      lastLoggedInAt = new Date();
    }

    public void logOut() {
      loggedIn = false;
    }

    public boolean canEdit(Comment comment) {
      return this.equals(comment.getAuthor());
    }

    public boolean canDelete(Comment comment) {
      return false;
    }

    @Override
    public boolean equals(Object obj) {
      // should add more logic in real application
      // for the sake of simplicity, pointer compare will do
      return super.equals(obj);
    }
  }

  public static class Moderator extends User {
    public Moderator(String name) {
      super(name);
    }

    public boolean canDelete(Comment comment) {
      return true;
    }
  }

  public static class Admin extends Moderator {
    public Admin(String name) {
      super(name);
    }

    public boolean canEdit(Comment comment) {
      return true;
    }
  }

  public static class Comment {
    private final User author;
    private final Comment repliedTo;
    private final Date createdAt;
    private String message;

    public Comment(User author, String command) {
      this(author, command, null);
    }

    public Comment(User author, String message, Comment repliedTo) {
      // Author cannot be null
      if (author == null) {
        throw new IllegalArgumentException("author cannot be null"); // any application exception will be fine
      }

      this.author = author;
      this.message = message;
      this.repliedTo = repliedTo;
      this.createdAt = new Date();
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public Date getCreatedAt() {
      return createdAt;
    }

    public User getAuthor() {
      return author;
    }

    public Comment getRepliedTo() {
      return repliedTo;
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(message);
      sb.append(" by ");
      sb.append(author.getName());
      if (repliedTo != null) {
        sb.append(" (replied to ");
        sb.append(repliedTo.getAuthor().getName());
        sb.append(")");
      }

      return sb.toString();
    }
  }
}
