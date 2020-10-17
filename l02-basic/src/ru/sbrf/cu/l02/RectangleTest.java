package ru.sbrf.cu.l02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    @DisplayName("Check Rectangle Side A")
    void getSideA() {
        Rectangle rectangle = new Rectangle(1, 1);
        rectangle.setSideA(5);
        assertEquals(5, rectangle.getSideA());
    }

    @Test
    @DisplayName("Check Rectangle Side B")
    void getSideB() {
        Rectangle rectangle = new Rectangle(1, 1);
        rectangle.setSideB(8);
        assertEquals(8, rectangle.getSideB());
    }

    @Test
    @DisplayName("Check Rectangle Perimeter")
    void getPerimeter() {
        Rectangle rectangle = new Rectangle(4, 3);
        assertEquals(14, rectangle.getPerimeter());
    }

    @Test
    @DisplayName("Check Rectangle Area")
    void getArea() {
        Rectangle rectangle = new Rectangle(4, 3);
        assertEquals(12, rectangle.getArea());
    }

}