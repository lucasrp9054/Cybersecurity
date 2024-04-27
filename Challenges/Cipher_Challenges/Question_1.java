import java.util.Scanner;

public class Question_1 {

    // Frequência das letras em textos em português
    private static final double[] PORTUGUESE_LETTER_FREQUENCY = {
            14.6, 1.04, 3.88, 4.99, 12.6, 1.02, 1.3, 1.28, 6.18, 0.4, 0.02, 2.78,
            4.74, 5.05, 10.7, 2.52, 1.2, 6.53, 7.81, 4.34, 4.63, 1.67, 0.01, 0.21, 0.01, 0.47
    };

    public static String decryptCaesar(String codedPhrase, int test_key) {
        test_key = 26 - test_key;
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < codedPhrase.length(); i++) {
            char character = codedPhrase.charAt(i);
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                decryptedText.append((char) ((character - base + test_key) % 26 + base));
            } else {
                decryptedText.append(character); // Mantém caracteres não-letrais inalterados
            }
        }
        return decryptedText.toString();
    }

    public static int[] countLetters(String phrase) {
        int[] letterCounts = new int[26];
        for (char character : phrase.toLowerCase().toCharArray()) {
            if (Character.isLetter(character)) {
                int index = character - 'a';
                letterCounts[index]++;
            }
        }
        return letterCounts;
    }

    public static int findStarterKey(String codedPhrase) {
        double minDifference = Double.MAX_VALUE;
        int bestKey = 0;

        for (int key = 0; key < 26; key++) {
            double difference = 0;
            String decryptedPhrase = decryptCaesar(codedPhrase, key);
            int[] letterCounts = countLetters(decryptedPhrase);

            for (int i = 0; i < 26; i++) {
                double expectedFrequency = PORTUGUESE_LETTER_FREQUENCY[i] / 100.0; // Convertendo para decimal
                double actualFrequency = (double) letterCounts[i] / decryptedPhrase.length();
                difference += Math.abs(expectedFrequency - actualFrequency);
            }

            if (difference < minDifference) {
                minDifference = difference;
                bestKey = key;
            }
        }

        return bestKey;
    }

    public static String getCodedPhrase() {
        String codedPhrase;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the coded phrase:");
        codedPhrase = scanner.nextLine();
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        System.out.println();

        return codedPhrase;
    }

    public static void main(String[] args) {
        String codedPhrase = getCodedPhrase();
        int starter_test_key = findStarterKey(codedPhrase);

        System.out.println("\t\t.....RESULTS....\n");
        System.out.println("Coded Phrase: " + codedPhrase);
        System.out.println("Most Common Letter: " + (char) ('a' + starter_test_key));

        for (int key = starter_test_key; key < 26; key++) {
            String decodedPhrase = decryptCaesar(codedPhrase, key);

            System.out.print("For key value " + key + ": ");
            System.out.println(decodedPhrase);
            System.out.println();
        }
    }
}
