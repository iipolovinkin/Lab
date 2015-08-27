package com.ecwid;

import com.beust.jcommander.internal.Maps;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * TODO: comment
 *
 * @author iipolovinkin
 * @since 25.08.2015
 */
public class ConsoleDownloaderTest {
    private ConsoleDownloader downloader;

    private String delim = " ";
    private String domain = "http://yandex.ru/";

    private String file1 = "fn1.zip";
    private String file2 = "fn2.zip";
    private String file3 = "fn3.zip";
    private String file4 = "fn4.zip";

    private String link1 = domain + "ln" + file1;
    private String link2 = domain + "ln" + file2;
    private String link3 = domain + "ln" + file3;
    private String link4 = domain + "ln" + file4;

    @Before
    public void setUp() throws Exception {
        downloader = new ConsoleDownloader();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testParseEmptyListThanReturnEmptyMap() throws Exception {
        List<String> rows = Collections.emptyList();
        Map<String, String> expected = Maps.newHashMap();

        Map<String, String> actual = downloader.parse(rows);

        assertThat(actual, is(expected));
    }

    @Test
    public void testParseListThanReturnMap() throws Exception {
        List<String> rows = Arrays.asList(link1 + " " + file1,
                link2 + " " + file2,
                link3 + " " + file3,
                link4 + " " + file4);
        Map<String, String> expected = Maps.newHashMap(link1, file1, link2, file2, link3, file3, link4, file4);

        Map<String, String> actual = downloader.parse(rows);

        assertThat(actual, is(expected));
    }

    @Test
    public void testSaveLinkToFile() throws Exception {
        String fileName = "fn2.txt";
        String link = "https://raw.githubusercontent.com/iipolovinkin/new-job/master/Console-downloader.md";
        File expectedFile = new File("src/main/resources/download/fn.txt");
        long expectedChecksum = FileUtils.checksum(expectedFile, new CRC32()).getValue();

        long actualChecksum = downloader.saveLinkToFile(link, fileName);

        System.out.println("actualChecksum = " + actualChecksum);
        System.out.println("expectedChecksum = " + expectedChecksum);

        assertThat(actualChecksum, is(expectedChecksum));
    }


}