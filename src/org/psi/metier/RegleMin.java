package org.psi.metier;

public class RegleMin implements Iregle{
	
	@Override
	public boolean hand1GagneHand2(Hand hand1, Hand hand2) {
		
		if(hand1.getCartes().get(0).getType().getScore() < hand2.getCartes().get(0).getType().getScore()) {
			
			return true;
		}
		
		if(hand1.getCartes().get(0).getType().getScore() == hand2.getCartes().get(0).getType().getScore()) {
			
			if(hand1.getCartes().get(0).getCouleur().getScore() < hand2.getCartes().get(0).getCouleur().getScore()) {
				
				return true;
				
			}
				
		}
		
		return false;
	}
	
	

}
