public class Ring extends Kujund implements Arvutused {

    double raadius;
    public Ring(String nimi, double raadius) {
        super(nimi);
        this.raadius = raadius;
    }

    @Override
    public double arvutaPindala() {
        return Math.PI * Math.pow(raadius, 2);
    }

    @Override
    public double arvutaYmbermoot() {
        return 2 * Math.PI * raadius;
    }

    @Override
    public String tagastaInfo() {
        return nimi + " pindala on " + arvutaPindala() + " ja ümbermõõt on " + arvutaYmbermoot();
    }
}
