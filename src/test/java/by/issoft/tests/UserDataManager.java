package by.issoft.tests;

import by.issoft.files.User;
import lombok.Data;
import lombok.experimental.Accessors;
import org.testng.annotations.DataProvider;

import java.util.List;

@Data
@Accessors(chain = true)
class UsersDataManager extends DataReader{


    public User getValidUser(){
        User t = (User) readFromFile("xxx");
        return null;
    }


    public User getUnValidUser(){
        User t = (User) readFromFile("yyy");
        return null;
    }

    @DataProvider
    public Object[][] dataForInput(){
        Object[][] data = new Object[3][2];
        data[0][0] = "0";
        data[0][1] = true;

        data[1][0] = "100000";
        data[1][1] = true;

        data[2][0] = "ds;.ga/g'a/g'we";
        data[2][1] = false;

        List<User> users = null ;

//        Object[][] result = users.stream()
//                            .map(item -> new Object[]{item})
//                            .toArray(Object[][]::new);

//        Object[][] result = new Object[users.size()][1];
//        for (int i = 0; i < users.size(); i++) {
//            result[i] = new Object[]{users.get(i)};
//        }

        return data;
    }
}
