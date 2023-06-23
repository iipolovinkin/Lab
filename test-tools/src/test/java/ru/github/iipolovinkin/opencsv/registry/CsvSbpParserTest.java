package ru.github.iipolovinkin.opencsv.registry;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
class CsvSbpParserTest {
    private ru.github.iipolovinkin.opencsv.registry.CsvSbpParser csvParser = new CsvSbpParser();


    @Test
    void testBeanBuilder() {
        // Arrange
        Path path = Paths.get("./src/test/resources/registry.csv");
        List<SbpBean> result = new ArrayList<>();
        Consumer<SbpBean> action = sbpBean -> {
            log.info("CsvSbpParserTest.accept: sbpBean = {}", sbpBean);
            result.add(sbpBean);
        };

        // Act
        csvParser.processCsv(path, action);


        // Assert
        Assertions.assertEquals(3, result.size());

        Assertions.assertEquals(new SbpBean("CARD*1234", "1234"), result.get(0));
        Assertions.assertEquals(new SbpBean("CARD*1235", "1235"), result.get(1));
        Assertions.assertEquals(new SbpBean("CARD*1236", "1236"), result.get(2));

    }

    @Test
    void testBeanBuilderExample() {
        Path path = Paths.get("./src/test/resources/registry.csv");
        List<SbpBean> result = csvParser.parseOneThread(path);

        Assertions.assertEquals(3, result.size());

        Assertions.assertEquals(new SbpBean("CARD*1234", "1234"), result.get(0));
        Assertions.assertEquals(new SbpBean("CARD*1235", "1235"), result.get(1));
        Assertions.assertEquals(new SbpBean("CARD*1236", "1236"), result.get(2));

    }

    @Test
    void testBeanBuilderExample2() {
        Path path = Paths.get("./src/test/resources/registryWithMissingColumn.csv");

        // Act && Assert
        Assertions.assertThrows(RuntimeException.class, () -> csvParser.parseOneThread(path));

    }

    @Test
    void testBeanBuilderExample3() {
        Path path = Paths.get("./src/test/resources/registry.csv");
        List<SbpBean> result = csvParser.parseMultiThread(path);

        Assertions.assertEquals(new SbpBean("CARD*1234", "1234"), result.get(0));
        Assertions.assertEquals(new SbpBean("CARD*1235", "1235"), result.get(1));
        Assertions.assertEquals(new SbpBean("CARD*1236", "1236"), result.get(2));
        Assertions.assertEquals(3, result.size());

    }

    @Test
    void testBeanBuilderExample4() {
        Path path = Paths.get("./src/test/resources/registryWithMissingColumn.csv");

        // Act && Assert
        Assertions.assertThrows(RuntimeException.class, () -> csvParser.parseMultiThread(path));

    }
}

