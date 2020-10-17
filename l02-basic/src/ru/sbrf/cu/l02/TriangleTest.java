package ru.sbrf.cu.l02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    @DisplayName("Check Triangle Side A")
    void getSideA() {
        Triangle triangle = new Triangle(1,1,60);
        triangle.setSideA(2);
        assertEquals(2, triangle.getSideA());
    }

    @Test
    @DisplayName("Check Triangle Side B")
    void getSideB() {
        Triangle triangle = new Triangle(1,1,60);
        triangle.setSideB(2);
        assertEquals(2, triangle.getSideB());
    }

    @Test
    @DisplayName("Check Triangle Angle")
    void getAngle() {
        Triangle triangle = new Triangle(1,1,60);
        triangle.setAngle(90);
        assertEquals(90, triangle.getAngle());
    }

    @Test
    @DisplayName("Check Triangle Perimeter")
    void getPerimeter() {
        Triangle triangle = new Triangle(2,2,60);
        assertEquals(Math.sqrt(Math.pow(2, 2) + Math.pow(2, 2) - (2 * 2 * 2 * Math.cos(Math.toRadians(60)))) + 2 + 2,
                triangle.getPerimeter());
    }

    @Test
    @DisplayName("Check Triangle Area")
    void getArea() {
        Triangle triangle = new Triangle(2,2,60);
        assertEquals(0.5 * 2 * 2 * Math.sin(Math.toRadians(60)),
                triangle.getArea());
    }
}