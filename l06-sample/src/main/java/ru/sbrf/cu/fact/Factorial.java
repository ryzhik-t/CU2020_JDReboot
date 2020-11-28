package ru.sbrf.cu.fact;

public class Factorial {

    int calc (int size) {
        if (size < 0) { throw new FactorialNegativeException(); }
        if (size == 0 || size == 1) { return 1; }
        long temp = calc(size - 1) * (long) size;
        if (temp > Integer.MAX_VALUE) { throw new FactorialException(); }
        return (int) temp;
    }

}
