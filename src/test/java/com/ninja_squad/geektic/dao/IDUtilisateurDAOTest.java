package com.ninja_squad.geektic.dao;

import java.util.*;

import com.ninja_squad.geektic.dao.GeekDAO;
import com.ninja_squad.geektic.metier.Utilisateur;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.*;


public class IDUtilisateurDAOTest extends BaseDaoTest {
	
	@Autowired
	private GeekDAO gDao;
	
	@Test
    public void testGetGeekByID() {
        Utilisateur result = gDao.getGeekById(1);
        Assert.assertEquals(1, result.idUtilisateur);
     }
}
