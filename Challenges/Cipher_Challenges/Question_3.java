import java.util.Scanner;

public class Question_3 {

    // S1-Box Matrix
    private static final int[][] S1 = {
            {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
            {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
            {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
            {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
    };

    public static int sBoxSubstitution(int word) {
        // Extracting the row index:
        // Using bitwise AND (&) to isolate the 6th bit from the right in the word
        // Shifting the extracted bit 4 positions to the right to align it as the first bit of the row
        // Using bitwise OR (|) to combine the 6th bit (after shifting) with the 1st bit (the least significant bit)
        // This forms the complete row index
        int row = (word & 0b100000) >> 4 | (word & 0b1); // 0b100000 represents the binary number 32

        // Extracting the column index:
        // Using bitwise AND (&) to isolate bits 2 to 5 from the right in the word
        // Shifting the extracted bits 1 position to the right to align them as a valid column index in the S1 matrix
        int col = (word & 0b011110) >> 1; // 0b011110 represents the binary number 30

        // Returning the value from the S1 matrix corresponding to the row and column indices
        return S1[row][col];
    }

    public static String getWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input word (composed of 6 bits): ");
        String word = scanner.nextLine();
        scanner.close();
        return word;
    }

    public static void main(String[] args) {
        String word = getWord();
        // Converting the input word to an integer
        int inputValue = Integer.parseInt(word, 2);
        // Performing S-box substitution
        int outputValue = sBoxSubstitution(inputValue);
        // Converting the output value back to binary
        String output = Integer.toBinaryString(outputValue);
        // Adding leading zeros, if necessary, to complete 4 bits
        while (output.length() < 4) {
            output = "0" + output;
        }
        System.out.println("Output word: " + output);
    }
}
