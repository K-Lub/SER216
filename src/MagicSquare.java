import java.util.Scanner;

/**
 * 
 * @author KailabBowler
 * @version Build 1, 1/19/17
 *
 */


public class MagicSquare {
	/**
	 * 
	 * @param args		required for main functions
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intArr[] = new int[100];
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Please Enter your Magic Square values, enter 0 to end.");
		
		int nSquared = 0;
		int n = 0;
		
		do{
			intArr[nSquared] = reader.nextInt(); 
			nSquared++;
		}while(intArr[nSquared - 1] != 0);
		
		nSquared -= 1;
		n = (int)Math.sqrt(nSquared);
		
		boolean proceed = false;
		for(int x = 1; x <= 3; x++){
			if(x == 1){
				System.out.println((proceed = checkLength(nSquared)) == true ? "Input was a perfect square" : "Input was not a perfect square");
			}
			if(x == 2){
				System.out.println((proceed = checkContains(intArr, nSquared)) == true ? "Input contains all numbers from 1 to " + nSquared : "Input did not contain all numbers from 1 to " + nSquared );
			}
			if(x == 3){
				System.out.println((proceed = checkTotals(intArr, n)) == true ? "Congrats this is a Magic Square" : "Sorry this is not a Magic Square");
			}
			if(!proceed){
				break;
			}
		}
			
		
	}
	
	/**
	 * 
	 * @param nSquared 		Number to check if it is a perfect square
	 * @return 				Boolean
	 */
	public static boolean checkLength(float nSquared){
		long n = (long)(Math.sqrt(nSquared)+.05);
		return n*n == nSquared;
	}
	/**
	 * 
	 * @param a 	Array to be checking
	 * @param to 	The number to check to starting from 1
	 * @return 		Boolean
	 */
	public static boolean checkContains(int[] a, int to){
		boolean proceed = false;
		for(int i = 1; i <= to; i++){
			proceed = false;
			for(int element : a){
				if(element == i){
					proceed = true;
				}
			}
			if(proceed == false){
				break;
			}
		}
		return proceed;
	}
	/**
	 * 
	 * @param a 	Array to be checking
	 * @param n 	x by x value for creating the 2D array
	 * @return		Boolean
	 */
	public static boolean checkTotals(int[] a, int n){
		
		int doubleArr[][] = new int[n][n];
		int counter = 0;
		int total = 0;
		
		boolean proceed = true;
		
		//setting to new 2D array
		for(int row = 0; row < n; row++){
			for(int col = 0; col < n; col++){
				System.out.print((doubleArr[row][col] = a[counter])+ " ");
				counter++;
			}
			System.out.println();
		}
		
		//solving for what each row column and diagonal should equal
		total = (int)(Math.pow(n, 2) * (Math.pow(n, 2) + 1)/(n * 2));
		
		for(int row = 0; row < n; row++){
			int temp = 0;
			for(int col = 0; col < n; col++){
				temp += doubleArr[row][col];
			}
			if(temp != total){
				proceed = false;
				break;
			}
		}
		if(proceed){
			for(int col = 0; col < n; col++){
				int temp = 0;
				for(int row = 0; row < n; row++){
					temp += doubleArr[row][col];
				}
				if(temp != total){
					proceed = false;
					break;
				}
			}
		}
		if(proceed){
			int temp = 0;
			for(int both = 0; both < n; both++){
				temp += doubleArr[both][both];	
			}
			if(temp != total){
				proceed = false;
			}
		}
		return proceed;
	}
}
