import java.util.List;

public class World {

    int width;
    int height;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void printMap(int worldWidth, int worldHeight, int playerXcoordinate, int playerYcoordinate, char playerSymbol,
                         int dragonXcoordinate, int dragonYcoordinate, char dragonSymbol,
                         int orcXcoordinate, int orcYcoordinate, char orcSymbol, List<Item> items) {
        //kõrgus
        // algväärtus    kuni    iga tsükkel
        char symbol = ' '; //luuakse uus muutuja (deklareerimine), esmakordne väärtuse andmine on initsialiseerimine
        for (int y = 0; y < worldHeight; y++) {
            System.out.println();
            // laius
            for (int x = 0; x < worldWidth; x++) {
                symbol = '-';
                if (y == 0 || y == worldHeight -1) {
                    //System.out.print("-");
                    symbol = '|';
                } else if (x == 0 || x == worldWidth -1) {
                   // System.out.print("|");

                } else {

                    //parem klõps -> refactor -> extract method
                    for (Item i: items){
                        if (i.yCoordinate == y && i.xCoordinate == x) {
                           // System.out.print("I");
                            symbol = 'I';
                            break;
                        }
                    }

                    if (playerXcoordinate == x && playerYcoordinate == y) {
                       // System.out.print(playerSymbol);
                        symbol = playerSymbol;
                    } else if (dragonXcoordinate == x && dragonYcoordinate == y) {
                       // System.out.print(dragonSymbol);
                        symbol = dragonSymbol;
                    } else if (orcXcoordinate == x && orcYcoordinate == y) {
                      //  System.out.print(orcSymbol);
                        symbol = orcSymbol;
                    }


                }
                System.out.print(symbol);
                symbol = ' ';
                //System.out.print(x);
            }
        }
    }

//    private static int getRandomCoordinate(int worldDimension) {
//        return (int) (Math.random() * (worldDimension - 2) + 1);
//    }

}
