package Prueba;
/**
 * Created by AntonioRang on 10/26/17.
 */
public class Recursión {
    public static void main(String[] args) {

        int[] arr = {6,0,10,2,6,6};
        int[] arr11 = {11,11,0,1,2,4,11};

        System.out.println("Metodo Factorial");
        System.out.println(factorial(6));
        System.out.println("\n");
        System.out.println("Metodo bunnyEars");
        System.out.println(bunnyEars(10));
        System.out.println("\n");
        System.out.println("Metodo bunnyEars2");
        System.out.println(bunnyEars2(10));
        System.out.println("\n");
        System.out.println("Metodo fibonnaci");
        System.out.println(fibonacci(6));
        System.out.println("\n");
        System.out.println("Metodo triangle");
        System.out.println(triangle(2));
        System.out.println("\n");
        System.out.println("Metodo sumDigits");
        System.out.println(sumDigits(1996));
        System.out.println("\n");
        System.out.println("Metodo count7");
        System.out.println(count7(7));
        System.out.println("\n");
        System.out.println("Metodo count8");
        System.out.println(count8(1988));
        System.out.println("\n");
        System.out.println("Metodo countX");
        System.out.println(countX("xxxhixxx"));
        System.out.println("\n");
        System.out.println("Metodo powerN");
        System.out.println(powerN(2,0));
        System.out.println("\n");
        System.out.println("Metodo changeXY");
        System.out.println(changeXY("xxxhixxx"));
        System.out.println("\n");
        System.out.println("Metodo array6");
        System.out.println(array6(arr,0));
        System.out.println("\n");
        System.out.println("Metodo array11");
        System.out.println(array11(arr11,0));

    }

    public static int factorial(int n) {
        if(n==0){
            return 1;
        } else{
            return n * factorial(n-1);
        }
    }

    public static int bunnyEars(int bunnies) {
        if(bunnies==0){
            return 0;
        } else{
            return 2 + bunnyEars(bunnies-1);
        }
    }

    public static int fibonacci(int n) {
        if(n <=1){
            return n;
        }else{
            return fibonacci(n-1) + fibonacci (n-2);
        }
    }

    public static int bunnyEars2(int bunnies) {
        if(bunnies == 0){
            return 0;
        }
        if(bunnies % 2 == 1) {
            return 2 + bunnyEars2(bunnies - 1);
        }
        return 3+bunnyEars2(bunnies-1);

    }

    public static int triangle(int rows) {
        if(rows == 0){
            return 0;
        } else{
            return rows + triangle(rows-1);
        }
    }

    public static int sumDigits(int n) {
        if(n/10 == 0 ){
            return n%10;
        } else{
            return n%10 + sumDigits(n/10);
        }
    }
    public static int count7(int n) {
        int count =0 ;
        if(n/10 == 0 ){
            if(n%10 == 7){
                count+=1;
            }
            return count;
        }
        if(n%10 == 7){
            count+=1;
            return count + count7(n/10);
        }
        return count + count7(n/10);
    }


    public static int count8(int n) {
        int count =0 ;
        if(n/10 == 0 ){
            if(n%10 == 8){
                count+=1;
            }
            return count;
        }
        if(n%10 == 8){
            count++;
            if(n/10%10 == 8){
                count++;
            }
            return count + count8(n/10);
        }
        return count + count8(n/10);
    }

    public static int powerN(int base, int n) {
        if(n==0){
            return 1;
        }
        if(n == 1){
            return base;
        }else{
            return base * powerN(base, n-1);
        }
    }


    public static int countX(String str) {
        int count =0;
        if(str == null || str.length() == 0) {
            return count;
        }
        String letter=str.substring(str.length()-1, str.length());
        if(str.length() == 1){
            if(letter.equals("x")){
                count++;
            }
            return count;
        }
        if(letter.equals("x")){
            count++;
        }
        return count + countX(str.substring(0, str.length()-1));
    }

    public static boolean array6(int[] nums, int index) {
        if(index < 0 || nums.length ==0 ){
            return false;
        }
        boolean temp = false;

        if(index == nums.length-1){
            if(nums[index] == 6){
                temp= true;
            }
            return temp;
        }
        if(nums[index] == 6){
            temp = true;
        }
        return temp || array6(nums, index+1);
    }

    public static int array11(int[] nums, int index) {
        if(index < 0 || nums.length ==0 ){
            return 0;
        }
        int count =0;
        if(index == nums.length-1){
            if(nums[index] == 11){
                count++;
            }
            return count;
        }

        if(nums[index] == 11){
            count ++;
        }
        return count + array11(nums, index+1);
    }

    public static String changeXY(String str) {
        if(str == null || str.length() == 0) {
            return "";
        }

        String temp = str.substring(0,1);

        if(str.length() == 1){
            if(temp.equals("x")){
                temp = "y";
            }
            return temp;
        }
        if(temp.equals("x")){
            temp = "y";
        }


        return temp + changeXY(str.substring(1,str.length()));
    }





}
