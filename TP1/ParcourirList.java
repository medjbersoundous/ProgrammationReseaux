import java.util.Scanner;

public class ParcourirList {
    public static int trouverIndice(String nom, String[] tNoms) {
        for (int i = 0; i < tNoms.length; i++) {
            if (tNoms[i].equals(nom)) {
                return i;
            }
        }
        return -1;
    }

    public static int trouverNote(String nom, String[] tNoms, int[] tNotes) {
        int indice = trouverIndice(nom, tNoms);
        if (indice == -1) {
            return -1;
        }
        return tNotes[indice];
    }

    public static void main(String[] args) {
        String[] tNoms = { "amine", "soundous", "hocine", "ahmed" };
        int[] tNotes = { 12, 20, 14, 10 };

        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("enter student name");

        String nom = input.nextLine();

        int note = trouverNote(nom, tNoms, tNotes);
        if (note == -1) {
            System.out.println(nom + " not found");
        } else {
            System.out.println( nom + "'s grade "+" is " + note);
        }

    }
}
