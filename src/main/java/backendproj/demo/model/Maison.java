package backendproj.demo.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.InputStream;

@Document
public class Maison {
    @Id
    private String id ;
    @Indexed(unique=true)
    private String nom_mais;
    private String nom_prop;
    private String nom_loc;
    private String type_serv;
    private String adress;
    private String attitude;
    private String longiture;
    private String prix_serv;
    private Binary imagedp;
    private InputStream stream;

    public Maison() {
    }

    public Maison(String nom_mais, String nom_prop,  String type_serv,String adress, String attitude,
                  String longiture, String prix_serv,Binary imagedp, InputStream stream) {
        this.nom_mais = nom_mais;
        this.nom_prop = nom_prop;
        this.type_serv = type_serv;
        this.adress = adress;
        this.attitude = attitude;
        this.longiture = longiture;
        this.prix_serv = prix_serv;
        this.imagedp = imagedp;
        this.stream = stream;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom_mais() {
        return nom_mais;
    }

    public void setNom_mais(String nom_mais) {
        this.nom_mais = nom_mais;
    }

    public String getNom_prop() {
        return nom_prop;
    }

    public void setNom_prop(String nom_prop) {
        this.nom_prop = nom_prop;
    }

    public String getNom_loc() {
        return nom_loc;
    }

    public void setNom_loc(String nom_loc) {
        this.nom_loc = nom_loc;
    }

    public String getType_serv() {
        return type_serv;
    }

    public void setType_serv(String type_serv) {
        this.type_serv = type_serv;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public String getLongiture() {
        return longiture;
    }

    public void setLongiture(String longiture) {
        this.longiture = longiture;
    }

    public String getPrix_serv() {
        return prix_serv;
    }

    public void setPrix_serv(String prix_serv) {
        this.prix_serv = prix_serv;
    }

    public Binary getImagedp() {
        return imagedp;
    }

    public void setImagedp(Binary imagedp) {
        this.imagedp = imagedp;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }
}
