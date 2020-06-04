package com.JD.MathUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Droite_test {

	@Test
	public void testIntersection() {
		Droite d1 = new Droite(3,0);
		Droite d2 = new Droite(2,0);
		
		Position intersection = Droite.intersection(d1, d2);
		assertEquals(intersection,new Position(0,0));
	}
	
	@Test
	public void testHaConfonduIntersection() {
		Droite d1 = new Droite(2,4);
		Droite d2 = new Droite(2,4);
		
		Position intersection = Droite.intersection(d1, d2);
		assertNull(intersection);
	}
	
	@Test
	public void testHaPasIntersection() {
		Droite d1 = new Droite(2,4);
		Droite d2 = new Droite(2,1);
		
		Position intersection = Droite.intersection(d1, d2);
		assertNull(intersection);
	}
	
	@Test
	public void testDeuxConstructeur() {
		Droite d1 = new Droite(1,1);
		Droite d2 = new Droite(new Position(0,1),new Position(1,2));
		
		assertEquals(d1.getCoefficient(),d2.getCoefficient(),0);
		assertEquals(d1.getReste(),d2.getReste(),0);
	}
	
	@Test
	public void testDeuxConstructeur2() {
		Droite d1 = new Droite(1,1);
		Droite d2 = new Droite(new Position(1,2),new Position(0,1));
		
		assertEquals(d1.getCoefficient(),d2.getCoefficient(),0);
		assertEquals(d1.getReste(),d2.getReste(),0);
	}

	
	@Test
	public void testPointAppartien() {
		Droite d1 = new Droite(1,0);

		Position appartiens1 = new Position(1,1);
		Position appartiens2 = new Position(2,2);
		Position appartiens3 = new Position(-4,-4);

		assertTrue(d1.apartientDroite(appartiens1));
		assertTrue(d1.apartientDroite(appartiens2));
		assertTrue(d1.apartientDroite(appartiens3));
	}

	
	@Test
	public void testPointPasAppartien() {
		Droite d1 = new Droite(2,0);

		Position appartiens1 = new Position(1,1);
		Position appartiens2 = new Position(2,2);
		Position appartiens3 = new Position(-4,-4);

		assertFalse(d1.apartientDroite(appartiens1));
		assertFalse(d1.apartientDroite(appartiens2));
		assertFalse(d1.apartientDroite(appartiens3));
	}

	
	@Test
	public void testPlusProchePointSimple() {
		Droite d1 = new Droite(1,0);

		Position point = new Position(2,0);
		Position attendu = new Position(1,1);
		
		assertEquals(d1.getPlusProchePoint(point),attendu);
	}

	
	@Test
	public void testPlusProchePointConfondu() {
		Droite d1 = new Droite(1,0);

		Position point = new Position(1,1);
		Position attendu = new Position(1,1);
		
		assertEquals(d1.getPlusProchePoint(point),attendu);
	}

	
	@Test
	public void testPlusProchePoint() {
		Droite d1 = new Droite(1,0);

		Position point = new Position(2,1);
		Position attendu = new Position(1.5F,1.5F);
		
		assertEquals(d1.getPlusProchePoint(point),attendu);
	}

	
	@Test
	public void testPerpendiculaire() {
		Droite d1 = new Droite(1,0);

		Droite perpendiculairePresumer = d1.perpendiculaire();
		Droite perpendiculaire = new Droite(-1,0);
		
		assertEquals(perpendiculairePresumer,perpendiculaire);
	}

	
	@Test
	public void testPerpendiculaire2() {
		Droite d1 = new Droite(3,4);

		Droite perpendiculairePresumer = d1.perpendiculaire();
		Droite perpendiculaire = new Droite(-0.33333334F,4);
		
		assertEquals(perpendiculairePresumer,perpendiculaire);
	}

	
	@Test
	public void testPerpendiculairePoint() {
		Droite d1 = new Droite(1,0);
		Position point = new Position(2,0);
		
		
		Droite perpendiculairePresumer = d1.perpendiculaire(point);
		Droite perpendiculaire = new Droite(-1,2);
		
		
		assertEquals(perpendiculairePresumer,perpendiculaire);
	}

}
