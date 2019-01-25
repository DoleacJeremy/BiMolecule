package fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ParamPanel extends JPanel implements ActionListener {
	private BufferedImage background;

	private JTextArea texteTaille;
	private JTextPane infoTaille;

	private JTextArea texteMolecule;
	private JTextPane infoMolecule;

	private JTextArea texteDelay;
	private JTextPane infoDelay;

	private JCheckBox casebox;
	private JTextPane infocasebox;

	private JButton bouton;

	public ParamPanel() {
		try {
			this.background = ImageIO.read(new File("background_param.png"));
		} catch (IOException e) {
			System.out.println("erreur de récupération de l'image du background");
		}

		// taille
		this.texteTaille = new JTextArea();
		this.texteTaille.setPreferredSize(new Dimension(50, 20));
		this.texteTaille.setText("600");
		this.infoTaille = new JTextPane();
		this.infoTaille.setText("taille fenetre (nombre) =>");
		this.infoTaille.setPreferredSize(new Dimension(200, 20));
		this.add(this.infoTaille);
		this.add(this.texteTaille);

		// molecule
		this.texteMolecule = new JTextArea();
		this.texteMolecule.setPreferredSize(new Dimension(50, 20));
		this.texteMolecule.setText("100");
		this.infoMolecule = new JTextPane();
		this.infoMolecule.setText("nb molecule (nombre) =>");
		this.infoMolecule.setPreferredSize(new Dimension(205, 20));
		this.add(this.infoMolecule);
		this.add(this.texteMolecule);

		// delay
		this.texteDelay = new JTextArea();
		this.texteDelay.setPreferredSize(new Dimension(50, 20));
		this.texteDelay.setText("250");
		this.infoDelay = new JTextPane();
		this.infoDelay.setText("delai en ms (nombre) =>");
		this.infoDelay.setPreferredSize(new Dimension(205, 20));
		this.add(this.infoDelay);
		this.add(this.texteDelay);

		// drone
		this.casebox = new JCheckBox();
		this.casebox.setSelected(false);
		this.infocasebox = new JTextPane();
		this.infocasebox.setText("affichage simpliste =>");
		this.infocasebox.setPreferredSize(new Dimension(180, 20));
		this.add(this.infocasebox);
		this.add(this.casebox);

		// vide
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(390, 220));
		this.add(panel);

		JPanel panel2 = new JPanel();
		panel2.setOpaque(false);
		panel2.setPreferredSize(new Dimension(260, 10));
		this.add(panel2);

		// bouton
		this.bouton = new JButton();
//		this.bouton .setPreferredSize(new Dimension(80,20));
		this.bouton.setPreferredSize(new Dimension(100, 30));
		this.bouton.setText("valider");
		this.bouton.addActionListener(this);
		this.add(this.bouton);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.background, 0, 0, 400, 400, null);
	}

	
	//methode qui intercepte l'appui sur le bouton aka le lancement de la simulation
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int taille = 600;
		int nbMolecule = 100;
		int delay = 250;
		boolean affichageDrone = !this.casebox.isSelected();
		
		boolean validationLancementFenetre = true;
		

		this.texteTaille.setBackground(Color.WHITE);
		try {
			taille = Integer.parseInt(this.texteTaille.getText());
			if(taille < 150)
				throw new Exception();
		}catch(Exception e) {
			this.texteTaille.setBackground(Color.RED);
			validationLancementFenetre = false;
		}
		this.texteMolecule.setBackground(Color.WHITE);
		try {
			nbMolecule = Integer.parseInt(this.texteMolecule.getText());
			if(nbMolecule < 3)
				throw new Exception();
		}catch(Exception e) {
			this.texteMolecule.setBackground(Color.RED);
			validationLancementFenetre = false;
		}
		this.texteDelay.setBackground(Color.WHITE);
		try {
			delay = Integer.parseInt(this.texteDelay.getText());
			if(delay < 0)
				throw new Exception();
		}catch(Exception e) {
			this.texteDelay.setBackground(Color.RED);
			validationLancementFenetre = false;
		}
		


		
		if(validationLancementFenetre) {
			String infos = this.texteTaille.getText() + "\n";
			infos += this.texteMolecule.getText() + " molecules\n";
			infos += this.texteDelay.getText() + " delai en ms\n";
			infos += "affichage simpliste : " + this.casebox.isSelected();
	
			System.out.println("infos recueillies : \n" + infos);
	
			simulationFenetre fenetre = new simulationFenetre(taille, nbMolecule, delay, affichageDrone);
			new Thread(fenetre).start();
		}

	}

}