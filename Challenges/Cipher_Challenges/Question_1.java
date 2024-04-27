import java.util.Scanner;

public class Question_1 {

    public static String decryptCaesar(String codedPhrase, int test_key) {

        test_key = 26 - test_key;
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < codedPhrase.length(); i++) {
            char character = codedPhrase.charAt(i);
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                decryptedText.append((char) ((character - base + test_key) % 26 + base));
            } else {
                decryptedText.append(character);
            }
        }
        return decryptedText.toString();
    }

    public static int findStaterKey(String codedPhrase) {

        int[] letterCounts = new int[26];
        char[] alphabet = new char[26];

        for (char character : codedPhrase.toLowerCase().toCharArray()) {
            if (Character.isLetter(character)) {
                int index = character - 'a';
                letterCounts[index]++;
            }
        }

        int maxCount = -1;
        char mostCommonLetter = ' ';
        for (int i = 0; i < letterCounts.length; i++) {
            if (letterCounts[i] > maxCount) {
                maxCount = letterCounts[i];
                mostCommonLetter = (char) ('a' + i);
            }
        }

        int starter_Key;
        starter_Key = mostCommonLetter; // Convert the most common letter to its ASCII value
        return starter_Key;
    }

    public static String getCodedPhrase() {

        String codedPhrase;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the coded phrase:");
        codedPhrase = scanner.nextLine();
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        System.out.println("Continuing...");

        return codedPhrase;
    }

    public static void main(String[] args) {

        String codedPhrase = getCodedPhrase();
        int starter_test_key = findStaterKey(codedPhrase);

        String decodedPhrase;
        System.out.println("\t\t.....RESULTS....\n");
        System.out.println("Coded Phrase: " + codedPhrase + "\n");
        System.out.println("Most Common Letter: " + (char) starter_test_key + "\n");

        int key;
        for (key = starter_test_key; key <= 26; key++) {
            decodedPhrase = decryptCaesar(codedPhrase, key);

            System.out.print("For key value " + key + ": ");
            System.out.println(decodedPhrase);
            System.out.println("\n\n");
        }
    }
}
