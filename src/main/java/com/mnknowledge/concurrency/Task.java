package com.mnknowledge.concurrency;

/**
 * @author Stanislav Petrov
 */
public class Task extends Thread {
    private User user;

    public Task(String name) {
        super(name);
    }

    public Task(String name, User user) {
        super(name);
        this.user = user;
    }

    public Task() {
        super();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Hello world from my task with user " + (user != null ? user.getName() : "none"));
    }
}
