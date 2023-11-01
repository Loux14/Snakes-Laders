import java.util.Random;

public class SerpentsEtEchelles {

	public static void main(String[] args) {
		int nb = Integer.parseInt(args[0]);

		TableauDeJeu tableau = new TableauDeJeu();
		CircularlyLinkedList<Joueur> joueurs = new CircularlyLinkedList<Joueur>();

		// Creation des joueurs
		joueurs.addFirst(new Joueur());
		for (int i = 1; i < nb; i++)
			joueurs.addLast(new Joueur());

		boolean finDePartie = false;
		Joueur joueurCourant = joueurs.first();

		while (!finDePartie) {
			System.out.println("Tour de " + joueurCourant.getNom());
			int de = rouleLeDe();
			System.out.println("Le joueur " + joueurCourant.getNom() + " a obtenu un " + de);

			//Deplacement du joueur
			int position = joueurCourant.getPosition();
			position += de;
			joueurCourant.setPosition(position);
			System.out.println("Le joueur " + joueurCourant.getNom() + " a atteint la tuile " + position);

		
			Tuile[] tableauTuiles = tableau.getTableau();

			//Position 0 
			if (position == 0) {
				joueurs.rotate();
				joueurCourant = joueurs.first();
				continue;
			}

			//Position > 100
			if (position > 100) {
				int difference = position - 100;
				position = 100 - difference;
				joueurCourant.setPosition(position);
				System.out.println("Le joueur " + joueurCourant.getNom() + " recule à la tuile " + position);
			}

			//Position 100
			if (position == 100) {
				finDePartie = true;
				System.out.println("Le joueur " + joueurCourant.getNom() + " a gagné !");
			}

			//Position tuile spéciale
			if (tableauTuiles[position - 1].isType()) {
				int destination = tableauTuiles[position - 1].getDestination();
				System.out.println("C'est une tuile spéciale !");
				if (destination > position) {
					System.out.println("Le joueur " + joueurCourant.getNom()
							+ " monte sur une échelle et atteint la tuile " + destination);
				} else {
					System.out.println("Le joueur " + joueurCourant.getNom()
							+ " descend d'un serpent et atteint la tuile " + destination);
				}
				joueurCourant.setPosition(destination);
			}


			//Changement de joueur
			joueurs.rotate();
			joueurCourant = joueurs.first();
		}
	}

	public static int rouleLeDe() {
		Random rand = new Random();
		return rand.nextInt(6) + 1;
	}
}
