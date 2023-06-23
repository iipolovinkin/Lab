package ru.github.iipolovinkin.smb;

import jcifs.smb.NtlmPasswordAuthentication;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import static java.lang.String.format;
import static java.lang.String.join;

@RequiredArgsConstructor
public class MyFileProcessorService {
    private final SmbFileUploadingServiceImpl fileUploadingService;
    private final NtlmPasswordAuthentication auth;
    private final Locale ruLocale = new Locale("ru", "RU");
    private final String networkFolder;

    void processFile(File file, LocalDate date) {
        fileUploadingService.upload(file, computeNetworkPath(networkFolder, date), auth);
    }

    boolean checkFile(String fileName, LocalDate date) {
        return fileUploadingService.checkFile(join("/", computeNetworkPath(networkFolder, date), fileName), auth);
    }

    private String computeNetworkPath(String uri, LocalDate date) {
        return uri + join("/",
                String.valueOf(date.getYear()),
                date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, ruLocale),
                formatDate(date)

        );
    }

    private String formatDate(LocalDate date) {
        return join(".",
                format("%04d", date.getYear()),
                format("%02d", date.getMonthValue()),
                format("%02d", date.getDayOfMonth())
        );
    }
}
