class NumberPrinter {

    private final Object lock = new Object();
    private int currentNumber = 1;

    public void printTwo() {
        while (currentNumber <= 15) {
            synchronized (lock) {
                if (currentNumber % 2 == 0) {
                    System.out.println(currentNumber + " is divisible by 2");
                }
                currentNumber++;
                lock.notifyAll(); // Notify other threads to check
                try {
                    if (currentNumber <= 15) {
                        lock.wait(); // Wait for other threads to complete
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void printThree() {
        while (currentNumber <= 15) {
            synchronized (lock) {
                if (currentNumber % 3 == 0) {
                    System.out.println(currentNumber + " is divisible by 3");
                }
                currentNumber++;
                lock.notifyAll();
                try {
                    if (currentNumber <= 15) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void printFour() {
        while (currentNumber <= 15) {
            synchronized (lock) {
                if (currentNumber % 4 == 0) {
                    System.out.println(currentNumber + " is divisible by 4");
                }
                currentNumber++;
                lock.notifyAll();
                try {
                    if (currentNumber <= 15) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void printFive() {
        while (currentNumber <= 15) {
            synchronized (lock) {
                if (currentNumber % 5 == 0) {
                    System.out.println(currentNumber + " is divisible by 5");
                }
                currentNumber++;
                lock.notifyAll();
                try {
                    if (currentNumber <= 15) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void printNumber() {
        while (currentNumber <= 15) {
            synchronized (lock) {
                if (currentNumber % 2 != 0 && currentNumber % 3 != 0 &&
                    currentNumber % 4 != 0 && currentNumber % 5 != 0) {
                    System.out.println(currentNumber);
                }
                currentNumber++;
                lock.notifyAll();
                try {
                    if (currentNumber <= 15) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}

public class MultiThreadNumberPrinter {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        Thread t1 = new Thread(printer::printTwo);
        Thread t2 = new Thread(printer::printThree);
        Thread t3 = new Thread(printer::printFour);
        Thread t4 = new Thread(printer::printFive);
        Thread t5 = new Thread(printer::printNumber);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
