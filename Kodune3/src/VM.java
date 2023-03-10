import java.sql.SQLOutput;

public class VM {

    Info info;
    int i = 1;
    int clustervcpu = 50;
    int clusterram = 500;
    int clusterdisk = 1000;
    boolean mahub;


    public VM(Info info) {

        this.info = info;
    }

    public void mahtuvus() {
        int totalvcpu = info.vcpu * info.vmkogus;
        int totalram = info.ram * info.vmkogus;
        int totaldisk = info.disk * info.vmkogus;
        if (totalvcpu <= clustervcpu && totalram <= clusterram && totaldisk <= clusterdisk){
            this.mahub = true;
        } else {
            this.mahub = false;
        }

    }
    public void looVM() {
        if(mahub){
            while (i <= info.vmkogus) {
                System.out.println("Loon virtukat: " + info.nimi + "-" + i);
                i++;
            }
        }else {
            System.out.println("Ei saa luua virtukaid");
        }

    }
    public String kasMahub() {
        if (mahub){
            return "Clustrisse mahuvad virtukad ära";
        } else {
            return "Clustrisse ei mahu virtukad ära";
        }
    }

}

