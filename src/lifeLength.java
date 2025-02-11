import java.util.Scanner;

public class lifeLength {

    public static int f1(int a0) {
        if (a0 == 0) {
            return 1;
        } else if (a0 % 2 == 0) {
            return a0 / 2;
        } else {
            return a0 * 3 + 1;
        }
    }

    public static int f2(int a0){
        return f1(f1(a0));
    }

    public static int f4(int a0){
        return f2(f2(a0));
    }

    public static int f8(int a0){
        return f4(f4(a0));
    }

    public static int f16(int a0){
        return f8(f8(a0));
    }

    public static int f32(int a0){
        return f16(f16(a0));
    }

    //i = 0 gives correct number of steps while i < n.
    public static int iterateF(int a0, int n){
        for(int i = 0; i < n; i++){
            a0 = f1(a0);
        }
            return a0;
    }

    public static int iterLifeLength(int a0){
        int c = 0;
        while (a0 != 1){
            a0 = f1(a0);
            c++;
        }
        return c;
    }

    public static String intToString(int i, int len){
        return "The life length of " + i + " is "  + len + ".";
    }

    /* Du behöver ha 1 + recLifeLength(f1(a0)) för att närma dig basfallet, +1 gör så att
    antalet steg det tar för att nå basfallet räknas med.
   */
    public static int recLifeLength(int a0){
        if (a0 == 1){
            return 0;
        } else {
            return 1 + recLifeLength(f1(a0));
        }
    }

    public static void task1(){
    Scanner sc = new Scanner(System.in);
    int a0;

    while (true){

       try {
           System.out.println("Pick an integer > 0, (0 to exit)");
           a0 = sc.nextInt();

           if (a0 == 0) {
               System.out.println("Goodbye...");
               break;
           }
           System.out.println("f(" + a0 + ") = " + f1(a0));
       } catch (Exception e) {
           System.out.println("Invalid input, try again. ");
           sc.nextInt();
       }
     }
    }

    public static void task2() {
        Scanner sc = new Scanner(System.in);
        int a0;

        while (true){

            try{
                System.out.println("Pick an integer > 0, (0 to exit)");
                a0 = sc.nextInt();
                if (a0 == 0){
                    break;
                } else {
                    System.out.println("f(1) = " + f1(a0) + ", f(2) = " + f2(a0) + ", f(4) = " + f4(a0) + ", f(8) = " + f8(a0) + ", f(16) = " + f16(a0) + ", f(32) = " + f32(a0));
                }
            } catch (Exception e) {
                System.out.println("Invalid input, try again. ");
                sc.nextInt();
            }
        }
    }

    public static void task3(){

        Scanner sc = new Scanner(System.in);
        int a0;
        int n;

        while (true){

            try{
                System.out.println("Pick an integer > 0, (0 to exit)");

                a0 = sc.nextInt();

                if (a0 == 0){
                    break;
                } else {

                    System.out.println("How many steps would you like to take? ");
                    n = sc.nextInt();
                    System.out.println("After " + n + " steps, the new value is: ");
                    System.out.println(iterateF(a0, n));
                }
            } catch (Exception e) {
                System.out.println("Invalid input, try again. ");
                sc.nextInt();
            }
        }
    }

    public static void task4() {
        for (int i = 1; i <= 15; i++) {
            int len = iterLifeLength(i);
            System.out.println(intToString(i, len));
        }
    }

        public static void task6() {
            for (int i = 1; i <= 15; i++) {
                System.out.println("iterLifeLength: " + iterLifeLength(i) + " recLifeLength: " + recLifeLength(i));
            }
        }

    public static void main(String[] args) {
        int t = 3;

        switch(t){
            case 1: task1(); break;
            case 2: task2(); break;
            case 3: task3(); break;
            case 4: task4(); break;
            case 6: task6(); break;
        }
    }
}


