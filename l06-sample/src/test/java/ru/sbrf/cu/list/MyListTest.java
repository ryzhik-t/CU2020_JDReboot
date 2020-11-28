package ru.sbrf.cu.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Реализация MyList должна")
class MyListTest {

    MyList<Integer> list;

    @BeforeEach
    public void beforeAll() {
        list = new MyLinkedList<>();
        list.add( 1 );
        list.add( 2 );
        list.add( 10 );
    }

    @DisplayName("добавлять элементы и корректно давать размер")
    @Test
    public void testAdd() {
        assertEquals( 3, list.size() );
    }

    @DisplayName("находить элемент по индексу")
    @Test
    public void testGet() {
        assertEquals( Integer.valueOf( 2 ), list.get( 1 ) );
    }

    @DisplayName("генерировать ошибку при попытке получения элемента, индекс которого больше размера")
    @Test
    public void testGetException() {
        assertThrows(MyLinkedListException.class, () -> list.get(3));
    }

    @DisplayName("удалять по элемент по первому совпадению")
    @Test
    public void testRemoveFirst() {
        list.add( 2 ); // 1 2 10 2
        boolean result = list.remove( 2 ); // 1 10 2
        assertTrue( result );
        assertEquals( Integer.valueOf( 1 ), list.get( 0 ) );
        assertEquals( Integer.valueOf( 10 ), list.get( 1 ) );
        assertEquals( Integer.valueOf( 2 ), list.get( 2 ) );
        assertEquals( 3, list.size() );
    }

    @DisplayName("возвращать false если удаление по элементу не удалось")
    @Test
    public void testRemoveFalse() {
        boolean result = list.remove( 3 );
        assertFalse( result );
        assertEquals( 3, list.size() );
    }

    @DisplayName("кооректно сортировать Integer")
    @Test
    public void testSort() {
        list.add( 6 );
        list.add( 4 );
        // 1,2,10,6,4

        list.sort();

        assertEquals( 5, list.size() );
        assertEquals( Integer.valueOf( 1 ), list.get( 0 ) );
        assertEquals( Integer.valueOf( 2 ), list.get( 1 ) );
        assertEquals( Integer.valueOf( 4 ), list.get( 2 ) );
        assertEquals( Integer.valueOf( 6 ), list.get( 3 ) );
        assertEquals( Integer.valueOf( 10 ), list.get( 4 ) );

        //list.showInfo();
    }

    @DisplayName("сортировать деревом")
    @Test
    public void testSortTree() {
        list.add( 6 );
        list.add( 4 );
        // 1,2,10,6,4

        list.sortTree();

        assertEquals( 5, list.size() );
        assertEquals( Integer.valueOf( 1 ), list.get( 0 ) );
        assertEquals( Integer.valueOf( 2 ), list.get( 1 ) );
        assertEquals( Integer.valueOf( 4 ), list.get( 2 ) );
        assertEquals( Integer.valueOf( 6 ), list.get( 3 ) );
        assertEquals( Integer.valueOf( 10 ), list.get( 4 ) );

        //list.showInfo();
    }

    @DisplayName("сортировать деревом большой список")
    @Test
    public void testSortTreeBig() {
        Random rn  = new Random();
        int min = 10_000_000;
        int max = 19_999_999;

        long startTime;
        long endTime;

        list.add( 6 );
        list.add( 4 );
        // 1,2,10,6,4

        System.out.println("Generate random list");
        startTime = System.nanoTime();
        for (int i = 0; i < 5_000_000; i++) {
            //System.out.println(rn.nextInt((max + 1) - min) + min);
            list.add(rn.nextInt((max + 1) - min) + min);
        }
        endTime = System.nanoTime();
        System.out.println("Milliseconds spent: " + (endTime - startTime) / 1000000);

        list.add( 20_000_000 ); // 1,2,10,6,4,...,20_000_000
        System.out.println("List size: " + list.size());

        System.out.print("Original (first n): ");
        for (int i = 0; i < 10; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.println("Sorting");
        startTime = System.nanoTime();
        //list.sort();
        list.sortTree();
        endTime = System.nanoTime();
        System.out.println("Milliseconds spent: " + (endTime - startTime) / 1000000);

        System.out.print("Sorted (first n): ");
        for (int i = 0; i < 10; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        assertEquals( 5_000_006, list.size() );
        assertEquals( Integer.valueOf( 1 ), list.get( 0 ) );
        assertEquals( Integer.valueOf( 2 ), list.get( 1 ) );
        assertEquals( Integer.valueOf( 4 ), list.get( 2 ) );
        assertEquals( Integer.valueOf( 6 ), list.get( 3 ) );
        assertEquals( Integer.valueOf( 10 ), list.get( 4 ) );
        assertEquals( Integer.valueOf( 20_000_000 ), list.get( 5_000_005 ) );
    }
}