package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef chef;
	private ControlAfficherMarche controlAfficherMarche;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		chef = new Chef("Abraracourcix", 10, village);
		village.setChef(chef);
		controlAfficherMarche = new ControlAfficherMarche(village);	
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarche);
	}

	@Test
	void testDonnerInfosMarche() {
		assertArrayEquals(controlAfficherMarche.donnerInfosMarche(), new String[] {});
		village.installerVendeur(new Gaulois("Asterix", 10), "fleurs", 10);
		assertArrayEquals(controlAfficherMarche.donnerInfosMarche(), new String[] {"Asterix", "10", "fleurs"});
		village.installerVendeur(new Druide("Panoramix", 10, 1, 5), "pains", 5);
		assertArrayEquals(controlAfficherMarche.donnerInfosMarche(), new String[] {"Asterix", "10", "fleurs", "Panoramix", "5", "pains"});
	}
}