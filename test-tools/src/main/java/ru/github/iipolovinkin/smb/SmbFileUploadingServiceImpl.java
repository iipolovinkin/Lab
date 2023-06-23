package ru.github.iipolovinkin.smb;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmbFileUploadingServiceImpl {
    public void upload(@NonNull File file, @NonNull String uri, NtlmPasswordAuthentication auth) {
        String fileName = file.getName();
        try {
            log.info("Файл {} будет опубликован в сетевую папку {}", fileName, uri);
            mkdir(uri, auth);

            String filePath = String.join("/", uri, fileName);
            SmbFile smbFile = new SmbFile(filePath, auth);
            try (SmbFileOutputStream smbfos = new SmbFileOutputStream(smbFile)) {
                smbfos.write(IOUtils.toByteArray(Files.newInputStream(file.toPath())));
            }
            log.info("Файл {} успешно опубликован в сетевую папку {}", fileName, uri);
        } catch (IOException e) {
            log.error(String.format("Ошибка при попытке публикации файла %s на сетевой диск %s", fileName, uri), e);
        }
    }

    public boolean checkFile(@NonNull String uri, NtlmPasswordAuthentication auth) {
        try {
            log.info("Проверка наличия сетевого файла {}", uri);

            SmbFile smbFile = new SmbFile(uri, auth);
            boolean exists = smbFile.exists();
            log.info("Сетевой файл {} {}сутствует", uri, exists ? "при" : "от" );
            return exists;
        } catch (IOException e) {
            log.error(String.format("Ошибка при проверке наличия файла %s", uri), e);
            throw new IllegalArgumentException(e);
        }
    }

    private void mkdir(String uri, NtlmPasswordAuthentication auth) throws IOException {
        SmbFile dir = new SmbFile(uri, auth);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

}
