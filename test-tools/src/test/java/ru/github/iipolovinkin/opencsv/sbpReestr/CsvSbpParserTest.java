package ru.github.iipolovinkin.opencsv.sbpReestr;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class CsvSbpParserTest {
    CsvSbpParser csvParser = new CsvSbpParser();

    @SneakyThrows
    @Test
    void testBeanBuilderExample() {
        Path path1 = Paths.get("");
        System.out.println("path1 = " + path1.toAbsolutePath());
        Path path = Paths.get("./src/test/resources/sbp_reestr.csv");
        List<SbpBean> result = csvParser.beanBuilderExample(path);

        Assertions.assertEquals(new SbpBean("CARD*1234", "1234"), result.get(0));
        Assertions.assertEquals(new SbpBean("CARD*1235", "1235"), result.get(1));
        Assertions.assertEquals(new SbpBean("CARD*1236", "1236"), result.get(2));

    }
}

