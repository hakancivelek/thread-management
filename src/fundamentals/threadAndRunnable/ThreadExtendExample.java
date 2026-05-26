package fundamentals.threadAndRunnable;

// 1. Using 'extends Thread' (poor design, but possible)
class ThreadExtendExample extends Thread {
    private SharedCounter sharedCounter;

    public ThreadExtendExample(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            sharedCounter.doWork();
            try { Thread.sleep(10); } catch (InterruptedException e) {}
        }
    }
}
