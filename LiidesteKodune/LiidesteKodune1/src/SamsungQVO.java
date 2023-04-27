public class SamsungQVO extends SSD implements Arvutused {

    public SamsungQVO(double mahutavus, double garantiiA, double garantiiTB, double hind, double energiaKasutus) {
        super(mahutavus, garantiiA, garantiiTB, hind, energiaKasutus);
    }


    @Override
    public String nimi() {
        return "Samsung 870 QVO 2TB";
    }
    @Override
    public double arvutaPaevaneKirjutamine() {
        return (garantiiTB * 1000) / (garantiiA * 365);
    }

    @Override
    public double arvutaHindPerGB() {
        return hind / mahutavus;
    }

    @Override
    public double arvutaAastaneEnergiaKasutus() {
        return (energiaKasutus * 8760) / 1000;
    }

    @Override
    public String tagastaInfo() {
        return "Päevas võid kirjutada " + nimi() + " peale " + String.format("%.2f",arvutaPaevaneKirjutamine())
                + "GB. Selle ketta puhul on hind per GB: " + String.format("%.2f",arvutaHindPerGB())
                + "€. Aastas tarbib see ketas energiat: " + String.format("%.2f",arvutaAastaneEnergiaKasutus()) + "kW.";
    }


}
