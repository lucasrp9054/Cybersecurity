import java.util.Scanner;

public class Question_2 {

    public static String feistelEncrypt(String phrase, int key) {
        String leftHalf = phrase.substring(0, phrase.length() / 2);//Start to half
        String rightHalf = phrase.substring(phrase.length() / 2);//Half to end

        // Implemente aqui a lógica da cifragem Feistel

        return ""; // Retornando uma string vazia por enquanto
    }

    public static int f_and(){
        // Aqui você implementará a função "f_and" para a lógica Feistel
        return 0; // Por enquanto, está retornando apenas 0
    }

    public static String getPhrase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the phrase to be coded:");
        String phrase = scanner.nextLine(); // Lê a frase fornecida pelo usuário

        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // Aguarda a entrada do usuário
        System.out.println();

        return phrase; // Retorna a frase a ser cifrada dentro do vetor
    }

    public static void main(String[] args) {
        int key = 0; // Você pode definir uma chave de criptografia aqui
        String phrase = getPhrase();
        String codedPhrase = feistelEncrypt(phrase, key);
    }
}
