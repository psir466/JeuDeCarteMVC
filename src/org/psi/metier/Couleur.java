package org.psi.metier;

public enum Couleur {
	
	PIQUE(3),
	TREFLE(4),
	COEUR(2),
	CARREAU(1);;
	
	private int score;

	private Couleur(int score){
		
		this.score = score;
		
	}

	public int getScore() {
		return score;
	}
	
	

}
