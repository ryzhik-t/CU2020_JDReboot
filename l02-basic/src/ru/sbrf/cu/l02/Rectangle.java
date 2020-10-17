package ru.sbrf.cu.l02;

public class Rectangle extends Shape {

    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        setSideA(sideA);
        setSideB(sideB);
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    @Override
    public double getPerimeter() {
        return (getSideA() + getSideB()) * 2;
    }

    @Override
    public double getArea() {
        return getSideA() * getSideB();
    }

    @Override
    void getInfo() {
        System.out.println("[Rectangle] Side A = " + getSideA() + ","
                + " Side B = " + getSideB() + ","
                + " Perimeter = " + getPerimeter() + ","
                + " Area = " + getArea()
        );
    }

}
