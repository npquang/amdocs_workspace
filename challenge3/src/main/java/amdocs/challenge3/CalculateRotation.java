package amdocs.challenge3;

/**
 * Date: 07/08/2019
 *
 * @author qpnguyen
 */
public class CalculateRotation {

  public static int shiftedDiff(String string1, String string2) {
    if (string1 == null || string1.isEmpty() || string2 == null || string2.isEmpty() || string1.length() != string2.length()) {
      return -1;
    }

    if (string1.equals(string2)) {
      return 0;
    }

    string2 += string2;

    return string2.indexOf(string1);
  }
}
