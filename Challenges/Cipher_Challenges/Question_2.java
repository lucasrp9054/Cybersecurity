import java.util.Scanner;

public class Question_2 {

    public static String feistelEncrypt(String phrase) {

        Scanner scanner = new Scanner(System.in);

        String codedPhrase = "";//Change

        String leftHalf = phrase.substring(0, phrase.length() / 2);//Start to half
        String rightHalf = phrase.substring(phrase.length() / 2);//Half to end

        System.out.println("First, we divide the phrase into two symmetrical halves.");
        System.out.println("leftHalf: "+ leftHalf);
        System.out.println("rightHalf: "+ rightHalf);

        System.out.println("Press Enter to continue...");
        scanner.nextLine();


        String subKey = circular_left_shift(phrase);

        System.out.println("Secondly, we need to realize circular left shift to generate our sub-key: ");
        System.out.println("Ki: "+ subKey);

        System.out.println("Press Enter to continue...");
        scanner.nextLine();

        return codedPhrase;
    }

    public static  String circular_left_shift(String phrase) {

        char[] vector_left_shift = new char[(phrase.length())];

        for (int i = 0; i < phrase.length(); i++)
        {
            if(i == 0)
            {
                vector_left_shift[((phrase.length()) - 1)] = phrase.charAt(i);
            }
            else
            {
                vector_left_shift[i-1] = phrase.charAt(i);
            }
        }
        return String.valueOf(vector_left_shift);
    }

    public static int f_and(String half, String subKey){

        // Aqui você implementará a função "f_and" para a lógica Feistel
        return 0; // Por enquanto, está retornando apenas 0
    }

    public static String getPhrase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the phrase to be coded:");
        String phrase = scanner.nextLine();

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        System.out.println();

        return phrase; // Retorna a frase a ser cifrada dentro do vetor
    }

    public static void main(String[] args) {
        int key = 0; // Você pode definir uma chave de criptografia aqui
        String phrase = getPhrase();
        String codedPhrase = feistelEncrypt(phrase);

    }
}
