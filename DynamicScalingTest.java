public class DynamicScalingTest {

    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Logical processors available: " + cores);

        int iterations = 10_000_000;

        long start1 = System.currentTimeMillis();

        Thread t1 = new Thread(new MathTask(0, iterations));
        t1.start();
        t1.join();

        long end1 = System.currentTimeMillis();

        System.out.println("Time with 1 thread: " + (end1 - start1) + " ms");

        long startN = System.currentTimeMillis();

        for (int i = 0; i < cores; i++) {
            Thread t = new Thread(new MathTask(i, iterations));
            t.start();
            t.join();
        }

        long endN = System.currentTimeMillis();

        System.out.println("Time with " + cores + " sequential runs: "
                + (endN - startN) + " ms");
    }
}