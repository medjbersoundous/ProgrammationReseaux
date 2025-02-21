import java.util.Scanner;

public class VerificateurPalindrome {
    public static boolean estPalindrome(String str) {
        str = str.toLowerCase();
        int debut = 0;
        int fin = str.length() - 1;
        while (debut < fin) {
            
            if (str.charAt(debut) != str.charAt(fin)) {
                return false;
            }
            debut++;
            fin--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un mot : ");
        String saisie = scanner.nextLine();
        if (estPalindrome(saisie)) {
            System.out.println("\"" + saisie + "\" est un palindrome !");
        } else {
            System.out.println("\"" + saisie + "\" n'est pas un palindrome.");
        }
        scanner.close();
    }
}