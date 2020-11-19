package sn.simplon.senforage.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column
    private String nom;
    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roles")
    private List<User> Users = new ArrayList<User>();

    public Role(int id, String nom, List<User> users) {
        this.id = id;
        this.nom = nom;
        Users = users;
    }

    public Role() {

    }

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> users) {
        Users = users;
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
