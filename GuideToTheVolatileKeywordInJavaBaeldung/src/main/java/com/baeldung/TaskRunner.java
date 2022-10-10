package com.baeldung;

/**
 * For multithreaded applications, we need to ensure a couple of rules for consistent behavior:
 *
 * Mutual Exclusion – only one thread executes a critical section at a time
 * Visibility – changes made by one thread to the shared data are visible to other threads to maintain data consistency
 * synchronized methods and blocks provide both of the above properties, at the cost of application performance.
 *
 * volatile is quite a useful keyword because it can help ensure the visibility aspect of the data change without, of course, providing mutual exclusion.
 * Thus, it's useful in the places where we're ok with multiple threads executing a block of code in parallel, but we need to ensure the visibility property.
 */
public class TaskRunner {



    // To ensure that updates to variables propagate predictably to other threads, we should apply the volatile modifier to those variables:
    private static volatile int number;
    private static volatile boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }

    }

    public static void main(String[] args) {
            new Reader().start();
            number = 42;
            ready = true;
    }

}
