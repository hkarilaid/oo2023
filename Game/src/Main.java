import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //fori teeb for tsükkli
    //sout system out
    public static void main(String[] args) {
//        Random rand = new Random(); //uus instants
//        Math.random(); // static
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
        World world = new World(10,5);
        Player player = new Player(world.width, world.height);
        Dragon dragon = new Dragon(world.width, world.height);
        Orc orc = new Orc(world.width, world.height);

        Item sword = new Item(10,1,"Mõõk", world.width, world.height);
        Item hammer = new Item(5,3,"Haamer", world.width, world.height);
        Item boot = new Item(1,10,"Saabas", world.width, world.height);

        // import java.util.List
        //import java.utill.Arraylist
        //imp0ort arrays
        //list - muudetav
        List<Item> items = new ArrayList<>(Arrays.asList(sword, hammer, boot));

        //array - ei ole muudetav
        Item[] items1 = {sword, hammer, boot};


        world.printMap(world.width, world.height,
                player.xCoordinate, player.yCoordinate, player.symbol,
                dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                orc.xCoordinate, orc.yCoordinate, orc.symbol, items);
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            player.move(input, world);

            world.printMap(world.width, world.height,
                    player.xCoordinate, player.yCoordinate, player.symbol,
                    dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                    orc.xCoordinate, orc.yCoordinate, orc.symbol, items);
            System.out.println();
            for (Item i : items) {
                if (i.xCoordinate == player.xCoordinate && i.yCoordinate == player.yCoordinate) {
                    player.item = i;
                    System.out.println("Korjasid eseme: " + player.item.name);
                    break;
                }
            }
            input = scanner.nextLine();
        }
    }


}