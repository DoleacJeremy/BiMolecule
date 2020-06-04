package com.JD.MathUtil;

public class Position {
	private float x;
	private float y;
	
	
	public Position(float xe , float ye){
		this.x = xe;
		this.y = ye;
	}
	
	
	
	//getteur
	public float getValeurAbsolueX(){
		return(this.x);
	}
	public float getValeurAbsolueY(){
		return(this.y);
	}
	
	
	
	
	
	//calcule la distance entre deux points
	public static Float distance(Position pointUn , Position pointDeux){
		//longueur des cotees
		float distanceX = pointUn.getValeurAbsolueX()-pointDeux.getValeurAbsolueX();
		float distanceY = pointUn.getValeurAbsolueY()-pointDeux.getValeurAbsolueY();
		
		//Pythagore
		double hypotenuseCarre = Math.abs((distanceX*distanceX)+(distanceY*distanceY));
		Float hypotenuse = (float)Math.sqrt(hypotenuseCarre);
		
		
		return(hypotenuse);
	}
	
	
	
	
	
	
	//recupere le point se trouvant au millieu du segment [p1,p2]
	public static Position getMilieu(Position p1 , Position p2) {
		float positionX;
		float xDistanceDesDeuxPoints;
		if(p1.getValeurAbsolueX() < p2.getValeurAbsolueX()) {
			xDistanceDesDeuxPoints = p2.getValeurAbsolueX()-p1.getValeurAbsolueX();
			positionX = p1.getValeurAbsolueX()+(xDistanceDesDeuxPoints/2);
		}else{
			xDistanceDesDeuxPoints = p1.getValeurAbsolueX()-p2.getValeurAbsolueX();
			positionX = p2.getValeurAbsolueX()+(xDistanceDesDeuxPoints/2);
		}
		
		
		float positionY;
		float yDistanceDesDeuxPoints;
		if(p1.getValeurAbsolueY() < p2.getValeurAbsolueY()) {
			yDistanceDesDeuxPoints = p2.getValeurAbsolueY()-p1.getValeurAbsolueY();
			positionY = p1.getValeurAbsolueY()+(yDistanceDesDeuxPoints/2);
		}else{
			yDistanceDesDeuxPoints = p1.getValeurAbsolueY()-p2.getValeurAbsolueY();
			positionY = p2.getValeurAbsolueY()+(yDistanceDesDeuxPoints/2);
		}
		
		return(new Position(positionX,positionY));
	}

	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		String retour = "";
		
		retour += "["+this.getValeurAbsolueX()+" , "+this.getValeurAbsolueY()+"]";
		
		return(retour);
	}
	
	
	
}
