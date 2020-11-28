package ru.sbrf.cu.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Реализация MyQueue должна")
class MyQueueTest {

    MyQueue<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
        list.add( 1 );
        list.add( 2 );
        list.add( 10 );
    }

    @DisplayName("забирать элемент из очереди FIFO")
    @Test
    void poll() {
        assertEquals(1, list.poll());
        assertEquals(2, list.size());
        list.showInfo();

        assertEquals(2, list.poll());
        assertEquals(1, list.size());
        list.showInfo();

        assertEquals(10, list.poll());
        assertEquals(0, list.size());
        list.showInfo();
    }

    @DisplayName("возвращать null, если в очереди нет элементов")
    @Test
    void pollNull() {
        list.poll();
        list.poll();
        list.poll();
        assertEquals(0, list.size());

        assertNull(list.poll());

        list.showInfo();
    }

}