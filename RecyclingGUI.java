
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.perisic.beds.CustomerPanel;
import com.perisic.beds.ReceiptPrinter;

/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * @author Marc Conrad
 *
 */
public class RecyclingGUI extends JFrame implements ActionListener  {
	CustomerPanel myCustomerPanel = new CustomerPanel(new ReceiptPrinter());
	int ProgressEnd;
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Received: e.getActionCommand()="+e.getActionCommand()+
							" e.getSource()="+e.getSource().toString() ); 
		if( e.getSource().equals(slot1) ) { 
            myCustomerPanel.itemReceived(1);
		} else if( e.getSource().equals(slot2) ) { 
            myCustomerPanel.itemReceived(2);
		} else if( e.getSource().equals(slot3) ) { 
            myCustomerPanel.itemReceived(3);
		} else if( e.getSource().equals(slot4) ) { 
            myCustomerPanel.itemReceived(4);
		} else if( e.getSource().equals(slot5) ) { 
            myCustomerPanel.itemReceived(5);
		} else if( e.getSource().equals(receipt) ) { 
            print(myCustomerPanel.printReceipt());
		}

		ProgressEnd = myCustomerPanel.getProgress();
		updateProgressBar(0, ProgressEnd);
	}
	
	JButton slot1 = new JButton("      Can     "); 
	JButton slot2 = new JButton("Plastic Bottle"); 
	JButton slot3 = new JButton(" Glass Bottle "); 
	JButton slot4 = new JButton("     Crate    ");
	JButton slot5 = new JButton("      Bag     ");
	
	JButton receipt = new JButton("    Receipt   "); 
	
	JProgressBar pb = new JProgressBar();
	
	JTextArea ta = new JTextArea();
	
	public RecyclingGUI() {
		super();
		setSize(700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.add(slot1); 
		panel.add(slot2);
		panel.add(slot3); 
		panel.add(slot4); 
		panel.add(slot5);
		
		slot1.addActionListener(this); 
		slot2.addActionListener(this); 
		slot3.addActionListener(this); 
		slot4.addActionListener(this); 
		slot5.addActionListener(this); 
		
		panel.add(receipt); 
		receipt.addActionListener(this);
		

        pb.setStringPainted(true);
        panel.add(pb);

		panel.add(ta); 
		
		getContentPane().add(panel);
		panel.repaint();
		
	}
	
	public void updateProgressBar(int start, int end) {
        for (int i = start; i <= end; i++) {
            final int currentValue = i;
            try {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        pb.setValue(currentValue);
                    }
                });
                java.lang.Thread.sleep(5);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
 
    }
	
	public void print(String str) { 
		ta.setText(str);
	}
	
	
	public static void main(String [] args ) { 
		RecyclingGUI myGUI = new RecyclingGUI(); 
		myGUI.setVisible(true);
		
	}
		
		
	

}