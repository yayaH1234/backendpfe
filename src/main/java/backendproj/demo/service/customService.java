package backendproj.demo.service;

import backendproj.demo.dao.custommrepo;
import backendproj.demo.dao.maisonRepos;
import backendproj.demo.model.Maison;
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
import java.util.Base64;
import java.util.List;
import java.util.Random;

@Service
public class customService {
    @Autowired
    private custommrepo custo;

    @Autowired
    private maisonRepos msRepo;


    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    public List<custommer> findAll(){
        return custo.findAll();
    }

    public String infoProfil(String email){
        ArrayList<String> ar=new ArrayList<>();
        custommer co=findByMail(email);
        //  offre dans l'app
        List<Maison> Lm=msRepo.findAll();
        int l=Lm.size();
        ar.add(String.valueOf(l));

        //  publication poster
        int i=0;
        for(Maison m:Lm){
            if(m.getNom_prop().equals(co.getNom()+" "+co.getPrenom())){
                i++;
            }
        }
        ar.add(String.valueOf(i));
/*
        //  publier image

        //ar.add(co.getImagedp().toString());
        ar.add(Base64.getUrlEncoder().encodeToString(co.getImagedp().getData()));

        //  publier email , numero

        ar.add(co.getEmail());
        ar.add(co.getNumeroTel());

        ar.add(co.getNom()+" "+co.getPrenom());
        ar.add(co.getPassword());
*/
        return ar.toString();
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

    public custommer createuser3( String email , String QuestSec,String repSec) {
        custommer o =findByMail(email);

        logger.debug("--------------------------------------------- > je suis la "+QuestSec+repSec);
        o.setQuestSec(QuestSec);
        o.setRepsec(repSec);
        updateuser(o);
        return o;
    }

    public custommer createuser2(String numeroTel,String email , MultipartFile imagedp)throws IOException {
        custommer o =findByMail(email);
        o.setNumeroTel(numeroTel);
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



    public String Login(String mail,String pwd){
        custommer log=findByMail(mail);
        if(mail.isEmpty() || pwd.isEmpty() || pwd.equals("") || mail.equals("") || log==null){
            return null;
        }
        if(log.getPassword().equals(pwd)){
            return "succes";
        }
        return null;
    }
    public String forgottPass(String email,String repSec){
        String pass=null;
        custommer cos=findByMail(email);
        if(repSec.equals(cos.getRepsec())){
            pass=cos.getPassword();
        }
        if(pass.equals(null)){
            pass="Error";
        }
        return pass;
    }

    public String achatMs(String emil,String nmMais){
        custommer cst=findByMail(emil);
        System.out.println("-------------> user information "+cst.toString());
        Maison ms=null;
     for(Maison m:msRepo.findAll()){
         System.out.println("-------------> after if "+m.toString());
         if(nmMais.equals(m.getNom_mais())){
             logger.debug("-------------> in service avant "+m.toString());
             System.out.println("-------------> in service avant "+m.toString());
             ms=m;
             logger.debug("-------------> in service apres "+ms.toString());
             System.out.println("-------------> in service apres "+ms.toString());
             ms.setNom_loc(cst.getNom());
             msRepo.save(ms);
             return "succes";
         }
     }    return "Error";


    }
    public String forDrawer(String email){
        custommer cstp=findByMail(email);
        ArrayList<String> ar=new ArrayList<String>();
        ar.add(cstp.getNom());
        ar.add(cstp.getEmail());
        ar.add(Base64.getUrlEncoder().encodeToString(cstp.getImagedp().getData()));
        return cstp.toString();
    }
    public Maison findByNomMs(String nomMs){
        Maison mson=null;
        for(Maison o:msRepo.findAll()){
            if(o.getNom_mais().equals(nomMs)){
                mson=o;
            }
        }
        return mson;
    }
    public String sheckProp(String email,String nomMs){
        Maison ms=findByNomMs(nomMs);
        custommer cstm=findByMail(email);
        if(ms.getNom_prop().equals(cstm.getNom())){
            return  "true";
        }else
    return "false";
    }
    public Maison updateMs1(String email,String nom_MS,String nomProp,String type,String adrss,String price){
        String rp=sheckProp(email,nom_MS);
        if(rp.equals("true")){
            Maison msMod=findByNomMs(nom_MS);
            msMod.setPrix_serv(price);
            msMod.setAdress(adrss);
            msMod.setNom_prop(nomProp);
            msMod.setType_serv(type);
            msRepo.save(msMod);
            return msMod;
        }
        return null;
    }
    public String getMs1(String nom_MS){
        Maison ms1=findByNomMs(nom_MS);
        ArrayList<String>  rp=new ArrayList<>();
        rp.add(ms1.getNom_mais());
        rp.add(ms1.getNom_prop());
        rp.add(ms1.getType_serv());
        rp.add(ms1.getAdress());
        rp.add(ms1.getPrix_serv());
    return rp.toString();
    }
    public Maison updateMs2(String email,String nom_MS,String lat,String lan){
        String rp=sheckProp(email,nom_MS);
        logger.debug("getting mail mmodiff2 "+rp);
        System.out.println("------> : getting mail mmodiff2 "+rp);
        if(rp.equals("true")){
            Maison msMod=findByNomMs(nom_MS);
            logger.debug("IN service updateMs2 "+msMod);
            System.out.println("------> : getting mail mmodiff2 "+msMod);
            msMod.setAttitude(lat);
            msMod.setLongiture(lan);
            msRepo.save(msMod);
            return msMod;
        }
        return null;
    }
    public String getMs2(String nom_MS){
        Maison ms1=findByNomMs(nom_MS);
        ArrayList<String>  rp=new ArrayList<>();
        rp.add(ms1.getAttitude());
        rp.add(ms1.getLongiture());
        return rp.toString();
    }
    public Maison updateMs3(String email,String nom_MS, MultipartFile imagedp)throws IOException{
   /*     String rp=sheckProp(email,nom_MS);
        if(rp.equals("true")){
     */       Maison msMod=findByNomMs(nom_MS);
            msMod.setImagedp(new Binary(BsonBinarySubType.BINARY, imagedp.getBytes()));
            msRepo.save(msMod);
            return msMod;
   /*     }
        return null;
    */}
}