package ru.github.iipolovinkin.testcontainers;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * https://www.testcontainers.org/quickstart/junit_4_quickstart/
 */
@Slf4j
public class RedisBackedCache {
    private Jedis jedis;

    public RedisBackedCache(String localhost, int port) {
        jedis = new Jedis(localhost, port);
    }

    void put(String key, String value) {
        log.info("key: {}, value: {}", key, value);
        jedis.set(key, value);
    }

    public String get(String key) {
        String value = jedis.get(key);
        log.info("get value by key: {}, value: {}", key, value);
        return value;
    }
}
