public class Jook extends Toode implements Tooted {


    public Jook(String nimi, double hind, int kogus) {
        super(nimi, hind, kogus);
    }

    @Override
    public String maht() {
        return "Oled ostnud " + kogus + "L " + nimi;
    }

    @Override
    public double hinnad() {
        return kogus * hind;
    }

    @Override
    public String tagastaInfo() {
        return maht() + " " + hinnad() + "€ eest.";
    }
}
