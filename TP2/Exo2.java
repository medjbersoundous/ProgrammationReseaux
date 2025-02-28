package TP2;

import java.io.*;
import java.util.Scanner;

public class Exo2 {
    public static String newHouse() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Code de la maison : ");
            String houseCode = scanner.nextLine();

            System.out.print("Adresse de la maison : ");
            String houseAddress = scanner.nextLine();

            System.out.print("Nombre de chambres : ");
            int houseNRoom = scanner.nextInt();

            System.out.print("Prix en millions de dinars : ");
            double housePrice = scanner.nextDouble();
            scanner.nextLine();

            return houseCode + ";" + houseAddress + ";" + houseNRoom + ";" + housePrice;
        }
    }

    public static void saveHouseInByte(String h) {
        try (FileOutputStream fos = new FileOutputStream("listeHouse.dat", true)) {
            fos.write(h.getBytes());
            fos.write("\n".getBytes()); 
            System.out.println("Maison enregistrée en mode octet.");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'enregistrement : " + e.getMessage());
        }
    }

    public static void readHousesFromByte() {
        try (FileInputStream fis = new FileInputStream("listeHouse.dat")) {
            int c;
            while ((c = fis.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture : " + e.getMessage());
        }
    }

    public static void saveHousesInByte(String[] houses) {
        try (FileOutputStream fos = new FileOutputStream("listeHouse.dat", true)) {
            for (String h : houses) {
                fos.write(h.getBytes());
                fos.write("\n".getBytes());
            }
            System.out.println("Toutes les maisons enregistrées en une seule écriture.");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'enregistrement : " + e.getMessage());
        }
    }

    public static void mergeHouseFiles(String[] inputFiles, String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String file : inputFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Erreur de lecture du fichier : " + file);
                }
            }
            System.out.println("Fusion terminée ! Résultats enregistrés dans " + outputFile);
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier fusionné : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        
        String newHouse = newHouse();
        saveHouseInByte(newHouse);

        
        System.out.println("\nListe des maisons enregistrées :");
        readHousesFromByte();

        
        String[] inputFiles = {"listeHouse.dat", "immobiliers.dat", "maison.dat"};
        String outputFile = "houses.dat";
        mergeHouseFiles(inputFiles, outputFile);
    }
}
