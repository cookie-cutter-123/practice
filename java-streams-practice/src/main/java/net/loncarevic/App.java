package net.loncarevic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class App {

  static void task1() {
    // Task 1: Understand the Stream class in Java and iterate through a stream
    // using forEach

    /*
     * Stream classes: Stream, IntStream, DoubleStream Stream methods: stream()
     * forEach() of() range() findFirst() ifPresent() noneMatch()
     */
    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    System.out.println(integers);

    integers.forEach(System.out::println);

    integers.forEach(x -> System.out.println("Custom forEach: " + x));

    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forEach(System.out::println);
    IntStream.range(1, 10).forEach(System.out::println);

    Stream.of(1, 2, 3).findFirst().ifPresent(System.out::println);

    System.out.println(IntStream.range(1, 4).noneMatch(x -> x > 1));
  }

  static void task2() {
    // Task 2: Perform statistics with numeric streams

    /*
     * Stream methods: mapToInt() sum() count() average() summaryStatistics()
     */
    List<Integer> integers = Arrays.asList(3, 6, 7, 0, 1, 3);
    System.out.println("Sum " + integers.stream().mapToInt(Integer::intValue).sum());
    System.out.println(
        "Summary statistics " + integers.stream().mapToInt(Integer::intValue).summaryStatistics());
  }

  static void task3() {
    // Task 3: Perform basic data processing using the map and filter methods

    /*
     * Stream methods: map filter
     */

    // Map can be chained to a map, since it is an intermediate method.
    // On the other hand, forEach is a terminal method, it cannot be chained.
    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .map(x -> x * x)
        .map(x -> x - 2)
        .forEach(System.out::println);

    // Filter certain values
    Stream.of(2, 6, 9, 0, 1, 3).filter(x -> x > 3).forEach(System.out::println);

    // Streams cannot be reused. A terminal operation closes the stream.
    IntStream intStream = IntStream.range(1, 10);
    System.out.println(intStream.sum());
    // This would throw the error: stream has already been operated upon or closed
    //    System.out.println(intStream.count());
  }

  static void task4() {
    // Task 4: Understand the reduce method
    System.out.println("Sum using reduce: " + Stream.of(1, 2, 3, 4).reduce(0, Integer::sum));
    System.out.println("Product using reduce: " + Stream.of(1, 2, 3, 4).reduce(1, (a, b) -> a * b));
    System.out.println(
        "Custom operation using reduce: " + Stream.of(1, 2, 3, 4).reduce(0, (a, b) -> 2 * a + b));
    System.out.println(
        "String concatenation using reduce: "
            + Stream.of("A", "B", "C", "D").reduce("", (a, b) -> a + b));
  }

  static void task5() {
    // Task 5: Perform string operations on a stream
    Stream.of("key_345", "key_198", "key_902")
        .map(String::toUpperCase)
        .forEach(System.out::println);
    Stream.of("key_345", "key_198", "key_902")
        .map(s -> s.split("_"))
        .map(a -> a[1])
        .mapToInt(Integer::parseInt)
        .forEach(System.out::println);
  }

  // Task 6: Open the CSV dataset and perform basic stream operations

  static void task6to7() {
    // Task 7: Explore the dataset with streams
    class Row {
      final String daily_vaccinations;
      final String country;

      Row(List list) {
        this.daily_vaccinations = (String) list.get(7);
        this.country = (String) list.get(0);
      }

      public String toString() {
        return country + ", " + daily_vaccinations;
      }
    }

    try {
      List<Row> records = new ArrayList<>();
      System.out.println(System.getProperty("user.dir"));
      BufferedReader br =
          new BufferedReader(
              new InputStreamReader(
                  Objects.requireNonNull(
                      App.class.getResourceAsStream("/country_vaccinations.csv"))));

      String line;
      line = br.readLine();
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        records.add(new Row(Arrays.asList(values)));
      }
      // Print the first 10 records
      records.stream().limit(10).forEach(System.out::println);
      // Skip all but the last 10 records
      records.stream().skip((long) records.size() - 10).forEach(System.out::println);
      // Print countries, but only once, using distinct
      records.stream().map(x -> x.country).distinct().forEach(System.out::println);
      // Print the number of rows in the dataset
      System.out.println("Number of rows: " + records.stream().count());
      // Print the number of nulls
      System.out.println(
          "Number of nulls: "
              + records.stream().filter(x -> x.daily_vaccinations.isEmpty()).count());

      // Summation
      System.out.println(
          "Total vactinations in Zimbabwe: "
              + records.stream()
                  .filter(x -> x.country.equals("Zimbabwe"))
                  .filter(x -> !x.daily_vaccinations.isEmpty())
                  .map(x -> x.daily_vaccinations)
                  .mapToDouble(Double::parseDouble)
                  .sum());

      records.stream()
          .map(x -> x.country)
          .distinct()
          .forEach(
              x -> {
                System.out.println(
                    "Total vaccinations in "
                        + x
                        + " = "
                        + records.stream()
                            .filter(y -> y.country.equals(x))
                            .filter(y -> !y.daily_vaccinations.isEmpty())
                            .map(y -> y.daily_vaccinations)
                            .mapToDouble(Double::parseDouble)
                            .sum());
              });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    task6to7();
  }
}
