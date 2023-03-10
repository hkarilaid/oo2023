import java.util.ArrayList;
import java.util.List;

public class LibisevKeskmine {
    //double[] arvudListis;  // pärisarvud
    //double[] keskmised; // salvestuse eesmärgil kõik keskmised
    //int lisatudArvudeArv;
    List<Double> arvudListis = new ArrayList<>();
    List<Double> arvudKeskmisega = new ArrayList<>();

    public LibisevKeskmine(double arv1, double arv2, double arv3) {
      //  arvudListis = new double[3];
      //  arvudListis[0] = arv1;
      //  arvudListis[1] = arv2;
      //  arvudListis[2] = arv3;

        arvudListis.add(arv1);
        arvudListis.add(arv2);
        arvudListis.add(arv3);


    }

    public void lisaArv(double arv) {
        arvudListis.add(arv);
        //kui pole varem midagi lisatud siis arvudKeskmisega suurus on 0
        for (int i = arvudKeskmisega.size(); i < arvudListis.size()-2; i++) {
            double keskmine = arvudListis.get(i) + arvudListis.get(i+1) + arvudListis.get(i+2) / 3;
            arvudKeskmisega.add(keskmine);
        }
       // double[] valjund = new double[arvud.length - 2];  // uue array tegemisel tuleb kohe pikkus ära öelda
      //  for (int i = 0; i < arvud.length-2; i++) {
       //     valjund[i] = (arvud[i] + arvud[i+1] + arvud[i+2]) / 3;
       // }
      //  return valjund;
    }
}
