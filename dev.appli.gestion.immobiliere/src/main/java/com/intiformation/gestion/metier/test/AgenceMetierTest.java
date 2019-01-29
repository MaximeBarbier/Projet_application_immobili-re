package com.intiformation.gestion.metier.test;

import com.intiformation.gestion.entity.Proprietaire;
import com.intiformation.gestion.metier.AgenceMetier;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class AgenceMetierTest {
	
	private AgenceMetier agencemetier;
	private Proprietaire p;
	
	@Before
	public void setUp() {
		
		agencemetier = new AgenceMetier();
	
	}

	@After
	public void tearDown() {
		
		agencemetier=null;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() {
		
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() {
		
	}
	
	@Test
	public void testListProprietaire() {
		
		System.out.println("\t\t > Cas de test : méthode listePropriétaire");
		
		assertNotNull(agencemetier.listProprietaires());
		
	}
	
	@Test
	public void testAjoutProprietaire() {
		
		System.out.println("\t\t > Cas de test : ajout  d'un propriétaire");
		
		assertNotNull(agencemetier.ajouterProprietaire(p));
	}
	
	public void testGetProprietaireById() {
		
		System.out.println("\t\t > Cas de test : get un propriétaire par son id");
		
		asser
	}
}
