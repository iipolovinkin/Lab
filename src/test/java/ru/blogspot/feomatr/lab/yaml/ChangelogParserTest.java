package ru.blogspot.feomatr.lab.yaml;


import org.junit.jupiter.api.Test;

public class ChangelogParserTest {

    private final String fileName = "changelog-master.yml"; // see resource folder
    private final ChangelogParser underTest = new ChangelogParser(fileName);

    @Test
    public void testParse() {
        underTest.parse();
    }

}