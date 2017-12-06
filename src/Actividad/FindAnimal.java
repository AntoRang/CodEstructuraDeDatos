package Actividad;
import Binary.BinaryNode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by AntonioRang on 11/17/17.
 */
public class FindAnimal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        BinaryNode root = new BinaryNode(4, "Es Mamifero");

        BinaryNode node2 = new BinaryNode(1, "Muerde");

        BinaryNode node1 = new BinaryNode("Perro");
        BinaryNode node3 = new BinaryNode("Gato");

        BinaryNode node5 = new BinaryNode(0, "Tiene escamas");

        //Izquierda
        BinaryNode node7 = new BinaryNode(1, "Respira bajo el agua");
        //Derecha
        BinaryNode node9 = new BinaryNode("Ave");

        BinaryNode node10 = new BinaryNode("Pescado");
        BinaryNode node11 = new BinaryNode("Serpiente");



        //Hijos de Raiz
        root.leftChild = node2;
        root.rightChild = node5;

        //Hijos de Nodo 2
        node2.leftChild = node1;
        node2.rightChild = node3;

        //Hijos de Nodo 5
        node5.leftChild = node7;
        node5.rightChild = node9;


        //Hijos de Nodo 9
        node7.leftChild = node10;
        node7.rightChild = node11;




        ArrayList<String> str;

        String respond;

        System.out.println("Quieres empezar");
        respond = entrada.next();
        while(respond.toUpperCase().equals("SI")) {
            str = pregunta(root);
            if (str.get(str.size() - 1).toUpperCase().equals("NO")) {
                modificarArbol(root, str);
            }
            System.out.println("Quieres volver a jugar?");
            respond = entrada.next();
        }

    }

    public static ArrayList<String> pregunta(BinaryNode node){
        ArrayList<String> respuestas = new ArrayList<String>();
        String respond;
        Scanner entrada = new Scanner(System.in);
        if(node.rightChild == null && node.leftChild == null){
            System.out.println("Tu animal es un " + node.animal+"?");
            respond = entrada.next();
            respuestas.add(respond);

            return respuestas;

        }

        System.out.println(node.qs+"?");
        respond = entrada.next();
        respuestas.add(respond);

        if(respond.toUpperCase().equals("SI")){
            return pregunta(node.leftChild);
        }else{
            return pregunta(node.rightChild);
        }
    }


    public static void modificarArbol(BinaryNode node, ArrayList<String> respuestas){

        String respond;
        Scanner entrada = new Scanner(System.in);
        BinaryNode actualNodo;

        if(respuestas.size()==1) {
            if (respuestas.get(respuestas.size() - 1).equals("SI")) {
                actualNodo = new BinaryNode(node.leftChild.animal);
            } else {
                actualNodo = new BinaryNode(node.rightChild.animal);
            }


            String animalNuevo;


            System.out.println("Cual animal pensaste?");

            respond = entrada.next();
            animalNuevo = respond;


            BinaryNode nuevoNodo = new BinaryNode(animalNuevo);

            System.out.println("Que se diferencia un "+ animalNuevo + " con "+ node.animal+"?");
            respond = entrada.next();


            BinaryNode diferencia = new BinaryNode(1,respond);

            if(respuestas.get(respuestas.size()).toUpperCase().equals("SI")) {
                node.leftChild = diferencia;
            }

            System.out.println("Se diferencia con un si o un no?");
            respond = entrada.next();
            System.out.println(respond);


            if(respond.toUpperCase().equals("SI")){
                node.leftChild.leftChild = nuevoNodo;
                node.leftChild.rightChild = actualNodo;
            }else{
                node.rightChild.leftChild = actualNodo;
                node.rightChild.rightChild = nuevoNodo;
            }

        }


        if(respuestas.get(respuestas.size()-1).equals("NO")) {
            respuestas.remove(respuestas.size() - 1);
            modificarArbol(node.rightChild, respuestas);
        } else {
            respuestas.remove(respuestas.size() - 1);
            modificarArbol(node.leftChild, respuestas);
        }


        }


    }




