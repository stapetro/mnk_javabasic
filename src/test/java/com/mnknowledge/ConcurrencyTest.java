package com.mnknowledge;

import com.mnknowledge.concurrency.BetterTask;
import com.mnknowledge.concurrency.Task;
import com.mnknowledge.concurrency.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Stanislav Petrov
 */
public class ConcurrencyTest {
    private BetterTask betterTask;
    private User ivan;

    @BeforeEach
    public void setUp() {
        ivan = new User("ivan georgiev");
        betterTask = new BetterTask(ivan);
    }

    @Test
    public void testConcurrency() throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + ": tests task execution");
        Task task = new Task("heavyTask", ivan);
        Task task1 = new Task();
        task.start();
        Thread betterTaskThread = new Thread(betterTask, "flexibleHeavyTask");
        betterTaskThread.start();
        System.out.println(Thread.currentThread().getName() + ": is waiting");
        betterTaskThread.join();
        new Thread(betterTask, "flexibleTask2").start();
        task1.start();
    }

    @Test
    public void testExecutors() throws InterruptedException {
        ExecutorService singleExec = Executors.newSingleThreadExecutor();
        singleExec.execute(betterTask);
        singleExec.shutdown();

        synchronized (ivan) {
            ivan.wait();
            Assertions.assertTrue(betterTask.isExecuted());
        }
    }
}
