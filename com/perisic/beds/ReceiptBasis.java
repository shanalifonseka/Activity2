package com.perisic.beds;
import java.util.Vector; 

/**
 * @author Marc Conrad
 *
 */
public class ReceiptBasis {
	private Vector<DepositItem> myItems = new Vector<DepositItem>();
	/**
	 * @param item
	 */
	public void addItem(DepositItem item) { 
		myItems.add(item); 
		item.number = myItems.indexOf(item) + 1; 
	}
	/**
	 * @return
	 */
	public String computeSum() { 
		String receipt = "----Recycling Machine Recipt----\n-------------------------------------------\n"; 
		int sum = 0; 
		for(int i=0; i < myItems.size(); i++ ) {
			DepositItem item = myItems.get(i); 
			receipt = receipt + item.number + "  " + item.name + "\t" + ": " +item.value; 
			receipt = receipt + System.getProperty("line.separator");
			sum = sum + item.value; 
		}
		receipt = receipt + "\nTotal\t: "+sum; 
		return receipt; 
	}
	
	public String countItems() {
		String count = "";
		int bottleCount=0 , canCount=0,	crateCount=0, bagCount= 0;
		
		for(int i=0; i < myItems.size(); i++ ) {
			
			DepositItem item = myItems.get(i);
			
			if(item.name.endsWith("Bottle")) {
				bottleCount++;
			}else if(item.name.equals("Can")) {
				canCount++;
			}else if(item.name.equals("Crate")) {
				crateCount++;
			}else if(item.name.equals("Bag")) {
				bagCount++;
			}
			
		}
		
		count = "\n"+"\n" + "Bottle Count\t: " + bottleCount + "\n" + "Can Count\t: " + canCount + "\n" + "Crate Count\t: " + crateCount + "\n" + "Bag Count\t: " + bagCount;
		return count;
	}
}

