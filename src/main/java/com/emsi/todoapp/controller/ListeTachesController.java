package com.emsi.todoapp.controller;

import com.emsi.todoapp.model.ListeTaches;
import com.emsi.todoapp.repository.ListeTachesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ListeTachesController {
    @Autowired
    ListeTachesRepository repository;

    @GetMapping("/listes")
    public ResponseEntity<List<ListeTaches>> getAllListes(){
        try{
            List<ListeTaches> listes = new ArrayList<>(repository.findAll());

            if(listes.isEmpty())
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(listes, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/listes")
    public ResponseEntity<ListeTaches> createListe(@RequestBody ListeTaches liste){
        try{
            ListeTaches listeTaches = repository
                    .save(new ListeTaches(liste.getNom(), liste.getIcone(), liste.getArrierePlan(), liste.getUtilisateur()));

            return  new ResponseEntity<>(listeTaches, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
