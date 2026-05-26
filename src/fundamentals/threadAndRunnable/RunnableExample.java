package fundamentals.threadAndRunnable;

// 2. Using 'implements Runnable' (preferred, clean separation)
class RunnableExample implements Runnable {
    private SharedCounter sharedCounter;

    public RunnableExample(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            sharedCounter.doWork();
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }
}