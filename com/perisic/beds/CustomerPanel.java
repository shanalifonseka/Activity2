package com.perisic.beds;

/**
 * @author Marc Conrad
 *
 */
public class CustomerPanel {
	DepositItemReceiver receiver = null; 
	/**
	 * @param slot
	 */
	public CustomerPanel(PrinterInterface printer) {
		super();
		receiver = new DepositItemReceiver(printer); 
	}
	/**
	 * 
	 * @param slot
	 */
	public void itemReceived(int slot) { 
		receiver.classifyItem(slot); 
	}
	/**
	 * 
	 */
	public String printReceipt() { 
		return receiver.printReceipt();
	}
	
	public int getProgress() { 
		return receiver.getProgress();
	}
}
