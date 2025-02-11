import java.util.Scanner;
public class lifeLength {

    //Main metoden med en switch som väljer vilken "task" som ska köras.
    public static void main(String[] args) {
        int n = 1;

        switch(n){
            case 1: task1(); break;
            case 2: task2(); break;
            case 3: task3(); break;
            case 4: task4(); break;
            case 6: task6(); break;
        }
    }

    /*
    Skapa en metod som beräknar f1(a0), om talet är 1 ska vi returnera 1.
    Är talet ett heltal ska det delas med två och returneras.
    Är talet udda ska det gångras med 3, sedan ska 1 adderas och slutligen returneras.
     */
    public static int f1(int a0) {
        if (a0 == 1) {
            return 1;
        } else if (a0 % 2 == 0) {
            return a0 / 2;
        } else {
            return a0 * 3 + 1;
        }
    }

    /*
    Ett gäng metoder som anropar f1 flertalet gånger.
    Ska användas för att visa vilket tal vi befinner oss på
    efter ett visst antal anrop av funktionen.

    f2 ska köra f1 två gånger, f4 ska köra f2 2 gånger osv osv.
     */
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

    /*
    En loop som hjälper oss beräkna vilket värde vi befinner oss på efter n
    antal steg.
     */
    public static int iterateF(int a0, int n){
        for(int i = 0; i < n; i++){
            a0 = f1(a0);
        }
            return a0;
    }

    /*
    En loop som ska hålla koll på hur många gånger man behöver köra
    f(a0) innan man tar sig till 1.
     */
    public static int iterLifeLength(int a0){
        int c = 0;
        while (a0 != 1){
            a0 = f1(a0);
            c++;
        }
        return c;
    }

    /*
    Skapa en metod som ska hjälpa oss skriva ut livslängden när man kör
    funktionen f1(a0) med ett specifikt värde i form av en string.
     */
    public static String intToString(int i, int len){
        return "The life length of " + i + " is "  + len + ".";
    }

    /*
    Här ska vi göra en rekursiv variant där målet är att beräkna
    hur många gånger man behöver köra f1(a0) för att ta oss till basfallet 1.

    Vi behöver ha med 1 + för att den ska räkna hur många gånger
    den behöver köra refLifeLength(f1(a0)) för att nå basfallet.
    Metoden lägger ihop antalet efter "påvägen tillbaka" efter
    den kallat sig själv nog många gånger för att nå basfallet.
     */
    public static int recLifeLength(int a0){
        if (a0 == 1){
            return 0;
        } else {
            return 1 + recLifeLength(f1(a0));
        }
    }

    /*
    I task 1 ska vi ta input från användaren med en scanner.
    Användaren ska få välja ett heltal som ska köras genom
    f1 metoden och sedan returnera dess värde.

    Metoden behöver ha koll på eventuella fel vid input.
    Endast heltal ska accepteras som giltigt input.
    Användaren ska kunna avsluta programmet med genom
    att ge input == 0.
     */
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

    /*
    I task2 ska vi igen ta input från användaren med en scanner.
    Vi behöver kunna hantera fel vid input annat än ett heltal.
    Användaren ska igen kunna avsluta metoden med hjälpa av
    input == 0.

    Vi ska ta input som användaren ger och anropa ett antal
    metoder som beräknar f1 flertalet gånger. Metoderna ska
    ta input som parameter och returnera värdet på a0 efter
    det körts via metoderna. Detta ska skrivas ut till användaren
    med hjälp av en sträng.
     */
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

    /*
    I task tre ska vi igen använda en scanner för att ta
    input från användaren. Vi behöver igen kunna hantera
    fel ifall användaren ger input som ej är ett heltal
    Användaren ska igen kunna avsluta med hjälp av input
    == 0.

    Här ska vi göra en metod som tar input från användaren
    kallar på iterateF med två input från användaren (a0, n) som
    parametrar, dessa två parametrar ska vara ett värde
    som man vill köra genom f1 och den andra parametern
    ska vara hur många gånger man vill köra f1 på det första
    värdet(a0). Metoden ska returnera det nuvarande värdet på (a0)
    efter det körts genom metoden n antalet gånger.
     */
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

    /*
    I task 4 behöver vi skapa en metod som loopar igenom
    från 1-15 och för varje steg så tar den värdet på
    countern (i) och kör iterLifeLength med countern som
    parameter. Sen behöver vi kalla på intToString
    och skriva ut vad vi har för värde på (i) samt
    hur många steg som krävs för värdet på countern
    att nå 1.
     */
    public static void task4() {
        for (int i = 1; i <= 15; i++) {
            int len = iterLifeLength(i);
            System.out.println(intToString(i, len));
        }
    }

    /*
    En metod som ska loopa igenom från 1-15, metoderna iterLifeLength
    och recLifeLength ska ta värdet från countern i som paramater och sedan
    returnera hur många steg det tar för metoden att nå 1 med de givna parameterna.

    Den kommer alltså göra detta med värden från 1-15.
     */
    public static void task6() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("iterLifeLength: " + iterLifeLength(i) + " recLifeLength: " + recLifeLength(i));
        }
    }
}


