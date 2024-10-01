import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private Queue<String> buffer = new LinkedList<>();
    private int capacity;

    // Constructor to initialize the buffer capacity
    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    // Synchronized method to produce messages
    public synchronized void produce(String message) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();  // Wait until there is space in the buffer
        }
        buffer.add(message);
        System.out.println("Produced: " + message);
        notifyAll();  // Notify waiting consumer threads
    }

    // Synchronized method to consume messages
    public synchronized String consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();  // Wait until there is a message in the buffer
        }
        String message = buffer.poll();
        System.out.println("Consumed: " + message);
        notifyAll();  // Notify waiting producer threads
        return message;
    }
}

class Producer implements Runnable {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                buffer.produce("Message " + i);
                Thread.sleep(100);  // Simulating message generation time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                buffer.consume();
                Thread.sleep(150);  // Simulating message consumption time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(10);  // Bounded buffer of size 10

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        // Start the producer and consumer threads
        producerThread.start();
        consumerThread.start();
    }
}
