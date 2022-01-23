package org.psi.vue;

import java.util.ArrayList;
import java.util.List;

// design patern Composite : traiter de les même méthodes 1 Vue et un ensemble de vue 
public class EnsembleDeVues implements Ivue {

	List<Ivue> listVue = new ArrayList<>();

	public EnsembleDeVues() {

	}

	public void addVue(Ivue ivue) {

		this.listVue.add(ivue);

	}

	@Override
	public void saisieJoueur() {

		for (Ivue vue : listVue) {

			vue.saisieJoueur();
		}

	}

	@Override
	public void distribuerCartes() {
		for (Ivue vue : listVue) {

			vue.distribuerCartes();
		}

	}

	@Override
	public void voirCartes() {
		for (Ivue vue : listVue) {

			vue.voirCartes();
		}

	}

	@Override
	public void voirWinner() {
		for (Ivue vue : listVue) {

			vue.voirWinner();
		}

	}

	@Override
	public boolean newPartie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void choixPartie() {

		for (Ivue vue : listVue) {

			vue.choixPartie();
		}

	}

}
