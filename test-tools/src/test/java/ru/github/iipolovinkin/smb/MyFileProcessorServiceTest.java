package ru.github.iipolovinkin.smb;

import jcifs.smb.NtlmPasswordAuthentication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;


class MyFileProcessorServiceTest {
    MyFileProcessorService myFileProcessorService;

    @BeforeEach
    void setUp() {
        String networkFolder = "smb://serverName/ShareFolder/";
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("domain", "user", "pass");
        SmbFileUploadingServiceImpl fileUploadingService = new SmbFileUploadingServiceImpl();

        myFileProcessorService = new MyFileProcessorService(fileUploadingService, auth, networkFolder);
    }

    @Test
    void testProcessFile() {
        File file = new File(Objects.requireNonNull(getClass().getResource("smbFile.txt")).getFile());
        LocalDate date = LocalDate.of(2023, Month.JUNE, 22);

        myFileProcessorService.processFile(file, date);

        Assertions.assertTrue(myFileProcessorService.checkFile(file.getName(), date));
    }
}
