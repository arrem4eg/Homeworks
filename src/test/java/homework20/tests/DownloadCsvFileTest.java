package homework20.tests;

import homework20.utils.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import static homework20.utils.HelpFunc.*;


public class DownloadCsvFileTest extends BaseTest {
    private static final String EXPECTED_HEADERS = "Manufacturer Id,"
            + "Period,Glass - Mixed,"
            + "Aluminium,PET - Clear,"
            + "PET - Colour,"
            + "HDPE,"
            + "Liquid Paper Board,"
            + "Steel,"
            + "Other Materials";

    private static final String EXPECTED_FIRST_ROW = "QM20000003,M2022-11,10,20,30,40,5,6,7,8";

    @Test
    public void csvDownloadTest() {
        String fileName = props.getData("fileName");
        String downloadFolder = props.getData("downloadFolder");

        openDownloadPage().downloadFile(fileName);

        assertTrue(fileIsExist(downloadFolder, fileName));
        assertNotEquals(fileIsEmpty(downloadFolder, fileName), "0");
        assertEquals(getExtension(downloadFolder, fileName), "csv");
        assertEquals(getCsvHeaders(downloadFolder, fileName), EXPECTED_HEADERS);
        assertEquals(getFirstRow(downloadFolder, fileName), EXPECTED_FIRST_ROW);
    }
}
