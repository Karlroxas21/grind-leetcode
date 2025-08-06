package org.coding.practice.questions.calculate.shape;

// Create a base class "Shape" with methods to calculate the area and perimeter (pure virtual).
// Implement derived classes "Rectangle" and "Circle" that inherit from "Shape"
// and provide their own area and perimeter calculations.

// Area of Rectangle = length * width
// Area of Circle = pie(3.14159) * radius^2

// Perimeter of Rectangle = 2 * (length + width)
// Perimeter of Circle(Circumference) = 2 * pie * radius

abstract class Shape {
    public abstract double area();
    public abstract double perimeter();
}
