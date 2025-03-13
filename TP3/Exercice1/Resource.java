package TP3.Exercice1;

public class Resource {
    private StringBuilder str = new StringBuilder();
    public synchronized void addChar(int i) {
        char c = (char) ('A' + i);
        str.append(c);
        System.out.println("Ajout du caractère: " + c);
    }
    public synchronized void addInt(int i) {
        str.append(i);
        System.out.println("Ajout de l'entier: " + i);
    }
    public int getLength() {
        return str.length();
    }

    public String getString() {
        return str.toString();
    }
}

