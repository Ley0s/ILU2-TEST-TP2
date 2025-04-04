package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.\n");
		} else {
			System.out.println(nomAcheteur + ", vous trouverez au marché.\n");
			String vendeur, quantite, produit;
			for (int i = 0; i < infosMarche.length; i++) {
				vendeur = infosMarche[i];
				i++;
				quantite = infosMarche[i];
				i++;
				produit = infosMarche[i];
				System.out.println("- " + vendeur + " qui vend " + quantite + " " + produit);
			}
			
		}
	}
}
