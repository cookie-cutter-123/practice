package main

import "fmt"

func functionsPractice() {
	sum, diff := operation(10, 5)
	fmt.Println("Sum is", sum, "and difference is", diff)

	// Blank identifier
	_, diff1 := operation(10, 5)
	fmt.Println("Difference is", diff1)

	fmt.Println(sumOfNumbers(1, 2, 3, 4, 5))
	printDetails("Igor", "Math", "Science", "English")

	fmt.Println(factorial(5))

	// Anonymous function - generally used when you need a function for a short period of time
	anonymousFunction1 := func(l int, b int) int {
		return l * b
	}
	fmt.Printf("Datatype of x is %T\n", anonymousFunction1)
	fmt.Println(anonymousFunction1(10, 5))

	// Define anonymous function and call it directly
	anonymousFunction2 := func(l int, b int) int {
		return l * b
	}(10, 5)
	fmt.Println(anonymousFunction2)
}

func operation(a int, b int) (sum int, diff int) {
	sum = a + b
	diff = a - b
	return // Return statement without arguments
}

// Variadic function
func sumOfNumbers(numbers ...int) int {
	result := 0
	for _, num := range numbers {
		result += num
	}
	return result
}

// Variadic function
func printDetails(student string, subjects ...string) {
	fmt.Printf("Student %s follows subjects: \n", student)
	for _, subject := range subjects {
		fmt.Println(subject)
	}
}

// Recursive function
func factorial(n int) int {
	if n == 0 {
		return 1
	}
	return n * factorial(n-1)
}

