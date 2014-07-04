package com.ninja_squad.geektic.dao;

import java.util.*;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.metier.CentreInteret;
import com.ninja_squad.geektic.metier.Utilisateur;

@Repository
public class GeekDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Utilisateur> getGeeks()
	{
        TypedQuery<Utilisateur> query = em.createQuery("SELECT g from Utilisateur g", Utilisateur.class);
        return query.getResultList();
    }
	
	public List<Utilisateur> getGeeksByCriteria(String s, String i)
	{	
		TypedQuery<Utilisateur> query = em.createQuery("SELECT g from Utilisateur g join g.centreInteret i WHERE g.sexe=:sexe and i.libelle=:interet", Utilisateur.class);   
		query.setParameter("sexe", s);
		query.setParameter("interet", i);
		return query.getResultList();
	}
	
	public List<CentreInteret> getAllInterets()
	{
		TypedQuery<CentreInteret> query = em.createQuery("SELECT c from CentreInteret c", CentreInteret.class);
		return query.getResultList();
	}
	
    public Utilisateur getGeekById(int id)
    {
    	return em.find(Utilisateur.class, id); 
    }
}
