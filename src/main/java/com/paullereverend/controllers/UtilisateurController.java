package com.paullereverend.controllers;

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
	public String getUtilisateurById(@PathVariable int id) {
		Optional<Utilisateur> utilisateur=utilisateurRepo.findById(id);
		if(!utilisateur.isPresent()) {
			throw new UtilisateurNotFoundException();
		}
		JSONObject jsonObject = new JSONObject(utilisateur.get());
		
		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public String createUtilisateur(Utilisateur user) {
		System.out.println(user.getNom());
		utilisateurRepo.save(user);
		JSONObject jsonObject = new JSONObject(user);
		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteUtilisateurById(@PathVariable int id) {
		Optional<Utilisateur> utilisateur=utilisateurRepo.findById(id);
		if(!utilisateur.isPresent()) {
			throw new UtilisateurNotFoundException();
		}
		utilisateurRepo.deleteById(id);
		JSONObject jsonObject = new JSONObject(utilisateur.get());
		
		return jsonObject.toString();
	}
	
	
}
