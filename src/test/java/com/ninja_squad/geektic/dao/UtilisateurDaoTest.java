package com.ninja_squad.geektic.dao;

import java.util.*;

import com.ninja_squad.geektic.dao.GeekDAO;
import com.ninja_squad.geektic.metier.Utilisateur;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.*;


public class UtilisateurDaoTest extends BaseDaoTest {
	
	@Autowired
	private GeekDAO gDao;

	@Test
    public void testGetGeekByCriteria() {
       List<Utilisateur> result = gDao.getGeeksByCriteria("homme", "Java");
       Assert.assertEquals("homme", result.get(0).sexe);
    }
	
}
