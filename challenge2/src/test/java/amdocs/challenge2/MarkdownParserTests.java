package amdocs.challenge2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 07/08/2019
 *
 * @author qpnguyen
 */
public class MarkdownParserTests {

  private void doTestValidHeader(String header, String expect) {
    assertEquals(expect, Challenge.markdownParser(header));
  }

  private void doTestInvalidHeader(String header) {
    assertEquals(header, Challenge.markdownParser(header));
  }

  @Test
  public void basicValidCases() {
    doTestValidHeader("# Big", "<h1>Big</h1>");
    doTestValidHeader("## Not As Big", "<h2>Not As Big</h2>");
    doTestValidHeader("### Smaller Still", "<h3>Smaller Still</h3>");
    doTestValidHeader("#### Smaller Still", "<h4>Smaller Still</h4>");
    doTestValidHeader("##### Smaller Still", "<h5>Smaller Still</h5>");
    doTestValidHeader("###### So Tiny For a Header", "<h6>So Tiny For a Header</h6>");
  }

  @Test
  public void invalidCases() {
    doTestInvalidHeader("#NoSpace");
    doTestInvalidHeader("Behind # The Scenes");
    doTestInvalidHeader("Wizard# Behind The Curtain");

    assertEquals("", Challenge.markdownParser(null));

    doTestInvalidHeader("");
    doTestInvalidHeader(" ");
    doTestInvalidHeader("  ");

    doTestInvalidHeader("#");
    doTestInvalidHeader("# ");
    doTestInvalidHeader("#  ");
    doTestInvalidHeader("## ");
    doTestInvalidHeader("##  ");
    doTestInvalidHeader("### ");
    doTestInvalidHeader("###  ");
    doTestInvalidHeader("#### ");
    doTestInvalidHeader("####  ");
    doTestInvalidHeader("##### ");
    doTestInvalidHeader("#####  ");
    doTestInvalidHeader("###### ");
    doTestInvalidHeader("######  ");
    doTestInvalidHeader("####### ");
  }

  @Test
  public void edgeCases() {
    doTestValidHeader("### ### Double Triple Header", "<h3>### Double Triple Header</h3>");
    doTestInvalidHeader("####### Snow White and the Seven Hashtags");
    doTestValidHeader("    #### Space Jam      ", "<h4>Space Jam</h4>");
    doTestValidHeader(" ##         Lost In Space          ", "<h2>Lost In Space</h2>");
    doTestValidHeader("# Far        Out, Dude", "<h1>Far        Out, Dude</h1>");
  }
}

