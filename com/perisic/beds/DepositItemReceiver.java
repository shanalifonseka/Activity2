package com.perisic.beds;

/**
 * @author Marc Conrad
 *
 */
public class DepositItemReceiver {
	boolean warning = false;
	int totalWeight = 0 ;
	int weightLimit = 1600;
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
		} else {
			totalWeight = totalWeight - item.getWeight();
			warning = true;
		}
		
	}
	/**
	 * 
	 */
	public void printReceipt() { 
		String str = theReceiptBasis.computeSum() + theReceiptBasis.countItems() + theReceiptBasis.getProgress(totalWeight, weightLimit, warning); 
		printer.print(str); 
		theReceiptBasis = null; 
	}
}
