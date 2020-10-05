package ru.sbrf.cu.l02;

public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double angle;

    private double perimeter;
    private double area;

    public Triangle(double sideA, double sideB, double angle) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.angle = angle;
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
        this.perimeter = Math.sqrt(Math.pow(this.sideA, 2) + Math.pow(this.sideB, 2) - (2 * this.sideA * this.sideB * Math.cos(Math.toRadians(this.angle))))
                + this.sideA + this.sideB;
    }

    private void setArea() {
        this.area = 0.5 * this.sideA * this.sideB * Math.sin(Math.toRadians(this.angle));
    }

}
