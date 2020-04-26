package backendproj.demo.controller;


import backendproj.demo.dao.userRepo;
import backendproj.demo.model.User;
import backendproj.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/user")

public class UserController {
    @Autowired
    private UserService a;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());


    @GetMapping(value="/test")
    public String test(){
        return "true";
    }
    @GetMapping(value="/listusers")
    public List<User> getAll()
    {
        System.out.println("------> : listuser");
        logger.debug("getting usres");
        return a.findAll();
    }
    @GetMapping(value="/listuser/{mail}")
    public User getUser(@PathVariable String mail){
       return  a.findByMail(mail);
    }
    @GetMapping(value="/listuser/authontif")
    public User login(@RequestParam("login") String lg,@RequestParam("pwd") String pd){
        return  a.Login(lg,pd);
    }

    @PostMapping("/add")
    public User creuser(@RequestParam("nom") String nom, @RequestParam("prenom")  String pnom,
                           @RequestParam("email") String email,@RequestParam("pwd") String password,
                           @RequestParam("num") String numeroTel, @RequestParam("img") MultipartFile imagedp,
                        Model model) throws IOException {

        return  a.createuser(nom,pnom,email,password,numeroTel,imagedp,model);

    }



    @DeleteMapping("/delete/{mail}")
    public void deleteUser(@PathVariable String mail){
        a.deleteByMail(mail);
    }


}
