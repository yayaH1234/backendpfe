package backendproj.demo.controller;

import backendproj.demo.model.Location;
import backendproj.demo.model.Maison;
import backendproj.demo.model.Vendre;
import backendproj.demo.service.AffaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/affaire")

public class AffaireController {

    @Autowired
    private AffaireService affaireService;


    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    //   traitement de location

    @GetMapping(value="/test")
    public String test(){
        return "true";
    }
    @GetMapping(value="/getAllLocation")
    public List<Location> getAll()
    {
        System.out.println("------> : listMaison");
        logger.debug("getting maisons");
        return affaireService.findAllL();
    }
    @PostMapping("/addLoca")
    public boolean createLocation(@RequestParam("nom_mais") String nom_mais, @RequestParam("prix")  String prix,
                               @RequestParam("candidat") String candidat,  @RequestParam("debut") String debut,
                               @RequestParam("fin") String fin){
        System.out.println("------> : addMaison");
        logger.debug("adding maisons");
        Location lo=new Location(nom_mais,prix,candidat,debut,fin);
        return  affaireService.updateL(lo);

    }
    @DeleteMapping("/deleteLo/{Nm_mais}")
    public void deleteLocation(@PathVariable String Nm_mais){
        affaireService.deleteByLId(Nm_mais);
    }



    // traitement de vendre

    @GetMapping(value="/getAllVendre")
    public List<Vendre> getAllV()
    {
        System.out.println("------> : listMaison");
        logger.debug("getting maisons");
        return affaireService.findAllV();
    }
    @PostMapping("/addVendre")
    public boolean createVendre(@RequestParam("Nom_mais") String nom_mais, @RequestParam("prix")  String prix,
                                @RequestParam("candidat") String candidat){
        System.out.println("------> : addMaison");
        logger.debug("adding maisons");
        Vendre lo=new Vendre(nom_mais,prix,candidat);
        return  affaireService.updateV(lo);

    }
    @DeleteMapping("/deleteVe/{Nm_mais}")
    public void deleteVendeur(@PathVariable String Nm_mais){
        affaireService.deleteByVId(Nm_mais);
    }


}
