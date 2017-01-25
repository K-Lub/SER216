import javax.swing.JFrame;
import javax.swing.JPanel;

public class Assignment2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6219194886153960712L;

	public static void main(String[] args){
		JFrame window = new JFrame("Learner");
		window.setContentPane(new Assignment2()); //this is where we go to GamePanel.java
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
	}
}
