package ru.sbrf.cu.l02;

public class Rectangle extends Shape {

    private double sideA;
    private double sideB;

    private double perimeter;
    private double area;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
        setPerimeter();
        setArea();
    }

    @Override
    public void getPerimeter() {
        System.out.println("Perimeter = " + this.perimeter);
    }

    @Override
    public void getArea() {
        System.out.println("Area = " + this.area);
    }

    private void setPerimeter() {
        this.perimeter = (this.sideA + this.sideB) * 2;
    }

    private void setArea() {
        this.area = this.sideA * this.sideB;
    }

}
