package com.perisic.beds;

/**
 * @author Marc Conrad
 *
 */
public class DepositItemReceiver {
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
		if( theReceiptBasis == null ) { 
			createReceiptBasis(); 
		}
		theReceiptBasis.addItem(item); 
	}
	/**
	 * 
	 */
	public void printReceipt() { 
		String str = theReceiptBasis.computeSum() + theReceiptBasis.countItems(); 
		printer.print(str); 
		theReceiptBasis = null; 
	}
}
