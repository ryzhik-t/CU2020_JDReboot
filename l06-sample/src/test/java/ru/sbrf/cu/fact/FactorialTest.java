package ru.sbrf.cu.fact;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Check Factorial")
class FactorialTest {

    Factorial factorial = new Factorial();

    @Test
    @Order(1_000)
    @DisplayName("Check 01. 0! = 1")
    void calcZero() {
        assertEquals(1, factorial.calc(0));
    }

    @Test
    @Order(2_000)
    @DisplayName("Check 02. 1! = 1")
    void calcOne() {
        assertEquals(1, factorial.calc(1));
    }

    @Test
    @Order(3_000)
    @DisplayName("Check 03. 5! = 120")
    void calcFive() {
        assertEquals(120, factorial.calc(5));
    }

    @Test
    @Order(4_000)
    @DisplayName("Check 04. Negative")
    void calcNegative() {
        assertThrows(FactorialNegativeException.class, () -> factorial.calc(-5));
    }

    @Test
    @Order(5_000)
    @DisplayName("Check 05. Overflow")
    void calcOverflow() {
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("12! = " + factorial.calc(12));
        //System.out.println("13! = " + factorial.calc(13));
        //System.out.println("14! = " + factorial.calc(14));
        assertThrows(FactorialException.class, () -> factorial.calc(70));
    }

}