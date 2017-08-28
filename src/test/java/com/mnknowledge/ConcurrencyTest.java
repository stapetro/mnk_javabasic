package com.mnknowledge;

import com.mnknowledge.concurrency.BetterTask;
import com.mnknowledge.concurrency.Task;
import com.mnknowledge.concurrency.User;

import org.junit.Test;

/**
 * @author Stanislav Petrov
 */
public class ConcurrencyTest {
    @Test
    public void testConcurrency() throws InterruptedException {
        User ivan = new User("ivan georgiev");
        System.out.println(Thread.currentThread().getName() + ": tests task execution");
        Task task = new Task("heavyTask", ivan);
        Task task1 = new Task();
        task.start();
        Thread betterTaskThread = new Thread(new BetterTask(ivan), "flexibleHeavyTask");
        betterTaskThread.start();
        System.out.println(Thread.currentThread().getName() + ": is waiting");
        betterTaskThread.join();
        new Thread(new BetterTask(ivan), "flexibleTask2").start();
        task1.start();
    }
}
