package TP3.Exercice1;

public class Thd2 extends Thread {
    private Resource resource;

    public Thd2(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 26; i++) {
            resource.addInt(i);
            try {
                Thread.sleep(50);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
