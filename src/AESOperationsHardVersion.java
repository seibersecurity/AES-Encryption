/**
 * Implement all of the methods of AES.
 *
 * @author - Hayden Seiberlich, Ryan Shaw, & Christian Torazzo
 */

public class AESOperationsHardVersion {

	private static final byte[] S_BOX = {
			(byte) 0x63, (byte) 0x7C, (byte) 0x77, (byte) 0x7B, (byte) 0xF2, (byte) 0x6B, (byte) 0x6F, (byte) 0xC5,
			(byte) 0x30, (byte) 0x01, (byte) 0x67, (byte) 0x2B, (byte) 0xFE, (byte) 0xD7, (byte) 0xAB, (byte) 0x76,
			(byte) 0xCA, (byte) 0x82, (byte) 0xC9, (byte) 0x7D, (byte) 0xFA, (byte) 0x59, (byte) 0x47, (byte) 0xF0,
			(byte) 0xAD, (byte) 0xD4, (byte) 0xA2, (byte) 0xAF, (byte) 0x9C, (byte) 0xA4, (byte) 0x72, (byte) 0xC0,
			(byte) 0xB7, (byte) 0xFD, (byte) 0x93, (byte) 0x26, (byte) 0x36, (byte) 0x3F, (byte) 0xF7, (byte) 0xCC,
			(byte) 0x34, (byte) 0xA5, (byte) 0xE5, (byte) 0xF1, (byte) 0x71, (byte) 0xD8, (byte) 0x31, (byte) 0x15,
			(byte) 0x04, (byte) 0xC7, (byte) 0x23, (byte) 0xC3, (byte) 0x18, (byte) 0x96, (byte) 0x05, (byte) 0x9A,
			(byte) 0x07, (byte) 0x12, (byte) 0x80, (byte) 0xE2, (byte) 0xEB, (byte) 0x27, (byte) 0xB2, (byte) 0x75,
			(byte) 0x09, (byte) 0x83, (byte) 0x2C, (byte) 0x1A, (byte) 0x1B, (byte) 0x6E, (byte) 0x5A, (byte) 0xA0,
			(byte) 0x52, (byte) 0x3B, (byte) 0xD6, (byte) 0xB3, (byte) 0x29, (byte) 0xE3, (byte) 0x2F, (byte) 0x84,
			(byte) 0x53, (byte) 0xD1, (byte) 0x00, (byte) 0xED, (byte) 0x20, (byte) 0xFC, (byte) 0xB1, (byte) 0x5B,
			(byte) 0x6A, (byte) 0xCB, (byte) 0xBE, (byte) 0x39, (byte) 0x4A, (byte) 0x4C, (byte) 0x58, (byte) 0xCF,
			(byte) 0xD0, (byte) 0xEF, (byte) 0xAA, (byte) 0xFB, (byte) 0x43, (byte) 0x4D, (byte) 0x33, (byte) 0x85,
			(byte) 0x45, (byte) 0xF9, (byte) 0x02, (byte) 0x7F, (byte) 0x50, (byte) 0x3C, (byte) 0x9F, (byte) 0xA8,
			(byte) 0x51, (byte) 0xA3, (byte) 0x40, (byte) 0x8F, (byte) 0x92, (byte) 0x9D, (byte) 0x38, (byte) 0xF5,
			(byte) 0xBC, (byte) 0xB6, (byte) 0xDA, (byte) 0x21, (byte) 0x10, (byte) 0xFF, (byte) 0xF3, (byte) 0xD2,
			(byte) 0xCD, (byte) 0x0C, (byte) 0x13, (byte) 0xEC, (byte) 0x5F, (byte) 0x97, (byte) 0x44, (byte) 0x17,
			(byte) 0xC4, (byte) 0xA7, (byte) 0x7E, (byte) 0x3D, (byte) 0x64, (byte) 0x5D, (byte) 0x19, (byte) 0x73,
			(byte) 0x60, (byte) 0x81, (byte) 0x4F, (byte) 0xDC, (byte) 0x22, (byte) 0x2A, (byte) 0x90, (byte) 0x88,
			(byte) 0x46, (byte) 0xEE, (byte) 0xB8, (byte) 0x14, (byte) 0xDE, (byte) 0x5E, (byte) 0x0B, (byte) 0xDB,
			(byte) 0xE0, (byte) 0x32, (byte) 0x3A, (byte) 0x0A, (byte) 0x49, (byte) 0x06, (byte) 0x24, (byte) 0x5C,
			(byte) 0xC2, (byte) 0xD3, (byte) 0xAC, (byte) 0x62, (byte) 0x91, (byte) 0x95, (byte) 0xE4, (byte) 0x79,
			(byte) 0xE7, (byte) 0xC8, (byte) 0x37, (byte) 0x6D, (byte) 0x8D, (byte) 0xD5, (byte) 0x4E, (byte) 0xA9,
			(byte) 0x6C, (byte) 0x56, (byte) 0xF4, (byte) 0xEA, (byte) 0x65, (byte) 0x7A, (byte) 0xAE, (byte) 0x08,
			(byte) 0xBA, (byte) 0x78, (byte) 0x25, (byte) 0x2E, (byte) 0x1C, (byte) 0xA6, (byte) 0xB4, (byte) 0xC6,
			(byte) 0xE8, (byte) 0xDD, (byte) 0x74, (byte) 0x1F, (byte) 0x4B, (byte) 0xBD, (byte) 0x8B, (byte) 0x8A,
			(byte) 0x70, (byte) 0x3E, (byte) 0xB5, (byte) 0x66, (byte) 0x48, (byte) 0x03, (byte) 0xF6, (byte) 0x0E,
			(byte) 0x61, (byte) 0x35, (byte) 0x57, (byte) 0xB9, (byte) 0x86, (byte) 0xC1, (byte) 0x1D, (byte) 0x9E,
			(byte) 0xE1, (byte) 0xF8, (byte) 0x98, (byte) 0x11, (byte) 0x69, (byte) 0xD9, (byte) 0x8E, (byte) 0x94,
			(byte) 0x9B, (byte) 0x1E, (byte) 0x87, (byte) 0xE9, (byte) 0xCE, (byte) 0x55, (byte) 0x28, (byte) 0xDF,
			(byte) 0x8C, (byte) 0xA1, (byte) 0x89, (byte) 0x0D, (byte) 0xBF, (byte) 0xE6, (byte) 0x42, (byte) 0x68,
			(byte) 0x41, (byte) 0x99, (byte) 0x2D, (byte) 0x0F, (byte) 0xB0, (byte) 0x54, (byte) 0xBB, (byte) 0x16
	};

	private static final int[] RCON = {
		0x00000000,
		0x01000000,
		0x02000000,
		0x04000000,
		0x08000000,
		0x10000000,
		0x20000000,
		0x40000000,
		0x80000000,
		0x1B000000,
		0x36000000
	};


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
		


		// HINT 2: You'll probably find the S-box elements specified in hexadecimal.  You don't need to convert from hexadecimal to decimal
		// in using HINT 1.  If you weren't already aware, in Java you can specify integer values with hex, by using 0x.  For example, 0x2a
		// is how you'd specify the decimal value 42 in hexadecimal.
		


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
		
		//Save original incoming matrix
        int[] original = state.clone();

        // Iterates through each column and reorganizes bytes by left shifting according to AES rules
        for (int c = 0; c < 4; c++) {
            // Ex: Top represents row 1
            int top = (original[c] >>> 24) & 0xFF;

            int second = (original[(c + 1) % 4] >>> 16) & 0xFF;

            int third = (original[(c + 2) % 4] >>> 8) & 0xFF;

            int bottom = original[(c + 3) % 4] & 0xFF;

            state[c] =
                (top << 24) |
                (second << 16) |
                (third << 8) |
                bottom;
        }
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
		int[] keyMatrix = new int[4];
		int count = 0;

		for (int c = 0; c < 4; c++) {
			int col = 0;

			for (int r = 0; r < 4; r++) {
				col |= (key[count] & 0xFF) << (24 - (r * 8));
				count++;
			}

			keyMatrix[c] = col;
		}

		return keyMatrix;
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

		// Initialize first 4 columns
		int[] expandedKeyMatrix = new int[44];

		for (int i = 0; i < 4; i++) {
			expandedKeyMatrix[i] = keyMatrix[i];
		}

		// Fill remaining 40 columns
		for (int i = 4; i < 44; i++) {
			if (i % 4 != 0) {
				expandedKeyMatrix[i] = expandedKeyMatrix[i-4] ^ expandedKeyMatrix[i-1];
			} else {
				int tFunctionInt = expandedKeyMatrix[i-1];
				
				int b0 = S_BOX[(tFunctionInt >>> 16) & 0xFF] & 0xFF; // Original second byte
				int b1 = S_BOX[(tFunctionInt >>>  8) & 0xFF] & 0xFF; // Original third byte
				int b2 = S_BOX[(tFunctionInt)        & 0xFF] & 0xFF; // Original fourth byte
				int b3 = S_BOX[(tFunctionInt >>> 24) & 0xFF] & 0xFF; // Original first byte

				tFunctionInt = (b0 << 24) | (b1 << 16) | (b2 << 8) | b3; // Recombine into int
				tFunctionInt ^= RCON[i / 4]; // Round constant operation
				
				expandedKeyMatrix[i] = expandedKeyMatrix[i-4] ^ tFunctionInt;
			}
		}

		return expandedKeyMatrix;
		
	}
}