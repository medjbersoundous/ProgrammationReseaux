package TP3.Exercice3;

public class Producteur extends Thread {
    private Buffer buffer;

    public Producteur(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (char c = 'A'; c <= 'Z'; c++) {
                buffer.put(c);
                System.out.println("Produit : " + c);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
