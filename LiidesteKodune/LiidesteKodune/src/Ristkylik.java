public class Ristkylik extends Kujund implements Arvutused{

    double kylg1;
    double kylg2;
    public Ristkylik(String nimi, double kylg1, double kylg2) {
        super(nimi);
        this.kylg1 = kylg1;
        this.kylg2 = kylg2;
    }

    @Override
    public double arvutaPindala() {
        return kylg1 * kylg2;
    }

    @Override
    public double arvutaYmbermoot() {
        return 2 * (kylg1 + kylg2);
    }

    @Override
    public String tagastaInfo() {
        return nimi + " pindala on " + arvutaPindala() + " ja ümbermõõt on " + arvutaYmbermoot();
    }
}
