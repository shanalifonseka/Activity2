package com.perisic.beds;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class ActionPerformHandler {
	CustomerPanel myCustomerPanel = new CustomerPanel(new ReceiptPrinter());
	int ProgressEnd;
	int ProgressStart = 0;
	boolean CheckProgress = true;
	String Receipt;
	
	public ActionPerformHandler(ActionEvent e) {
		if( e.getActionCommand().equals("      Can     ") ) { 
            myCustomerPanel.itemReceived(1);
		} else if( e.getActionCommand().equals("Plastic Bottle") ) { 
            myCustomerPanel.itemReceived(2);
		} else if( e.getActionCommand().equals(" Glass Bottle ") ) { 
            myCustomerPanel.itemReceived(3);
		} else if( e.getActionCommand().equals("     Crate    ") ) { 
            myCustomerPanel.itemReceived(4);
		} else if( e.getActionCommand().equals("      Bag     ") ) { 
            myCustomerPanel.itemReceived(5);
		} else if( e.getActionCommand().equals("    Receipt   ") ) { 
			if (myCustomerPanel.getTotalWeight()!= 0 ) {
				CheckProgress = false;
	            Receipt = myCustomerPanel.printReceipt();
			} else {
				JOptionPane.showMessageDialog(null, "Add item(s) befroe generate the receipt! ");
			}
		}
		
		if (myCustomerPanel.getWarning()== false && CheckProgress) {
			ProgressEnd = myCustomerPanel.getProgress();
			ProgressStart = ProgressEnd;
		}
	}
	
}
