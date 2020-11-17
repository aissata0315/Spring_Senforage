package sn.simplon.senforage.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Village implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nom;
    @OneToMany(mappedBy = "village")
    private List<Client> clients = new ArrayList<>();

    public Village() {
    }

    public Village(int id, String nom, List<Client> clients) {
        this.id = id;
        this.nom = nom;
        this.clients = clients;
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
}
