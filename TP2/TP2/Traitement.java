package TP2;

import java.io.*;
import java.util.*;

public class Traitement {
    static ArrayList<String> t = new ArrayList<>();
    String chemin;
 
    public Traitement(String chemin) {
        this.chemin = chemin;
        File file = new File(chemin);
        if (!file.exists()) {
            System.out.println("Fichier n'existe pas");
        } else {
            copier();
            String motDominant = recherche();
            remplacer(motDominant);
            écrire();
        }
    }

    public void copier() {
        try (BufferedReader br = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                t.addAll(Arrays.asList(ligne.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String recherche() {
        HashMap<String, Integer> map = new HashMap<>();
        for (String mot : t) {
            map.put(mot, map.getOrDefault(mot, 0) + 1);
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public String miroir(String mot) {
        return new StringBuilder(mot).reverse().toString();
    }

    public void remplacer(String motDominant) {
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i).equals(motDominant)) {
                t.set(i, miroir(motDominant));
            }
        }
    }

    public void écrire() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(chemin))) {
            for (String mot : t) {
                bw.write(mot + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Traitement("d:/fichier.txt");
    }
}
