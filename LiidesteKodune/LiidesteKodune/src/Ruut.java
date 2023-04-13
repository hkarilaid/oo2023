public class Ruut extends Kujund implements Arvutused{

    double kylg;
    public Ruut(String nimi, double kylg) {
        super(nimi);
        this.kylg = kylg;
    }

    @Override
    public double arvutaPindala() {
        return Math.pow(kylg, 2);
    }

    @Override
    public double arvutaYmbermoot() {
        return 4 * kylg;
    }

    @Override
    public String tagastaInfo() {
        return nimi + " pindala on " + arvutaPindala() + " ja ümbermõõt on " + arvutaYmbermoot();
    }
}
