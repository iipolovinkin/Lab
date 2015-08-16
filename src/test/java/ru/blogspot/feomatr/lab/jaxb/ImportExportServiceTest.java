package ru.blogspot.feomatr.lab.jaxb;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test JAXB
 *
 * @author iipolovinkin
 * @since 16.08.2015
 */
public class ImportExportServiceTest {

    private ImportExportService importExportService;
    private String OneItemXml = "src/main/resources/jaxb/OneItem.xml";
    private String MapItemXml = "src/main/resources/jaxb/MapItem.xml";

    @BeforeClass
    public static void setUpClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        importExportService = new ImportExportService();
    }

    @Test
    public void testReadItemFromXml() throws Exception {
        File file = new File(OneItemXml);
        Item expected = new Item(100L, "The Best Ever Seen Item");

        Item actual = importExportService.readItemFromFile(file);

        assertThat(actual, is(expected));
    }

    @Test
    public void testReadMapFromFile() throws Exception {
        File file = new File(MapItemXml);
        Foo expected = new Foo();
        HashMap m = Maps.newHashMap();
        m.put(123, "this is a value");
        m.put(312, "this is another value");
        m.put(576, "this is another value");
        expected.setHashMap(m);

        Foo actual = importExportService.readMapFromFile(file);

        assertThat(actual.toString(), is(expected.toString()));

    }
}