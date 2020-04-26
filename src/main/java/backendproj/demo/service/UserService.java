package backendproj.demo.service;


import backendproj.demo.dao.userRepo;
import backendproj.demo.model.User;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UserService {
    @Autowired
    private userRepo userRep;

    public List<User> findAll(){
        return userRep.findAll();
    }
    public ArrayList<String> findIds(){
        List<User> e =findAll();
        ArrayList<String> a=new ArrayList<>();
        for (User m:e) {
        a.add(m.getId());
        }
        return a;
    }

    public User createuser(String nom, String prenom, String email,
                              String password, String numeroTel, MultipartFile imagedp, Model model)throws IOException {
        User user=new User(nom,prenom,email,password,numeroTel,new Binary(BsonBinarySubType.BINARY, imagedp.getBytes()));
       /* User r;
        int n;*/
       int o=0;
        {
            /*int nb = (int) Math.random()*1000;
            r = findById(String.valueOf(nb));
            n=nb;*/
            Random rand = new Random();
            int ran = rand.nextInt(1000000);
            String p=String.valueOf(ran);
            o=0;
            for(String u:findIds()){
                if(u.equals(p)){
                    o=1;
                }
            }
            if(o==0){
                user.setId(String.valueOf(p));
            }
        }while(o==1);
       // user.setId();


        System.out.println(user.toString());
        userRep.save(user);
        return user;
    }


    public User findById(String id){
        return userRep.findById(id).get();
    }

    public void deleteById(String id){
        userRep.deleteById(id);
    }

    public void deleteAllUser(){
        userRep.deleteAll();
    }

    public void updateuser(User cl){
        userRep.save(cl);
    }

    public User findByMail(String mail){
        for(User im:userRep.findAll()){
            if(im.getEmail().equals(mail)){
                return im;
            }
        }
        return null;
    }

    public void deleteByMail(String mail){
        User op=findByMail(mail);
        userRep.delete(op);
    }



    public User Login(String mail,String pwd){
        User log=findByMail(mail);
        if(mail.isEmpty() || pwd.isEmpty() || pwd.equals("") || mail.equals("") || log==null){
            return null;
        }
        if(log.getPassword().equals(pwd)){
            return log;
        }
        return null;
    }
}
