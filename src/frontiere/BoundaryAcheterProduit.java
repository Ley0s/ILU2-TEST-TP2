package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierNom(nomAcheteur)) {
			System.out.println("Je suis d�sol� " + nomAcheteur
					+ " mais il faut �tre un habitant de notre village pour commercer ici.");
		} else {
			String question = "Quel produit voulez vous acheter ?";
			String produit = Clavier.entrerChaine(question);
			Gaulois[] vendeurs = controlAcheterProduit.rechercherProduit(produit);
			if (vendeurs.length == 0) {
				System.out.println("Je suis d�sol� " + nomAcheteur 
						+ " mais personne ne vend ce produit ici.");
			} else {
				question = "Chez quel commer�ant voulez-vous acheter des " + produit +" ?";
				for (int i = 0; i < vendeurs.length; i++) {
					question += ("\n" + (i+1) + " - " + vendeurs[i].getNom());
				}
				int reponse = Clavier.entrerEntier(question);
				Gaulois vendeur = vendeurs[reponse-1];
				System.out.println(nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " 
						+ vendeur.getNom());
				System.out.println("Bonjour " + nomAcheteur);
				question = "Combien de " + produit + " voulez vous acheter ?";
				int quantite = Clavier.entrerEntier(question);
				int quantiteAchetee = controlAcheterProduit.acheterProduit(vendeur.getNom(), quantite);
				if (quantiteAchetee == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit
							+ ", malheureusement il n'y en a plus !");
				} else if (quantiteAchetee < quantite) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit
							+ ", malheureusement " + vendeur.getNom() + " n'en a plus que " 
							+ quantiteAchetee + ". " + nomAcheteur + " ach�te tout le stock de " 
							+ vendeur.getNom() + ".");
				} else {
					System.out.println(nomAcheteur + " ach�te " + quantiteAchetee + " " + produit + " � " 
							+ vendeur.getNom() + ".");
				}
			}
		}
		
	}
}