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

    integers.forEach(
        x -> {
          System.out.println("Custom forEach: " + x);
        });

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
    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).map(x -> x * x).forEach(System.out::println);

    // Streams cannot be reused. A terminal operation closes the stream.
  }

  static void task4() {
    // Task 4: Understand the reduce method

  }

  static void task5() {
    // Task 5: Perform string operations on a stream

  }

  // Task 6: Open the CSV dataset and perform basic stream operations

  static void task6to7() {
    // Task 7: Explore the dataset with streams
  }

  public static void main(String[] args) {
    task3();
  }
}
