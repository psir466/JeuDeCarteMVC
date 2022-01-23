package org.psi.metier;

public class JeuFactory {
	
	public enum TypeJeu {
		
		normal,
		small,
		cool,
	}
	
	
	public iJeu creerJeu(TypeJeu typeJeu) {
		
		if(typeJeu == TypeJeu.small ){
			
			return new Jeu32();
		}
			
		if(typeJeu == TypeJeu.normal){
			
			return new Jeu();
		}
		
		if(typeJeu == TypeJeu.cool){
			
			return new CoolJeuAdapter();
		}

		return null;
	}
}
