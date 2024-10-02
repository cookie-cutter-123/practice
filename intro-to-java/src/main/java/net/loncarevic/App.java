package net.loncarevic;

public class App {
  public static void main(String[] args) {
    loopsLab3();
  }

  public static void primitiveDataTypes() {
    int width;
    int height;
    int area;
    double radius = 10.0;
    double pi = 3.14;
    boolean result = true;
    int[] daysInMonths = new int[12];
    String[] monthNames = {
      "January",
      "February",
      "March",
      "April",
      "May",
      "June",
      "July",
      "August",
      "September",
      "October",
      "November",
      "December"
    };

    width = 8;
    height = 12;
    area = 96;

    daysInMonths[0] = 31;
    daysInMonths[1] = 28;
    daysInMonths[2] = 31;
    daysInMonths[3] = 30;
    daysInMonths[4] = 31;
    daysInMonths[5] = 30;
    daysInMonths[6] = 31;
    daysInMonths[7] = 31;
    daysInMonths[8] = 30;
    daysInMonths[9] = 31;
    daysInMonths[10] = 30;
    daysInMonths[11] = 31;

    System.out.println("Hello World!");
    System.out.println("Width: " + width);
    System.out.println("Height: " + height);
    System.out.println("Area: " + area);
    System.out.println("Radius: " + radius);
    System.out.println("Pi: " + pi);
    System.out.println("Result: " + result);

    for (int i = 0; i < daysInMonths.length; i++) {
      System.out.println(monthNames[i] + " has " + daysInMonths[i] + " days.");
    }
  }

  public static void loopsLab3() {
    String[] daysOfWeek = {
      "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    for (int i = 0; i < daysOfWeek.length; i++) {
      System.out.println(daysOfWeek[i]);
    }

    for (String days : daysOfWeek) {
      System.out.println(days);
    }

    for (int i = daysOfWeek.length - 1; i >= 0; i--) {
      System.out.println(daysOfWeek[i]);
    }

    int count = 0;
    while (count <= 20) {
      count++;
      if (count % 2 == 1) {
        continue;
      }
      System.out.println(count);
    }

    for (int i = 0; i <= 100; i++) {
      if (i == 50) i = 61;
      System.out.println(i);
    }

    // This will print one,two,three,four, since there is no break statement in case 2
    String output = "";
    int x = 2;
    switch (x) {
      case 1:
      case 2:
      case 3:
        output += "one,two,three,";
      case 4:
        output += "four,";
        break;
      case 5:
        output += "five,";
        break;
      default:
        output += "six";
        output += "six";
    }
    System.out.println(output);
  }
}
