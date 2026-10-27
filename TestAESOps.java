/**
* Start by implementing the AES related methods in any of the 3 provided Java files.  And then return here to test.
* @author - Hayden Seiberlich, Ryan Shaw, & Christian Torazzo
*/

public class TestAESOps {
	
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
		byte[] key = {
			(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03,
			(byte) 0x04, (byte) 0x05, (byte) 0x06, (byte) 0x07,
			(byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0B,
			(byte) 0x0C, (byte) 0x0D, (byte) 0x0E, (byte) 0x0F
		};

		int[] matrix = AESOperationsHardVersion.generateKeyMatrixFromKey(key);
		int[] expandedMatrix = AESOperationsHardVersion.keyExpansion(matrix);

		for (int col : expandedMatrix) {
			System.out.printf("%08X%n", col);
		}
	}
}