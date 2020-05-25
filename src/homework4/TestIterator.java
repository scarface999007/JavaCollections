package homework4;

import homework4.LinkedList;
import homework4.SimpleLinkedListImpl;

import java.util.Iterator;
import java.util.List;

public class TestIterator {

    public static void main(String[] args) {
        int[] array = {1 , 2 , 3};

        for (int i = 0; hasNext(array, i); i++) {
            int value = nextValue(array, i);
            doIt(value);
        }

        System.out.println("---------");

        for (int value : array) {
            System.out.println(value);
        }

        System.out.println("---------");

        List<Integer> jLinkedList = new java.util.LinkedList<>();
        jLinkedList.add(1);
        jLinkedList.add(2);
        jLinkedList.add(3);

        for (Integer value : jLinkedList) {
            System.out.println(value);
        }

        Iterator<Integer> iterator = jLinkedList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
        }

        System.out.println("---------");

        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(3);
        linkedList.insertFirst(2);
        linkedList.insertFirst(1);


        LinkedList.Entry<Integer> current = linkedList.getFirstElement();
        while (hasNextList(current)) {
            Integer value = getNextList(current);
            doIt(value);
            current = current.next;
        }

        //Тест foreach
        SimpleLinkedListImpl<Integer> list = new SimpleLinkedListImpl<>();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);
        for (Integer digit: list) {
            System.out.println("Тест foreach Int = " + digit);
        }
    }

    private static Integer getNextList(LinkedList.Entry<Integer> current) {
        return current.value;
    }

    private static boolean hasNextList(LinkedList.Entry<Integer> current) {
        return current != null;
    }

    private static boolean hasNext(int[] array, int i) {
        return i < array.length;
    }

    private static int nextValue(int[] array, int i) {
        return array[i];
    }

    private static void doIt(int value) {
        System.out.println(value);
    }
}
