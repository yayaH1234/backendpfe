package backendproj.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Location {
    @Id
    private String Nom_mais;
    private String prix;
    private String candidat;
    private String debut;
    private String fin;

    public Location(String nom_mais, String prix, String candidat, String debut, String fin) {
        Nom_mais = nom_mais;
        this.prix = prix;
        this.candidat = candidat;
        this.debut = debut;
        this.fin = fin;
    }

    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" +
                "Nom_mais='" + Nom_mais + '\'' +
                ", prix='" + prix + '\'' +
                ", candidat='" + candidat + '\'' +
                ", debut='" + debut + '\'' +
                ", fin='" + fin + '\'' +
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

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
