package com.emsi.todoapp.controller;

import com.emsi.todoapp.model.Utilisateur;
import com.emsi.todoapp.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/utilisateurs")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs(){
        try{
            List<Utilisateur> utilisateurs = new ArrayList<>(utilisateurRepository.findAll());

            if(utilisateurs.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(utilisateurs, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/utilisateurs/{utilisateurID}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("utilisateurID") int utilisateurID){
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(utilisateurID);

        if(utilisateur.isPresent())
            return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/utilisateurs")
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur){
        try{
            Utilisateur _utilisateur = utilisateurRepository.save(new Utilisateur(utilisateur.getNomComplet(), utilisateur.getAdresseEmail(), utilisateur.getMotDePasse()));

            return new ResponseEntity<>(_utilisateur, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/utilisateurs/{utilisateurID}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable("utilisateurID") int utilisateurID,@RequestBody Utilisateur utilisateur){
        try {
             Optional<Utilisateur> _utilisateur = utilisateurRepository.findById(utilisateurID);

             if(_utilisateur.isPresent())
             {
                 _utilisateur.get()
                         .setNomComplet(utilisateur.getNomComplet())
                         .setAdresseEmail(utilisateur.getAdresseEmail())
                         .setMotDePasse(utilisateur.getMotDePasse());

                 return new ResponseEntity<>(utilisateurRepository.save(_utilisateur.get()), HttpStatus.OK);
             }else{
                 return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
             }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/utilisateurs/{utilisateurID}")
    public ResponseEntity<Utilisateur> deleteUtilisateur(@PathVariable("utilisateurD") int utilisateurID)
    {
        try{
            utilisateurRepository.deleteById(utilisateurID);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/utilisateurs")
    public ResponseEntity<Utilisateur> login(@RequestBody String adresseEmail,@RequestBody  String motDePasse)
    {
        Optional<Utilisateur> utilisateur= utilisateurRepository.findByAdresseMailAndMotDePasse(adresseEmail, motDePasse);
        if(utilisateur.isPresent())
            return new ResponseEntity<>(utilisateur.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
