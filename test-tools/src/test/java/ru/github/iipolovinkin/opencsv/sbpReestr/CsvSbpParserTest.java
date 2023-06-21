package ru.github.iipolovinkin.opencsv.sbpReestr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class CsvSbpParserTest {
    private CsvSbpParser csvParser = new CsvSbpParser();

    @Test
    void testBeanBuilderExample() {
        Path path = Paths.get("./src/test/resources/reestr.csv");
        List<SbpBean> result = csvParser.parseOneThread(path);

        Assertions.assertEquals(new SbpBean("CARD*1234", "1234"), result.get(0));
        Assertions.assertEquals(new SbpBean("CARD*1235", "1235"), result.get(1));
        Assertions.assertEquals(new SbpBean("CARD*1236", "1236"), result.get(2));
        Assertions.assertEquals(3, result.size());

    }

    @Test
    void testBeanBuilderExample2() {
        Path path = Paths.get("./src/test/resources/reestrWithMissingColumn.csv");

        // Act && Assert
        Assertions.assertThrows(RuntimeException.class, () -> csvParser.parseOneThread(path));

    }

    @Test
    void testBeanBuilderExample3() {
        Path path = Paths.get("./src/test/resources/reestr.csv");
        List<SbpBean> result = csvParser.parseMultiThread(path);

        Assertions.assertEquals(new SbpBean("CARD*1234", "1234"), result.get(0));
        Assertions.assertEquals(new SbpBean("CARD*1235", "1235"), result.get(1));
        Assertions.assertEquals(new SbpBean("CARD*1236", "1236"), result.get(2));
        Assertions.assertEquals(3, result.size());

    }

    @Test
    void testBeanBuilderExample4() {
        Path path = Paths.get("./src/test/resources/reestrWithMissingColumn.csv");

        // Act && Assert
        Assertions.assertThrows(RuntimeException.class, () -> csvParser.parseMultiThread(path));

    }
}

