public class MathTask implements Runnable {
    private final int threadId;
    private final int iterations;

    public MathTask(int threadId, int iterations) {
        this.threadId = threadId;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        long sum = 0;

        for (int i = 0; i < iterations; i++) {
            sum += (long) i * i * i + (long) i * threadId;
        }

        System.out.println("Thread " + threadId + " finished. Sum = " + sum);
    }
}