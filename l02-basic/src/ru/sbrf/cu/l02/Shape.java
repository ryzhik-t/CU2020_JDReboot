package ru.sbrf.cu.l02;

public abstract class Shape {

    private double perimeter;
    private double area;

    public Shape() {

    }

    abstract void getInfo();
    abstract double getPerimeter();
    abstract double getArea();

}
