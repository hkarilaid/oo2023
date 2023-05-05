package ee.hendrik.proovikontrollt662;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToiduController {

    @Autowired
    ToiduaineRepository toiduaineRepository;

    @Autowired
    ToiduKomponentRepository toiduKomponentRepository;


    // localhost:8080/leia-nime-alusel?id=1&nimetus=kartul

    @GetMapping("leia-nime-alusel")
    public Toiduaine leiaNimeAlusel(
            @RequestParam String nimetus
    ) {
        return toiduaineRepository.findByNimetus(nimetus);
    }

    // localhost:8080/leia-nime-alusel2?nimetus=kartul
    @GetMapping("leia-nime-alusel2")
    public Toiduaine leiaNimeAlusel2(
            @RequestParam String nimetus
    ) {
        List<Toiduaine> toiduained = toiduaineRepository.findAll();
        for (int i = 0; i < toiduained.size(); i++) {
            if (toiduained.get(i).getNimetus().equals(nimetus)) {
                return toiduained.get(i);
            }
        }
        return null;
    }

    // localhost:8080/leia-rasva-alusel?alg=1&l6pp=5
    @GetMapping("leia-rasva-alusel")
    public List<Toiduaine> leiaRasvaAlusel(
            @RequestParam int alg,
            @RequestParam int l6pp
    ) {
        return toiduaineRepository.findByRasvIsBetween(alg, l6pp);
    }

    // localhost:8080/leia-rasva-alusel2?alg=1&l6pp=5
    @GetMapping("leia-rasva-alusel2")
    public List<Toiduaine> leiaRasvaAlusel2(
            @RequestParam int alg,
            @RequestParam int l6pp
    ) {
        List<Toiduaine> toiduained = toiduaineRepository.findAll();
        List<Toiduaine> tagastatavadToiduained = new ArrayList<>();
        for (int i = 0; i < toiduained.size(); i++) {
            if (toiduained.get(i).getRasv() > alg && toiduained.get(i).getRasv() < l6pp) {
                if (toiduained.get(i).getRasv() > alg && toiduained.get(i).getRasv() < l6pp) {
                    tagastatavadToiduained.add(toiduained.get(i));
                }
            }

        }
        return tagastatavadToiduained;
    }

    // localhost:8080/kustuta-toiduaine?id=1
    @GetMapping("kustuta-toiduaine")
    public List<Toiduaine> kustutaToiduaine(
            @RequestParam Long id
    ) {
        toiduaineRepository.deleteById(id);
        return toiduaineRepository.findAll();
    }


    // localhost:8080/saa-rasv?id=1
    @GetMapping("saa-rasv")
    public int saaRasv(
            @RequestParam Long id
    ) {
        ToiduKomponent toiduKomponent = toiduKomponentRepository.findById(id).get();
        int rasv = toiduKomponent.getToiduaine().getRasv() * toiduKomponent.getKogus() / 100;
        return rasv;
    }

    // localhost:8080/lisa-toidukomponent?id=1&toiduaineId=&kogus=100
    @GetMapping("lisa-toidukomponent")
    public List<ToiduKomponent> lisaToiduKomponent(
            @RequestParam Long id,
            @RequestParam Long toiduaineId,
            @RequestParam int kogus
    ) {
        Toiduaine toiduaine = toiduaineRepository.findById(toiduaineId).get();
        toiduKomponentRepository.save(new ToiduKomponent(id, toiduaine,kogus));
        return toiduKomponentRepository.findAll();
    }


    // localhost:8080/lisa-toiduaine?id=1&nimetus=kartul&valk=5&rasv=2&sysivesik=3
    @GetMapping("lisa-toiduaine")
    public List<Toiduaine> lisaToiduaine(
            @RequestParam Long id,
            @RequestParam String nimetus,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik

    ) throws Exception {
        if (valk + rasv + sysivesik > 100) {
            throw new Exception("Valk, rasv ja sysivesik ei saa kokku olla üle 100%");
        } else {
            toiduaineRepository.save(new Toiduaine(id, nimetus, valk, rasv, sysivesik));
            return toiduaineRepository.findAll();
        }
    }
}
