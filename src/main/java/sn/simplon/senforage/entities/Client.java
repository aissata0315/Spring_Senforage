package sn.simplon.senforage.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String telephone;
    @ManyToOne
    @JoinColumn(name = "village_ID")
    private Village village;

    public Client() {
    }

    public Client(int id, String nom, String telephone, Village village) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.village = village;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }
}
