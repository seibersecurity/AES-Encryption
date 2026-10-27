/**
 * Implement all of the methods of AES.
 *
 * @author - Hayden Seiberlich, Ryan Shaw, & Christian Torazzo
 */

public class AESOperationsHardVersion {
	
	/**
	* Computes the byte substitution step of an AES round.
	*
	* @param state The current state matrix implemented as 1 dimensional array of ints of length 4. This method modifies this matrix by replacing each byte
	* of each int with the corresponding output from the AES s-box.
	*/
	public static void byteSubstitution(int[] state) {
		// HINT 1:  I'd recommend simply hardcoding the S-box as a 1 dimensional array of bytes as a field within this class.
		// If you use this hint, then you'd convert the 2D S-box to a simple array, by starting with the first row, followed by the 2nd, etc.
		// Just Google AES S-box to find it, such as on the wikipedia page.  The input byte is then simply used as an index into this array.
		//
		// HINT 2: You'll probably find the S-box elements specified in hexadecimal.  You don't need to convert from hexadecimal to decimal
		// in using HINT 1.  If you weren't already aware, in Java you can specify integer values with hex, by using 0x.  For example, 0x2a
		// is how you'd specify the decimal value 42 in hexadecimal.
		//
		// HINT 3: Reminder, when you initialize an array in Java, you can do so by specifying a list of elements within { }.
		// For example, consider the following:
		//   byte[] someBytes = { 0x2a, 0x33, 0x41 };
		// In this example, someBytes is initialized to an array of length 3, with the specific values specified in hexadecimal.
		// If you follow HINT 1, you'd have something like this as a field outside this method for the entire S-box.
		
		// HINT SPECIFIC TO HARD VERSION:
		// You'll need to figure out how to get each of the 4 byte values from each int, as well as how to reassemble the results
		// as ints.  To get your index into your SBox, casting state[i] to type byte will give you the least significant 8 bits, which
		// you can then use as an index into your SBox to get the replacement bits for that byte.  You can use a combination of a right-shift
		// by 8 positions and a cast to type byte to get the next byte, etc.
	
	}
	
	
	/**
	* Computes the shift rows step of an AES round.
	*
	* @param state The current state matrix implemented as 1 dimensional array of ints of length 4. 
	*  This method modifies this matrix to contain the result of the shift rows step.
	*  Each int in this array is a column (NOT a row).
	*/
	public static void shiftRows(int[] state) {
		// You'll need to figure out the bit-wise operations necessary to accomplish this.
		// NOTE: state[i] is column i (NOT row i).
		
		// NOTE: bit-wise and is &, or is |, XOR is ^, left shifting Y by k places is Y << k, right shifting Y by k places is Y >> k
	}
	
	
	/**
	* Computes the mix columns step of an AES round.
	*
	* @param state The current state matrix implemented as 1 dimensional array of ints of length 4. 
	* This method modifies this matrix to contain the result of the mix columns step.
	*  Each int in this array is a column (NOT a row).
	*/
	public static void mixColumns(int[] state) {
		// Some of the hints in the easier versions of this may be helpful (specifically the hints in AESOperations.java, but you'll also need
		// to figure out the shifts and bit-wise operations that you need.
		
		// NOTE: bit-wise and is &, or is |, XOR is ^, left shifting Y by k places is Y << k, right shifting Y by k places with sign extension is Y >> k,
		// unsigned right shift of Y by k places Y >>> k.  If you use >> the new bit at the right most end will depend on sign (1 for negative and 0 for
		// positive).  So be careful, if you need to right shift, you'll probably want the unsigned >>> where the new right most bit will be a 0 always.
	}
	
	
	/**
	* Returns a 2D array from the key.
	* @param key The key
	* @return array of int values, where each int is a column of the key matrix, most-significant byte of an int is the
	* top element of the column.  Least significant byte is the bottom element of the column.
	*/
	public static int[] generateKeyMatrixFromKey(byte[] key) {
		// HINT: the bytes of the key are filled into the key matrix down the columns (not across rows).
	}
	
	
	/**
	* Computes the expanded key matrix for AES.
	* @param keyMatrix The first 4 columns as 4 int values
	* @return Returns a new matrix that corresponds to the expanded key matrix of AES.
	*/
	public static int[] keyExpansion(int[] keyMatrix) {
		// HINT: The expanded key matrix has 44 columns, so start by constructing an array of length 44.  
		// Then initialize the first 4 columns with the keyMatrix.  Then iterate over the columns
		// computing the rest per the AES key expansion rules.  Finally return the new array.
	}
}