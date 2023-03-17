import java.util.ArrayList;
import java.util.List;

public class listid {

    List<String> toidud;

    public listid(List<String> toidud) {
        this.toidud = toidud;
    }

    public void toiduLisamine(String nimi){
        this.toidud.add(nimi);
    }

    public void toiduEemaldamine(int indeks){
        this.toidud.remove(indeks);
    }
   // public List<String> getToidud() {
    //    return this.toidud;
    }




