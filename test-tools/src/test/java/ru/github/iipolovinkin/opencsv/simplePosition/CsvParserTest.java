package ru.github.iipolovinkin.opencsv.simplePosition;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.github.iipolovinkin.opencsv.simplePosition.CsvParser;
import ru.github.iipolovinkin.opencsv.simplePosition.SimplePositionBean;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

class CsvParserTest {
    CsvParser csvParser = new CsvParser();

    @SneakyThrows
    @Test
    void testBeanBuilderExample() {
        Path path1 = Paths.get("");
        System.out.println("path1 = " + path1.toAbsolutePath());
        Path path = Paths.get("./src/test/resources/simplePosition.csv");
        List<SimplePositionBean> result = csvParser.beanBuilderExample(path);
        Assertions.assertEquals(Arrays.<SimplePositionBean>asList(
                new SimplePositionBean("hello", "123"),
                new SimplePositionBean("he1lo", "143")
        ), result);
    }
}

