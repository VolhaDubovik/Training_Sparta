package by.issoft.internet;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$$x;

public class FileDownloadPage {

    public SelenideElement findFile (String fileName){
        ElementsCollection allFilesLinks = $$x("//div[@class='example']//a");
        for (SelenideElement filesList : allFilesLinks){
            String fileFromList = filesList.getText();
            if (fileFromList.equals(fileName)){
                SelenideElement foundFile = filesList;
                return foundFile;
            }
        }
        return null;
    }

    public boolean downloadFile(String folder, SelenideElement foundFile) throws FileNotFoundException {
        Configuration.reportsFolder = folder;
        File downloadFile = foundFile.download(8000);
        System.out.println(downloadFile.getAbsoluteFile());
        return downloadFile.exists();
    }

}
