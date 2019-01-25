package bi_molecule;

import java.util.LinkedList;
import java.util.Random;

import Math_util.Position;

public class AmmasMolleculaire {
	private LinkedList<Molecule> molecules;
	private int taille;

	public AmmasMolleculaire(int taille) {
		// taille de zone dans laquelle on va pouvoir mettre des molecules
		this.taille = taille;
		this.molecules = new LinkedList<Molecule>();
	}

	// recupere la liste des positions pour l'affichage principalement
	public LinkedList<Position> getPositions() {
		LinkedList<Position> positions = new LinkedList<Position>();

		for (Molecule m : this.molecules) {
			positions.add(m.getPosition());
		}

		return (positions);
	}

	// permet de lancer le deplacement de toutes les molecules pour un tour
	public boolean jouerMolecules() {
		boolean fin = true;
		int nbModif = 0;

		for (Molecule m : this.molecules) {
			if (!m.estBienPositioner()) {
				fin = false;
				nbModif++;
				m.repositioner();
			}
		}

		System.out.println("AmmasMolleculaire>40  nombres de mouvements : " + nbModif);
		return (fin);
	}

	// permet de tout mettre comme il faut au debut
	public void remplirMolecules(int effectif) {
		//creation et stockage de toutes les molecules
		System.out.println("AmmasMolleculaire>49 remplissage des molecules (" + this.molecules.size() + ")");
		Molecule insertion;
		for (int i = 0; i < effectif; i++) {
			insertion = new Molecule(
					new Position((float) (Math.random() * this.taille), (float) (Math.random() * this.taille)));
			this.molecules.add(insertion);
		}

		//chacune des molecules choisie deux autres a regarde pour etre a egale distance
		System.out.println("AmmasMolleculaire>58 fin de creation des molecules");
		for (int i = 0; i < effectif; i++) {
			this.trouverMolecules(i);
		}

		System.out.println("AmmasMolleculaire>63 fin de l'assignation des molecules");
	}

	// permet de selectionner les deux autres molecules
	// (ne peuvent pas etre une seule selectionner deux fois ni la molecule courrante)
	private void trouverMolecules(int i) {

		int poto1 = (new Random()).nextInt(this.molecules.size());
		int poto2 = (new Random()).nextInt(this.molecules.size());

		while (poto1 == i || poto2 == i || poto1 == poto2) {
			poto1 = (new Random()).nextInt(this.molecules.size());
			poto2 = (new Random()).nextInt(this.molecules.size());
		}

		this.molecules.get(i).setMolecules(this.molecules.get(poto1), this.molecules.get(poto2));
	}

}