package ru.sbrf.cu.l02;

import java.util.Scanner;

public class Figures {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        String ft; // figure type
        double sideA; // figure side A
        double sideB; // figure side B
        double angle = 0; // angle between A and B (for triangle)

        // prompt
        setOutput("Enter figure type:");
        setOutput(" triangle (t)");
        setOutput(" square (s)");
        setOutput(" rectangle (r)");
        ft = scanner.next();

        // check figure type
        if (!ft.equals("t") && !ft.equals("s") && !ft.equals("r")) {
            setOutput("Unknown figure type");
            System.exit(1);
        }

        // get side A
        setOutput("Enter side A:");
        sideA = scanner.nextDouble();

        // get side B
        if (ft.equals("s")) {
            sideB = sideA;
        } else {
            setOutput("Enter side B:");
            sideB = scanner.nextDouble();
        }

        // get angle
        if (ft.equals("t")) {
            setOutput("Enter angle:");
            angle = scanner.nextDouble();
        }

        // calc figure perimeter
        if (ft.equals("s") || ft.equals("r")) {
            setOutput("Perimeter: " + getPerimeterSquare(sideA, sideB));
        } else {
            setOutput("Perimeter: " + getPerimeterTriangle(sideA, sideB, angle));
        }

        // calc figure area
        if (ft.equals("s") || ft.equals("r")) {
            setOutput("Area: " + getAreaSquare(sideA, sideB));
        } else {
            setOutput("Area: " + getAreaTriangle(sideA, sideB, angle));
        }

    }

    public static void setOutput(String text) {
        System.out.println(text);
    }

    public static double getPerimeterSquare(double a, double b) {
        if (a <= 0 || b <= 0) {
            setOutput("Incorrect side length");
            System.exit(1);
        }

        return (a * 2) + (b * 2);
    }

    public static double getPerimeterTriangle(double a, double b, double g) {
        if (a <= 0 || b <= 0) {
            setOutput("Incorrect side length");
            System.exit(1);
        }

        if (g <= 0 || g >= 180) {
            setOutput("Incorrect angle value");
            System.exit(1);
        }

        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) - (2 * a * b * Math.cos(Math.toRadians(g)))) + a + b;
    }

    public static double getAreaSquare(double a, double b) {
        if (a <= 0 || b <= 0) {
            setOutput("Incorrect side length");
            System.exit(1);
        }

        return a * b;
    }

    public static double getAreaTriangle(double a, double b, double g) {
        if (a <= 0 || b <= 0) {
            setOutput("Incorrect side length");
            System.exit(1);
        }

        if (g <= 0 || g >= 180) {
            setOutput("Incorrect angle value");
            System.exit(1);
        }

        return 0.5 * a * b * Math.sin(Math.toRadians(g));
    }
}
