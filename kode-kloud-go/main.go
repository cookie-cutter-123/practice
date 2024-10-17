package main

import (
	"fmt"
	"reflect"
	"strconv"
)

var globalVariable = "I am a global variable"

func main() {
	//basics()
	//types("Igor", 31)
	//printNumbersButSkip3(6)
	arraysPractice()
}

func basics() {
	// Println with variables
	var greeting = "Hello"
	var nameIgor = "Igor"
	fmt.Println("Printing ", greeting, " ", nameIgor)

	// Printf with format specifiers
	var nameJoe = "Joe"
	var grade = 78
	fmt.Printf("Student %s has a grade of %d\n", nameJoe, grade)
	fmt.Printf("Type of nameJoe is a %T\n", nameJoe)

	// Short variable declaration
	age := 30
	fmt.Println("Age is", age)

	// Print global variable
	fmt.Println("Global variable is:", globalVariable)

	// Zero values
	var floatZero float64
	fmt.Printf("Zero value of float64 is %.2f\n", floatZero)

	// User input
	var nameOfUser string
	fmt.Print("Enter your name: ")
	fmt.Scanf("%s", &nameOfUser)
	fmt.Printf("Hello %s\n", nameOfUser)

	// Constants are immutable - their value cannot be changed
	// Constants are untyped unless they are explicitly given type at declaration
	const ageOfUniverse = 13.8
	fmt.Printf("Age of universe is %.1f billion years\n", ageOfUniverse)

	// Flexibility that comes with untyped constants is lost with typed constants
	const typedAgeOfUniverse float64 = 13.8
	fmt.Printf("Age of universe is %.1f billion years\n", typedAgeOfUniverse)
}

func types(name string, someNumber int) {
	// Type of variable
	fmt.Printf("Type of name is a %T\n", name)

	// Type of literal using reflection
	fmt.Printf("Type %v \n", reflect.TypeOf(1000))

	// Type casting
	var f float64 = float64(someNumber)
	fmt.Printf("Number is %.2f\n", f)

	// Convert number to string using strconv
	var s string = strconv.Itoa(someNumber)
	fmt.Printf("Number as string is %q\n", s)

	// Convert string to number using strconv
	i, err := strconv.Atoi(s)
	fmt.Printf("%v, %T\n", i, i)
	fmt.Printf("%v, %T\n", err, err)
}

func printNumbersButSkip3(n int) {
	for i := 1; i < n; i++ {
		if i == 3 {
			continue
		}
		fmt.Println(i)
	}
}

func arraysPractice() {
	// Declare an array with a specific size
	var grades [3]int = [3]int{97, 85, 93}
	fmt.Println(grades)

	// Declare an array without specifying the size
	elements := [...]int{1, 2, 3}
	// Print the length of the array
	fmt.Println(len(elements))
	// Print the element on the second index of the array
	fmt.Println(elements[1])

	// Iterate over an array using range
	for index, element := range grades {
		fmt.Println(index, "=>", element)
	}

	// Two-dimensional array
	arr := [3][2]int{{1, 2}, {3, 4}, {5, 6}}
	fmt.Println(arr[2][1])
}
