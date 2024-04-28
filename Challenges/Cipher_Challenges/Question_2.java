import java.util.Scanner;


public class Question_2 {

    public static void feistelEncrypt(String phrase, int key) {

        String leftHalf = phrase.substring(0, phrase.length() / 2);//Start to half
        String rightHalf = phrase.substring(phrase.length() / 2);//Half to end





    }

    public static int f_and(){


        return 0;
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

        int key= 0;//Mudar
        String phrase = getPhrase();
        String codedPhrase = feistelEncrypt(phrase, key);

    }
}