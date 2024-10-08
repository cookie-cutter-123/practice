package net.loncarevic;

import java.util.HashMap;
import java.util.Map;

/** Hello world! */
public class App {
  public static void main(String[] args) {

    //    romanToInt("MCMXCIV");
    //    romanToInt("III");
    //    System.out.println(isValid("{}"));
    System.out.println(isPalindrome(1234321));
  }

  static int romanToInt(String s) {

    Map<Character, Integer> map = new HashMap<>();

    int sum = 0;

    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    s = s.replace("IV", "IIII");
    s = s.replace("IX", "VIIII");
    s = s.replace("XL", "XXXX");
    s = s.replace("XC", "LXXXX");
    s = s.replace("CD", "CCCC");
    s = s.replace("CM", "DCCCC");

    System.out.println(s);

    for (int i = 0; i < s.length(); i++) {
      sum = sum + map.get(s.charAt(i));
    }

    System.out.println(sum);

    return sum;
  }

  public static boolean isValid(String s) {
    while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
      s = s.replace("{}", "");
      s = s.replace("()", "");
      s = s.replace("[]", "");
    }
    return s.isEmpty();
  }

  public static boolean isPalindrome(int x) {
    String xAsString = String.valueOf(x);
    int len = xAsString.length();

    String first = xAsString.substring(0, len / 2);
    StringBuilder second = new StringBuilder(xAsString.substring((len + 1) / 2)).reverse();

    System.out.println(first + "\t" + second);

    return first.contentEquals(second);
  }
}
