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
    void getInfo() {
        System.out.println("[Square] Side A = " + this.sideA + ","
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
        this.perimeter = this.sideA * 4;
    }

    private void setArea() {
        this.area = Math.pow(sideA, 2);
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        setPerimeter();
        setArea();
    }

}
