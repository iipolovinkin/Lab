package ru.blogspot.feomatr.lab.serialization.jaxb;

import java.io.File;

/**
 * Created by iipolovinkin on 08.01.15.
 */
public class DemoJAXB {

    public static void main(String[] args) {
        // see ImportExportServiceTest

        String MapItemWithoutFoo = "src/main/resources/jaxb/MapItemWithoutFoo.xml";
        File file = new File(MapItemWithoutFoo);

        ImportExportService importExportService;
        importExportService = new ImportExportService();
        MyHashMapType actual = importExportService.readClearMapFromFile(file);
        System.out.println(actual);
    }
}
