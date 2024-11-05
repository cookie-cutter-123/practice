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
}
