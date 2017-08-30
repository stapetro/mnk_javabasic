package com.mnknowledge.concurrency;

/**
 * @author Stanislav Petrov
 */
public class BetterTask implements Runnable {
    private User user;
    private boolean executed = false;

    public BetterTask(User user) {
        this.user = user;
    }


    public synchronized boolean isExecuted() {
        return executed;
    }

    public synchronized void setExecuted(boolean executed) {
        this.executed = executed;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": Hello world from my better task from user " + user.getName());
        synchronized (user) {
            setExecuted(true);
            user.notify();
        }
    }
}
