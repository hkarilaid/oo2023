package ee.hendrik.kontrolltoo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KaubanduskeskusController {


    @Autowired
    KaubanduskeskusRepository kaubanduskeskusRepository;

    @Autowired
    PoodRepository poodRepository;

        // localhost:8080/lisa-kaubanduskeskus?nimi=Rocca&poed=Selver,COOP
    @PostMapping("lisa-kaubanduskeskus")
    public List<Kaubanduskeskus> lisaKaubanduskeskus(
            @RequestParam String nimi,
            @RequestParam String[] poed) {

        List<Pood> lisatudPoed = new ArrayList<>();
        for (String i : poed) {
            Pood pood = poodRepository.findById(i).get();
            lisatudPoed.add(pood);
        }

        kaubanduskeskusRepository.save(new Kaubanduskeskus(nimi,lisatudPoed));
        return kaubanduskeskusRepository.findAll();
    }


    @GetMapping("kylastajad-kokku")
    public String kylastajateArv(
            @RequestParam String nimi) {


        Kaubanduskeskus kaubanduskeskus = kaubanduskeskusRepository.findById(nimi).get();
        int kylastajateArv = 0;

        for (Pood pood : kaubanduskeskus.getPoed()) {
                kylastajateArv += pood.getKylastajateArv();
            }
            return "Kaubanduskeskuses " + nimi + " on kokku " + kylastajateArv + " külastajat.";

    }
}
