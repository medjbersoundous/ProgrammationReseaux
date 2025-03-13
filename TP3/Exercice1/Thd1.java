package TP3.Exercice1;

public class Thd1 extends Thread {
    private Resource resource;

    public Thd1(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 0; i < 26; i++) {
            resource.addChar(i);
            try {
                Thread.sleep(50);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

