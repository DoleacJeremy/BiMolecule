package com.JD.fenetre;

import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ParamFenetre extends JFrame {
	private ParamPanel panel;

	public ParamFenetre() {
		this.panel = new ParamPanel();
		this.panel.setPreferredSize(new Dimension(400, 400));
		this.setContentPane(this.panel);

		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Bi Mollecule - parametrage");
		this.setSize(new Dimension(400, 400));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}