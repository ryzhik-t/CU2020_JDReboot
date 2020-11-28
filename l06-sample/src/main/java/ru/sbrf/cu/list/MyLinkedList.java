package ru.sbrf.cu.list;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>, MyQueue<T> {
    private ListItem<T> head = null;
    private ListItem<T> tail = null;
    private int size = 0;

    private class ListItem<T> {
        T value;
        ListItem<T> prev;
        ListItem<T> next;
    }

    @Override
    public void add( T item ) {
        // Создаем новый элемент
        ListItem<T> internalItem = new ListItem<>();
        internalItem.value = item;
        //Если голова ещё не задана - то её присваиваем новому элементу
        if ( head == null ) {
            head = internalItem;
        }
        // Хвост заменяется на новый
        ListItem<T> tempTail = tail;
        tail = internalItem;
        // Связываем старый хвост и новый хвост между собой
        if ( tempTail != null ) {
            tempTail.next = tail;
        }
        tail.prev = tempTail;
        // Двигаемся по счетчику
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    public void showInfo() {
        System.out.println();
        System.out.println("size: " + size);
        System.out.println("head: " + head);
        System.out.println("tail: " + tail);
        if (size == 0) {
            return;
        }
        ListItem<T> internalItem = head;
        for (int i = 0; i < size; i++) {
            System.out.println();
            System.out.println("element #" + i + " (value: " + internalItem.value + ")");
            System.out.println("  prev: " + internalItem.prev);
            System.out.println("  this: " + internalItem + " *");
            System.out.println("  next: " + internalItem.next);
            internalItem = internalItem.next;
        }
    }

    @Override
    public T get( int index ) {
        // TODO Ошибка если индекс больше размера (+)
        if (index >= size) {
            throw new MyLinkedListException();
        }
        // TODO Если индекс > size/2 - то перебираем от tail (+)
        boolean findFromTail = index > size / 2;
        int currPosition = findFromTail ? size - 1 : 0;
        T result = null;
        ListItem<T> item = findFromTail ? tail : head;
        // Пошли перебирать элементы пока не дойдем до индекса или же не выйдем за размеры списка
        while ( result == null && (findFromTail == (currPosition > size / 2)) ) {
            if ( index == currPosition ) {
                result = item.value;
            }
            item = findFromTail ? item.prev : item.next;
            if (findFromTail) currPosition--;
            else currPosition++;
        }
        return result;
    }

    @Override
    public boolean remove( T item ) {
        // TODO Реализовать (+)
        if (size == 0) {
            return false;
        }
        ListItem<T> internalItem = head; // поиск с головы
        int currPosition = 0;
        do {
            // нашли элемент
            if (internalItem.value == item) {
                // если элемент является головой, переключаем указатель головы на следующий элемент
                // иначе переключаем предыдущий элемент на следующий элемент
                if (internalItem == head) {
                    head = internalItem.next;
                    head.prev = null;
                }
                else {
                    internalItem.prev.next = internalItem.next;
                }
                // если элемент является хвостом, переключаем указатель хвоста на предыдущий элемент
                // иначе переключаем следующий элемент на предыдущий элемент
                if (internalItem == tail) {
                    tail = internalItem.prev;
                    tail.next = null;
                }
                else {
                    internalItem.next.prev = internalItem.prev;
                }
                // отвязываем найденный элемент от цепочки
                internalItem.prev = null;
                internalItem.next = null;
                // уменьшаем размер на 1
                size--;
                // возврат
                return true;
            }
            internalItem = internalItem.next;
            currPosition++;
        }
        while (currPosition < size);

        // не нашли элемент
        return false;
    }

    @Override
    public T poll() {
        //TODO реализовать (+)
        if (size == 0) {
            return null;
        }
        ListItem<T> polledItem = head;
        // указатель головы смещаем на следующий элемент (либо на null)
        head = polledItem.next;
        // если в списке остались элементы, удаляем ссылку у новой головы на исключаемый элемент
        // в противном случае обнуляем хвост
        if (head != null) {
            head.prev = null;
        }
        else {
            tail = null;
        }
        // отвязываем элемент от списка
        polledItem.next = null;
        // уменьшаем размер списка
        --size;
        // возвращаем значение элемента
        return polledItem.value;
    }

    @Override
    public void sort() {
        boolean wasChange = true;
        while ( wasChange ){
            wasChange = false;
            ListItem<T> first = head;
            ListItem<T> second = head.next;
            while ( second != null ){
                wasChange = wasChange || compareAndReplaceItem(first, second);
                first = second;
                second = second.next;
            }
        }
    }

    private boolean compareAndReplaceItem( ListItem<T> first, ListItem<T> second ) {
        if (second.value.compareTo( first.value ) < 0){

            if (first != head) {
                first.prev.next = second;
                second.prev = first.prev;
            }
            else {
                second.prev = null;
                head = second;
            }

            if (second != tail) {
                second.next.prev = first;
                first.next = second.next;
            }
            else {
                first.next = null;
                tail = first;
            }

            first.prev = second;
            second.next = first;

            return true;
        }
        return false;
    }

    @Override
    public void sortTree() {
        if (size < 2) { return; }

        ListItem<T> item = head;

        Tree tree = new Tree(item);
        for (int i = 1; i < size; i++) {
            item = item.next;
            tree.insert(new Tree(item));
        }

        //BTreePrinter.printNode(tree);

        //tree.traversePrint();
        //System.out.println();

        head = null;
        tail = null;
        size = 0;
        tree.traverseReorder();
    }

    class Tree {
        Tree left;
        Tree right;
        ListItem<T> item;
        T value;

        public Tree(ListItem<T> item) {
            this.item = item;
            value = item.value;
        }

        public void insert(Tree aTree) {
            if (aTree.item.value.compareTo(item.value) < 0) {
                if (left != null) left.insert(aTree);
                else left = aTree;
            } else {
                if (right != null) right.insert(aTree);
                else right = aTree;
            }
        }

        /* print sorted values in one line */
        public void traversePrint() {
            if (left != null)
                left.traversePrint();

            System.out.print(value + " ");

            if (right != null)
                right.traversePrint();
        }

        /* re-create linked list */
        public void traverseReorder() {
            if (left != null)
                left.traverseReorder();

            if (size == 0) {
                head = item;
                item.prev = null;
            }
            else {
                item.prev = tail;
                tail.next = item;
            }

            tail = item;
            item.next = null;
            size++;

            if (right != null)
                right.traverseReorder();
        }
    }
}
