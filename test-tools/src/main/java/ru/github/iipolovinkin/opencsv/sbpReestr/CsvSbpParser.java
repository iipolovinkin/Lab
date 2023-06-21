package ru.github.iipolovinkin.opencsv.sbpReestr;

import com.google.common.collect.Lists;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * docs https://opencsv.sourceforge.net/
 */
public class CsvSbpParser {
    public List<SbpBean> parseOneThread(Path path) {
        CsvToBean<SbpBean> csvToBean = buildCsvToBean(path);

        return getOneThreadSbpBeans(csvToBean);
    }

    public List<SbpBean> parseMultiThread(Path path) {
        CsvToBean<SbpBean> csvToBean = buildCsvToBean(path);

        return csvToBean.parse();
    }


    @SneakyThrows
    private CsvToBean<SbpBean> buildCsvToBean(Path path) {
        InputStreamReader reader = new InputStreamReader(Files.newInputStream(path), "windows-1251");
        return new CsvToBeanBuilder<SbpBean>(reader)
                .withSeparator(';')
                .withIgnoreEmptyLine(true)
                .withType(SbpBean.class)
                .withVerifier(SbpBean::isFullFilled)
                .build();
    }

    @NotNull
    private <T> List<T> getOneThreadSbpBeans(CsvToBean<T> csvToBean) {
        return Lists.newArrayList(csvToBean.iterator());
    }
}
