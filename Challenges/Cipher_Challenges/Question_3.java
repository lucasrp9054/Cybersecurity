import java.util.Scanner;

public class Question_3 {






    public static String getWord() {
        String word;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the coded phrase:");
        word = scanner.nextLine(); // Lê a frase cifrada fornecida pelo usuário
        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // Aguarda a entrada do usuário
        System.out.println();

        return word; // Retorna a frase cifrada
    }

    public static void main(String[] args) {

    }
}