public class toiduaine {

    kartul kartul;

    String nimetus;
    int valgud;
    int rasvad;
    int sysivesinikud;

    public toiduaine(String nimetus, int valgud, int rasvad, int sysivesinukud, int kogus) {
        this.nimetus = nimetus;
        this.valgud = valgud;
        this.rasvad = rasvad;
        this.sysivesinikud = sysivesinukud;
        kartul.kogus = kogus;
    }

    public String protsendiKontroll() {
        int koguaine = this.valgud + this.rasvad + this.sysivesinikud;
        if(koguaine > 100){
            return this.nimetus + " koguprotsent ei saa ületada 100%";
        } else{
            return "Toiduaine";
        }
    }


}
