package ee.hendrik.veebipood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class TellimusController {
 /*  List<Toode> tellimuseTooted = new ArrayList<>(Arrays.asList(
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
    )); */

    @GetMapping("tellimused")
    public List<Tellimus> saaTellimused() {
        return tellimusRepository.findAll();
    }


    @DeleteMapping("kustuta-tellimus/{id}")
    public String kustutaTellimus(@PathVariable int id) {
        tellimusRepository.deleteById(id);
        return "Tellimus kustutatud!";
    }
    @Autowired
    IsikRepository isikRepository;
    //IsikController isikController;
    @Autowired
    ToodeRepository toodeRepository;
    //ToodeController toodeController;

    @Autowired
    TellimusRepository tellimusRepository;


    // POST localhost:8080/lisa-tellimus2?id=9&tellijaId=1&tooteIds=1,7,8
    @PostMapping("lisa-tellimus2")
    public List<Tellimus> lisaTellimus2(
            @RequestParam int id,
            @RequestParam int tellijaId,
            @RequestParam int[] tooteIds) throws Exception {
        Isik tellija = isikRepository.findById(tellijaId).get();

        List<Toode> tellitudTooted = new ArrayList<>();
        for (int i: tooteIds) {

      //      if (i != 4) {
      //          Toode toode = toodeRepository.findById(i).get();
      //          tellitudTooted.add(toode);
      //      } <-- see lahendus lisab kõik peale 4 andmebaasi
            //      if (i == 4) {
            //          return tellimusRepository.findAll();
            //
            //      } <-- see lahendus ei lisa mitte midagi andmebaasi, aga ta ei ütle et ei õnnestunud
            if (i == 4) {
                throw new Exception("ID-ga 4 ei saa andmebaasi lisada!"); // lõppeb, ei lisa midagi andmebaasi ja tuleb ka sõnum
            }
            Toode toode = toodeRepository.findById(i).get();
            tellitudTooted.add(toode);
        }

//        tellimused.add(new Tellimus(id,
        tellimusRepository.save(new Tellimus(id, tellija, tellitudTooted));
        return tellimusRepository.findAll();
    }



    // localhost:8080/lisa-tellimus2?id=9&tellijaId=3&tooteIds=2,2,3
    @PostMapping("lisa-tellimus3")
    public List<Tellimus> lisaTellimus3(
            @RequestBody Tellimus tellimus) {
                tellimusRepository.save(tellimus);
                return tellimusRepository.findAll();
    }

    @PostMapping("lisa-tellimus4")
    public List<Tellimus> lisaTellimus4(
            @RequestBody Tellimus tellimus) {
       // Isik isik = isikController.isikud.get(tellimus.getTellija().getId());
        Isik isik = isikRepository.findById(tellimus.getTellija().getId()).get();

                List<Toode> tellitudTooted = new ArrayList<>();
        for (Toode t: tellimus.getTooted()) {
         //   Toode toode = toodeController.tooted.get(t.getId());
            Toode toode = toodeRepository.findById(t.getId()).get();
            tellitudTooted.add(toode);
        }

       // tellimused.add(new Tellimus(tellimus.getId(), isik, tellitudTooted));
       // return tellimused;
        tellimusRepository.save(new Tellimus(tellimus.getId(), isik, tellitudTooted));
        return tellimusRepository.findAll();
    }

    @GetMapping("saa-kogusumma")
    public double saaKogusumma() {
       List<Tellimus> tellimused = tellimusRepository.findAll();
       double kogusumma = 0;
        for (Tellimus t: tellimused) {
            for (Toode toode: t.getTooted()) {
                kogusumma += toode.getHind();
            }
        }
        return kogusumma;
    }
}
