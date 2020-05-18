package backendproj.demo.service;

import backendproj.demo.dao.maisonRepos;
import backendproj.demo.model.Maison;
import backendproj.demo.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

@Service
public class MaisonService {
    @Autowired
    private maisonRepos maisonRepo;
  /*  @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;*/

    public List<Maison> findAllM(){
        return maisonRepo.findAll();
    }

    /*public String CreateMaison(String nom_mais,String nom_loc,String type_serv,String adress,
                               String attitude,String longiture,String prix_serv,Binary imagedp, MultipartFile stream) throws IOException{
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "video");
        metaData.put("nom_mais", nom_mais);
        metaData.put("nom_loc", nom_loc);
        metaData.put("type_serv", type_serv);
        metaData.put("adress", adress);
        metaData.put("attitude", attitude);
        metaData.put("longiture", longiture);
        metaData.put("prix_serv", prix_serv);
        metaData.put("imagedp", imagedp);
        metaData.put("stream", stream);
        Random rand = new Random();
        int ran = rand.nextInt(1000000);
        metaData.put("id",ran);
        gridFsTemplate.store(
                stream.getInputStream(), stream.getName(), stream.getContentType(), metaData);
        String id =String.valueOf(ran);
        return id.toString();
    }
    public Maison getMaison(String nom_mais) throws IllegalStateException, IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("nom_mais").is(id)));
        Maison ms = new Maison();
        ms.setAdress(file.getMetadata().get("adress").toString());
        ms.setNom_prop(file.getMetadata().get("nom_prop").toString());
        ms.setNom_loc(file.getMetadata().get("nom_loc").toString());
        ms.setType_serv(file.getMetadata().get("type_serv").toString());
        ms.setAttitude(file.getMetadata().get("attitude").toString());
        ms.setLongiture(file.getMetadata().get("longiture").toString());
        ms.setImagedp((Binary) file.getMetadata().get("imagedp"));
        ms.setPrix_serv(file.getMetadata().get("prix_serv").toString());
        return ms;
    }*/

    public  Maison CreateMs(String nom_mais,String nom_prop,String type_serv,String adress,
                               String attitude,String longiture,String prix_serv,MultipartFile imagedp) throws IOException{




        Maison a=new Maison(nom_mais,nom_prop, type_serv,adress, attitude,
                longiture,prix_serv,new Binary(BsonBinarySubType.BINARY, imagedp.getBytes()));
        maisonRepo.save(a);
        return a;
    }

    public Maison findByNom_mais(String nom_mais){
        for(Maison im:maisonRepo.findAll()){
            if(im.getNom_mais().equals(nom_mais)){
                return im;
            }
        }
        return null;
    }
    public Maison findByTypeServ(String type_serv){
        for(Maison im:maisonRepo.findAll()){
            if(im.getType_serv().equals(type_serv)){
                return im;
            }
        }
        return null;
    }


    public void deleteByNom_mais(String nom_mais){
        Maison op=findByNom_mais(nom_mais);
        maisonRepo.delete(op);
    }



    }
