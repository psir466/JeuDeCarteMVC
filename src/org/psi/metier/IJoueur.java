package org.psi.metier;

public interface IJoueur {
	
	

	public String getNom();

	public void setNom(String nom) ;

	public Hand getHand();

	public void setHand(Hand hand) ;

	@Override
	public int hashCode();

	@Override
	public boolean equals(Object obj);

	
	
}
