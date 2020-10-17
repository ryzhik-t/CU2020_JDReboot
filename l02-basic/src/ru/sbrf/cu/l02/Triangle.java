package ru.sbrf.cu.l02;

public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double angle;

    public Triangle(double sideA, double sideB, double angle) {
        setSideA(sideA);
        setSideB(sideB);
        setAngle(angle);
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getSideA() {
        return this.sideA;
    }

    public double getSideB() {
        return this.sideB;
    }

    public double getAngle() {
        return this.angle;
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt(
                Math.pow(getSideA(), 2) + Math.pow(getSideB(), 2)
                        - (2 * getSideA() * getSideB() * Math.cos(Math.toRadians(getAngle())))
        )
                + getSideA() + getSideB();
    }

    @Override
    public double getArea() {
        return 0.5 * getSideA() * getSideB() * Math.sin(Math.toRadians(getAngle()));
    }

    @Override
    void getInfo() {
        System.out.println("[Triangle] Side A = " + getSideA() + ","
                + " Side B = " + getSideB() + ","
                + " Angle = " + getAngle() + ","
                + " Perimeter = " + getPerimeter() + ","
                + " Area = " + getArea()
        );
    }

}
