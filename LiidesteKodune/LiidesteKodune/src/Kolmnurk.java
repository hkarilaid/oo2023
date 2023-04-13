public class Kolmnurk extends Kujund implements Arvutused{



    double korgus;
    double alus;
    double kylg1;
    double kylg2;

    public Kolmnurk(String nimi, double korgus, double alus, double kylg1, double kylg2) {
        super(nimi);
        this.korgus = korgus;
        this.alus = alus;
        this.kylg1 = kylg1;
        this.kylg2 = kylg2;
    }


    @Override
    public double arvutaPindala() {
        return (korgus * alus) / 2;
    }

    @Override
    public double arvutaYmbermoot() {
        return kylg1 + kylg2 + alus;
    }

    @Override
    public String tagastaInfo() {
        return nimi + " pindala on " + arvutaPindala() + " ja ümbermõõt on " + arvutaYmbermoot();
    }
}
