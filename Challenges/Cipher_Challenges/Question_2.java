import java.util.Scanner;

public class Question_2 {

    public static String f_Encrypt(String phrase) {

        Scanner scanner = new Scanner(System.in);


        String leftHalf = phrase.substring(0, phrase.length() / 2);//Start to half
        String rightHalf = phrase.substring(phrase.length() / 2);//Half to end

        System.out.println("First, we divide the phrase into two symmetrical halves.");
        System.out.println("leftHalf: "+ leftHalf);
        System.out.println("rightHalf: "+ rightHalf);

        System.out.println("Press Enter to continue...");
        scanner.nextLine();


        String subKey = circular_left_shift(phrase);

        System.out.println("Secondly, we need to realize circular left shift to generate our sub-key: ");
        System.out.println("Sub-key: "+ subKey);

        System.out.println("Press Enter to continue...");
        scanner.nextLine();

        System.out.println("Now we are going to run the AND function on both halves for 2 rounds.");

        String new_rightHalf = rightHalf; // Defina as variáveis fora do loop
        String new_leftHalf = leftHalf;

        for (int i = 1; i < 5; i++)
        {
            if(i % 2 == 0)
            {
                new_rightHalf = functionAND( rightHalf, subKey);
            }
            else
            {
                new_leftHalf = functionAND( leftHalf, subKey);
            }
        }
        String codedPhrase = new_leftHalf + new_rightHalf;

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

    public static String functionAND(String half, String subKey){
        // Use the same size of the sub-key from the half received
        String usedKey = subKey.substring(0, half.length());

        char[] vectorAND = new char[half.length()];

        char[] keyAND = usedKey.toCharArray();

        for(int i = 0; i < half.length(); i++) {
            if (keyAND[i] == '0' || half.charAt(i) == '0')
            {
                vectorAND[i] = '0';
            }
            else
            {
                vectorAND[i] = '1';
            }
        }
        return String.valueOf(vectorAND);
    }

    public static String getPhrase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the phrase to be coded:");
        String phrase = scanner.nextLine();

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
        return phrase; // Retorna a frase a ser cifrada dentro do vetor
    }

    public static void main(String[] args) {
        int key = 0; // Você pode definir uma chave de criptografia aqui
        String phrase = getPhrase();
        String codedPhrase = f_Encrypt(phrase);
        System.out.println("The phrase before being coded is: " + phrase);
        System.out.println("The phrase after being coded is: " + codedPhrase);

    }
}
