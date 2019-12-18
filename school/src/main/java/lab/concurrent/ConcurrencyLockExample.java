package lab.concurrent;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyLockExample implements Runnable {

    private List<String> resource;
    private Lock lock;

    public ConcurrencyLockExample(List r) {
        this.resource = r;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try {
            // пытаемся взять лок в течении 10 секунд
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                resource.add("1");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //убираем лок
            lock.unlock();
        }
        // Для логгирования не требуется потокобезопасность
        resource.add("2");
    }

}