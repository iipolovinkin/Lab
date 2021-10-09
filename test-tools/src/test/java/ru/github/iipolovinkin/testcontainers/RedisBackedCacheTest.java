package ru.github.iipolovinkin.testcontainers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import static org.junit.Assert.assertEquals;

/**
 * https://www.testcontainers.org/quickstart/junit_4_quickstart/
 */
@Slf4j
public class RedisBackedCacheTest {
    String version = "6.2.6-alpine";
    String fullImageName = "redis:" + version;

    //for debug information use debug root level in logback-test.xml
    @Rule
    public GenericContainer redis = new GenericContainer(DockerImageName.parse(fullImageName))
            .withExposedPorts(6379);

    private RedisBackedCache underTest;

    @Before
    public void setUp() {
        String address = redis.getHost();
        Integer port = redis.getFirstMappedPort();
        log.info("address = {}, port = {}", address, port);
        underTest = new RedisBackedCache(address, port);
    }

    @Test
    public void testSimplePutAndGet() {
        underTest.put("test", "example");

        String retrieved = underTest.get("test");
        assertEquals("example", retrieved);
    }
}