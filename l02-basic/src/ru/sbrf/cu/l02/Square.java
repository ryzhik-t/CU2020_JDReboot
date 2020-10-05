package ru.sbrf.cu.l02;

public class Square extends Shape {

    private double sideA;

    private double perimeter;
    private double area;

    public Square(double sideA) {
        this.sideA = sideA;
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
        this.perimeter = this.sideA * 4;
    }

    private void setArea() {
        this.area = Math.pow(sideA, 2);
    }
}
