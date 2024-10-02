package main

import "fmt"

var globalVariable = "I am a global variable"

func main()  {
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
}