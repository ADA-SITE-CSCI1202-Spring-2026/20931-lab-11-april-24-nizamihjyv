public class WaitNotifyTest {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread consumer = new Thread(new Consumer(resource));
        Thread producer = new Thread(new Producer(resource));

        consumer.start();
        producer.start();
    }
}