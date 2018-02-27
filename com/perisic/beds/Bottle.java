package com.perisic.beds;

/**
 * @author Marc Conrad
 *
 */
public class Bottle extends DepositItem {
	static int weight = 10; 
	static int size = 8; 
	/**
	 * 
	 */
	public Bottle(int Type) { 
		if (Type == 1) {
			name = "Plastic Bottle";
		} else if (Type == 2) {
			name = "Glass Bottle";
		}
		value = 18; 
	}
}
