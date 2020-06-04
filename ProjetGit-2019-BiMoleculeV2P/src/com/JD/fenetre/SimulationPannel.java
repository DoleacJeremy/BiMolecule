package com.JD.fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.JD.MathUtil.Position;
import com.JD.core.AmmasMolleculaire;

@SuppressWarnings("serial")
public class SimulationPannel extends JPanel {
	private AmmasMolleculaire groupe;
	private BufferedImage background;
	private BufferedImage drone;
	private int taille;
	private boolean affichageDrone;

	public SimulationPannel(AmmasMolleculaire g, int t, boolean drone) {
		this.groupe = g;
		this.taille = t;
		this.affichageDrone = drone;

		try {
			this.background = ImageIO.read(new File("background.png"));
			this.drone = ImageIO.read(new File("drone.png"));
		} catch (IOException e) {
			System.out.println("oui alors heu bonjours , j'ai pas pu chopper l'image ");
			System.out.println("lol");
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(this.background, 0, 0, this.taille, this.taille, null);

		LinkedList<Position> positions = this.groupe.getPositions();
		for (Position p : positions) {
			if (this.affichageDrone)
				g.drawImage(this.drone, (int) p.getValeurAbsolueX() - 10, (int) p.getValeurAbsolueY() - 10, 20, 20,null);
			else {
				g.setColor(Color.BLUE);
				g.drawRect((int) p.getValeurAbsolueX() - 5, (int) p.getValeurAbsolueY() - 5, 10, 10);
			}
		}
	}

	// permet de bouger une fois toutes les molecules
	public boolean bouger() {
		boolean retour = this.groupe.jouerMolecules();
		this.repaint();
		return (retour);
	}
}