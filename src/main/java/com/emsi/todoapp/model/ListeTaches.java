package com.emsi.todoapp.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class ListeTaches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listeID;
    @NotNull
    private String nom;
    @NotNull
    private String icone;
    @NotNull
    private String arrierePlan;

    @ManyToOne
    private Utilisateur utilisateur;

    public ListeTaches(){}

    public ListeTaches(String nom, String icone, String arrierePlan, Utilisateur utilisateur) {
        this.nom = nom;
        this.icone = icone;
        this.arrierePlan = arrierePlan;
        this.utilisateur = utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public ListeTaches setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getIcone() {
        return icone;
    }

    public ListeTaches setIcone(String icone) {
        this.icone = icone;
        return this;
    }

    public String getArrierePlan() {
        return arrierePlan;
    }

    public ListeTaches setArrierePlan(String arrierePlan) {
        this.arrierePlan = arrierePlan;
        return this;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public ListeTaches setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        return this;
    }

    @Override
    public String toString() {
        return "ListeTaches{" +
                "listeID=" + listeID +
                ", nom='" + nom + '\'' +
                ", icone='" + icone + '\'' +
                ", arrierePlan='" + arrierePlan + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
