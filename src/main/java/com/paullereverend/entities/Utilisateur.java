package com.paullereverend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identifiant de l'utilisateur")
	private int id;
	
    @ApiModelProperty(notes = "Nom de l'utilisateur")
	private String nom;
    
    @ApiModelProperty(notes = "Prénom de l'utilisateur")
	private String prenom;

	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
