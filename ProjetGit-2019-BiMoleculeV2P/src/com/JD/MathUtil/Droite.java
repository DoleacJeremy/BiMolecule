package com.JD.MathUtil;

public class Droite {
	private float coefficient;
	private float reste;

	
	//creation d'une droite a partir de deux points
	public Droite(Position p1, Position p2) {
		float x = p2.getValeurAbsolueX() - p1.getValeurAbsolueX();
		float y = p2.getValeurAbsolueY() - p1.getValeurAbsolueY();

		if (x != 0) {
			this.coefficient = y / x;
		}

		this.reste = p1.getValeurAbsolueY() - (this.coefficient * p1.getValeurAbsolueX());
	}
	//creation d'une droite a partir d'un couple classique de a et b
	public Droite(float a, float b) {
		this.coefficient = a;
		this.reste = b;
	}

	
	public float getCoefficient() {
		return (this.coefficient);
	}
	public float getReste() {
		return (this.reste);
	}

	// permet de dire si un point appartient a la droite
	public boolean apartientDroite(Position p) {
		boolean retour = this.coefficient * p.getValeurAbsolueX() + this.reste == p.getValeurAbsolueY();
		return (retour);
	}

	// permet de trouver la perpendiculaire d'une droite qui passe par un point donner
	public Droite perpendiculaire(Position p) {
		//a = Float.MAX_VALUE; dans le cas d'une perpendiculaire qui sera verticale )
		float a = Float.MAX_VALUE;
		if (this.coefficient != 0)
			a = -(1 / this.coefficient);

		float b = p.getValeurAbsolueY() - a * p.getValeurAbsolueX();

		Droite retour = new Droite(a, b);
		return (retour);
	}

	// permet de trouver la perpendiculaire d'une droite
	public Droite perpendiculaire() {
		float a = -(1 / this.coefficient);
		float b = this.reste;

		Droite retour = new Droite(a, b);

		return (retour);
	}

	// permet d'obtenir la position du point d'intersection des deux droites passer en paremetre
	public static Position intersection(Droite d1, Droite d2) {
		// si les droites sont parallele et ne se touche donc pas ou ont tous les points confondus
		if (d1.getCoefficient() == d2.getCoefficient())
			return (null);

		float x = (d2.getReste() - d1.getReste()) / (d1.getCoefficient() - d2.getCoefficient());
		float y = d1.getCoefficient() * x + d1.getReste();

		return (new Position(x, y));
	}

	// permet de trouver le plus proche point de p2 qui appartient a la droite courante
	public Position getPlusProchePoint(Position p) {

		Droite perpendiculaire = this.perpendiculaire(p);
		Position retour = Droite.intersection(this, perpendiculaire);

		return (retour);
	}

	
	
	
	
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Droite other = (Droite) obj;
		if (Float.floatToIntBits(coefficient) != Float.floatToIntBits(other.coefficient))
			return false;
		if (Float.floatToIntBits(reste) != Float.floatToIntBits(other.reste))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Droite [coefficient=" + coefficient + " , reste=" + reste + "]";
	}

}