import java.util.Scanner;


public class Question_2 {

    public static String feistelEncrypt(String text, int key) {

        String codedText = "";




        return codedText;
    }

    public static int f_and(){


        return 0;
    }

    public static String getPhrase() {
        String phrase;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the phrase to be coded:");
        phrase = scanner.nextLine(); // Lê a frase fornecida pelo usuário
        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // Aguarda a entrada do usuário
        System.out.println();

        return phrase; // Retorna a frase a ser cifrada
    }



    public static void main(String[] args) {

        int key= 0;//Mudar
        String phrase = getPhrase();
        String codedPhrase = feistelEncrypt(phrase, key);

    }
}