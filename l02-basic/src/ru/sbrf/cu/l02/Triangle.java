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
    void getInfo() {
        System.out.println("[Triangle] Side A = " + this.sideA + ","
                + " Side B = " + this.sideB + ","
                + " Angle = " + this.angle + ","
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
        this.perimeter = Math.sqrt(Math.pow(this.sideA, 2) + Math.pow(this.sideB, 2) - (2 * this.sideA * this.sideB * Math.cos(Math.toRadians(this.angle))))
                + this.sideA + this.sideB;
    }

    private void setArea() {
        this.area = 0.5 * this.sideA * this.sideB * Math.sin(Math.toRadians(this.angle));
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

    public void setAngle(double angle) {
        this.angle = angle;
        setPerimeter();
        setArea();
    }

}
