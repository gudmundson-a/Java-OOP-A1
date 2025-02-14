public class Raise {
    public static int raiseOneCounter;
    public static int raiseHalfCounter;

    /*
    Här har vi en rekursiv metod som beräknar
    x^k. Vi har en double x som motsvara basen och
    en int k som motsvarar exponenten. X ska alltså
    multipliceras med sig självt k antalet gånger.

    Vi drar bort 1 från k varje gång vi anropar
    funktionen på nytt för att närma oss basfallet.
     */
    public static double recRaiseOne(double x, int k) {
        raiseOneCounter++;
        if (k == 0) {
            return 1;
        } else {
            return x * recRaiseOne(x, k - 1);
        }
    }

    /*
    Här är tanken att skapa en metod som liknar recRaiseOne.
    Den ska alltså vara rekursiv beräkna x^k igen, men den
    här gången vill vi att k ska halveras för varje anrop
    enligt ekvation 4.

    Till att börja med ska man kolla ifall värdet på k==0,
    isåfall ska 1 returneras.
    Är det så att värdet på k är jämt ska x^k/2 * x^k/2 köras.
    Är värdet på k udda ska x*x^k/2 * x^k/2 köras. (fortfarande
    enligt ekvation 4).

    Man ska även se till att skapa en lokal variabel för x^k/2
    och använda den för att få fram slutresultatet.
     */
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

    /*
    I task 9 ska vi göra ett test där man beräknar
    x^k med hjälp av båda metoderna. Man ska skriva ut resultaten
    samt antalet rekursiva anrop som behövdes för att nå basfallet.

    Detta ska appliceras med en loop som räknar från 1-15. Alltså
    vi vill ha ett värde på k som går från 1-15 och kör båda
    metoderna var för sig.
     */
    public static void task9(){
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
        task9();
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
