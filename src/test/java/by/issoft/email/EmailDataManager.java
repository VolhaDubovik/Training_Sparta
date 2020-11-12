package by.issoft.email;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.nio.file.Paths;


public class EmailDataManager {

    private static final String filePath = "src/test/resources/emailTestData.json";

    ObjectMapper mapper = new ObjectMapper();


    private EmailData getEmailData() throws IOException {
        EmailData emailData = mapper.readValue(Paths.get(filePath).toFile(), EmailData.class);
        return emailData;
    }

    @DataProvider
    public Object[][] message() throws IOException { // message

        EmailData emailData = getEmailData();
        Object[][] messageData = new Object[emailData.getMessages().size()][1];
        for (int i = 0; i < emailData.getMessages().size(); i++) {
            Message m = emailData.getMessages().get(i);
            messageData[i][0] = m;
        }

        return messageData;
    }

}
