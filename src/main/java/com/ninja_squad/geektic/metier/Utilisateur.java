package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="UTILISATEUR")
public class Utilisateur {
	
	@Id
	@Column(name="ID")
	public int idUtilisateur;
	
	@Column(name="nom")
	public String nom;
	
	@Column(name="prenom") 
	public String prenom;
	
	@Column(name="age")
	public String age;
	
	@Column(name="sexe")
	public String sexe;
	
	@Column(name="mail")
	public String mail;

	@JoinColumn(name="CI")
	@ManyToOne
	public CentreInteret centreInteret ;
}
