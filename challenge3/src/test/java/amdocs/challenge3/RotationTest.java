package amdocs.challenge3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class RotationTest {
  public String makeWord() {
    String testWord = "";
    String charSet = "abcdefghijklMNOPQRSTUVWXYZ1234567890)(*&^% `<>?/}{+=";
    Random r = new Random();
    for (int i = 0; i < r.nextInt(45) + 2; i++) {
      testWord += charSet.charAt(r.nextInt(charSet.length()));
    }
    return testWord;
  }

  public int sD(String first, String second) {
    int shift = first.concat(first).lastIndexOf(second);
    char[] a = first.toCharArray();
    char[] b = second.toCharArray();
    Arrays.sort(a);
    Arrays.sort(b);
    return shift > -1 && Arrays.equals(a, b) ? first.length() - shift : -1;
  }

  @Test
  public void test() {
    assertEquals(2, CalculateRotation.shiftedDiff("room", "omro"));
    assertEquals(5, CalculateRotation.shiftedDiff("fatigue", "tiguefa"));
    assertEquals(-1, CalculateRotation.shiftedDiff("hoop", "pooh"));
    assertEquals(2, CalculateRotation.shiftedDiff("coffee", "eecoff"));
    assertEquals(4, CalculateRotation.shiftedDiff("eecoff", "coffee"));
    assertEquals(-1, CalculateRotation.shiftedDiff("Moose", "moose"));
    assertEquals(2, CalculateRotation.shiftedDiff("isn't", "'tisn"));
    assertEquals(0, CalculateRotation.shiftedDiff("Esham", "Esham"));
    assertEquals(0, CalculateRotation.shiftedDiff(" ", " "));
    assertEquals(-1, CalculateRotation.shiftedDiff("dog", "god"));
    assertEquals(-1, CalculateRotation.shiftedDiff("  ", " "));
    assertEquals(-1, CalculateRotation.shiftedDiff("doomhouse", "hoodmouse"));
    assertEquals(18, CalculateRotation.shiftedDiff("123456789!@#$%^&*( )qwerty", "9!@#$%^&*( )qwerty12345678"), 18);
    // THE RANDOM TESTS!!!!!!!!
    String[] randomTests = {
      makeWord(), makeWord(), makeWord(), makeWord(),
      makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
      makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
      makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
      makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
      makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
      makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
      makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
      makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
      makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord()
    };
    for (String s : randomTests) {
      Random rand = new Random();
      int fragSize = rand.nextInt(s.length() - 1) + 1;
      String fragmentA = s.substring(fragSize);
      String fragmentB = s.substring(0, fragSize - 1);
      assertEquals(sD(fragmentA.concat(fragmentB), fragmentB.concat(fragmentA)),
        CalculateRotation.shiftedDiff(fragmentA.concat(fragmentB), fragmentB.concat(fragmentA)));
    }
  }
}