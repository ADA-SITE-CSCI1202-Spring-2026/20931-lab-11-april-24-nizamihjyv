public class DynamicScalingTest {

    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Logical processors available: " + cores);

        runTest(1);
        runTest(cores);
    }

    public static void runTest(int threadCount) throws InterruptedException {
        int iterations = 10_000_000;

        Thread[] threads = new Thread[threadCount];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new MathTask(i, iterations));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time with " + threadCount + " thread(s): "
                + (endTime - startTime) + " ms");
    }
}