package bi_molecule;

import static org.junit.Assert.*;
import org.junit.Test;
import Math_util.Position;

public class Molecule_test {

	@Test
	public void testValidationPosition() {

		Molecule bonneposition = new Molecule(new Position(1,2));
		
		Molecule poto1 = new Molecule(new Position(0,0));
		Molecule poto2 = new Molecule(new Position(2,0));
		
		bonneposition.setMolecules(poto1, poto2);
		
		assertTrue(bonneposition.estBienPositioner());
	}

	@Test
	public void testValidationPositionPointAligner() {

		Molecule bonneposition = new Molecule(new Position(1,1));
		
		Molecule poto1 = new Molecule(new Position(0,0));
		Molecule poto2 = new Molecule(new Position(2,2));
		
		bonneposition.setMolecules(poto1, poto2);
		
		assertTrue(bonneposition.estBienPositioner());
	}

	@Test
	public void testPositionPasAligner() {

		Molecule bonneposition = new Molecule(new Position(1,1));
		
		Molecule poto1 = new Molecule(new Position(0,0));
		Molecule poto2 = new Molecule(new Position(3,2));
		
		bonneposition.setMolecules(poto1, poto2);
		
		assertFalse(bonneposition.estBienPositioner());
	}

	@Test
	public void testRepositionementDejaBon() {

		Molecule bonneposition = new Molecule(new Position(0,0));
		Molecule poto1 = new Molecule(new Position(1,1));
		Molecule poto2 = new Molecule(new Position(-1,-1));
		
		
		bonneposition.setMolecules(poto1, poto2);
		bonneposition.repositioner();


		assertTrue(bonneposition.getPosition().getValeurAbsolueX() == 0);
		assertTrue(bonneposition.getPosition().getValeurAbsolueY() == 0);
		assertTrue(bonneposition.estBienPositioner());
	}
	
	@Test
	public void testRepositionementPasDejaBon() {

		Molecule bonneposition = new Molecule(new Position(-2,1));
		Molecule poto1 = new Molecule(new Position(1,1));
		Molecule poto2 = new Molecule(new Position(-1,-1));
		
		
		bonneposition.setMolecules(poto1, poto2);
		bonneposition.repositioner();
		
		
		assertEquals(bonneposition.getPosition(),new Position(-1.5F,1.5F));
		assertTrue(bonneposition.estBienPositioner());
	}

}
