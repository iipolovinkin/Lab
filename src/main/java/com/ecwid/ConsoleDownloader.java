package com.ecwid;

import com.beust.jcommander.internal.Maps;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;

/**
 * TODO: comment
 *
 * @author iipolovinkin
 * @since 25.08.2015
 */
public class ConsoleDownloader {
    private static final Logger log = LoggerFactory.getLogger(ConsoleDownloader.class);


    /**
     * Parse List of string. Each string looks like pair FileUrl filename.
     * One row example : "https://raw.githubusercontent.com/iipolovinkin/new-job/master/Console-downloader.md SomeFile.txt"
     * Return Map, where keys - string urls, values -file names.
     *
     * @param rows
     * @return
     */
    public Map<String, String> parse(@NotNull List<String> rows) {
        Map<String, String> result = Maps.newHashMap();
        for (String row : rows) {
            String[] split = row.split(" ");
            String link = split[0];
            String file = split[1];
            result.put(link, file);
        }
        return result;
    }

    /**
     * Save File from link (URL).
     * Return checksum.
     *
     * @param link
     * @param fileName
     * @return
     * @throws IOException
     */
    public long saveLinkToFile(@NotNull String link, @NotNull String fileName) throws IOException {
        long result = 0;

        URL website = new URL(link);

        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(fileName);
        long receivedBytes = fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        try {
            File savedFile = new File(fileName);
            result = FileUtils.checksum(savedFile, new CRC32()).getValue();
        } catch (IOException e) {
            log.error("", e);

        }
        return result;
    }
}
