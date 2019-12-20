package lab.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo1 {
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor();
    }
    public static void main0(String[] args) {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                10_000,
                TimeUnit.SECONDS,
                workQueue);

        for (int i = 0; i < 6; i++) {
            threadPoolExecutor.submit(createRunnable(i));
        }

        threadPoolExecutor.shutdown();
    }

    private static Runnable createRunnable(int num) {
        return () -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish num = " + num);
        };
    }
}
