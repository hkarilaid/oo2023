import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        toiduaine kartul = new toiduaine(50, 30, 20);
        toidukomponent kartu = new toidukomponent("Kartul", 100);

        toiduaine hapukoor = new toiduaine(10,40,60);
        toidukomponent hapukoo = new toidukomponent("Hapukoor",30);

        toiduaine vorst = new toiduaine(20,10,70);
        toidukomponent vors = new toidukomponent("Vorst",50);



        String ksonum = kartul.protsendiKontroll();
        System.out.println(ksonum);

        String hsonum = hapukoor.protsendiKontroll();
        System.out.println(hsonum);

        String vsonum = vorst.protsendiKontroll();
        System.out.println(vsonum);

        String rasv2 = kartu.rasvaKogus();
        System.out.println(rasv2);

        String rasv3 = hapukoo.rasvaKogus();
        System.out.println(rasv3);

        String rasv4 = vors.rasvaKogus();
        System.out.println(rasv4);

        List<String> toidud = new ArrayList<>();
        toidud.add("porgand");
        toidud.add("muna");
        System.out.println(toidud);
        toidud.remove("muna");
        System.out.println(toidud);


    }
}