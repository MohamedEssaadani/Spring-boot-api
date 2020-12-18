package com.emsi.todoapp.repository;

import com.emsi.todoapp.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Integer> {
    List<Tache> findByImportant(boolean important);
    List<Tache> findByEtat(boolean etat);
}
