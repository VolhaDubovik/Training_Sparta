package by.issoft.internet;

import com.codeborne.selenide.SelenideElement;


import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;

public class FileDownload {

    SelenideElement someFileTxtLink = $("a[href='download/some-file.txt']");

    public void downloadFile() throws FileNotFoundException {
        someFileTxtLink.download();

    }

}
