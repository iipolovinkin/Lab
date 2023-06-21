package ru.github.iipolovinkin.opencsv.simplePosition;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;

/**
 * docs https://opencsv.sourceforge.net/
 */
public class CsvParser {

    public List<SimplePositionBean> beanBuilderExample(Path path) throws Exception {
        List<SimplePositionBean> beans = new CsvToBeanBuilder(new FileReader(path.toFile()))
                .withType(SimplePositionBean.class).build().parse();
        return beans;
    }
}
