package by.issoft.internet;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AvailableExamplesPage {

    SelenideElement dropdownLink = $("a[href='/dropdown']");
    SelenideElement fileDownloadLink = $("a[href='/download']");
    SelenideElement framesLink = $("a[href='/frames']");
    SelenideElement keyPressesLink = $("a[href='/key_presses']");

    SelenideElement fileUploadLink = $("a[href='/upload']");
    SelenideElement dynamicContentLink = $("a[href='/dynamic_content']");
    SelenideElement checkboxesLink = $("a[href='/checkboxes']");

    public void openDropdownListPage(){

        open("https://the-internet.herokuapp.com/");
        dropdownLink.click();
    }

    public void openFileDownloaderPage(){
        open("https://the-internet.herokuapp.com/");
        fileDownloadLink.click();

    }

    public void openFramesPage(){
        open("https://the-internet.herokuapp.com/");
        framesLink.click();

    }

    public void openKeyPressesPage(){
        open("https://the-internet.herokuapp.com/");
        keyPressesLink.click();

    }

    public void openFileUploaderPage(){
        open("https://the-internet.herokuapp.com/");
        fileUploadLink.click();

    }

    public void openDynamicContentPage(){
        open("https://the-internet.herokuapp.com/");
        dynamicContentLink.click();

    }

    public void openCheckboxesPage(){
        open("https://the-internet.herokuapp.com/");
        checkboxesLink.click();

    }

}

