package ru.github.iipolovinkin.opencsv.sbpReestr;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.List;

/**
 * docs https://opencsv.sourceforge.net/
 */
public class CsvSbpParser {

    public List<SbpBean> beanBuilderExample(Path path) throws Exception {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(path.toFile()), "windows-1251");
        return new CsvToBeanBuilder(reader)
                .withSeparator(';')
                .withIgnoreEmptyLine(true)
                .withType(SbpBean.class)
                .build().parse();
    }
}
