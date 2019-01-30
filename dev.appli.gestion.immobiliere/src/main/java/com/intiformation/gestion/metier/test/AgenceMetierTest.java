package com.intiformation.gestion.metier.test;

import com.intiformation.gestion.entity.Proprietaire;
import com.intiformation.gestion.metier.AgenceMetier;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class AgenceMetierTest {
	
	private AgenceMetier agencemetier;
	private Proprietaire p;
	int id = p.getId();
	
	
	
	@Before
	public void setUp() {
		
		System.out.println("> Avant chaque cas de test");
		
		agencemetier = new AgenceMetier();
	
	}

	@After
	public void tearDown() {
		
		System.out.println("\t> Apr�s chaque cas de test \n");
		
		agencemetier=null;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() {
		
		System.out.println("\t>Avant le 1er cas de test \n");
		
		// Initialisation des objets avant les tests
		Proprietaire p = new Proprietaire();
		
		List<Proprietaire> listeprop = new ArrayList<Proprietaire>();
		
		
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() {
		
		System.out.println("\t>Apr�s le dernier cas de test \n");
	}
	
	
	
	@Test
	public void testAjoutProprietaire() {
		
		System.out.println("\t\t > Cas de test : ajout  d'un propri�taire");
		
		Proprietaire prop = null;
		
		
		p = new Proprietaire(4, "Claude Fran�ois", "Au paradis", "0654878956");
		
		
		assertEquals(agencemetier.ajouterProprietaire(prop), agencemetier.ajouterProprietaire(p));
		
		//assertTrue("Le propri�taire a-t-il �t� ajout�? ", agencemetier.ajouterProprietaire(prop) == agencemetier.ajouterProprietaire(p));
		
		//assertNotNull(agencemetier.ajouterProprietaire(p));
	}
	
	@Test
	public void testListProprietaire() {
		
		System.out.println("\t\t > Cas de test : m�thode listePropri�taire");
		
		p = new Proprietaire(4, "Claude Fran�ois", "999 rue du paradis", "0654878956");
		
		agencemetier.ajouterProprietaire(p);
		
		List<Proprietaire> listeprop = agencemetier.listProprietaires();
		
		listeprop.add(p);
		
		assertNotNull(listeprop);
		
	}
	
	@Test
	public void testGetProprietaireById() {
		
		System.out.println("\t\t > Cas de test : get un propri�taire par son id");
		
		Proprietaire prop = agencemetier.getProprietairebyId(1);
		
		assertNotNull(prop);
		
	}
	
	@Test
	public void testModifProp() {
		
		System.out.println("\t\t > Cas de test : modifier un propri�taire");
		
		Proprietaire prop = agencemetier.getProprietairebyId(1);
		//Proprietaire prop2 = agencemetier.modifierProprietaire(prop);
		
		//assertEquals(prop, prop2);
	}
	
	
	@Test
	public void testSuppressionProp() {
		
		System.out.println("\t\t > Cas de test : supprimer un propri�taire");
		
		agencemetier.supprimerProprietaire(1);
		assertNull(agencemetier.getProprietairebyId(1));
		
	}
	
	
	
	
}
