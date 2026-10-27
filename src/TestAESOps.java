/**
* Start by implementing the AES related methods in any of the 3 provided Java files.  And then return here to test.
* @author - Hayden Seiberlich, Ryan Shaw, & Christian Torazzo
*/

public class TestAESOps {

	// AddRoundKey: XOR each state column with the matching column of the round key
    private static void addRoundKey(int[] state, int[] expandedKey, int round) {
        for (int c = 0; c < 4; c++) {
            state[c] ^= expandedKey[round * 4 + c];
        }
    }

	public static int[] encrypt(byte[] plaintext, byte[] key) {
		int[] expandedKey = AESOperationsHardVersion.keyExpansion(
                AESOperationsHardVersion.generateKeyMatrixFromKey(key));
		
		int[] state = AESOperationsHardVersion.generateKeyMatrixFromKey(plaintext);

		// Initial round
        addRoundKey(state, expandedKey, 0);

		// Rounds 1-9
        for (int round = 1; round <= 9; round++) {
            AESOperationsHardVersion.byteSubstitution(state);
            AESOperationsHardVersion.shiftRows(state);
            AESOperationsHardVersion.mixColumns(state);
            addRoundKey(state, expandedKey, round);
        }

        // Final round
        AESOperationsHardVersion.byteSubstitution(state);
        AESOperationsHardVersion.shiftRows(state);
        addRoundKey(state, expandedKey, 10);

        return state;
	}

	public static void main(String[] args) {
		
		// Write some code to test your various methods.
		// You might consider using homework problems as a source of test cases since you can compare
		// output to what you worked through by hand.
		
		// In Java, if you want to output an integer value in hexadecimal, you can use printf as follows:
		// int value = SOME INTEGER VALUE;
		// System.out.printf("%02x", value);
		// The % starts specifying formatting.  The 02 means use 2 places and pad 1 digit numbers with a leading 0.
		// The x means use hexadecimal.  printf doesn't put a new line character.  If you want to start a new line after,
		// System.out.printf("%02x\n", value);  
		// If you want to output multiple values with a single printf (assume they're called value1, value2, etc)
		// then in the String that is the first parameter, you'd have formatting requirements for each as follows:
		// System.out.printf("%02x %02x %02x %02x\n", value1, value2, value3, value4);

		byte[] plaintext = {
			(byte) 0x4D, (byte) 0x65, (byte) 0x65, (byte) 0x74,   // M e e t
			(byte) 0x20, (byte) 0x6D, (byte) 0x65, (byte) 0x20,   // (space) m e (space)
			(byte) 0x61, (byte) 0x74, (byte) 0x20, (byte) 0x6E,   // a t (space) n
			(byte) 0x6F, (byte) 0x6F, (byte) 0x6E, (byte) 0x2E    // o o n .
		};

		byte[] key = {
			(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03,
			(byte) 0x04, (byte) 0x05, (byte) 0x06, (byte) 0x07,
			(byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0B,
			(byte) 0x0C, (byte) 0x0D, (byte) 0x0E, (byte) 0x0F
		};

		int[] ciphertext = encrypt(plaintext, key);

		System.out.println("Plaintext:  " + new String(plaintext));
		System.out.print("Ciphertext: ");
		for (int col : ciphertext) {
			System.out.printf("%08X", col);
		}
	}
}