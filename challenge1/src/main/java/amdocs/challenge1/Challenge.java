package amdocs.challenge1;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 07/08/2019
 *
 * @author qpnguyen
 */
public class Challenge {
  public static boolean hasUniqueChars(String string) {
    if (string == null || string.isEmpty()) {
      return true;
    }

    char[] charArray = string.toCharArray();
    Set<Character> set = new HashSet<>(charArray.length);
    for (char c : charArray) {
      if (set.contains(c)) {
        return false;
      } else {
        set.add(c);
      }
    }

    return true;
  }
}
