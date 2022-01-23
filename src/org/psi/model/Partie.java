package org.psi.model;

import java.util.ArrayList;

import org.psi.metier.Iregle;
import org.psi.metier.Jeu;
import org.psi.metier.JeuFactory;
import org.psi.metier.JeuFactory.TypeJeu;
import org.psi.metier.Joueur;
import org.psi.metier.IJoueur;
import org.psi.metier.Regle;
import org.psi.metier.WinningJoueur;
import org.psi.metier.iJeu;

public class Partie {

	private ArrayList<IJoueur> joueurs = new ArrayList<>();

	private iJeu jeu = new JeuFactory().creerJeu(TypeJeu.cool);

	private Iregle regle;

	public Partie() {

	}

	public Partie(Iregle regle) {
		super();
		this.regle = regle;

	}

	public ArrayList<IJoueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<IJoueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Iregle getRegle() {
		return regle;
	}

	public void setRegle(Iregle regle) {
		this.regle = regle;
	}

	public IJoueur evalueWinner() {

		WinningJoueur winner = null;
		
		boolean atoutgagne = false;

		for (IJoueur joueur1 : this.getJoueurs()) {

			for (IJoueur joueur2 : this.getJoueurs()) {

				if (atoutgagne) {
					break;
				}

				if (!joueur1.equals(joueur2)) {

					atoutgagne = true;

					if (!this.getRegle().hand1GagneHand2(joueur1.getHand(), joueur2.getHand())) {
						atoutgagne = false;
						break;
					}

					// winner = (WinningJoueur) joueur1; Cette ligne plante
					// pas possible de caster comme cela
					// à voir

					// on utilise décorator 					
				 winner = new WinningJoueur(joueur1);
					
				}

			}

		}

		

		
		return winner;

	}

	public iJeu getJeu() {
		return jeu;
	}

	public void setJeu(iJeu jeu) {
		this.jeu = jeu;
	}

}
