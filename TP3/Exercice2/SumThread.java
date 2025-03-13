package TP3.Exercice2;

public class SumThread extends Thread {
    private int start, end;
    private long sum = 0;

    public SumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            sum += i;
        }
    }

    public long getSum() {
        return sum;
    }
}

