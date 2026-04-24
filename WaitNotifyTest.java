public class WaitNotifyTest {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread consumer = new Thread(new Consumer(resource));
        Thread producer = new Thread(new Producer(resource));

        consumer.start();

        try {
            Thread.sleep(1000); // delay to show waiting behavior
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        producer.start();
    }
}