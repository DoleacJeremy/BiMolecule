package bi_molecule;

import Math_util.Droite;
import Math_util.Position;

public class Molecule {
	private Position position;
	private Molecule moleculeUn;
	private Molecule moleculeDeux;

	public Molecule(Position p) {
		this.position = p;
	}

	public void setMolecules(Molecule m1, Molecule m2) {
		this.moleculeUn = m1;
		this.moleculeDeux = m2;
	}

	public Position getPosition() {
		return (this.position);
	}

	// regarde si la molecule est bien positionnee par rapport aux deux autres qu'elle observe
	public boolean estBienPositioner() {
		float distance1 = Position.distance(this.position, this.moleculeUn.getPosition());
		float distance2 = Position.distance(this.position, this.moleculeDeux.getPosition());
		float rapport = distance1 / distance2;

		boolean fin = ((rapport <= 1.00005F) && (rapport >= 0.99995));
		return (fin);
	}

	//repositionne la molecule suivante a egale distance des deux qu'elle observe
	public void repositioner() {

		// faire une droite qui passe par les deux positions des molecules qu'elle observe
		Droite droite = new Droite(this.moleculeUn.getPosition(), this.moleculeDeux.getPosition());

		// abort abort , la droite a un coefficient de 0. je repete ha pas perpendiculaire
		if (droite.getCoefficient() == 0) {
			this.position = new Position((float) (Math.random() * 200) + 100, (float) (Math.random() * 200) + 100);
		} else {

			// fait la perpendiculaire a la droite precedemment cree , cela va donner tous les point a egale distance des deux molecules
			Droite perpendiculaire = droite.perpendiculaire(
					Position.getMilieu(this.moleculeUn.getPosition(), this.moleculeDeux.getPosition()));

			// trouver le plus proche point sur toutes des possibilites precedemment trouver
			this.position = perpendiculaire.getPlusProchePoint(this.position);
		}

	}

}