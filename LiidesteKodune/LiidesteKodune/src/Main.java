public class Main {
    public static void main(String[] args) {

        Ring ring = new Ring("Ring", 4);
        System.out.println(ring.tagastaInfo());
        Ruut ruut = new Ruut("Ruut",5);
        System.out.println(ruut.tagastaInfo());
        Ristkylik ristkylik = new Ristkylik("Ristkülik",4,2);
        System.out.println(ristkylik.tagastaInfo());
        Kolmnurk kolmnurk = new Kolmnurk("Kolmnurk",2,5,3,3);
        System.out.println(kolmnurk.tagastaInfo());
    }
}