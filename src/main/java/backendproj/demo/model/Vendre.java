package backendproj.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document
public class Vendre {
    @Id
    private String Nom_mais;
    private String prix;
    private String candidat;

    public Vendre(String nom_mais, String prix, String candidat) {
        Nom_mais = nom_mais;
        this.prix = prix;
        this.candidat = candidat;
    }

    public Vendre() {
    }

    @Override
    public String toString() {
        return "Vendre{" +
                "Nom_mais='" + Nom_mais + '\'' +
                ", prix='" + prix + '\'' +
                ", candidat='" + candidat + '\'' +
                '}';
    }

    public String getNom_mais() {
        return Nom_mais;
    }

    public void setNom_mais(String nom_mais) {
        Nom_mais = nom_mais;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getCandidat() {
        return candidat;
    }

    public void setCandidat(String candidat) {
        this.candidat = candidat;
    }
}
