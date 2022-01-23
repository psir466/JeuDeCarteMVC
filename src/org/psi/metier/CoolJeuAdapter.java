package org.psi.metier;

import java.util.ArrayList;

public class CoolJeuAdapter implements iJeu{

	private CoolJeu coolJeu;
	
	public CoolJeuAdapter() {
		
		coolJeu = new CoolJeu();
	}
	
	@Override
	public void melanger() {
		
		this.coolJeu.coolmelanger();
		
	}

	@Override
	public ArrayList<Carte> getJeu() {
		// TODO Auto-generated method stub
		return this.coolJeu.getJeu();
	}

}
