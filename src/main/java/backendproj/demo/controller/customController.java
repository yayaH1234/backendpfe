package backendproj.demo.controller;

import backendproj.demo.model.User;
import backendproj.demo.model.custommer;
import backendproj.demo.service.customService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/custommer")
public class customController {

    @Autowired
    private customService a;


    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @GetMapping(value="/test")
    public String test(){
        return "true";
    }
    @GetMapping(value="/listusers")
    public List<custommer> getAll()
    {
        System.out.println("------> : listuser");
        logger.debug("getting usres");
        return a.findAll();
    }

    @GetMapping(value="/listemail")
    public List<String> getAllmail()
    {
        System.out.println("------> : listuser");
        logger.debug("getting usres");
        return a.findAllEmail();
    }
    @GetMapping(value="/getPassword")
    public String getpasswod(@RequestParam("email") String eml, @RequestParam("repSec") String repSec)
    {
        System.out.println("------> : getting password");
        logger.debug("getting password");
        return a.forgottPass(eml,repSec);
    }


    @GetMapping(value="/achat/{mail}")
    public String achetOrReserv(@PathVariable String mail)
    {
        System.out.println("------> : getting infotmation reserve");
        logger.debug("getting infotmation reserve");
        String[] dev=mail.split("__");
        String eml=dev[0];
        String nmms=dev[1];
        return a.achatMs(eml,nmms);
    }
    @GetMapping(value="/getdraw/{mail}")
    public String getdraw(@PathVariable String mail)
    {
        System.out.println("------> : getting draw");
        logger.debug("getting draw");
        return a.forDrawer(mail);
    }

    @GetMapping(value="/getPassword2/{mail}")
    public String getpasswod2(@PathVariable String mail)
    {
        System.out.println("------> : getting password");
        logger.debug("getting password");
        String[] dev=mail.split("__");
        String eml=dev[0];
        String repSec=dev[1];
        return a.forgottPass(eml,repSec);
    }


    @GetMapping(value="/listuser/{mail}")
    public custommer getUser(@PathVariable String mail){
        return  a.findByMail(mail);
    }

    @GetMapping(value="/userpro/{mail}")
    public String getUserinfo(@PathVariable String mail){
        return  a.infoProfil(mail);
    }

    @GetMapping(value="/listuser/authontif")
    public custommer login(@RequestParam("login") String lg, @RequestParam("pwd") String pd){
        return  a.Login(lg,pd);
    }

    @PostMapping("/add")
    public custommer creuser(@RequestParam("nom") String nom, @RequestParam("prenom")  String pnom,
                        @RequestParam("email") String email,@RequestParam("pwd") String password,
                        @RequestParam("num") String numeroTel, @RequestParam("img") MultipartFile imagedp,
                        Model model) throws IOException {

        return  a.createuser(nom,pnom,email,password,numeroTel,imagedp,model);

    }

    @PostMapping("/signup1")
    public custommer creuser1(@RequestParam("nom") String nom, @RequestParam("prenom")  String pnom,
                         @RequestParam("email") String email,@RequestParam("pwd") String password,
                         Model model) throws IOException {

        return  a.createuser1(nom,pnom,email,password,model);

    }
    @PostMapping("/signup2")
    public custommer creuser2(
            @RequestParam("email") String email, @RequestParam("img") MultipartFile imagedp,
            @RequestParam("num") String num,Model model) throws IOException {
        logger.debug("inserting2");
        return  a.createuser2(num,email,imagedp);

    }
    @PostMapping("/signup3")
    public custommer creuser3( @RequestParam("sqtsec")  String sqtsec,
                         @RequestParam("email") String email,@RequestParam("repsec") String repsec
    ) throws IOException {

        return  a.createuser3(sqtsec,email,repsec);

    }


    @DeleteMapping("/delete/{mail}")
    public void deleteUser(@PathVariable String mail){
        a.deleteByMail(mail);
    }

}
