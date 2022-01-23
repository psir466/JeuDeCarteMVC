package org.psi.vue;

import java.util.Scanner;
import java.util.Map.Entry;

import org.psi.controleur.*;
import org.psi.metier.Carte;
import org.psi.metier.IJoueur;
import org.psi.metier.Regle;
import org.psi.metier.RegleMin;

public class Vue implements Ivue {


	private static Scanner sc = new Scanner(System.in);



	public void saisieJoueur() {

		System.out.println("nom joueur ?");

		String input = sc.nextLine();

		if (input.isEmpty()) {

			Deroulementpartie.startGame();

		} else {

			Deroulementpartie.creerJoueur(input);

		}

	}

	public void distribuerCartes() {
		
		System.out.println("Cartes distribuées");

		Deroulementpartie.distribuerCarteJoueurs();
		
		

	}

	public void voirCartes() {
		
		System.out.println("Cartes des joueurs");

		for (Entry<IJoueur, Carte> entry : Deroulementpartie.voirCarteJoueur().entrySet()) {

			System.out.println("Joueur : " + entry.getKey().getNom() + " Carte " + entry.getValue().getCouleur()
					+ entry.getValue().getType());

		}
	}

	public void voirWinner() {

		System.out.println("le gagnant est :" + Deroulementpartie.winner().getNom());

	};
	
	public boolean newPartie() {
		
		System.out.println("Voulez vous faire une autre partie");
		
		String input = sc.nextLine();
		
		if(input.equals("oui")) {
			
			return false;
		}
		
		return true;
		
	}

	@Override
	public void choixPartie() {
		System.out.println("Gagnant carte la plus élevée / la moins élevée");
		
		String input = sc.nextLine();
		
		if(input.equals("plus")){
			
			/// PAS TERRIBLE !!!!!!!!!!!! MAIS U MOIN ON NE MODIFIE PAS LE CONTROLEUR
			
			Deroulementpartie.getPartie().setRegle(new Regle());
			
		}else {
			
			Deroulementpartie.getPartie().setRegle(new RegleMin());
		}
		
	}

}
