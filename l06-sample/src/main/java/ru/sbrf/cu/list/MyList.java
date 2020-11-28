package ru.sbrf.cu.list;

public interface MyList<T extends Comparable<T>> {
    // Добавить новый элемент в конец списка
    void add(T item);

    // Количество элеметов в списке
    int size();

    // Получить элемент по индексу
    T get(int index);

    // Удалить первый элемент по совпадению. Если не найден - то false
    boolean remove(T item);

    // Допускаем, что T - comparable
    // TODO реализовать другой алгоритм сортировки
    void sort();

    void sortTree();

    // Вывести информацию об объектах списка
    void showInfo();
}
