public class Raise {
    public static int raiseOneCounter;
    public static int raiseHalfCounter;

    public static double recRaiseOne(double x, int k) {
        raiseOneCounter++;
        if (k == 0) {
            return 1;
        } else {
            return x * recRaiseOne(x, k - 1);
        }
    }

    public static double recRaiseHalf(double x, int k){
        raiseHalfCounter++;
            // base case
        if (k == 0){
          return 1.0;
           }
        else if (k % 2 == 0){

            double halfPower = recRaiseHalf(x, k/2);
            return halfPower * halfPower;
           }

        else {
               double halfPower = recRaiseHalf(x, k/2);
               return x * halfPower * halfPower;
        }
    }

    public static void testRaiseMethods(){
        double x = 1.5;
        for (int k = 1; k <= 15; k++){
            raiseHalfCounter = 0;
            raiseOneCounter = 0;

            double resultOne = recRaiseOne(x, k);
            double resultHalf = recRaiseHalf(x, k);

            System.out.println("k = " + k);
            System.out.println("recRaiseOne result = " + resultOne + ", recursive calls = " + raiseOneCounter);
            System.out.println("recRaiseHalf result = " + resultHalf + ", recursive calls = " + raiseHalfCounter);
        }
    }


    public static void main(String[] args) {
        //test cases
//        System.out.println(recRaiseHalf(5, 3));
//        System.out.println(recRaiseHalf(2, 10));
//        System.out.println(recRaiseHalf(5, 0));

//        testRaiseMethods();

//          for (int i = 0; i <= 10000; i++){
//              raiseOneCounter = 0;
//              recRaiseOne(1.0005,i);
//              System.out.println(i + ", " + raiseOneCounter);
//
//         }

//          for(int i = 0; i <= 10000; i++){
//              raiseHalfCounter = 0;
//              recRaiseHalf(1.0005,i);
//              System.out.println(i + ", " + raiseHalfCounter);
//          }

    }
}
