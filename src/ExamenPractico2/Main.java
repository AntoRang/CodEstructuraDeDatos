package ExamenPractico2;
import Queue.Queue;
import Stacks.Stack;

/**
 * Created by AntonioRang on 10/19/17.
 */
public class Main {
    public static void main(String[] args) {
        String s = "Mi examen practico de estructura de datos vali popo";
        System.out.println(reverseParentheses(s));

    }


    public static String reverseParentheses(String str){
        Queue<String> letters = new Queue<String>();
        Stack<String> finlet = new Stack<String>();
        char temp;
        boolean flag =false;
        boolean flagS = true;
        int len;
        int count =0;
        String strFinal = "";



        for(int i=0; i<str.length(); i++){

            temp = str.charAt(i);

                switch (temp) {
                    case '(':
                        flag =true;
                        break;
                    case ')':
                        flag = false;
                        flagS = false;
                        while(! flagS){
                            letters.offer(finlet.pop());
                            if(finlet.empty()){
                                flagS =true;
                            }
                        }
                        len = letters.size();
                        for (int k = 0; k < len; k++) {
                            strFinal += letters.remove();
                        }

                        break;

                    default:
                        if(! flag){
                            strFinal += temp;
                        }

                }

                if (flag && temp != '(') {

                    finlet.push(String.valueOf(temp));
                }



        }

        return strFinal;
    }
}
