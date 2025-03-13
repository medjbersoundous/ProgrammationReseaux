package TP3.Exercice3;

public class Consommateur extends Thread {
    private Buffer buffer;

    public Consommateur(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 0; i < 26; i++) {
                char c = buffer.get();
                System.out.println("Consommé : " + c);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

