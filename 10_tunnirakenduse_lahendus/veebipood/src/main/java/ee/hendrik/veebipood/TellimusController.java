package ee.hendrik.veebipood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class TellimusController {
    List<Toode> tellimuseTooted = new ArrayList<>(Arrays.asList(
            new Toode(3,"Sprite", 1.7),
            new Toode(3,"Sprite", 1.7)

    ));
    List<Toode> tellimuse2Tooted = new ArrayList<>(Arrays.asList(
            new Toode(3,"Sprite", 1.7),
            new Toode(4,"Vichy", 2.0),
            new Toode(5,"Vitamin well", 2.5)
    ));
    Isik tellija = new Isik(1,"Ees","Pere",new Date());
    List<Tellimus> tellimused = new ArrayList<>(Arrays.asList(
            new Tellimus(1,tellija,tellimuseTooted),
            new Tellimus(2,tellija,tellimuse2Tooted)
    ));

    @GetMapping("tellimused")
    public List<Tellimus> saaTellimused() {
        return tellimused;
    }


    @DeleteMapping("kustuta-tellimus/{index}")
    public String kustutaTellimus(@PathVariable int index) {
        tellimused.remove(index);
        return "Tellimus kustutatud!";
    }
    @Autowired
    IsikController isikController;
    @Autowired
    ToodeController toodeController;


    // POST localhost:8080/lisa-tellimus?id=9&tellijaIndex=3&tooteIndexid=2,2,3
    @PostMapping("lisa-tellimus")
    public List<Tellimus> lisaTellimus(
            @RequestParam int id,
            @RequestParam int tellijaIndex,
            @RequestParam int[] tooteIndexid) {
        Isik tellija = isikController.isikud.get(tellijaIndex);

        List<Toode> tellitudTooted = new ArrayList<>();
        for (Integer i: tooteIndexid) {
            Toode toode = toodeController.tooted.get(i);
            tellitudTooted.add(toode);
        }

        tellimused.add(new Tellimus(id,tellija,tellitudTooted));
        return tellimused;
    }

    @PostMapping("lisa-tellimus2")
    public List<Tellimus> lisaTellimus2(
            @RequestBody Tellimus tellimus) {
                tellimused.add(tellimus);
                return tellimused;
    }

    @PostMapping("lisa-tellimus4")
    public List<Tellimus> lisaTellimus4(
            @RequestBody Tellimus tellimus) {
        Isik isik = isikController.isikud.get(tellimus.getTellija().getId());

        List<Toode> tellitudTooted = new ArrayList<>();
        for (Toode t: tellimus.getTooted()) {
            Toode toode = toodeController.tooted.get(t.getId());
            tellitudTooted.add(toode);
        }

        tellimused.add(new Tellimus(tellimus.getId(), isik, tellitudTooted));
        return tellimused;
    }
}
