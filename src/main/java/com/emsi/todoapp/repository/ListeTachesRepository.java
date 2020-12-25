package com.emsi.todoapp.repository;

import com.emsi.todoapp.model.ListeTaches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListeTachesRepository extends JpaRepository<ListeTaches, Integer> {
    //native SQL query
    @Query(nativeQuery = true, value =  "SELECT * FROM ListeTaches WHERE utilisateurID = :id")
    List<ListeTaches> rechercheParUtilisateurID(@Param("id") Integer id);

    @Query("SELECT l FROM ListeTaches l WHERE l.utilisateur.utilisateurID = :uid")
    List<ListeTaches> rechercheParUID(@Param("uid") Integer uid);
}
