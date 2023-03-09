import java.sql.SQLOutput;

public class VM {
    
    String nimi;
    int vcpu;
    int ram;
    int disk;
    int vlan;
    int vmkogus;
    int i = 1;
    int clustervcpu = 40;
    int clusterram = 500;
    int clusterdisk = 1000;
    boolean mahub;


    public VM(String nimi, int vcpu, int ram, int disk, int vlan, int vmkogus) {
        this.nimi = nimi;
        this.vcpu = vcpu;
        this.ram = ram;
        this.disk = disk;
        this.vlan = vlan;
        this.vmkogus = vmkogus;
    }



    public void mahtuvus() {
        int totalvcpu = this.vcpu * this.vmkogus;
        int totalram = this.ram * this.vmkogus;
        int totaldisk = this.disk * this.vmkogus;
        if (totalvcpu <= clustervcpu && totalram <= clusterram && totaldisk <= clusterdisk){
            this.mahub = true;



        } else {
            this.mahub = false;

        }


    }
    public void looVM() {
        if(mahub){
        while (i <= vmkogus) {
            System.out.println("Loon virtukat: " + this.nimi + "-" + i);
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

