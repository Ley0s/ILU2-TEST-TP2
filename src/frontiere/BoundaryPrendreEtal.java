package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolé " + nomVendeur 
					+ " mais il faut être un habitant de notre village pour commencer ici.\n");
		} else {
			System.out.println("Bonjour " + nomVendeur
					+ ", je vais chercher si je peux vous trouver un étal.\n");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Désolé " + nomVendeur
						+ " je n'ai plus détal qui ne soit pas déjà occupé.\n");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !\n");
		System.out.println("Il me faudrait quelques renseignements :\n");
		String question = "Quel produit souhaitez vous vendre ?\n";
		String produit = Clavier.entrerChaine(question);
		question = "Combien souhaitez-vous en vendre ?\n";
		int nbProduit = Clavier.entrerEntier(question);
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur
					+ " s'est installé à l'étal n°" + numeroEtal + "\n");
		}
	}
}
