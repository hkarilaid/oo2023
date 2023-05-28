package ee.hendrik.baaskodune;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TellimusController {



    @Autowired
    SSDRepository ssdRepository;

    @Autowired
    ServerRepository serverRepository;

    @Autowired
    TellimusRepository tellimusRepository;




    @GetMapping("vaata-tellimust")
    public List<Tellimus> saaTellimus() {
        return tellimusRepository.findAll();
    }





   // localhost:8080/lisa-tellimus?id=1&serverID=1&ssdID=2

    @GetMapping("lisa-tellimus")
    public List<Tellimus> lisaTellimus(
            @RequestParam int id,
            @RequestParam int[] serverID,
            @RequestParam int[] ssdID )
             {

         List<Server> tellitudServer = new ArrayList<>();
        for (int i: serverID) {
            Server server = serverRepository.findById(i).get();
            tellitudServer.add(server);
        }
        int totalBays = tellitudServer.stream().mapToInt(Server::getKettaBayd).sum();
        List<SSD> tellitudSSD = new ArrayList<>();
        for (int i: ssdID) {
            SSD ssds = ssdRepository.findById(i).get();
            for (int j = 0; j < totalBays; j++) {
                tellitudSSD.add(ssds);
            }

        }



        tellimusRepository.save(new Tellimus(id, tellitudServer, tellitudSSD));
        return tellimusRepository.findAll();
    }

    // localhost:8080/saa-kogusumma?tellimuseID=2

    @GetMapping("tellimuse-kogusumma")
    public double saaKogusumma(
            @RequestParam int tellimuseID) {
        Optional<Tellimus> tellimusOptional = tellimusRepository.findById(tellimuseID);
        double kogusumma = 0;

        if (tellimusOptional.isPresent()) {
            Tellimus tellimus = tellimusOptional.get();

            for (Server server : tellimus.getServer()) {
                kogusumma += server.getHind();
            }
            for (SSD ssds : tellimus.getSsds()) {
                kogusumma += ssds.getHind();
            }
        } else {

            throw new IllegalArgumentException("Tellimust ID-ga " + tellimuseID + " ei leitud.");
        }

        return kogusumma;
    }

}
