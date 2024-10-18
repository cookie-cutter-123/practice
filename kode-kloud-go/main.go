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
	//arraysPractice()
	slicesPractice()
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

func slicesPractice() {
	// In slices, variables can be added or removed
	// A slice has a pointer to the first element, length and capacity

	// Declare a slice
	slice := []int{1, 2, 3, 4, 5}
	fmt.Println(slice)

	// Declare an array and slice it
	arr := [5]int{1, 2, 3, 4, 5}
	slice1 := arr[1:3]
	fmt.Println(slice1)

	// If we change an element in the slice, the original array is changed
	slice1[0] = 100
	fmt.Println("Array is", arr)
	fmt.Println("Slice is", slice1)

	// Create a slice of a slice
	subSlice := slice1[:1]
	fmt.Println(subSlice)

	// Declaring a slice using make
	slice2 := make([]int, 5, 10) // (type, length, capacity)
	fmt.Println(slice2)
	fmt.Printf("Length is %d; capacity is %d\n", len(slice2), cap(slice2))

	// Append to a slice
	slice2 = append(slice2, 1, 2, 3)
	fmt.Println(slice2)

	// Append a slice to a slice
	slice2 = append(slice2, slice1...)
	fmt.Println(slice2)

	// Delete using append and slicing
	arr1 := []int{1, 2, 3, 4, 5}
	i := 2 // index to delete
	arr1 = append(arr1[:i], arr1[i+1:]...)
	fmt.Println(arr1)

	// Copy a slice
	fmt.Println("Copy a slicep")
	srcSlice := []int{10, 20, 30, 40, 50}
	destSlice := make([]int, 3)
	num := copy(destSlice, srcSlice)
	fmt.Println(destSlice)
	fmt.Println("Number of elements copied:", num)
}
