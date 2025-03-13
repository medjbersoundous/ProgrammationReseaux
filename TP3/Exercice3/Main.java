package TP3.Exercice3;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);

        Producteur p = new Producteur(buffer);
        Consommateur c = new Consommateur(buffer);

        p.start();
        c.start();

        try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

