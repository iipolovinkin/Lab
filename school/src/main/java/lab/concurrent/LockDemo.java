package lab.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static Integer sharedObject = 0;
    public static Lock lock = new ReentrantLock();
    public static int THREAD_COUNT = 3;

    public static void main(String[] args) {
        main0();
    }

    public static void main1(String[] args) throws InterruptedException {
        Collection<Callable<Object>> tasks = new ArrayList<>();

        for (int i = 0; i < THREAD_COUNT; i++) {
//            tasks.add(Executors.callable(getRunnableLock(i + 1)));
//            tasks.add(Executors.callable(getRunnableTryLock(i + 1)));
//            tasks.add(Executors.callable(getRunnableTryLockTime(i + 1)));
//            tasks.add(Executors.callable(getRunnableLockInterruptibly(i + 1)));

        }

        invokeAll(THREAD_COUNT, tasks);

        System.out.println("\nИтоговый sharedObject = " + sharedObject);
    }

    public static void main0() {
        Thread thread1 = new Thread(getRunnableLock(1));
        thread1.start();
        mSleep(100);
        Thread thread2 = new Thread(getRunnableLock(2));
        thread2.start();
        mSleep(20);
        System.out.println("thread2.isInterrupted() = " + thread2.isInterrupted());
        thread2.interrupt();
        System.out.println("thread2.isInterrupted() = " + thread2.isInterrupted());
//        try {
//            Thread.sleep(10_0000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private static void mSleep(int timeOut) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // lock - unlock
    // tryLock, unlock
    // tryLock(10, Seconds), unlock
    // lock.lockInterruptibly()

    public static <T extends Callable<Object>> void invokeAll(int thCount, Collection<T> tasks) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(thCount);

        executorService.invokeAll(tasks);

        executorService.shutdown();
    }

    private static Runnable getRunnableLock(int num) {
        return () -> {
            System.out.printf("Worker %s в ожидании блокировки\n", num);
            lock.lock();
            try {
                System.out.printf("Worker %s захватил блокировку. ", num);
                sharedObject += 1;
                System.out.printf("Worker %s Установил результат %s. ", num, sharedObject);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
//                System.out.printf("Worker %s НЕ Освобождает блокировку, если не вызвать unlock.\n", num);
                System.out.printf("Worker %s Освобождает блокировку.\n", num);
                lock.unlock();
            }
        };
    }

    private static Runnable getRunnableTryLock(int num) {
        return () -> {
            System.out.printf("Worker %s в ожидании блокировки\n", num);
            if (!lock.tryLock()) {
                System.out.printf("Worker %s не захватил блокировку. \n", num);
                return;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                if (sharedObject == 0) {
                    System.out.println();
                }
                System.out.printf("Worker %s захватил блокировку. ", num);
                sharedObject += 1;
                System.out.printf("Worker %s Установил результат %s. ", num, sharedObject);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.printf("Worker %s Освобождает блокировку.\n", num);
                lock.unlock();
            }
        };
    }

    private static Runnable getRunnableTryLockTime(int num) {
        return () -> {
            System.out.printf("Worker %s в ожидании блокировки\n", num);
            boolean tryLock = false;
            try {
                if (lock.tryLock(1, TimeUnit.SECONDS)) tryLock = true;
                else tryLock = false;
                if (!tryLock) {
                    System.out.printf("\nWorker %s не захватил блокировку. \n", num);
                    return;
                }

                TimeUnit.MILLISECONDS.sleep(300);
                if (sharedObject == 0) {
                    System.out.println();
                }
                System.out.printf("Worker %s захватил блокировку. ", num);
                sharedObject += 1;
                System.out.printf("Worker %s Установил результат %s. ", num, sharedObject);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (tryLock) {
                    System.out.printf("Worker %s Освобождает блокировку.\n", num);
                    lock.unlock();
                }

            }
        };
    }

    private static Runnable getRunnableAwaitWithCondition(int num) {
        return () -> {
            System.out.printf("Worker %s в ожидании блокировки\n", num);
            lock.lock();
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                if (sharedObject == 0) {
                    System.out.println();
                }
                System.out.printf("Worker %s захватил блокировку. ", num);
                sharedObject += 1;
                System.out.printf("Worker %s Установил результат %s. ", num, sharedObject);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
//                System.out.printf("Worker %s НЕ Освобождает блокировку, если не вызвать unlock.\n", num);
                System.out.printf("Worker %s Освобождает блокировку.\n", num);
                lock.unlock();
            }
            if (sharedObject < THREAD_COUNT) {
//                try {
                System.out.printf("Worker %s await.\n", num);
//                    condition.await();
                System.out.printf("Worker %s преодолел await.\n", num);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            } else {
                System.out.printf("Worker %s добрался последним и выпускает всех.\n", num);
//                condition.signalAll();
            }
        };
    }

    private static Runnable getRunnableLockInterruptibly(int num) {
        return () -> {
            System.out.printf("Worker %s в ожидании блокировки lockInterruptibly\n", num);
            boolean b = false;
            try {
                lock.lockInterruptibly();
                b = true;


                TimeUnit.MILLISECONDS.sleep(300);
                if (sharedObject == 0) {
                    System.out.println();
                }
                System.out.printf("Worker %s захватил блокировку. ", num);
                sharedObject += 1;
                System.out.printf("Worker %s Установил результат %s. ", num, sharedObject);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("Worker %s. InterruptedException блокировка захвачена: %s\n", num, b);
                e.printStackTrace();
            } finally {
                if (b) {
                    System.out.printf("Worker %s Освобождает блокировку.\n", num);
                    lock.unlock();
                }

            }
        };
    }

}
