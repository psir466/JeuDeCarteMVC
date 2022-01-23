package org.psi.metier;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private List<Carte> cartes = new ArrayList<>();

	public Hand(List<Carte> cartes) {
		super();
		this.cartes = cartes;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	

}
