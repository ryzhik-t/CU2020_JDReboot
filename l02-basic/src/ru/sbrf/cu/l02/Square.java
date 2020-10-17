package ru.sbrf.cu.l02;

public class Square extends Shape {

    private double sideA;

    public Square(double sideA) {
        setSideA(sideA);
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideA() {
        return this.sideA;
    }

    @Override
    public double getPerimeter() {
        return getSideA() * 4;
    }

    @Override
    public double getArea() {
        return Math.pow(getSideA(), 2);
    }

    @Override
    void getInfo() {
        System.out.println("[Square] Side A = " + getSideA() + ","
                + " Perimeter = " + getPerimeter() + ","
                + " Area = " + getArea()
        );
    }

}
