package main

import "fmt"

// A pointer is a variable that holds a memory address of another variable.
// The address-of operator (&) gives us the memory address of a variable.
// The dereference operator (*) gives us the value stored at the memory address.

func pointersPractice() {
	number10 := 10
	fmt.Printf("%T %v \n", &number10, &number10)
	fmt.Printf("%T %v \n", *(&number10), *(&number10))

	var ptrNumber10 *int = &number10
	fmt.Printf("%T %v \n", ptrNumber10, ptrNumber10)

	// Dereferencing a pointer
	*ptrNumber10 = 20
	fmt.Printf("%T %v \n", number10, number10)

	// Passing by value does not change the original value
	fmt.Println("\nPassing by value:")
	hello := "Hello"
	fmt.Println("Before: ", hello)
	modify(hello)
	fmt.Println("After: ", hello)

	// Passing by reference changes the original value since we are passing the memory address
	fmt.Println("\nPassing by reference:")
	fmt.Println("Before: ", hello)
	modifyPtr(&hello)
	fmt.Println("After: ", hello)

	// Slices are passed by reference by default since they are pointers to an array
	// Maps are also passed by reference
}

func modify(hello string) {
	hello += " world"
}

func modifyPtr(hello *string) {
	*hello += " world"
}