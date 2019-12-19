package lab.concurrent;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        ReadWriteMap<String, String> map = new ReadWriteMap(new HashMap());

        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(() -> {
            map.put("key", "value");
        });
        es.submit(() -> System.out.println("k,v = 1 " + map.get("key")));
        es.submit(() -> System.out.println("k,v = 2 " + map.get("key")));
        es.submit(() -> System.out.println("k,v = 3 " + map.get("key")));

        es.shutdown();

    }

    public static class ReadWriteMap<K, V> {
        private final Map<K, V> map;
        private final ReadWriteLock lock = new ReentrantReadWriteLock(false);
        private final Lock r = lock.readLock();
        private final Lock w = lock.writeLock();

        public ReadWriteMap(Map<K, V> map) {
            this.map = map;
        }

        public V put(K key, V value) {
            w.lock();
            try {
                System.out.println(value + " put = " + new Date().getTime());
                TimeUnit.MILLISECONDS.sleep(100);
                return map.put(key, value);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            } finally {
                w.unlock();
            }
        }

        public V get(Object key) {
            r.lock();
            try {
                System.out.println(key + " get = " + new Date().getTime());
                return map.get(key);
            } finally {
                r.unlock();
            }
        }

    }
}
