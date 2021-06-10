package main.java;

public class TestingThread implements Runnable {

    private String s;
    private int i;
    private int number;

    public TestingThread(String s, int i) {

        this.s = s;
        this.i = i;
    }

    // synchronized only lets one thread at a time use this method
    // it's kind of like a gatekeeper
    public synchronized void incrementNumber() {
        number++;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(500);
                incrementNumber();
                System.out.println(number);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}
