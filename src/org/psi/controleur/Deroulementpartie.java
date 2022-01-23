package org.psi.controleur;

import org.psi.metier.IJoueur;
import org.psi.metier.Joueur;
import org.psi.metier.Regle;
import org.psi.model.Partie;
import org.psi.vue.Ivue;
import org.psi.vue.Vue;
import org.psi.vue.VueSwing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.psi.metier.Carte;
import org.psi.metier.Hand;

public class Deroulementpartie {

	private static Partie partie;

	private static Ivue vue = new Vue();

	private static GameState gameState;

	enum GameState {

		choixPartie, crtJoueur, distribCarte, voirCartes, winner;

	};
	
	static {
		creerNewPartie();
	}

	public static void creerNewPartie() {

		

		partie = new Partie();

		gameState = GameState.crtJoueur;

	}

	public static void creerJoueur(String nom) {

		partie.getJoueurs().add(new Joueur(nom));

	}

	public static void distribuerCarteJoueurs() {

		int i = 0;

		partie.getJeu().melanger();

		for (IJoueur joueur : partie.getJoueurs()) {

			List<Carte> cartes = new ArrayList<>();

			Carte c = partie.getJeu().getJeu().get(i);

			cartes.add(c);

			joueur.setHand(new Hand(cartes));

			i++;
		}

	}

	public static Map<IJoueur, Carte> voirCarteJoueur() {

		Map<IJoueur, Carte> map = new HashMap<>();

		for (IJoueur joueur : partie.getJoueurs()) {

			map.put(joueur, joueur.getHand().getCartes().get(0));

		}

		return map;
	}

	public static IJoueur winner() {

		return partie.evalueWinner();

	}

	public static void run() {

		boolean end = false;
		
		while (gameState == GameState.crtJoueur) {
			vue.saisieJoueur();
		}

		while (!end) {
			
			if (gameState == GameState.choixPartie) {
				vue.choixPartie();

				gameState = GameState.distribCarte;
			}

			if (gameState == GameState.distribCarte) {
				vue.distribuerCartes();

				gameState = GameState.voirCartes;
			}
			
			

			if (gameState == GameState.voirCartes) {
				vue.voirCartes();

				gameState = GameState.winner;
			}

			if (gameState == GameState.winner) {
				vue.voirWinner();

			}
			
			end = vue.newPartie();
			
			if(!end) {
				gameState = GameState.distribCarte;
			}
		}

	}

	public static void startGame() {
		gameState = GameState.choixPartie;
	}

	public static GameState getGameState() {
		return gameState;
	}

	public static void setGameState(GameState gameState) {
		Deroulementpartie.gameState = gameState;
	}

	public static Partie getPartie() {
		return partie;
	}

	public static void setPartie(Partie partie) {
		Deroulementpartie.partie = partie;
	}
	
	

}
