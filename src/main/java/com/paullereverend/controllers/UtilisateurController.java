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
import com.paullereverend.services.UtilisateurService;

@RestController
public class UtilisateurController {
	
	@Autowired
	UtilisateurService service;
	

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur getUtilisateurById(@PathVariable int id) {
		return service.getUtilisateurById(id);
	}
		
	@RequestMapping(value = "/get", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Utilisateur> getAllUtilisateurs() {
		return service.getAllUtilisateurs();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur createUtilisateur(Utilisateur user) {
		return service.createUtilisateur(user);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur deleteUtilisateurById(@PathVariable int id) {
		return service.deleteUtilisateurById(id);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur updateUtilisateur(@PathVariable int id, Utilisateur user) {
		return service.updateUtilisateur(id, user);
	}
	
	
	
}
