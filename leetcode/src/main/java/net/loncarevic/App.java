package net.loncarevic;

import java.util.*;

/** Hello world! */
public class App {
  public static void main(String[] args) {

    //    romanToInt("MCMXCIV");
    //    romanToInt("III");
    //    System.out.println(isValid("{}"));
    //    System.out.println(isPalindrome(1234321));
    //    System.out.println(breakPalindrome("aba"));
    //    System.out.println(calculateAmount(List.of(2, 5, 1, 4)));
    //    System.out.println(teams("fer4"));
    System.out.println(removeDuplicates(new int[] {1, 2, 2, 2, 3, 3, 4, 4}));
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

  // https://leetcode.com/problems/break-a-palindrome/
  public static String breakPalindrome(String palindrome) {
    int len = palindrome.length();

    if (len < 2) return "";

    // Change first non-a occurrence
    for (int i = 0; i < len / 2; i++) {
      if (palindrome.charAt(i) != 'a')
        return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
    }

    // If all characters are 'a', change the last one to 'b';
    return palindrome.substring(0, len - 1) + 'b';
  }

  // Hackerrank (Fivetran), but there are similar on leetcode
  public static long calculateAmount(List<Integer> prices) {
    int sum = prices.getFirst();
    int min = prices.getFirst();
    for (int i = 1; i < prices.size(); i++) {
      sum += Math.max(prices.get(i) - min, 0);
      min = Math.min(prices.get(i), min);

      System.out.println(
          "Item: "
              + prices.get(i)
              + ", Min so far: "
              + min
              + ", Discount: "
              + (prices.get(i) - min));
    }
    return sum;
  }

  /*
  Hackerrank (Fivetran)
  The School of Languages and Science teaches five subjects: Physics, Chemistry, Math, Botany, and Zoology.
  Each student is skilled in one subject. The skills of the students are described by string of named skills
  that consists of the letters p, c, m, b, and z only. Each character describes the skill of a student.
  Given a list of students' skills, determine the total number of different teams satisfying the following constraints:
  - A team consists of a group of exactly five students.
  - Each student is skilled in a different subject.
  - A student may only be on one team.
  */
  public static int teams(String skills) {
    // p, c, m, b, z
    int len = skills.length();
    if (len < 5) return 0;
    int countP = 0;
    int countC = 0;
    int countM = 0;
    int countB = 0;
    int countZ = 0;

    for (int i = 0; i < len; i++) {
      if (skills.charAt(i) == 'p') {
        countP++;
      }
      if (skills.charAt(i) == 'c') {
        countC++;
      }
      if (skills.charAt(i) == 'm') {
        countM++;
      }
      if (skills.charAt(i) == 'b') {
        countB++;
      }
      if (skills.charAt(i) == 'z') {
        countZ++;
      }
    }

    return Collections.min(Arrays.asList(countP, countC, countM, countB, countZ));
  }

  // https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
  public static int removeDuplicates(int[] nums) {
    int len = nums.length;
    if (len == 0) return 0;
    int j = 0;
    for (int i = 0; i < len - 1; i++) {
      if (nums[i] != nums[i + 1]) {
        nums[j] = nums[i];
        j++;
      }
    }
    nums[j] = nums[len - 1];
    return j + 1;
  }
}
