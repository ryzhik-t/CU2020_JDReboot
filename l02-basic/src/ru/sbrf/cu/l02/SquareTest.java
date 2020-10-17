package ru.sbrf.cu.l02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    @DisplayName("Check Square Side A")
    void getSideA() {
        Square square = new Square(1);
        square.setSideA(3);
        assertEquals(3, square.getSideA());
    }

    @Test
    @DisplayName("Check Square Perimeter")
    void getPerimeter() {
        Square square = new Square(2);
        assertEquals(8, square.getPerimeter());
    }

    @Test
    @DisplayName("Check Square Area")
    void getArea() {
        Square square = new Square(2);
        assertEquals(4, square.getArea());
    }

}