package com.emsi.todoapp.repository;

import com.emsi.todoapp.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByAdresseMailAndMotDePasse(String adresseEmail, String motDePasse);
}
