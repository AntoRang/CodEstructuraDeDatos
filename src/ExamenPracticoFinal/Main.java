package ExamenPracticoFinal;

import Stacks.Stack;
import practica03.LinkedList;

import java.util.Arrays;

/**
 * Created by AntonioRang on 12/4/17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(mystery(4,0));

        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();

        list1.addLast(0);
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(10);
        list1.addLast(11);
        list1.addLast(41);


        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(7);
        list2.addLast(8);

        System.out.println(union(list1, list2).toString());

        insertInOrder(list1, 42);
        System.out.println(list1.toString());

        eraseInOrder(list2, 2, false);
        System.out.println(list2.toString());

        moveToBeginning(list1, 5);
        System.out.println(list1.toString());


        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(2);
        stack1.push(5);
        stack1.push(12);
        stack1.push(24);
        stack1.push(35);
        stack1.push(46);
        stack1.push(60);
        System.out.println(Arrays.toString(stack1.toArray()));
        System.out.println(get(stack1, 7));

        Stack<Integer> stack2 = new Stack<Integer>();
        stack2.push(2);
        stack2.push(5);
        stack2.push(12);
        stack2.push(24);
        stack2.push(35);
        stack2.push(46);
        stack2.push(60);
        System.out.println(Arrays.toString(stack2.toArray()));
        moveToTop(stack2, 2);
        System.out.println(Arrays.toString(stack2.toArray()));


        String[] arr = {"123","398","210", "019", "528","003","513","129","220","294"};

        superSort(arr);


    }

    public static String cleanString(String str){
        return"";
    }

    public static int mystery(int m, int n){
        int nout = n;
        if(m == 0){
            return (n+1);
        }
        if( m >0 &&  n== 0){
            return mystery(m-1,1);
        }
        if(m > 0 && n >0){
            return mystery(m-1,mystery(m,n-1));
        }

        return -1;
    }

    public static LinkedList<Integer> union(LinkedList<Integer> list1, LinkedList<Integer> list2){
        LinkedList<Integer> list3 = new LinkedList<Integer>();

        for(int i=0; i < list1.size(); i++){
            list3.addLast(list1.get(i));
        }
        for(int i=0; i < list2.size(); i++){
            list3.addLast(list2.get(i));
        }
        return list3;
    }

    public static void insertInOrder(LinkedList<Integer> list, int element){
        boolean out = false;
        int i=0;
        while(! out){
            if(list.get(i) > element){
                list.add(i, element);
                out=true;
            }
            if(list.size()-1  == i){
                list.addLast(element);
                out = true;
            }
            i++;
        }
    }

    public static void eraseInOrder(LinkedList<Integer> list, int count, boolean desc){
        if(count > list.size()){
            while (! list.isEmpty()) {
                list.removeFirst();
            }
            return;
        }
        if(desc){
            for(int i=0; i< count;i++){
                list.removeLast();
            }
        }else{
            for(int j=0; j<count;j++){
                list.removeFirst();
            }
        }
    }

    public static void moveToBeginning(LinkedList<Integer> list, int i){
        if(i>list.size()-1){
            throw new IndexOutOfBoundsException();
        }
        int element = list.get(i);
        list.remove(i);
        list.addFirst(element);
    }

    public static int get(Stack<Integer> stackin, int i){

        for(int j=1; j <= i; j++){
            if(stackin.empty()){
                throw new IndexOutOfBoundsException();
            }
            if(j == i){
                return stackin.peek();
            }
            stackin.pop();
        }
        return -1;
    }

    public static void moveToTop(Stack<Integer> stackin, int i){
        Stack<Integer> stackout1 = new Stack<Integer>();
        Stack<Integer> stackout2 = new Stack<Integer>();
        int element;
        int topElement=0;
        while(! stackin.empty()){
            element = stackin.pop();
            stackout1.push(element);
        }


        for(int j=1; j <= i;j++){
            if(stackout1.empty()){
                throw new IndexOutOfBoundsException();
            }
            if(i == j){
                topElement = stackout1.pop();
            }else{
                stackout2.push(stackout1.pop());
            }
        }


        while(! stackout2.empty()){
            stackin.push(stackout2.pop());
        }

        while(! stackout1.empty()){
            stackin.push(stackout1.pop());
        }
        stackin.push(topElement);

    }

    public static void superSort(String[] arr){
        LinkedList<String> buckets0 = new LinkedList<String>();
        LinkedList<String> buckets1 = new LinkedList<String>();
        LinkedList<String> buckets2 = new LinkedList<String>();
        LinkedList<String> buckets3 = new LinkedList<String>();
        LinkedList<String> buckets4 = new LinkedList<String>();
        LinkedList<String> buckets5 = new LinkedList<String>();
        LinkedList<String> buckets6 = new LinkedList<String>();
        LinkedList<String> buckets7 = new LinkedList<String>();
        LinkedList<String> buckets8 = new LinkedList<String>();
        LinkedList<String> buckets9 = new LinkedList<String>();

        String element;
        int len = arr.length;
        int subO = 0;
        int subF = 1;
        for(int i=0;i<arr.length;i++){
            element= arr[i].substring(2,3);
            switch (element){
                case "0":
                    buckets0.addFirst(arr[i]);
                    break;
                case "1":
                    buckets1.addFirst(arr[i]);
                    break;
                case "2":
                    buckets2.addFirst(arr[i]);
                    break;
                case "3":
                    buckets3.addFirst(arr[i]);
                    break;
                case "4":
                    buckets4.addFirst(arr[i]);
                    break;
                case "5":
                    buckets5.addFirst(arr[i]);
                    break;
                case "6":
                    buckets6.addFirst(arr[i]);
                    break;
                case "7":
                    buckets7.addFirst(arr[i]);
                    break;
                case "8":
                    buckets8.addFirst(arr[i]);
                    break;
                case "9":
                    buckets9.addFirst(arr[i]);
                    break;
                default:
                    break;

            }
        }



        int j=0;
        while (!buckets0.isEmpty()) {
            arr[j++] = buckets0.removeLast();
        }
        while (!buckets1.isEmpty()) {
            arr[j++] = buckets1.removeLast();
        }
        while (!buckets2.isEmpty()) {
            arr[j++] = buckets2.removeLast();
        }
        while (!buckets3.isEmpty()) {
            arr[j++] = buckets3.removeLast();
        }
        while (!buckets4.isEmpty()) {
            arr[j++] = buckets4.removeLast();
        }
        while (!buckets5.isEmpty()) {
            arr[j++] = buckets5.removeLast();
        }
        while (!buckets6.isEmpty()) {
            arr[j++] = buckets6.removeLast();
        }
        while (!buckets7.isEmpty()) {
            arr[j++] = buckets7.removeLast();
        }
        while (!buckets8.isEmpty()) {
            arr[j++] = buckets8.removeLast();
        }
        while (!buckets9.isEmpty()) {
            arr[j++] = buckets9.removeLast();
        }

        System.out.println(Arrays.toString(arr));


    }
    public static void orden(String [] arr, int sub0, int subF){
        LinkedList<String> buckets0 = new LinkedList<String>();
        LinkedList<String> buckets1 = new LinkedList<String>();
        LinkedList<String> buckets2 = new LinkedList<String>();
        LinkedList<String> buckets3 = new LinkedList<String>();
        LinkedList<String> buckets4 = new LinkedList<String>();
        LinkedList<String> buckets5 = new LinkedList<String>();
        LinkedList<String> buckets6 = new LinkedList<String>();
        LinkedList<String> buckets7 = new LinkedList<String>();
        LinkedList<String> buckets8 = new LinkedList<String>();
        LinkedList<String> buckets9 = new LinkedList<String>();

        String element;
        int len = arr.length;

        for(int i=0;i<arr.length;i++){

            element= arr[i].substring(sub0,subF);
            switch (element){
                case "0":
                    buckets0.addFirst(arr[i]);
                    break;
                case "1":
                    buckets1.addFirst(arr[i]);
                    break;
                case "2":
                    buckets2.addFirst(arr[i]);
                    break;
                case "3":
                    buckets3.addFirst(arr[i]);
                    break;
                case "4":
                    buckets4.addFirst(arr[i]);
                    break;
                case "5":
                    buckets5.addFirst(arr[i]);
                    break;
                case "6":
                    buckets6.addFirst(arr[i]);
                    break;
                case "7":
                    buckets7.addFirst(arr[i]);
                    break;
                case "8":
                    buckets8.addFirst(arr[i]);
                    break;
                case "9":
                    buckets9.addFirst(arr[i]);
                    break;
                default:
                    break;

            }
        }

    }
}

