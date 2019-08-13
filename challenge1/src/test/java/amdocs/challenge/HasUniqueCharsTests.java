package amdocs.challenge;

import amdocs.challenge1.Challenge;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Property of CS
 * Date: 07/08/2019
 *
 * @author qpnguyen
 */
public class HasUniqueCharsTests {
  @Test
  public void shouldReturnTrueWhenAllAreUnique() {
    boolean expected = true;
    boolean actual = Challenge.hasUniqueChars("abcdefghijklm");
    assertEquals(expected, actual);
    expected = true;
    actual = Challenge.hasUniqueChars(" abcC");
    assertEquals(expected, actual);
    expected = true;
    actual = Challenge.hasUniqueChars("iopkgysrwTn");
    assertEquals(expected, actual);
    expected = true;
    actual = Challenge.hasUniqueChars("903kslgoHjREW");
    assertEquals(expected, actual);
    expected = true;
    actual = Challenge.hasUniqueChars("");
    assertEquals(expected, actual);
  }

  @Test
  public void shouldReturnFalseWhenAllAreNotUnique() {
    boolean expected = false;
    boolean actual = Challenge.hasUniqueChars("abb");
    assertEquals(expected, actual);
    expected = false;
    actual = Challenge.hasUniqueChars("   ");
    assertEquals(expected, actual);
    expected = false;
    actual = Challenge.hasUniqueChars("apdofjeuafy");
    assertEquals(expected, actual);
  }
}

