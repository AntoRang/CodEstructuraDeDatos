package Stacks;

import java.util.Arrays;

/**
 * Created by AntonioRang on 9/14/17.
 */
public class Main {
    public static void main(String[] args) {


        System.out.println("Testing array reversing");
        int[] inputArray = {1, 2, 3, 4, 5};

        Stack<Integer> iStack = new Stack<Integer>();

        for (int i = 0; i < inputArray.length; i++) {
            iStack.push(inputArray[i]);
        }

        int[] outputArray = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            outputArray[i] = iStack.pop();
        }

        System.out.println("Input: " + Arrays.toString(inputArray));
        System.out.println("Output: " + Arrays.toString(outputArray));
        System.out.println();

        System.out.println("Testing train ordering");
        Stack<Integer> train = new Stack<Integer>();
        train.push(3);
        train.push(2);
        train.push(1);
        train.push(3);
        train.push(2);

        System.out.println("Train as it arrived to the station: " + Arrays.toString(train.toArray()));

        Stack<Integer> hs1 = new Stack<Integer>();
        Stack<Integer> hs2 = new Stack<Integer>();
        Stack<Integer> ostack = new Stack<Integer>();

        while(!train.empty()) {
            switch (train.peek()) {
                case 1:
                    ostack.push(train.peek());
                    train.pop();
                    break;
                case 2:
                    hs1.push(train.peek());
                    train.pop();
                    break;
                case 3:
                    hs2.push(train.peek());
                    train.pop();
                    break;
            }
        }
        while(!hs2.empty()){
            train.push(hs2.pop());
        }
        while(!hs1.empty()){
            train.push(hs1.pop());
        }
        while(!ostack.empty()){
            train.push(ostack.pop());
        }

        // TODO: sort the wagons in priority order

        System.out.println("Train ordered by priority: " + Arrays.toString(train.toArray()));
        System.out.println();

        Stack<Integer> towerOne = new Stack<Integer>();
        Stack<Integer> towerTwo = new Stack<Integer>();
        Stack<Integer> towerThree = new Stack<Integer>();

        towerOne.push(3);
        towerOne.push(2);
        towerOne.push(1);

        System.out.println("At the beginning");
        System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
        System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
        System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));


//        // TODO: run a simulation so that towerTwo ends with all discs in correct order.


        towerTwo.push(towerOne.pop());
        towerThree.push(towerOne.pop());
        towerThree.push(towerTwo.pop());
        towerTwo.push(towerOne.pop());
        towerOne.push(towerThree.pop());
        towerTwo.push(towerThree.pop());
        towerTwo.push(towerOne.pop());


        System.out.println("At the end");
        System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
        System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
        System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
        System.out.println();



    }



}
