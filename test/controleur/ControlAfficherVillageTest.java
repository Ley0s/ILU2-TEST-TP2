package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef chef;
	private ControlAfficherVillage controlAfficherVillage;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		chef = new Chef("Abraracourcix", 10, village);
		village.setChef(chef);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage);
	}

	@Test
	void testDonnerNomsVillageois() {
		assertArrayEquals(controlAfficherVillage.donnerNomsVillageois(), new String[]{"Abraracourcix"});
		village.ajouterHabitant(new Gaulois("Asterix", 10));
		assertArrayEquals(controlAfficherVillage.donnerNomsVillageois(), new String[]{"Abraracourcix", "Asterix"});
		village.ajouterHabitant(new Druide("Panoramix", 10, 1, 5));
		assertArrayEquals(controlAfficherVillage.donnerNomsVillageois(), new String[] {"Abraracourcix", "Asterix", "le druide Panoramix"});
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(), "le village des irréductibles");
		assertNotEquals(controlAfficherVillage.donnerNomVillage(), "CrousLand");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);
		assertNotEquals(controlAfficherVillage.donnerNbEtals(), 6);
	}

}