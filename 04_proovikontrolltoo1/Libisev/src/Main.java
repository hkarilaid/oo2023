import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println(keskmine(1,5,9));

        double[] sisend = {3,4,5,6,12};
        System.out.println(Arrays.toString(libisevKeskmine(sisend)));

        LibisevKeskmine libisev = new LibisevKeskmine(2,3,4);
        libisev.lisaArv(4);
        libisev.lisaArv(5);
        System.out.println(libisev.arvudKeskmisega);


    }

    private static double keskmine(double arv1, double arv2, double arv3) {
        return (arv1 + arv2 + arv3) / 3;
    }

    private static double[] libisevKeskmine(double[] arvud) {
        double[] valjund = new double[arvud.length - 2];  // uue array tegemisel tuleb kohe pikkus ära öelda
        for (int i = 0; i < arvud.length-2; i++) {
            valjund[i] = (arvud[i] + arvud[i+1] + arvud[i+2]) / 3;
        }
        return valjund;
    }
}