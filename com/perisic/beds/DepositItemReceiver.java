package com.perisic.beds;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/**
 * @author Marc Conrad
 *
 */
public class DepositItemReceiver {
	boolean warning = false;
	int totalWeight = 0 ;
	int weightLimit = 1600;
	int progress;
	String Receipt;
	ReceiptBasis theReceiptBasis = null; 
	PrinterInterface printer = null; 
	
	/**
	 * 
	 */
	public DepositItemReceiver(PrinterInterface printer) {
		super();
		this.printer = printer;
	}
	/**
	 * 
	 */
	public void createReceiptBasis() { 
		theReceiptBasis = new ReceiptBasis(); 
	}
	
	/**
	 * @param slot
	 */
	public void classifyItem(int slot) { 
		DepositItem item = null; 
		
		if( slot == 1 ) { 
			item = new Can(); 
		} else if( slot == 2 ) { 
			item = new Bottle(1); 
		} else if( slot == 3 ) { 
			item = new Bottle(2); 
		} else if ( slot == 4 ) { 
			item = new Crate(); 
		} else if ( slot == 5 ) { 
			item = new Bag(); 
		} 
		totalWeight = totalWeight + item.getWeight();
		
		if( theReceiptBasis == null ) { 
			createReceiptBasis(); 
		}

		if (totalWeight<=weightLimit) {
			theReceiptBasis.addItem(item); 
			calculateProgress();
			System.out.println(progress);
			JOptionPane.showMessageDialog(null, "Item added sucessfully! ");
		} else {
			warning = true;
			totalWeight = totalWeight - item.getWeight();
			JOptionPane.showMessageDialog(null, "Warning! Recycling Machine is overloaded");		}
		
	}
	/**
	 * 
	 */
	public String printReceipt() { 
		Receipt = theReceiptBasis.computeSum() + theReceiptBasis.countItems() + theReceiptBasis.displayProgress(totalWeight, weightLimit); 
		printer.print(Receipt); 
		theReceiptBasis = null;
		
		return Receipt;
	}
	
	public void calculateProgress() {
		double pro = 0.0;
		Double t = (double) totalWeight;
		Double w = (double) weightLimit;
		DecimalFormat df = new DecimalFormat("#.##");
		
		pro = Double.parseDouble(df.format((t / w)*100));
		progress = (int)pro;
	}
	
	public int getProgress() {
		return progress;
	}
	
	public boolean getWarning() {
		return warning;
	}
	
	public int getTotalWeight() {
		return totalWeight;
	}
}
