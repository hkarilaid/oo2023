package ee.hendrik.kontrolltoo2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PoodController {

    @Autowired
    PoodRepository poodRepository;

    @GetMapping("poed")
    public List<Pood> saaPoed() { return poodRepository.findAll(); }



        // localhost:8080/lisa-pood?nimetus=Selver&avamine=10&sulgemine=22&kylastajateArv=0
    @PostMapping("lisa-pood")
    public List<Pood> lisaPood(
            @RequestParam String nimetus,
            @RequestParam int avamine,
            @RequestParam int sulgemine,
            @RequestParam int kylastajateArv) {
        poodRepository.save(new Pood(nimetus,avamine,sulgemine,kylastajateArv));
        return poodRepository.findAll();
    }
        // localhost:8080/kas-avatud?nimetus=Selver&kell=9
    @GetMapping("kas-avatud")
    public String kasAvatud(
            @RequestParam String nimetus,
            @RequestParam int kell) {
        Pood pood = poodRepository.findById(nimetus).get();
        int avatud = pood.getAvamine();
        int suletud = pood.getSulgemine();

        if(kell >= avatud && kell < suletud ) {
            return "Pood on avatud";
        } else {
            return "Pood on suletud";
        }

    }
        // localhost:8080/lisa-kylastaja?nimetus=Selver
    @PostMapping("lisa-kylastaja")
    public String lisaKylastaja(
            @RequestParam String nimetus) {
        Pood pood = poodRepository.findById(nimetus).get();
        int kylastaja = pood.getKylastajateArv() + 1;
        pood.setKylastajateArv(kylastaja);
        poodRepository.save(pood);
        return "Külastaja lisatud, hetkel külastajaid: " + kylastaja;

    }
}
