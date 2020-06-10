package backendproj.demo.model;



//import com.sun.istack.internal.NotNull;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document()
public class User {
    @Id
    private String id ;
    @NotNull
    private String Nom;
    private String prenom;
    @Indexed(unique=true)
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String numeroTel;
    private Binary imagedp;
    private String QuestSec;
    private String repsec;

    public User() { }

    public User(String nom, String prenom, String email,
                String password, String numeroTel, Binary imagedp) {
        Nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.numeroTel = numeroTel;
        this.imagedp = imagedp;
    }

    public User(String nom, String prenom, String email, String password) {
        Nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public String getQuestSec() {
        return QuestSec;
    }

    public void setQuestSec(String questSec) {
        QuestSec = questSec;
    }

    public String getRepsec() {
        return repsec;
    }

    public void setRepsec(String repsec) {
        this.repsec = repsec;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", Nom='" + Nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", numeroTel='" + numeroTel + '\'' +
                ", imagedp=" + imagedp +
                '}';
    }

    public String toString(String a) {
        return a;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public Binary getImagedp() {
        return imagedp;
    }

    public void setImagedp(Binary imagedp) {
        this.imagedp = imagedp;
    }
}
