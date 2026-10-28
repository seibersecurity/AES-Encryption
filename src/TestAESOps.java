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

	// Encrypts 128-bit plaintext using AES with 128-bit key size
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

		// Random Example
		byte[] plaintext1 = {
			(byte) 0x4D, (byte) 0x65, (byte) 0x65, (byte) 0x74,   // M e e t
			(byte) 0x20, (byte) 0x6D, (byte) 0x65, (byte) 0x20,   // (space) m e (space)
			(byte) 0x61, (byte) 0x74, (byte) 0x20, (byte) 0x6E,   // a t (space) n
			(byte) 0x6F, (byte) 0x6F, (byte) 0x6E, (byte) 0x2E    // o o n .
		};

		byte[] key1 = {
			(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03,
			(byte) 0x04, (byte) 0x05, (byte) 0x06, (byte) 0x07,
			(byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0B,
			(byte) 0x0C, (byte) 0x0D, (byte) 0x0E, (byte) 0x0F
		};

		// Homework 6 AES Example
		byte[] plaintext2 = {
			(byte) 0x12, (byte) 0xAE, (byte) 0x34, (byte) 0xA1,
			(byte) 0x32, (byte) 0xB1, (byte) 0x54, (byte) 0x50,
			(byte) 0x34, (byte) 0x00, (byte) 0x65, (byte) 0x10,
			(byte) 0x54, (byte) 0x21, (byte) 0x01, (byte) 0x12
		};

		byte[] key2 = {
			(byte) 0x08, (byte) 0x10, (byte) 0x35, (byte) 0xA6,
			(byte) 0x32, (byte) 0xA1, (byte) 0x74, (byte) 0x40,
			(byte) 0x64, (byte) 0x00, (byte) 0x25, (byte) 0x10,
			(byte) 0x46, (byte) 0xE1, (byte) 0x35, (byte) 0x13
		};

		int[] ciphertext1 = encrypt(plaintext1, key1);
		int[] ciphertext2 = encrypt(plaintext2, key2);


		System.out.println("Plaintext:  " + new String(plaintext1));
		System.out.print("Plaintext:  ");
		for (int col : plaintext1) {
			System.out.printf("%02X", col);
		}

		System.out.println();
		System.out.print("Ciphertext: ");
		for (int col : ciphertext1) {
			System.out.printf("%08X", col);
		}

		System.out.println();
		System.out.println("Plaintext:  " + new String(plaintext2));
		System.out.print("Plaintext:  ");
		for (int col : plaintext2) {
			System.out.printf("%02X", col);
		}

		System.out.println();
		System.out.print("Ciphertext: ");
		for (int col : ciphertext2) {
			System.out.printf("%08X", col);
		}

	}
}