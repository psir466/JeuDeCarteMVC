package org.psi.metier;

import java.util.ArrayList;
import java.util.Collections;

public class Jeu implements iJeu {
	
	private ArrayList<Carte> jeu = new ArrayList<>();
	
	public Jeu() {
		
		for (Type type : Type.values()) { 
			
			for (Couleur couleur : Couleur.values()) {
				
				Carte carte = new Carte(couleur, type);
				
				this.jeu.add(carte);
				
			}
		     
		}
		
	}

	public ArrayList<Carte> getJeu() {
		return jeu;
	}

	public void setJeu(ArrayList<Carte> jeu) {
		this.jeu = jeu;
	}	
	
	
	public void melanger() {
		
		Collections.shuffle(jeu);
	}

}
