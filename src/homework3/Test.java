package homework3;

public class Test {
    public static void main(String[] args) {
        ///Переворачиваем вводимые строки
        String str = "asdf";

        StackImpl<Character> stack = new StackImpl<>(str.length());

        for (int i = 0; i < str.length(); i++) {
            if(!stack.isFull()){
                stack.push(str.charAt(i));
            }
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        ///Test dequeue
        Dequeue<Integer> dequeue = new DequeueImpl<>(5);

        dequeue.insertLeft(3);
        dequeue.insertRight(1);
        dequeue.insertLeft(2);
        dequeue.insertRight(4);
        dequeue.insertLeft(6);
        dequeue.insertRight(10);

        /*while (!dequeue.isEmpty()){
            System.out.print(dequeue.removeLeft() + " ");
        }*/
        while (!dequeue.isEmpty()){
            System.out.print(dequeue.removeRight() + " ");
        }


    }
}
