import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        VM k8sWorker = new VM(new Info("k8s-Worker", 4,8,60,101,5));

        Info info = new Info("k8s-master",4,8,60,101,3);
        VM k8sMaster = new VM(info);


        k8sWorker.mahtuvus();
        k8sMaster.mahtuvus();
        String sonum = k8sWorker.kasMahub();
        System.out.println(sonum);
        k8sWorker.looVM();
        k8sMaster.looVM();
    }
}