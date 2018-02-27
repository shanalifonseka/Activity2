import com.perisic.beds.*;
/**
 * Tests the recycling machine.
 * @author Marc Conrad
 *
 */
public class SimpleTester {
	
	public static void main(String [] args) { 
		Display myDisplay = new Display(); 
	    CustomerPanel myPanel = new CustomerPanel(myDisplay);
 
		myPanel.itemReceived(1);
		myPanel.itemReceived(1);
		myPanel.itemReceived(3);
		myPanel.itemReceived(2);
		myPanel.itemReceived(4);
		myPanel.printReceipt();
	}
}
