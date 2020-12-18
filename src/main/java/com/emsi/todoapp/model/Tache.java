package com.emsi.todoapp.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tacheID;
    @NotNull
    private String description;
    @NotNull
    private Date dateEcheance;
    @NotNull
    private Date dateRappel;
    @NotNull
    private boolean etat;
    @NotNull
    private boolean important;

    @ManyToOne
    private ListeTaches liste;

    public Tache(){}

    public Tache(String description, Date dateEcheance, Date dateRappel, boolean etat, boolean important) {
        this.description = description;
        this.dateEcheance = dateEcheance;
        this.dateRappel = dateRappel;
        this.etat = etat;
        this.important = important;
    }

    public String getDescription() {
        return description;
    }

    public Tache setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public Tache setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
        return this;
    }

    public Date getDateRappel() {
        return dateRappel;
    }

    public Tache setDateRappel(Date dateRappel) {
        this.dateRappel = dateRappel;
        return this;
    }

    public boolean isEtat() {
        return etat;
    }

    public Tache setEtat(boolean etat) {
        this.etat = etat;
        return this;
    }

    public boolean isImportant() {
        return important;
    }

    public Tache setImportant(boolean important) {
        this.important = important;
        return this;
    }

    @Override
    public String toString() {
        return "Tache{" +
                "tacheID=" + tacheID +
                ", description='" + description + '\'' +
                ", dateEcheance=" + dateEcheance +
                ", dateRappel=" + dateRappel +
                ", etat=" + etat +
                ", important=" + important +
                ", liste=" + liste +
                '}';
    }
}
