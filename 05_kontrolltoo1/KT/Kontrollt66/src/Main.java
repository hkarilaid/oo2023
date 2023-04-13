public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        toiduaine kartul = new toiduaine("Kartul", 50, 30, 20, 100);
        toiduaine hapukoor = new toiduaine("Hapukoor",10,40,50,30);




        String sonum = kartul.protsendiKontroll();
        System.out.println(sonum);
    }
}