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
    void getInfo() {
        System.out.println("[Rectangle] Side A = " + this.sideA + ","
                + " Side B = " + this.sideB + ","
                + " Perimeter = " + this.perimeter + ","
                + " Area = " + this.area
        );
    }

    @Override
    public double getPerimeter() {
        return this.perimeter;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    private void setPerimeter() {
        this.perimeter = (this.sideA + this.sideB) * 2;
    }

    private void setArea() {
        this.area = this.sideA * this.sideB;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        setPerimeter();
        setArea();
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
        setPerimeter();
        setArea();
    }

}
