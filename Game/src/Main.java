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

        int worldWidth = 10;
        int worldHeight = 5;

        int playerXcoordinate = getRandomCoordinate(worldWidth); //castimine ehk teisendamine ühest tüübist teise
        int playerYcoordinate = getRandomCoordinate(worldHeight);
        char playerSymbol = 'X';
        int dragonXcoordinate = getRandomCoordinate(worldWidth);
        int dragonYcoordinate = getRandomCoordinate(worldHeight);
        char dragonSymbol = 'D';
        int orcXcoordinate = getRandomCoordinate(worldWidth);
        int orcYcoordinate = getRandomCoordinate(worldHeight);
        char orcSymbol = 'O';

        //kõrgus
        // algväärtus    kuni    iga tsükkel
        for (int y = 0; y < worldHeight; y++) {
            System.out.println();
            // laius
            for (int x = 0; x < worldWidth; x++) {
                if (y == 0 || y == worldHeight-1) {
                    System.out.print("-");
                } else if (x == 0 || x == worldWidth-1) {
                    System.out.print("|");
                } else {

                    //parem klõps -> refactor -> extract method
                    printCharacters(playerXcoordinate, playerYcoordinate, playerSymbol,
                            dragonXcoordinate, dragonYcoordinate, dragonSymbol,
                            orcXcoordinate, orcYcoordinate, orcSymbol, y, x);

                }
                //System.out.print(x);
            }
        }
    }

    private static int getRandomCoordinate(int worldDimension) {
        return (int) (Math.random() * (worldDimension - 2) + 1);
    }

    private static void printCharacters(int playerXcoordinate, int playerYcoordinate, char playerSymbol,
                                        int dragonXcoordinate, int dragonYcoordinate, char dragonSymbol,
                                        int orcXcoordinate, int orcYcoordinate, char orcSymbol, int mapY, int mapX) {
        if (playerXcoordinate == mapX && playerYcoordinate == mapY) {
            System.out.print(playerSymbol);
        } else if (dragonXcoordinate == mapX && dragonYcoordinate == mapY) {
            System.out.print(dragonSymbol);
        } else if (orcXcoordinate == mapX && orcYcoordinate == mapY) {
            System.out.print(orcSymbol);
        } else {
            System.out.print(" ");
        }
    }
}