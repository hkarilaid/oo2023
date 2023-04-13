public class Telefon extends Toode implements Tooted{
    String tyyp;
    public Telefon(String nimi, double hind, int kogus, String tyyp) {
        super(nimi, hind, kogus);
        this.tyyp = tyyp;
    }

    @Override
    public String maht() {
        return "Oled ostnud " + nimi + " " + tyyp;
    }

    @Override
    public double hinnad() {
        return kogus * hind;
    }

    @Override
    public String tagastaInfo() {
        return maht() + "i " + hinnad() + "€ eest";
    }
}
