package backendproj.demo.service;

import backendproj.demo.dao.custommrepo;
import backendproj.demo.model.User;
import backendproj.demo.model.custommer;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class customService {
    @Autowired
    private custommrepo custo;


    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    public List<custommer> findAll(){
        return custo.findAll();
    }

    public ArrayList<String> findAllEmail(){

        List<custommer> e =findAll();
        ArrayList<String> a=new ArrayList<>();
        for(custommer l:e){
            a.add(l.getEmail());
        }
        return a;
    }


    public ArrayList<String> findIds(){
        List<custommer> e =findAll();
        ArrayList<String> a=new ArrayList<>();
        for (custommer m:e) {
            a.add(m.getId());
        }
        return a;
    }

    public custommer createuser3( String email , String numeroTel, String QuestSec,String repSec) {
        custommer o =findByMail(email);

        o.setNumeroTel(numeroTel);
        o.setQuestSec(QuestSec);
        o.setRepsec(repSec);
        updateuser(o);
        return o;
    }

    public custommer createuser2(String email , MultipartFile imagedp)throws IOException {
        custommer o =findByMail(email);
        logger.debug("je suis la "+imagedp.toString());
        o.setImagedp(new Binary(BsonBinarySubType.BINARY, imagedp.getBytes()));
        // o.setImagedp(imagedp);
        updateuser(o);
        return o;
    }

    public custommer createuser1(String nom, String prenom, String email,
                            String password, Model model)throws IOException {
        custommer user=new custommer(nom,prenom,email,password);
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
        custo.save(user);
        return user;
    }


    public custommer createuser(String nom, String prenom, String email,
                           String password, String numeroTel,MultipartFile  imagedp, Model model)throws IOException {
        custommer user=new custommer(nom,prenom,email,password,numeroTel,new Binary(BsonBinarySubType.BINARY, imagedp.getBytes()));
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
        custo.save(user);
        return user;
    }

    public custommer findById(String id){
        return custo.findById(id).get();
    }

    public void deleteById(String id){
        custo.deleteById(id);
    }

    public void deleteAllUser(){
        custo.deleteAll();
    }

    public void updateuser(custommer cl){
       custo.save(cl);
    }

    public custommer findByMail(String mail){
        for(custommer im:custo.findAll()){
            if(im.getEmail().equals(mail)){
                return im;
            }
        }
        return null;
    }

    public void deleteByMail(String mail){
        custommer op=findByMail(mail);
        custo.delete(op);
    }



    public custommer Login(String mail,String pwd){
        custommer log=findByMail(mail);
        if(mail.isEmpty() || pwd.isEmpty() || pwd.equals("") || mail.equals("") || log==null){
            return null;
        }
        if(log.getPassword().equals(pwd)){
            return log;
        }
        return null;
    }
}