package com.emsi.todoapp.controller;

import com.emsi.todoapp.model.ListeTaches;
import com.emsi.todoapp.model.Tache;
import com.emsi.todoapp.repository.ListeTachesRepository;
import com.emsi.todoapp.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins =  "*")
@RestController
@RequestMapping("/api")
public class TachesController {
    @Autowired
    TacheRepository tacheRepository;

    @Autowired
    ListeTachesRepository listeTachesRepository;

    @PostMapping("/listes/{listeID}/taches")
    public ResponseEntity<Tache> createTache(@RequestBody Tache tache,@PathVariable("listeID") Integer listeID){
        try{
            Optional<ListeTaches> liste = listeTachesRepository.findById(listeID);

            if(liste.isPresent())
            {
                tache.setListe(liste.get());
                Tache _tache = tacheRepository
                        .save(new Tache(tache.getDescription(),
                                tache.getDateEcheance(),
                                tache.getDateRappel(),
                                false,
                                false,
                                tache.getListe()));

                return new ResponseEntity<>(_tache, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/listes/{listeID}/taches/{tacheID}")
    public ResponseEntity<Tache> updateTache(@RequestBody Tache tache,
                                             @PathVariable("tacheID") Integer tacheID,
                                             @PathVariable("listeID") Integer listeID){
        try{
            Optional<ListeTaches> liste = listeTachesRepository.findById(listeID);
            Optional<Tache> _tache = tacheRepository.findById(tacheID);
            if(liste.isPresent() && _tache.isPresent()){
                _tache.get()
                        .setDescription(tache.getDescription())
                        .setDateEcheance(tache.getDateEcheance())
                        .setDateRappel(tache.getDateRappel())
                        .setImportant(tache.isImportant())
                        .setEtat(tache.isEtat())
                        .setListe(tache.getListe());

                return new ResponseEntity<>(tacheRepository.save(_tache.get()), HttpStatus.OK);
            }

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
