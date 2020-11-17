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
}
