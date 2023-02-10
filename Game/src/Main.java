import java.sql.SQLOutput;

public class Main {

    //fori teeb for tsükkli
    //sout system out
    public static void main(String[] args) {

        System.out.println("Hello world!");
   //     String sonaline = "Sõnaline muutuja";
   //     char taheline = 's';
   //     double komakohaga = 123.321;
  //      float komakohaga2 = 123.321321F;
  //      boolean kahendv22rtus = true;
   //     byte pisikenumber = 127;
   //     short lyhikenumber = 123;
   //     long pikknumber = 12342342354L;

        int playerXcoordinate = 3;
        int playerYcoordinate = 3;
        int dragonXcoordinate = 6;
        int dragonYcoordinate = 2;
        int orcXcoordinate = 5;
        int orcYcoordinate = 1;

        //kõrgus
        // algväärtus    kuni    iga tsükkel
        for (int y = 0; y < 5; y++) {
            System.out.println();
            // laius
            for (int x = 0; x < 10; x++) {
                if (y == 0 || y == 4) {
                    System.out.print("-");
                } else if (x == 0 || x == 9) {
                    System.out.print("|");
                } else {
                    if (playerXcoordinate == x && playerYcoordinate == y) {
                        System.out.print("X");
                    } else if (dragonXcoordinate == x && dragonYcoordinate == y) {
                        System.out.print("D");
                    } else if (orcXcoordinate == x && orcYcoordinate == y) {
                        System.out.print("O");
                    } else {
                        System.out.print(" ");
                    }
                    ;
                }
                //System.out.print(x);
            }
        }
    }
}