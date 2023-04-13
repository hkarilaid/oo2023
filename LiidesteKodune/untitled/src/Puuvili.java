public class Puuvili extends Toode implements Tooted{

    double kaal;
    public Puuvili(String nimi, double hind, int kogus, double kaal) {
        super(nimi, hind, kogus);
        this.kaal = kaal;
    }

    @Override
    public String maht() {
        return "Oled ostnud " + kogus + "tk " + nimi;
    }

    @Override
    public double hinnad() {
        return (kaal * kogus) * hind;
    }

    @Override
    public String tagastaInfo() {
        return maht() + " " + hinnad() + "€ eest. (kilohind on " + hind + "€)";
    }
}
