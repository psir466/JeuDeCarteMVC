package org.psi.metier;

import java.util.ArrayList;
import java.util.Collections;

public class CoolJeu {

	private ArrayList<Carte> jeu = new ArrayList<>();

	public CoolJeu() {
		

		for (Type type : Type.values()) {

			if (type != Type.C_2 && type != Type.C_3 && type != Type.C_4 && type != Type.C_5 && type != Type.C_6) {

				for (Couleur couleur : Couleur.values()) {

					Carte carte = new Carte(couleur, type);

					this.jeu.add(carte);

				}
			}

		}

	}

	public ArrayList<Carte> getJeu() {
		return jeu;
	}

	public void setJeu(ArrayList<Carte> jeu) {
		this.jeu = jeu;
	}

	
	public void coolmelanger() {
		// TODO Auto-generated method stub

		System.out.println("Cool mélange");
		
		Collections.shuffle(jeu);
	}
	
}
