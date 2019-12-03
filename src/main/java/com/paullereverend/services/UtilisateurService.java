package com.paullereverend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.paullereverend.entities.Utilisateur;
import com.paullereverend.exceptions.UtilisateurNotFoundException;
import com.paullereverend.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepo;
	
	public Utilisateur getUtilisateurById(@PathVariable int id) {
		Optional<Utilisateur> utilisateur=utilisateurRepo.findById(id);
		if(!utilisateur.isPresent()) {
			throw new UtilisateurNotFoundException();
		}
		return utilisateur.get();
	}
	
	public List<Utilisateur> getAllUtilisateurs() {
		return utilisateurRepo.findAll();
	}
	public Utilisateur createUtilisateur(Utilisateur user) {
		utilisateurRepo.save(user);
		return user;
	}
	public Utilisateur deleteUtilisateurById(@PathVariable int id) {
		Optional<Utilisateur> utilisateur=utilisateurRepo.findById(id);
		if(!utilisateur.isPresent()) {
			throw new UtilisateurNotFoundException();
		}
		utilisateurRepo.deleteById(id);
		return utilisateur.get();
	}
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
