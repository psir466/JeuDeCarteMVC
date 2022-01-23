package org.psi.metier;

public class Carte {
	
	
	private Couleur couleur;
	
	private Type type;

	
	public Carte(Couleur couleur, Type type) {
		super();
		this.couleur = couleur;
		this.type = type;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public Type getType() {
		return type;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
	
	
	
	

}
