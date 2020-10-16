package ru.sbrf.cu.l02;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class TestShape {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String shapeType; // shape type
        double sideA; // side A
        double sideB; // side B
        double angle = 0; // angle between side A and side B (for triangle)

        Square square;
        Rectangle rectangle;
        Triangle triangle;

        // prompt
        setOutput("Enter figure type:");
        setOutput(" square (s)");
        setOutput(" rectangle (r)");
        setOutput(" triangle (t)");
        shapeType = scanner.next();

        // check shape type
        if (!shapeType.equals("s") && !shapeType.equals("r") && !shapeType.equals("t")) {
            setOutput("Unknown shape type");
            System.exit(1);
        }

        // get side A
        setOutput("Enter side A:");
        sideA = scanner.nextDouble();

        // get side B
        if (shapeType.equals("s")) {
            sideB = sideA;
        } else {
            setOutput("Enter side B:");
            sideB = scanner.nextDouble();
        }

        // get angle
        if (shapeType.equals("t")) {
            setOutput("Enter angle:");
            angle = scanner.nextDouble();
        }

        switch (shapeType) {
            case "s" -> {
                square = new Square(sideA);
                square.getInfo();
            }
            case "r" -> {
                rectangle = new Rectangle(sideA, sideB);
                rectangle.getInfo();
            }
            case "t" -> {
                triangle = new Triangle(sideA, sideB, angle);
                triangle.getInfo();
            }
        }

    }

    public static void setOutput(String text) {
        System.out.println(text);
    }

    @Test
    public void testSquare() {
        Square square = new Square(5);
        square.getInfo();

        square.setSideA(7);
        square.getInfo();
    }

    @Test
    public void testRectangle() {
        Rectangle rectangle = new Rectangle(5, 3);
        rectangle.getInfo();

        rectangle.setSideA(4);
        rectangle.getInfo();

        rectangle.setSideB(7);
        rectangle.getInfo();

        rectangle.setSideA(7);
        rectangle.getInfo();
    }

    @Test
    public void testTriangle() {
        Triangle triangle = new Triangle(2,2,60);
        triangle.getInfo();

        triangle.setSideA(3);
        triangle.getInfo();

        triangle.setSideB(3);
        triangle.getInfo();

        triangle.setAngle(90);
        triangle.getInfo();
    }

}
