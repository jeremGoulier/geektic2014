package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="CENTRE_INTERET")
public class CentreInteret {
	
	@Id
	@Column(name="id")
	public int idCI;
	
	@Column(name="libelle")
	public String libelle;
}
