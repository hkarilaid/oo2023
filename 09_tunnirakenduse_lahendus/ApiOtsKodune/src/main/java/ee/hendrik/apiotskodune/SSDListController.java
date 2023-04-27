package ee.hendrik.apiotskodune;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SSDListController {

    List<SSD> ssdd = new ArrayList<>(Arrays.asList(
            new SSD("SamsungQVO",129.9,2,3.0,3),
            new SSD("CrucialMX500",121.9,2,3.0,5),
            new SSD("Samsung870EVO",174.9,2,2.5,5)

            ));

    @GetMapping("SSDs")
    public List<SSD> getSsdd() {
        return ssdd;
    }

    @PatchMapping("soodustus/{protsent}")
    public List<SSD> allahindlus(@PathVariable double protsent) {
        for (SSD ssd : ssdd) {
            double vanaHind = ssd.getHind();
            double uusHind = vanaHind - (vanaHind / 100 * protsent);
            ssd.setHind(uusHind);
        }
        return ssdd;
    }

    @DeleteMapping("kustuta-ssd/{index}")
    public List<SSD> kustutaSSD(@PathVariable int index) {
        ssdd.remove(index);
        return ssdd;
    }
}
