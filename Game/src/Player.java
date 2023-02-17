public class Player {
    int xCoordinate; //castimine ehk teisendamine ühest tüübist teise
    int yCoordinate;
    char symbol;

    //constructor
    public Player(int worldWidth, int worldHeight) {
        this.xCoordinate = getRandomCoordinate(worldWidth);
        this.yCoordinate = getRandomCoordinate(worldHeight);
        this.symbol = 'X';
    }
    private static int getRandomCoordinate(int worldDimension) {
        return (int) (Math.random() * (worldDimension - 2) + 1);
    }
    //public tähendab et mõni teine klass saab ka seda funtsiooni kasutada
    //private tähendab, et seda funktsiooni saab ainult selles klassis kasutada
    public void move(String input) {
        if (input.equals("w")) {
            this.yCoordinate = this.yCoordinate - 1;
        } else if (input.equals("s")) {
            this.yCoordinate = this.yCoordinate + 1;
        } else if (input.equals("a")) {
            this.xCoordinate = this.xCoordinate - 1;
        } else if (input.equals("d")) {
            this.xCoordinate = this.xCoordinate + 1;
        }
    }
}
