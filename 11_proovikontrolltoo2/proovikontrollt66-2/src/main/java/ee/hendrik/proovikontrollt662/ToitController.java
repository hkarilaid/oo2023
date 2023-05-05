package ee.hendrik.proovikontrollt662;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToitController {


    @Autowired
    ToitRepository toitRepository;



    // localhost:8080/toidu-valgud?nimetus=voileib
    @GetMapping("toidu-valgud")
    public int toiduValgud(
        @RequestParam String nimetus
    ) {
        Toit toit = toitRepository.findById(nimetus).get();
        List<ToiduKomponent> toidukomponendid = toit.getToidukomponendid();
        int valk = 0;
        for ( ToiduKomponent t: toidukomponendid) {
            valk += t.getToiduaine().getValk() * t.getKogus() / 100;
        }
        return valk;
    }


    // localhost:8080/toidu-rasv?nimetus=voileib
    @GetMapping("toidu-rasv")
    public int toiduRasv(
            @RequestParam String nimetus
    ) {
        Toit toit = toitRepository.findById(nimetus).get();
        List<ToiduKomponent> toidukomponendid = toit.getToidukomponendid();
        int rasv = 0;
        for ( ToiduKomponent t: toidukomponendid) {
            rasv += t.getToiduaine().getRasv() * t.getKogus() / 100;
        }
        return rasv;
    }


    // localhost:8080/toidu-sysivesik?nimetus=voileib
    @GetMapping("toidu-sysivesik")
    public int toiduSysivesik(
            @RequestParam String nimetus
    ) {
        Toit toit = toitRepository.findById(nimetus).get();
        List<ToiduKomponent> toidukomponendid = toit.getToidukomponendid();
        int sysivesik = 0;
        for ( ToiduKomponent t: toidukomponendid) {
            sysivesik += t.getToiduaine().getSysivesik() * t.getKogus() / 100;
        }
        return sysivesik;
    }

    @GetMapping("saa-toiduained")
    public List<Toiduaine> saaToiduAined(
            @RequestParam String nimetus
    ) {
        Toit toit = toitRepository.findById(nimetus).get();
        List<ToiduKomponent> toidukomponendid = toit.getToidukomponendid();
        int kogus = 0;
        for ( ToiduKomponent t: toidukomponendid) {
            kogus += t.getKogus();
        }
        return new ArrayList<>();
    }

}
