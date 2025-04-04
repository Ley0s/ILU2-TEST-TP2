package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà  un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois " + nomVisiteur);
					String questionForce = "Quelle est votre force ?\n";
					int force = Clavier.entrerEntier(questionForce);
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur);
		String question = new String();
		question = "Quelle est votre force ?\n";
		int forceDruide = Clavier.entrerEntier(question.toString());
		int effetPotionMax, effetPotionMin;
		do {
			question = "Quelle est la force de la potion la plus faible que vous produisez ?\n";
			effetPotionMin = Clavier.entrerEntier(question);
			question = "Quelle est la force de la potion la plus forte que vous produisez ?\n";
			effetPotionMax = Clavier.entrerEntier(question);
			if(effetPotionMax < effetPotionMin) {
				System.out.println("Attention druide, vous vous êtes trompés entre le minimum et le maximum\n");
			}
		} while (effetPotionMax < effetPotionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
