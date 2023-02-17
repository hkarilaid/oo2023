public class World {

    int width;
    int height;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void printMap(int worldWidth, int worldHeight, int playerXcoordinate, int playerYcoordinate, char playerSymbol,
                                 int dragonXcoordinate, int dragonYcoordinate, char dragonSymbol,
                                 int orcXcoordinate, int orcYcoordinate, char orcSymbol) {
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

//    private static int getRandomCoordinate(int worldDimension) {
//        return (int) (Math.random() * (worldDimension - 2) + 1);
//    }

    private void printCharacters(int playerXcoordinate, int playerYcoordinate, char playerSymbol,
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
