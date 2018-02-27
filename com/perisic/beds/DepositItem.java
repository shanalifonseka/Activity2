package com.perisic.beds;

/**
 * @author Marc Conrad
 *
 */
public abstract class DepositItem {
	int number; 
	int value;
	String name;
	
	abstract public int getWeight();
}
