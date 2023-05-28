package ee.hendrik.baaskodune;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServerController {




    @Autowired
    ServerRepository serverRepository;


    @GetMapping("Server")
    public List<Server> getServer() {
        return serverRepository.findAll();
    }



   // localhost:8080/lisa-server?id=1&nimi=HP-DL360&hind=3000&kettaBayd=10&energiaKasutus=150

    @GetMapping("lisa-server")
    public List<Server> lisaServer(
            @RequestParam int id,
            @RequestParam String nimi,
            @RequestParam double hind,
            @RequestParam int kettaBayd,
            @RequestParam double energiaKasutus) {
        serverRepository.save(new Server(id,nimi,hind,kettaBayd,energiaKasutus));
        return serverRepository.findAll();
    }

}
