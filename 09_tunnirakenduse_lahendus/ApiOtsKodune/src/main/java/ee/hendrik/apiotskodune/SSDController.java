package ee.hendrik.apiotskodune;

import org.springframework.web.bind.annotation.*;

@RestController
public class SSDController {

    SSD ssd = new SSD("SamsungQVO",129.9,2,3.0,3);

    @GetMapping("SSD")
    public SSD getSsd() {
        return ssd;
    }

    @GetMapping("change-price/{hind}")
    public SSD changePrice(@PathVariable double hind) {
        ssd.setHind( hind );
        return ssd;
    }

    
}
