package com.emsi.todoapp.repository;

import com.emsi.todoapp.model.ListeTaches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListeTachesRepository extends JpaRepository<ListeTaches, Integer> {
}
