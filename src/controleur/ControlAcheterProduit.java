package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if(etalVendeur != null) {
			return etalVendeur.acheterProduit(quantite);
		}
		return -1;
	}
	
	public boolean verifierNom(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public Gaulois[] rechercherProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
}
