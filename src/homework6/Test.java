package homework6;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int rightSide = 25;
        int leftSide = -25;
        int balancedTree = 0;
        for (int i = 0; i < 20; i++) {
            Tree<Integer> tree = new TreeImpl<>(4);
            for (int j = 0; j < 15; j++) {
                int rndNum = new Random().nextInt(rightSide - leftSide + 1) + leftSide;
                tree.add(rndNum);
            }
            if(tree.isBalanced()){
                balancedTree++;
                tree.display();
            }
        }
        System.out.println("Несбалансированных деревьев = " + (100 - ((balancedTree/20.0) * 100)) + "%");
    }
}
