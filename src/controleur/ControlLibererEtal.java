package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
		this.village = village;
	}

	public boolean isVendeur(String nomVendeur) {
		Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return (etalVendeur != null);
	}
	
	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'�tal est occup�
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantit� de produit � vendre au d�but du march�
	 * 		[4] : quantit� de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if(etal==null) {
			return null;
		}
		String[] donneesEtal = etal.etatEtal();
		village.partirVendeur(etal.getVendeur());
		return donneesEtal;
	}

}
