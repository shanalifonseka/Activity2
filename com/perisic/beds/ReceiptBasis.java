package com.perisic.beds;
import java.text.DecimalFormat;
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
		String receipt = "--------------------------------------------------Recycling Machine Recipt------------------------------------------------\n-------------------------------------------------------------------------------------------------------------------------------------\n"; 
		int sum = 0; 
		for(int i=0; i < myItems.size(); i++ ) {
			DepositItem item = myItems.get(i); 
			receipt = receipt+ "\t\t" + item.number + "  " + item.name + "\t" + ": " +item.value; 
			receipt = receipt + System.getProperty("line.separator");
			sum = sum + item.value; 
		}
		receipt = receipt + "\n\t\tTotal\t: "+sum; 
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
		
		count = "\n\n\t\t--Count-------------------------------" + "\n\t\tBottle Count\t: " + bottleCount + "\n\t\tCan Count\t: " + canCount + "\n\t\tCrate Count\t: " + crateCount + "\n\t\tBag Count\t: " + bagCount;
		return count;
	
}
	public String displayProgress(int totalWeight, int weightLimit) {
		String progress = "\n\n\t\t--Progress--------------------------\n";
		Double t = (double) totalWeight;
		Double w = (double) weightLimit;
		DecimalFormat df = new DecimalFormat("#.##");
		
		progress = progress + "\t\t" + df.format((t / w)*100)+ "%";
		
		return progress;
	}
}

