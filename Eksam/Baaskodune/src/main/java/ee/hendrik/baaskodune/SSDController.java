package ee.hendrik.baaskodune;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SSDController {


    @Autowired
    SSDRepository ssdRepository;


    @GetMapping("SSD")
    public List<SSD> getSsd() {
        return ssdRepository.findAll();
    }


    // localhost:8080/muuda-hind?id=1&hind=15

    @PostMapping("muuda-hind")
    public List<SSD> muudaHind(
            @RequestParam int id,
            @RequestParam double hind) {
      SSD ssd = ssdRepository.findById(id).get();
      ssd.setHind(hind);
      ssdRepository.save(ssd);
      return ssdRepository.findAll();
    }


    // localhost:8080/lisa-ssd?id=1&nimi=SamsungQVO&hind=129.9&suurus=2&energiaKasutus=3.0&garantii=3

    @GetMapping("lisa-ssd")
    public List<SSD> lisaSSD(
            @RequestParam int id,
            @RequestParam String nimi,
            @RequestParam double hind,
            @RequestParam double suurus,
            @RequestParam double energiaKasutus,
            @RequestParam int garantii) {
        ssdRepository.save(new SSD(id,nimi,hind,suurus,energiaKasutus,garantii));
        return ssdRepository.findAll();
    }

}
