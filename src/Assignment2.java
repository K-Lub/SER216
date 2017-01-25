import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Assignment2 extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 300;
	
	private JButton jbtConvertToDecimal1 = new JButton("Convert To Decimal");
	private JButton jbtConvertToDecimal2 = new JButton("Convert To Decimal");
	
	private JLabel jlbBinaryString = new JLabel("Binary String");
	private JLabel jlbHexString = new JLabel("Hexidecimal String");
	
	private JTextField jtfBinaryString	 = new JTextField(45);
	private JTextField jtfHexString	 = new JTextField(45);
	private JTextField jtfConvertedString1	 = new JTextField(45);
	private JTextField jtfConvertedString2	 = new JTextField(45);
	
	public static void main(String[] args){
		JFrame window = new JFrame("Binary/Hex Converter");
		window.setContentPane(new Assignment2()); //this is where we go to GamePanel.java
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
	}
	public Assignment2(){
		super();
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
		
		jbtConvertToDecimal1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  try{
		    	  parseBinary(jtfBinaryString.getText());
		    	  }
		    	  catch(BinaryNumberFormatException binaryE){
		    		  jtfConvertedString1.setText(binaryE.getMessage());
		    	  }
		      }
	    });
		jbtConvertToDecimal2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  try{
		    		  parseHex(jtfHexString.getText());
		    	  }
		    	  catch(HexNumberFormatException hexE){
		    		  jtfConvertedString2.setText(hexE.getMessage());
		    	  }
		      }
	    });
		
		jtfBinaryString.setText("1010");
		jtfBinaryString.setHorizontalAlignment(JTextField.CENTER);
		jtfConvertedString1.setHorizontalAlignment(JTextField.CENTER);
		jtfHexString.setText("E");
		jtfHexString.setHorizontalAlignment(JTextField.CENTER);
		jtfConvertedString2.setHorizontalAlignment(JTextField.CENTER);
		
			add(jlbBinaryString);
			add(jtfBinaryString);
			add(jtfConvertedString1);
			add(jbtConvertToDecimal1);
			
			add(jlbHexString);
			add(jtfHexString);
			add(jtfConvertedString2);
			add(jbtConvertToDecimal2);
		
	}
	
	private void parseBinary(String binaryS) throws BinaryNumberFormatException{
		for(char element : binaryS.toCharArray()){
			if(element != '0' &&  element != '1'){
				throw new BinaryNumberFormatException(element);
			}
		}
		jtfConvertedString1.setText(""+Integer.parseInt(binaryS, 2));
	}
	private void parseHex(String hexS) throws HexNumberFormatException{
		for(char element : hexS.toCharArray()){
			if(element < '0' || element > 'e'){
				throw new HexNumberFormatException(element);
			}
		}
		jtfConvertedString2.setText(""+Integer.parseInt(hexS, 16));
	}
}
