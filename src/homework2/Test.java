package homework2;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Integer [] defaultArr = new Integer[10000];

        Random rnd = new Random();
        for (int i = 0; i < defaultArr.length ; i++) {
            defaultArr[i] = rnd.nextInt();
        }

        Integer [] arr1 = defaultArr.clone();
        Integer [] arr2 = defaultArr.clone();
        Integer [] arr3 = defaultArr.clone();


        ArrayImpl<Integer> bubbleArr = new ArrayImpl<>(arr1);
        ArrayImpl<Integer> selectArr = new ArrayImpl<>(arr2);
        ArrayImpl<Integer> insertArr = new ArrayImpl<>(arr3);

        long a = System.currentTimeMillis();
        bubbleArr.sortBubble();
        System.currentTimeMillis();
        System.out.println("sortBubble : " + (System.currentTimeMillis() - a));
        System.out.println("bubbleArr : " + Arrays.toString(bubbleArr.toArray()));

        a = System.currentTimeMillis();
        selectArr.sortSelect();
        System.currentTimeMillis();
        System.out.println("sortSelect : " + (System.currentTimeMillis() - a));
        System.out.println("selectArr : " + Arrays.toString(selectArr.toArray()));

        a = System.currentTimeMillis();
        insertArr.sortInsert();
        System.currentTimeMillis();
        System.out.println("sortInsert : " + (System.currentTimeMillis() - a));
        System.out.println("insertArr : " + Arrays.toString(insertArr.toArray()));


    }
}
