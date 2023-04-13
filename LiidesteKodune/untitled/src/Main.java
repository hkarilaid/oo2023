public class Main {
    public static void main(String[] args) {

        Jook jook = new Jook("Piim",1.5,2);
        System.out.println(jook.tagastaInfo());
        Puuvili puuvili = new Puuvili("Õun",3,5,0.15);
        System.out.println(puuvili.tagastaInfo());
        Telefon telefon = new Telefon("iPhone4",1000,1,"nutitelefon");
        System.out.println(telefon.tagastaInfo());
    }
}