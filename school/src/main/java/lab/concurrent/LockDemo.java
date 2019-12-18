package lab.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static Integer sharedObject = 0;

    public static void main(String[] args) throws InterruptedException {

        List l = new ArrayList();
        ConcurrencyLockExample e1 = new ConcurrencyLockExample(l);
        ConcurrencyLockExample e2 = new ConcurrencyLockExample(l);
        invokeAll(3,
                Executors.callable(e1), Executors.callable(e2));
    }

    public static void main12(String[] args) throws InterruptedException {
        Lock firstLock = new ReentrantLock();
        Lock secondLock = new ReentrantLock();
        MyRunnable t1 = new MyRunnable(100, firstLock, secondLock);
        MyRunnable t2 = new MyRunnable(200, firstLock, secondLock);

        invokeAll(3, t1, t2);
    }

    public static <T extends Callable<Object>> void invokeAll(int thCount, T... tasks) throws InterruptedException {

    }

    public static <T extends Callable<Object>> void invokeAll(int thCount, Collection<T> tasks) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(thCount);

        executorService.invokeAll(tasks);

        executorService.shutdown();
    }

    public static void main2(String[] args) throws InterruptedException {
        int thCount = 2_000;
        int taskCount = 500_000;
        ExecutorService executorService = Executors.newFixedThreadPool(thCount);

        for (int i = 0; i < taskCount; i++) {
            executorService.submit(getRunnable(i));
        }
        Thread.sleep(20000);
        executorService.shutdown();
        System.out.println("sharedObject = " + sharedObject);
    }

    private static Runnable getRunnable(int i) {
        return () -> {
//            Lock lock = new ReentrantLock();
//            lock.lock();
//            try {
            sharedObject += 1;
//                System.out.println("i = " + i);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            lock.unlock();
//            System.out.println(i + " sharedObject = " + sharedObject);
        };
    }

    private static class MyRunnable implements Callable<Object> {
        private final Lock first;
        private final Lock second;
        private final int num;

        public MyRunnable(int num, Lock firstLock, Lock secondLock) {
            this.first = firstLock;
            this.second = secondLock;
            this.num = num;
        }

        @Override
        public Object call() throws Exception {
            r2();
            return null;
        }

        private void r2() {

            Lock lock = first;
            if (lock.tryLock()) {
                try {
                    System.out.println("success num " + num);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("fail num " + num);
            }
        }

        private void r1() {
            boolean tryLock = first.tryLock();
            System.out.println("tryLock = " + tryLock);

            boolean tryLock2 = second.tryLock();
            System.out.println("tryLock2 = " + tryLock2);

            if (tryLock2) {
                System.out.println("UnLock2");
                second.unlock();
            }


            if (tryLock) {
                System.out.println("UnLock1");
                first.unlock();
            }
        }
    }
}
