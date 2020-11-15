package by.issoft.internet;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class InternetElementsTest {

    AvailableExamplesPage availableExamplesPage = new AvailableExamplesPage();
    Dropdown dropdown = new Dropdown();
    FileDownload fileDownload = new FileDownload();
    Frames frames = new Frames();
    KeyPresses keyPresses = new KeyPresses();


    @Test
    public void checkSelectedDropdownOption(){
        availableExamplesPage.openDropdownListPage();
        Assert.assertEquals(dropdown.getSelectedDropdownOption(), "Option 1", "This option is not selected.");

    }

    @Test
    public void checkDownloadedFile() throws FileNotFoundException {
        availableExamplesPage.openFileDownloaderPage();
        fileDownload.downloadFile();

    }

    @Test
    public void checkNumberedListForIframe(){
        availableExamplesPage.openFramesPage();
        frames.getTextBody().startsWith("1.");

    }

    @Test
    public void checkResultLineContainsEnteredValue(){
        availableExamplesPage.openKeyPressesPage();
        keyPresses.isEnteredValueDisplayedInResultLine("Ccccc");
    }










}
