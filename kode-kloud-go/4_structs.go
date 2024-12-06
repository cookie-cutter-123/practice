package main

import "fmt"

/* Structs:
- user-defined data types
- a structure that groups together data elements
- provides a way to reference a series of grouped values through a single variable name
- used what it makes sense to group or associate two or more data variables
 */

func structsPractice(){
	type Student struct {
		name string
		rollNo int
		marks []int
		grades map[string]int
	}

	var s Student
	fmt.Printf("%+v\n", s)

	igor := Student{
		name: "Igor",
		rollNo: 12,
	}

	fmt.Printf("%+v\n", igor)
	fmt.Println(igor.name)
	igor.rollNo = 13 // update value
	fmt.Printf("%+v\n", igor)

	c := Circle{x: 5, y: 5, radius: 5, area: 0}
	fmt.Printf("%+v\n", c)
	calculateArea(&c)
	fmt.Printf("%+v\n", c)
}

type Circle struct {
	x int
	y int
	radius float64
	area float64
}

func calculateArea(c *Circle) {
	const PI = 3.14
	var area float64
	area = PI * c.radius * c.radius
	(*c).area = area
}