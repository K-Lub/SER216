
public class HexNumberFormatException extends NumberFormatException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private char illegalChar;
	private String information = "Invalid Format for Hex String - Illegal character: ";
	
	HexNumberFormatException(char i){
		illegalChar = i;
	}
	
	public String getMessage(){
		return information + illegalChar;
	}
}
