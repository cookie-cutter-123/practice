package net.loncarevic;

public class App {
  public static void main(String[] args) {
    primitiveDataTypes();
  }

  public static void primitiveDataTypes(){
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
}
