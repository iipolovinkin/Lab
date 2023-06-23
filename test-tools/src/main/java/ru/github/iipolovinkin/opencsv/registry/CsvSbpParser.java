package ru.github.iipolovinkin.opencsv.registry;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * docs https://opencsv.sourceforge.net/
 */
public class CsvSbpParser {
    public List<SbpBean> parseOneThread(Path path) {
        List<SbpBean> result = new ArrayList<>();
        processCsv(path, result::add);
        return result;
    }

    @SneakyThrows
    public List<SbpBean> parseMultiThread(Path path) {
        try (InputStreamReader reader = new InputStreamReader(Files.newInputStream(path), Charset.forName("cp1251"))) {
            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                return new CsvToBeanBuilder<SbpBean>(bufferedReader)
                        .withSeparator(';')
                        .withIgnoreEmptyLine(true)
                        .withType(SbpBean.class)
                        .withVerifier(SbpBean::isFullFilled)
                        .build()
                        .parse();
            }
        }
    }


    @SneakyThrows
    public void processCsv(Path path, Consumer<SbpBean> action) {
        try (InputStreamReader reader = new InputStreamReader(Files.newInputStream(path), Charset.forName("cp1251"))) {
            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                new CsvToBeanBuilder<SbpBean>(bufferedReader)
                        .withSeparator(';')
                        .withIgnoreEmptyLine(true)
                        .withType(SbpBean.class)
                        .withVerifier(SbpBean::isFullFilled)
                        .build()
                        .iterator().forEachRemaining(action);
            }
        }
    }

}
