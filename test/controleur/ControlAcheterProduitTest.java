package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef chef;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlAcheterProduit controlAcheterProduit;
	
	@BeforeEach
	public void initialisationSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		chef = new Chef("Abraracourcix", 10, village);
		village.setChef(chef);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}

	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit);
	}

	@Test
	void testAcheterProduit() {
		Gaulois asterix = new Gaulois("Asterix", 10);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 10);
		assertEquals(controlAcheterProduit.acheterProduit("Asterix", 5), 5);
		assertEquals(controlAcheterProduit.acheterProduit("Asterix", 10), 5);
		assertEquals(controlAcheterProduit.acheterProduit("Asterix", 5), 0);
		assertNotEquals(controlAcheterProduit.acheterProduit("Existe pas", 5), 5);
	}

	@Test
	void testVerifierNom() {
		assertTrue(controlAcheterProduit.verifierNom("Abraracourcix"));
		assertFalse(controlAcheterProduit.verifierNom("Asterix"));
		village.ajouterHabitant(new Gaulois("Asterix", 10));
		assertTrue(controlAcheterProduit.verifierNom("Asterix"));
		assertFalse(controlAcheterProduit.verifierNom("Panoramix"));
		village.ajouterHabitant(new Druide("Panoramix", 10, 1, 5));
		assertTrue(controlAcheterProduit.verifierNom("Panoramix"));
		assertFalse(controlAcheterProduit.verifierNom("Existe pas"));
	}

	@Test
	void testRechercherVendeursProduit() {
		assertNull(controlAcheterProduit.rechercherProduit("fleurs"));
		Gaulois asterix = new Gaulois("Asterix", 10);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 10);
		assertArrayEquals(controlAcheterProduit.rechercherProduit("fleurs"), new Gaulois[] {asterix});
		Druide panoramix = new Druide("Panoramix", 10, 1, 5);
		village.ajouterHabitant(panoramix);
		village.installerVendeur(panoramix, "fleurs", 5);
		assertArrayEquals(controlAcheterProduit.rechercherProduit("fleurs"), new Gaulois[] {asterix, panoramix});
		assertNull(controlAcheterProduit.rechercherProduit("cailloux"));
	}

}
