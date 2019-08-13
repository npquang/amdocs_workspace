package amdocs.challenge2;

/**
 * Date: 07/08/2019
 *
 * @author qpnguyen
 */
public class Challenge {
  private final static char MARK_HEADER = '#';

  public static String markdownParser(String string) {
    if (string == null) {
      return "";
    }

    String trimStr = string.trim();

    if (trimStr.isEmpty() || trimStr.charAt(0) != MARK_HEADER) {
      // Return origin
      return string;
    }

    // This is valid, then count the number of hash char
    char[] charArray = trimStr.toCharArray();
    boolean isValid = false;
    int count = 1;
    for (; count < charArray.length; count++) {
      if (charArray[count] == ' ') {
        isValid = true;
        break;
      } else if (charArray[count] != MARK_HEADER) {
        break;
      }
    }

    if (!isValid || count > 6) {
      // Invalid header, return origin
      return string;
    }

    return String.format("<h%d>%s</h%d>", count, trimStr.substring(count).trim(), count);
  }
}
