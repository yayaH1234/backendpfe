package backendproj.demo.controller;

import backendproj.demo.model.Maison;
import backendproj.demo.model.User;
import backendproj.demo.service.MaisonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @GetMapping(value="/listusers")
    public List<Maison> getAll()
    {
        System.out.println("------> : listMaison");
        logger.debug("getting maisons");
        return maisonService.findAllM();
}
    @PostMapping("/add")
    public User cremaison(@RequestParam("nom_mais") String nom, @RequestParam("nom_prop")  String pnom,
                        @RequestParam("type_serv") String email, @RequestParam("adress") String password,
                        @RequestParam("attitude") String numeroTel, @RequestParam("longiture") MultipartFile imagedp,
                        @RequestParam("prix_serv") String numeoTel,Model model) throws IOException {

        return  maisonService.(nom,pnom,email,password,numeroTel,imagedp,model);

    }
}
