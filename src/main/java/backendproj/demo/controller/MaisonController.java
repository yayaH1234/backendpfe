package backendproj.demo.controller;

import backendproj.demo.model.Maison;
import backendproj.demo.model.User;
import backendproj.demo.service.MaisonService;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(value="/maison")

public class MaisonController {
    @Autowired
    private MaisonService maisonService;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @GetMapping(value="/test")
    public String test(){
        return "true";
    }
    @GetMapping(value="/get")
    public List<Maison> getAll()
    {
        System.out.println("------> : listMaison");
        logger.debug("getting maisons");
        return maisonService.findAllM();
    }




/*
    @PostMapping("/add")
    public String cremaison(@RequestParam("nom_mais") String nom, @RequestParam("nom_prop")  String pnom,
                        @RequestParam("type_serv") String type_serv, @RequestParam("adress") String adress,
                        @RequestParam("attitude") String attitude, @RequestParam("longiture") String longiture,
                        @RequestParam("prix_serv") String prix_serv,@RequestParam("imagedp") Binary imagedp,
                            @RequestParam("stream") MultipartFile stream,Model model) throws IOException {

        return  maisonService.CreateMaison(nom,pnom,type_serv,adress,
                attitude,longiture,prix_serv,imagedp,stream);

    }*/

    @PostMapping("/addM")
    public Maison createmaison(@RequestParam("nom_mais") String nom, @RequestParam("nom_prop")  String pnom,
                            @RequestParam("type_serv") String type_serv, @RequestParam("adress") String adress,
                            @RequestParam("attitude") String attitude, @RequestParam("longiture") String longiture,
                            @RequestParam("prix_serv") String prix_serv,@RequestParam("imagedp") MultipartFile imagedp,
                           Model model) throws IOException {
        System.out.println("------> : addMaison");
        logger.debug("adding maisons");
        return  maisonService.CreateMs(nom,pnom,type_serv,adress,attitude,longiture,prix_serv,imagedp);
    }
    @GetMapping(value="/listmbyserv/{typeserv}")
    public String getBySERvice(@PathVariable String typeserv) {
        return maisonService.findByTypeServ(typeserv);
    }



    @GetMapping(value="/listm/{nom_mais}")
    public String getUser(@PathVariable String nom_mais){
            return  maisonService.findByNom_maisForSend(nom_mais);}
  /*  public Maison getUser(@PathVariable String nom_mais){
        return  maisonService.findByNom_mais(nom_mais);
    }*/
  @GetMapping(value="/listmaisJSON/{nom_mais}")
  public Maison getmaisonJSON(@PathVariable String nom_mais){
      return  maisonService.findByNom_mais(nom_mais);}


    @GetMapping("/delete/{nom_mais}")
    public void deleteMs(@PathVariable String nom_mais){
        System.out.println("------> : getting mail for log");
        logger.debug("getting mail for log");
        String[] dev=nom_mais.split("___");
        String idOrNm=dev[0];
        String mail=dev[1];
        System.out.println("------> : information delete in controller"+idOrNm+" "+mail);
        maisonService.deleteByNom_mais(idOrNm,mail);
    }
    @DeleteMapping("/deleteAllMais")
    public void deleteAllMs(){
        System.out.println("------> : getting mail for log");
        logger.debug("getting mail for log");
        maisonService.delAllMais();
    }

}
