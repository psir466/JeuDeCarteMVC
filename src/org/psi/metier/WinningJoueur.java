package org.psi.metier;

public class WinningJoueur implements IJoueur {

	private IJoueur winner;

	private String nom;

	private Hand hand;

	// DP Décorator
	public WinningJoueur(IJoueur joueur) {
		this.winner = joueur;
	}


	public String getNom() {
		return "LE WINNER EST .... " + this.winner.getNom();
	}

	public void setNom(String nom) {
		this.winner.setNom(nom);
	}

	public Hand getHand() {
		return this.winner.getHand();
	}

	public void setHand(Hand hand) {
		this.winner.setHand(hand);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WinningJoueur other = (WinningJoueur) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

}
