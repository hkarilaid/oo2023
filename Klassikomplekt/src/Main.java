public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Info info = new Info ("Mac", "16gb", "Mac");
        Arvuti arvuti = new Arvuti(, 1000);

        Arvuti arvuti2 = new Arvuti(new Info("Windows", "8gb" "Windows"), 1000);
        arvuti2.paneDollaritesse();
    }
}