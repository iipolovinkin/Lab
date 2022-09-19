package lab.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemoCopy {
    public static void main(String[] args) {

//        runTasks(Executors.newSingleThreadExecutor(), 10, 500, 0);
//        runTasks(Executors.newFixedThreadPool(4), 10, 500, 0);
//        runTasks(Executors.newCachedThreadPool(), 10, 500, 0);
//        runTasks(Executors.newSingleThreadScheduledExecutor(), 10, 500, 0);
//        runTasks(Executors.newScheduledThreadPool(4), 10, 500, 0);

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(getRunnable(5000, 1), 1, 2, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(getRunnable(500, 2), 2, 2, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(getRunnable(500, 2), 2, 2, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(getRunnable(500, 2), 2, 2, TimeUnit.SECONDS);

    }

    public static void scheduledExecutorDemo() throws InterruptedException {
        ThreadFactory thFactory = r -> {
            System.out.println("r = " + 1);
            return new Thread(r);
        };
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor(thFactory);
        scheduledExecutor.schedule(getRunnable(500, 1), 5, TimeUnit.SECONDS);
        scheduledExecutor.scheduleAtFixedRate(
                getRunnable(500, 2),
                1,
                2, TimeUnit.SECONDS);
        Thread.sleep(10_000);
    }

    private static void runTasks(ExecutorService executorService, int threadCount, long millis, int add) {
        for (int i = 0; i < threadCount; i++) {
//            executorService.submit(getRunnable(millis + i * add, i));
            executorService.submit(getRunnable(millis + i * add, i));
        }

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private static Runnable getRunnable(long timeOut, int num) {
        return () -> {
            try {
                System.out.printf("Num: %s, timeout: %s, Thread :%s \n", num, timeOut, Thread.currentThread().getName());
                Thread.sleep(timeOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
