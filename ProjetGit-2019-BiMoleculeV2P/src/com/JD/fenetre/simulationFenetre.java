package com.JD.fenetre;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

import com.JD.core.AmmasMolleculaire;

@SuppressWarnings("serial")
public class simulationFenetre extends JFrame implements Runnable{
	private SimulationPannel panel;
	private int delayMS;
	private int nbMolecule;
	
	public simulationFenetre(int taille, int nbMolecule, int delay , boolean drone ) {
		super();
		

		AmmasMolleculaire g = new AmmasMolleculaire(taille);
		g.remplirMolecules(nbMolecule);
		this.delayMS = delay;
		this.nbMolecule = nbMolecule;
		
		
		this.panel = new SimulationPannel(g,taille,drone);
		this.panel.setPreferredSize(new Dimension(taille,taille));
		this.panel.setBackground(Color.GREEN);
		this.setContentPane(this.panel);
		
		
		this.setResizable(false);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Bi Molecule - simulation - "+nbMolecule);
		this.setSize(new Dimension(taille,taille));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	//lance l'animation en boucle avec le delai choisi jusqu'a ce que plus aucune molecule ne bouge
	private void lancerAnimation() throws InterruptedException {
		boolean fin = false;
		
		while(!fin) {
			if(!this.isActive())
				Thread.sleep(1000);
			fin = this.panel.bouger();
			this.panel.repaint();

			Thread.sleep(this.delayMS);
		}
		this.setTitle("Bi Molecule - simulation - "+this.nbMolecule+" - fini");
		System.out.println("fin de la simulation, et merci d'avoir lance le programme dans la console !");
	}

	//lancement de la simulation avec le thread
	public void run() {
		try {
			this.lancerAnimation();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}