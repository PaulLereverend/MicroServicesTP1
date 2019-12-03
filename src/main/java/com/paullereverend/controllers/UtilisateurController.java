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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value="Gestion des utilisateurs", description="Ressources permettant de gérer des utilisateurs (CRUD)")
public class UtilisateurController {
	
	@Autowired
	UtilisateurService service;
	
	@ApiOperation(value = "Récupère un utilisateur", response = Utilisateur.class)
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur getUtilisateurById(@ApiParam(value = "Identifiant d'un utilisateur (ex 1,2,3...)", required = true) @PathVariable int id) {
		return service.getUtilisateurById(id);
	}
	@ApiOperation(value = "Récupère la liste des utilisateurs", response = List.class)
	@RequestMapping(value = "/get", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Utilisateur> getAllUtilisateurs() {
		return service.getAllUtilisateurs();
	}
	@ApiOperation(value = "Créé un utilisateur", response = Utilisateur.class)
	@RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur createUtilisateur(@ApiParam(value = "Utilisateur à créer", required = true) Utilisateur user) {
		return service.createUtilisateur(user);
	}
	
	@ApiOperation(value = "Supprime un utilisateur", response = Utilisateur.class)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur deleteUtilisateurById(@ApiParam(value = "Identifiant d'un utilisateur (ex 1,2,3...)", required = true) @PathVariable int id) {
		return service.deleteUtilisateurById(id);
	}
	
	@ApiOperation(value = "Met à jour un utilisateur", response = Utilisateur.class)
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Utilisateur updateUtilisateur(@ApiParam(value = "Identifiant d'un utilisateur (ex 1,2,3...)", required = true) @PathVariable int id, @ApiParam(value = "Utilisateur modifié", required = true) Utilisateur user) {
		return service.updateUtilisateur(id, user);
	}
	
	
	
}
