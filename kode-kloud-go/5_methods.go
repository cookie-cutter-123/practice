package main

import "fmt"

/* A method augments a function by adding an extra parameter section
immediately after the `func` keyword that accepts a single argument.
That argument is called  a`receiver.
 */

type Circle1 struct {
	radius float64
	area float64
}

func (c *Circle1) calculateArea() {
	const PI = 3.14
	c.area = PI * c.radius * c.radius
}

func methodsPractice() {
	c := Circle1{radius: 5}
	c.calculateArea()
	fmt.Printf("%+v\n", c)
}