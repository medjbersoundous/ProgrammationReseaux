package TP3.Exercice1;

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource();

        Thd1 t1 = new Thd1(resource);
        Thd2 t2 = new Thd2(resource);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Taille de la chaîne : " + resource.getLength());
        System.out.println("Contenu final : " + resource.getString());
    }
}

