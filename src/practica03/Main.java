package practica03;

public class Main {

	public static void main(String[] args) {
//		System.out.println("** Probando el metodo josephus() **");
//
//		LinkedList<String> josephus = new LinkedList<String>();
//	    josephus.addLast("Josephus");
//	    josephus.addLast("Enrique IV");
//	    josephus.addLast("Antonieta");
//	    josephus.addLast("Romeo");
//	    josephus.addLast("Julieta");
//	    josephus.addLast("Capoleto");
//
//	    System.out.println(josephus);
//	    System.out.println("Sobrevivio "+josephus.josephus(3)+ " :D");
//	    System.out.println(josephus);
//
//		System.out.println("** TEST CIRCULAR DOUBLY-LINKEDLIST CLASS **");
//		System.out.println("\t** USING INTEGERS **");
//		LinkedList<Integer> iList = new LinkedList<Integer>();
//
//		System.out.println("Testing: addFirst(i | i >= 0 && i < 10) + toString");
//		System.out.println(iList);
//		for(int i = 0; i < 10; i++) {
//			iList.addFirst(i);
//			System.out.println(iList);
//		}
//		System.out.println();
//
//		System.out.println("Testing: isEmpty + removeFirst + toString");
//		System.out.println(iList);
//		while(!iList.isEmpty()) {
//			iList.removeFirst();
//			System.out.println(iList);
//		}
//		System.out.println();
//
//		System.out.println("Testing: addLast(i | i >= 0 && i < 10) + toString");
//		System.out.println(iList);
//		for(int i=0; i<10; i++) {
//			iList.addLast(i);
//			System.out.println(iList);
//		}
//		System.out.println();
//
//		System.out.println("Testing: isEmpty + removeLast + toString");
//		System.out.println(iList);
//		while(!iList.isEmpty()) {
//			iList.removeLast();
//			System.out.println(iList);
//		}
//		System.out.println();
//
//		System.out.println("Testing: add(2 * i | i >= 0 && i < 10) + toString");
//		System.out.println(iList);
//		for(int i = 0; i < 10; i++) {
//			iList.add(i, i * 2);
//			System.out.println(iList);
//		}
//		System.out.println("Testing: add(4, 7) + toString");
//		iList.add(4, 7);
//		System.out.println(iList);
//		System.out.println("Testing: add(8, 13) + toString");
//		iList.add(8, 13);
//		System.out.println(iList);
//		System.out.println("Testing: add(0, -1) + toString");
//		iList.add(0, -1);
//		System.out.println(iList);
//		System.out.println("Testing: add(size(), 20) + toString");
//		iList.add(iList.size(), 20);
//		System.out.println(iList);
//		System.out.println();
//
//		System.out.println("Testing: remove(6) + toString");
//		System.out.println(iList);
//		iList.remove(6);
//		System.out.println(iList);
//		System.out.println("Testing: remove(new Integer(6)) + toString");
//		iList.remove(new Integer(6));
//		System.out.println(iList);
//		System.out.println();
//
//		System.out.println("Testing: size + indexOf + get");
//		for(int i=0; i<iList.size(); i++) {
//			System.out.println("Get element at index " + iList.indexOf(iList.get(i)) + ": " + iList.get(i));
//		}
//		System.out.println();
//
//		System.out.println("Testing: size + contains");
//		for(int i=0; i<iList.size(); i++) {
//			System.out.println("Is element " + i + " contained in the list? " + iList.contains(i));
//		}
//		System.out.println();
//
//		System.out.println("Testing: getFirst + toString");
//		System.out.println(iList);
//		System.out.println(iList.getFirst());
//		System.out.println();
//
//		System.out.println("Testing: getLast + toString");
//		System.out.println(iList);
//		System.out.println(iList.getLast());
//		System.out.println();
//
//		System.out.println("Testing: set(3, 20) + toString");
//		System.out.println(iList);
//		iList.set(3, 20);
//		System.out.println(iList);
//		System.out.println();
//
//		System.out.println("Testing: toArray");
//		Object[] array = iList.toArray();
//		System.out.println(array);
//		if(array != null) {
//			for(int i=0; i<array.length; i++)
//				System.out.print(array[i] + " ");
//			System.out.println();
//		}
//		System.out.println();
//
//		System.out.println("Testing: clear + toString");
//		System.out.println(iList);
//		iList.clear();
//		System.out.println(iList);
//		System.out.println();
//
//		System.out.println("\t** USING STRINGS **");
//		LinkedList<String> strLinkedList = new LinkedList<String>();
//		strLinkedList.addLast("Hello");
//		strLinkedList.addLast("World");
//		System.out.println(strLinkedList);
//		strLinkedList.remove("World");
//		System.out.println(strLinkedList);
//		System.out.println();
//
//        System.out.println("6 de Noviembre");
//        System.out.println("Ejercicios de Listas Ligadas");
//
//        LinkedList<Integer> lista = new LinkedList<Integer>();
//        for(int i=0;i < 10;i++){
//            lista.addFirst(i);
//        }
//        lista.addFirst(9);
//        lista.addFirst(9);
//        lista.addFirst(9);
//        System.out.println(lista.toString());
//        System.out.println();
//        System.out.println("Metodo Count");
//        System.out.println(lista.count(0));
//        System.out.println();
//        System.out.println("Metodo RemoveFirstOccurrence");
//        System.out.println(lista.toString());
//        System.out.println(lista.removeFirstOccurrence(0));
//        System.out.println(lista.toString());
//        lista.add(6,8);
//        lista.add(8,8);
//        System.out.println();
//        System.out.println("Metodo RemoveLastOccurrence");
//        System.out.println(lista.toString());
//        System.out.println(lista.removeLastOccurrence(8));
//        System.out.println(lista.toString());
//        System.out.println();
//        System.out.println("Metodo LastIndexOf");
//        System.out.println(lista.lastIndexOf(8));


        LinkedList<Integer> iListRemove = new LinkedList<Integer>();

        iListRemove.addLast(9);
        iListRemove.addLast(9);
        iListRemove.addLast(8);
        iListRemove.addLast(1);
        iListRemove.addLast(4);
        iListRemove.addLast(9);
        iListRemove.addLast(91);
        iListRemove.addLast(94);
        iListRemove.addLast(9);

        System.out.println(iListRemove.toString());
//        System.out.println(iListRemove.countValue(9));
        iListRemove.reverseOrder(1,9);
        System.out.println(iListRemove.toString());



	}

}
