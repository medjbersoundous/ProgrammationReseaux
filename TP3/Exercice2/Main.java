package TP3.Exercice2;

public class Main {
    public static void main(String[] args) {
        int n = 1000;
        int m = 4;
        SumThread[] threads = new SumThread[m];

        int chunkSize = n / m;
        int start = 1;

        for (int i = 0; i < m; i++) {
            int end = (i == m - 1) ? n : start + chunkSize - 1;
            threads[i] = new SumThread(start, end);
            threads[i].start();
            start = end + 1;
        }

        long totalSum = 0;
        for (int i = 0; i < m; i++) {
            try {
                threads[i].join();
                totalSum += threads[i].getSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Somme totale = " + totalSum);
    }
}
