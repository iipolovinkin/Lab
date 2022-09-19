package ru.github.iipolovinkin.testcontainers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class RedisBackedCacheIntTest {
    String version = "6.2.6-alpine";
    String fullImageName = "redis:" + version;

    // container {
    @Container
    public GenericContainer redis = new GenericContainer(DockerImageName.parse(fullImageName))
            .withExposedPorts(6379);
    private RedisBackedCache underTest;

    // }

    @BeforeEach
    public void setUp() {
        String address = redis.getHost();
        Integer port = redis.getFirstMappedPort();

        // Now we have an address and port for Redis, no matter where it is running
        underTest = new RedisBackedCache(address, port);
    }

    @Test
    public void testSimplePutAndGet() {
        underTest.put("test", "example");

        String retrieved = underTest.get("test");
        Assertions.assertEquals("example", retrieved);
    }
}
