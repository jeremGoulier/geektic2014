package com.ninja_squad.geektic.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDAO;
import com.ninja_squad.geektic.metier.CentreInteret;
import com.ninja_squad.geektic.metier.Utilisateur;

import javax.transaction.Transactional;



@RestController
@Transactional
@RequestMapping("/api/geek")
public class GeekService {

	@Autowired
	private GeekDAO gDAO;
	
	
    @RequestMapping("/RechercheGeek/{sex}/{interet}")
    public List<Utilisateur>afficherGeeksParSexe(@PathVariable("sex") String s, @PathVariable("interet") String i) {  
        return gDAO.getGeeksByCriteria(s, i);
    }  
    
    @RequestMapping("/ListeCentreInteret")
    public List<CentreInteret>buildComboBox() {  
        return gDAO.getAllInterets();
    }  
    
    @RequestMapping("/{id}")
    public Utilisateur getGeek(@PathVariable int id)
    {
       return gDAO.getGeekById(id);
    }
    
    
}



