package org.psi.metier;

public enum Type {
	
	C_1(14),
	C_2(2),
	C_3(3),
	C_4(4),
	C_5(5),
	C_6(6),
	C_7(7),
	C_8(8),
	C_9(9),
	C_10(10),
	C_V(11),
	C_D(12),
	C_R(13);;
	
	private int score;

	Type(int score){
		
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	
	

}
