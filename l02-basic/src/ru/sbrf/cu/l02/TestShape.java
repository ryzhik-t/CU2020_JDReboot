package ru.sbrf.cu.l02;

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
            case "s":
                square = new Square(sideA);
                square.getPerimeter();
                square.getArea();
                break;
            case "r":
                rectangle = new Rectangle(sideA, sideB);
                rectangle.getPerimeter();
                rectangle.getArea();
                break;
            case "t":
                triangle = new Triangle(sideA, sideB, angle);
                triangle.getPerimeter();
                triangle.getArea();
                break;
        }

    }

    public static void setOutput(String text) {
        System.out.println(text);
    }

}
