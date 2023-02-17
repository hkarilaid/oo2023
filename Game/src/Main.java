import java.sql.SQLOutput;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input);

        int worldWidth = 10;
        int worldHeight = 5;

        Player player = new Player(worldWidth, worldHeight);
        Dragon dragon = new Dragon(worldWidth, worldHeight);
        Orc orc = new Orc(worldWidth, worldHeight);

        printMap(worldWidth, worldHeight,
                player.xCoordinate, player.yCoordinate, player.symbol,
                dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                orc.xCoordinate, orc.yCoordinate, orc.symbol);

        while (!input.equals("end")) {
            player.move(input);

            printMap(worldWidth, worldHeight,
                    player.xCoordinate, player.yCoordinate, player.symbol,
                    dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                    orc.xCoordinate, orc.yCoordinate, orc.symbol);
            System.out.println();
            input = scanner.nextLine();
        }
    }

    private static void printMap(int worldWidth, int worldHeight, int playerXcoordinate, int playerYcoordinate, char playerSymbol, int dragonXcoordinate, int dragonYcoordinate, char dragonSymbol, int orcXcoordinate, int orcYcoordinate, char orcSymbol) {
        //kõrgus
        // algväärtus    kuni    iga tsükkel
        for (int y = 0; y < worldHeight; y++) {
            System.out.println();
            // laius
            for (int x = 0; x < worldWidth; x++) {
                if (y == 0 || y == worldHeight -1) {
                    System.out.print("-");
                } else if (x == 0 || x == worldWidth -1) {
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