public class toiduaine {

    toidukomponent toidukomponent;
    double valgud;
    double rasvad;
    double sysivesinikud;



    public toiduaine(int valgud, int rasvad, int sysivesinukud) {
        this.valgud = valgud;
        this.rasvad = rasvad;
        this.sysivesinikud = sysivesinukud;

    }



    public String protsendiKontroll() {
        double koguaine = this.valgud + this.rasvad + this.sysivesinikud;
        if(koguaine > 100){
            return /*toidukomponent.getNimetus() +*/ " koguprotsent ületab 100%";
        } else{
            return " Toiduaine on normis";
        }
    }







}
