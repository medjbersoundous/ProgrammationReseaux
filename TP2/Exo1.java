package TP2;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class Exo1 {
    public static void main(String args[]) {
        String nomFichierLecture = "nombre.txt";
        String nomFichierEcriture = "resultat.txt";

        try (
                BufferedReader entree = new BufferedReader(new FileReader(nomFichierLecture));
                BufferedWriter sortie = new BufferedWriter(new FileWriter(nomFichierEcriture))) {
            System.out.println("Nombres et carrés contenus dans ce fichier :");

            String ligneLue;
            while ((ligneLue = entree.readLine()) != null) {
                StringTokenizer tok = new StringTokenizer(ligneLue, " ");
                Vector<Integer> nbrs = new Vector<>();

                while (tok.hasMoreTokens()) {
                    nbrs.add(Integer.parseInt(tok.nextToken()));
                }

                for (int nbr : nbrs) {
                    int carre = (int) Math.pow(nbr, 2);
                    if (nbrs.contains(carre)) {
                        String resultat = nbr + " " + carre;
                        System.out.println(resultat);
                        sortie.write(resultat);
                        sortie.newLine();
                    }
                }
            }

            System.out.println("Les résultats ont été enregistrés dans " + nomFichierEcriture);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture ou de l'écriture du fichier : " + e.getMessage());
        }
    }
}
