package com.emsi.todoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int utilisateurID;
    @NotNull
    private  String nomComplet;
    @NotNull
    private  String adresseEmail;
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String motDePasse;

    public Utilisateur(){}

    public Utilisateur(String nomComplet, String adresseEmail, String motDePasse) {
        this.nomComplet = nomComplet;
        this.adresseEmail = adresseEmail;
        this.motDePasse = motDePasse;
    }

    public int getUtilisateurId() {
        return utilisateurID;
    }


    public String getNomComplet() {
        return nomComplet;
    }

    public Utilisateur setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
        return this;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public Utilisateur setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
        return this;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Utilisateur setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
        return this;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "utilisateurID=" + utilisateurID +
                ", nomComplet='" + nomComplet + '\'' +
                ", adresseEmail='" + adresseEmail + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}