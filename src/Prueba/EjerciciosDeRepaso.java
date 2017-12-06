package Prueba;

import Queue.Queue;
import practica03.LinkedList;

import java.util.Arrays;

/**
 * Created by AntonioRang on 11/7/17.
 */
public class EjerciciosDeRepaso {
    public static void main(String[] args) {

//        System.out.println("Ejercicios de Recursividad");
//        System.out.println();
//        System.out.println("1.- Maximo comun divisor");
//        System.out.println(gcd(30,12));
//        System.out.println();
//        System.out.println("2.- Exponentes");
//        System.out.println(pow(2,11));
//        System.out.println();
//        System.out.println("4.- Suma de numeros consecutivos");
//        System.out.println(consecutiveAddittion(1,10));
//        System.out.println();
//        System.out.println("5.- Numeros a binario");
//        System.out.println(toBinary(99));
//        System.out.println();

        System.out.println("Ejercicio Filas");
        Queue<Integer> q1 = new Queue<Integer>();
        q1.offer(4);
        q1.offer(7);
        q1.offer(9);
        q1.offer(10);
        q1.offer(15);
        q1.offer(30);
        System.out.println(Arrays.toString(q1.toArray()));

        Queue<Integer> q2 = new Queue<Integer>();
        q2.offer(2);
        q2.offer(3);
        q2.offer(5);
        q2.offer(15);
        q2.offer(16);
        q2.offer(18);
        q2.offer(24);
        q2.offer(31);
        System.out.println(Arrays.toString(q2.toArray()));



        Queue<Integer> merge = merge(q1,q2);
        System.out.println(Arrays.toString(merge.toArray()));




    }

    // Ejercicios de Recursividad

    // 1
    public static int gcd(int m, int n){
        if(m == n){
            return m;
        }
        if(m > n){
            return gcd(m-n,n);
        } else{
            return gcd(m,n-m);
        }

    }

    // 2
    public static int pow(int base, int exponent){
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }else{
            return base * pow(base, exponent-1);
        }
    }

    // 3
    public static int max(LinkedList<Integer> lista){
        LinkedList<Integer> temp = lista;

        return 0;

    }

    // 4
    public static int consecutiveAddittion(int start, int end){
        if(start > end){
            return 0;
        }
        if(start == end){
            return end;
        }else{
            return start + consecutiveAddittion(start + 1, end);
        }

    }

    // 5
    public static String toBinary(int n){

        int mod;
        if(n < 0){
            return "";
        }
        if(n/2 == 0){
            mod = n%2;
            return String.valueOf(mod);
        }else{
            mod = n%2;
            return toBinary(n/2)+ String.valueOf(mod) ;
        }
    }

    // Ejercicios de Filas

    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2){
        Queue<Integer> temp = new Queue<Integer>();
        int tempq1 = q1.remove();
        int tempq2 = q2.remove();
        while(!q1.isEmpty() && !q2.isEmpty()){
            if(tempq1 >= tempq2){
                temp.offer(tempq2);
                tempq2 = q2.remove();


            } else{
                temp.offer(tempq1);
                tempq1 = q1.remove();

            }
        }
        if(tempq1 <= tempq2) {
            temp.offer(tempq1);
            temp.offer(tempq2);
        }
        if(tempq2 < tempq1){
            temp.offer(tempq2);
            temp.offer(tempq1);
        }

        while (!q1.isEmpty()){
            temp.offer(q1.remove());
        }
        while (!q2.isEmpty()){
            temp.offer(q2.remove());
        }

        System.out.println("Queue Q1: "+ Arrays.toString(q1.toArray()));
        System.out.println("Queue Q2: "+ Arrays.toString(q2.toArray()));
        return temp;

    }

    // Ejercicios de Ordenamiento


    public static LinkedList<Integer> bucketSort(LinkedList<Integer> lista){


        return lista;
    }




}
