package main

import "fmt"

type shape interface {
	area() float64
	perimeter() float64
}

type square struct {
	side float64
}

func (s square) area() float64 {
	return s.side * s.side
}

func (s square) perimeter() float64 {
	return 4 * s.side
}

type rect struct {
 	length, width float64
}

func (r rect) area() float64 {
	return r.length * r.width
}

func (r rect) perimeter() float64 {
	return 2 * (r.length + r.width)
}

func printData(s shape) {
	fmt.Println(s)
	fmt.Println("Area is", s.area())
	fmt.Println("Perimeter is", s.perimeter())
}



func interfacePractice() {
	r := rect{length: 5, width: 3}
	s := square{side: 5}
	printData(r)
	printData(s)
}