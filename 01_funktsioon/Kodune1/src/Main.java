import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        double summa = getInput();
        String pilet = getPiletiraha(summa);
        System.out.println(pilet);
        System.out.println("Sul on veel vaja: " + getMissing(summa) + "€");


    }



    private static double getInput() {
        Scanner number = new Scanner(System.in);
        System.out.print("Kui palju sul raha on: ");
        double summa = number.nextDouble();
        return summa;
    }

    private static String getPiletiraha(double summa) {
        if (summa < 10) {
            return "Sul ei ole pileti jaoks raha";
        } else {
            return "Sul on pileti jaoks raha";
        }
    }
    private static double getMissing(double summa) {
        return  10 - summa;
    }




}