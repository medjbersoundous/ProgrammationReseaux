package TP3.Exercice3;

public class Buffer {
    private char[] buffer;
    private int count = 0, in = 0, out = 0;

    public Buffer(int size) {
        buffer = new char[size];
    }

    public synchronized void put(char c) throws InterruptedException {
        while (count == buffer.length) {
            wait();
        }
        buffer[in] = c;
        in = (in + 1) % buffer.length;
        count++;
        notify();
    }

    public synchronized char get() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        char c = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        notify();
        return c;
    }
}

