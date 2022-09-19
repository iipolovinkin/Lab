package ru.blogspot.feomatr.lab.yaml;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class ChangelogParser {
    private final Yaml yaml = new Yaml();
    private final String fileName;

    public void parse() {
        log.info("fileName = {}", fileName);
        Map<String, Object> load = yaml.load(fileName);
        Object o = load.values().stream().findFirst().get();
        log.info("o.getClass() = {}", o.getClass());
    }

}
