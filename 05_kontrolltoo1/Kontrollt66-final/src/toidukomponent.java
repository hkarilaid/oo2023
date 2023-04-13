public class toidukomponent {

    toiduaine toiduaine;
    String nimetus;
    double kogus;

    public toidukomponent(String nimetus, double kogus) {
        this.nimetus = nimetus;
        this.kogus = kogus;
    }


    public String rasvaKogus(){
        double rasv = (this.kogus / 100) * 10;
        return "Rasva on " + this.nimetus + " " + rasv + "g";
    }
    public String getNimetus() { return nimetus; }

}
