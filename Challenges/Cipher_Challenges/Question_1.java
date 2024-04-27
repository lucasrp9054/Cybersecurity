import java.util.Scanner;

public class Question_1 {

    // Frequência das letras em textos em português
    private static final double[] PORTUGUESE_LETTER_FREQUENCY = {
            14.6, 1.04, 3.88, 4.99, 12.6, 1.02, 1.3, 1.28, 6.18, 0.4, 0.02, 2.78,
            4.74, 5.05, 10.7, 2.52, 1.2, 6.53, 7.81, 4.34, 4.63, 1.67, 0.01, 0.21, 0.01, 0.47
    };

    // Função para decifrar a frase usando o cifrador de César
    public static String decryptCaesar(String codedPhrase, int test_key) {
        test_key = 26 - test_key; // Determina a chave de decifração
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < codedPhrase.length(); i++) {
            char character = codedPhrase.charAt(i);
            if (Character.isLetter(character)) { // Verifica se o caractere é uma letra
                char base = Character.isLowerCase(character) ? 'a' : 'A'; // Define a base do alfabeto
                decryptedText.append((char) ((character - base + test_key) % 26 + base)); // Decifra a letra
            } else {
                decryptedText.append(character); // Mantém caracteres não-letrais inalterados
            }
        }
        return decryptedText.toString(); // Retorna a frase decifrada
    }

    // Função para contar a frequência de cada letra na frase decifrada
    public static int[] countLetters(String phrase) {
        int[] letterCounts = new int[26];
        for (char character : phrase.toLowerCase().toCharArray()) {
            if (Character.isLetter(character)) { // Verifica se o caractere é uma letra
                int index = character - 'a'; // Calcula o índice da letra no array de contagem
                letterCounts[index]++; // Incrementa o contador para a letra correspondente
            }
        }
        return letterCounts; // Retorna a contagem de letras
    }

    // Função para encontrar a chave inicial mais provável usando a análise de frequência
    public static int findStarterKey(String codedPhrase) {
        double minDifference = Double.MAX_VALUE; // Define a diferença mínima inicial como o maior valor possível
        int bestKey = 0; // Inicializa a melhor chave como 0

        // Percorre todas as chaves possíveis
        for (int key = 0; key < 26; key++) {
            double difference = 0; // Inicializa a diferença como 0 para a chave atual
            String decryptedPhrase = decryptCaesar(codedPhrase, key); // Decifra a frase usando a chave atual
            int[] letterCounts = countLetters(decryptedPhrase); // Conta a frequência das letras na frase decifrada

            // Calcula a diferença entre a frequência esperada e a frequência real de cada letra
            for (int i = 0; i < 26; i++) {
                double expectedFrequency = PORTUGUESE_LETTER_FREQUENCY[i] / 100.0; // Frequência esperada em decimal
                double actualFrequency = (double) letterCounts[i] / decryptedPhrase.length(); // Frequência real
                difference += Math.abs(expectedFrequency - actualFrequency); // Soma das diferenças absolutas
            }

            // Atualiza a melhor chave se a diferença atual for menor que a diferença mínima
            if (difference < minDifference) {
                minDifference = difference; // Atualiza a diferença mínima
                bestKey = key; // Atualiza a melhor chave
            }
        }

        return bestKey; // Retorna a melhor chave encontrada
    }

    // Função para obter a frase cifrada do usuário
    public static String getCodedPhrase() {
        String codedPhrase;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the coded phrase:");
        codedPhrase = scanner.nextLine(); // Lê a frase cifrada fornecida pelo usuário
        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // Aguarda a entrada do usuário
        System.out.println();

        return codedPhrase; // Retorna a frase cifrada
    }

    public static void main(String[] args) {
        String codedPhrase = getCodedPhrase(); // Obtém a frase cifrada do usuário
        int starter_test_key = findStarterKey(codedPhrase); // Encontra a chave inicial mais provável

        System.out.println("\t\t.....RESULTS....\n");
        System.out.println("Coded Phrase: " + codedPhrase); // Exibe a frase cifrada
        System.out.println("Most Common Letter: " + (char) ('a' + starter_test_key)); // Exibe a letra mais comum

        // Decifra a frase para todas as chaves possíveis a partir da chave inicial mais provável
        for (int key = starter_test_key; key < 26; key++) {
            String decodedPhrase = decryptCaesar(codedPhrase, key); // Decifra a frase usando a chave atual

            System.out.print("For key value " + key + ": ");
            System.out.println(decodedPhrase); // Exibe a frase decifrada
            System.out.println();
        }
    }
}
