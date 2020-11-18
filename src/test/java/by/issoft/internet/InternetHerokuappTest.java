package by.issoft.internet;


import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class InternetHerokuappTest {

    AvailableExamplesPage availableExamplesPage = new AvailableExamplesPage();
    DropdownPage dropdownPage = new DropdownPage();
    FileDownloadPage fileDownloadPage = new FileDownloadPage();
    FramesPage framesPage = new FramesPage();
    KeyPressesPage keyPressesPage = new KeyPressesPage();

    //dropdown
    @Test
    public void checkSelectedDropdownOption(){
        availableExamplesPage.openDropdownListPage();
        Assert.assertEquals(dropdownPage.getSelectedDropdownOption(), "Option 1", "This option is not selected.");

    }

    //download
    @Test
    public void checkDownloadedFile() throws FileNotFoundException {
        availableExamplesPage.openFileDownloaderPage();
        SelenideElement fileElement = fileDownloadPage.findFile("some-file.txt");
        assertNotNull(fileElement, "This file is not found.");
        boolean downloadedFile = fileDownloadPage.downloadFile("downloads", fileElement);
        assertTrue(downloadedFile, "This file is not downloaded.");

    }

    //iFrame
    @Test
    public void checkNumberedListForIframe(){
        availableExamplesPage.openFramesPage();
        Assert.assertTrue(framesPage.getDefaultTextBodyAfterNumbered().startsWith("1."), "Text is not started from number.");
    }

    @Test
    public void checkEnteredFrameBodyText(){
        String expectedText = "Hello";
        availableExamplesPage.openFramesPage();
        Assert.assertEquals(framesPage.getFrameBodyText(), expectedText, "Text does not match.");

    }

    //key press
    @Test
    public void checkResultLineContainsEnteredValue(){
        availableExamplesPage.openKeyPressesPage();
        Assert.assertTrue(keyPressesPage.isEnteredValueDisplayedInResultLine("C"), "Entered value is not displayed in Result Line.");
    }

    @Test
    public void checkTabKeyIsDisplayedInResultLine(){
        availableExamplesPage.openKeyPressesPage();
        Assert.assertEquals(keyPressesPage.inputKeyPressTab(), "You entered: TAB", "Result Line doesn't contain Tab value");

    }

}
