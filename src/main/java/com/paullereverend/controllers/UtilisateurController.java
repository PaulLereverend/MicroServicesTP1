package com.paullereverend.controllers;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paullereverend.entities.Utilisateur;
import com.paullereverend.exceptions.UtilisateurNotFoundException;
import com.paullereverend.repositories.UtilisateurRepository;

@RestController
public class UtilisateurController {
	
	@Autowired
	private UtilisateurRepository utilisateurRepo;
	

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur getUtilisateurById(@PathVariable int id) {
		Optional<Utilisateur> utilisateur=utilisateurRepo.findById(id);
		if(!utilisateur.isPresent()) {
			throw new UtilisateurNotFoundException();
		}
		return utilisateur.get();
	}
		
	@RequestMapping(value = "/get", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurRepo.findAll();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur createUtilisateur(Utilisateur user) {
		System.out.println(user.getNom());
		utilisateurRepo.save(user);
		return user;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur deleteUtilisateurById(@PathVariable int id) {
		Optional<Utilisateur> utilisateur=utilisateurRepo.findById(id);
		if(!utilisateur.isPresent()) {
			throw new UtilisateurNotFoundException();
		}
		utilisateurRepo.deleteById(id);
		return utilisateur.get();
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur updateUtilisateur(@PathVariable int id, Utilisateur user) {
		Optional<Utilisateur> utilisateur=utilisateurRepo.findById(id);
		if(!utilisateur.isPresent()) {
			throw new UtilisateurNotFoundException();
		}
		Utilisateur util = utilisateur.get();
		
		utilisateurRepo.save(recopie(util, user));
		return util;
	}
	private Utilisateur recopie (Utilisateur user1, Utilisateur user2) {
		if (user2.getNom() != null){
			user1.setNom(user2.getNom());
		}
		if (user2.getPrenom() != null){
			user1.setPrenom(user2.getPrenom());
		}
		return user1;
	}
	
	
}
