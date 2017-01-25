
public class BinaryNumberFormatException extends NumberFormatException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private char illegalChar;
	private String information = "Invalid Format for Binary String - Illegal character: ";
	
	BinaryNumberFormatException(char i){
		illegalChar = i;
	}
	
	public String getMessage(){
		return information + illegalChar;
	}
}
