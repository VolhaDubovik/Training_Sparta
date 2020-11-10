package by.issoft.files;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xerces.internal.impl.dv.util.ByteListImpl;
//import io.restassured.mapper.TypeRef;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import javafx.stage.Screen;
import lombok.Data;
import lombok.experimental.Accessors;
import org.w3c.dom.ls.LSOutput;
//import sun.awt.CGraphicsDevice;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

@Data
@Accessors(chain = true)
public class MainClass {

    @Data
    public static class BankData {


        @JsonProperty("Cur_ID")
        int cur_ID;                 //170
        @JsonProperty("Date")
        String date;                //2020-10-28T00:00:00
        @JsonProperty("Cur_Abbreviation")
        String cur_Abbreviation;    //AUD
        @JsonProperty("Cur_Scale")
        int cur_Scale;              //1
        @JsonProperty("Cur_Name")
        String cur_Name;            //Австралийский доллар
        @JsonProperty("Cur_OfficialRate")
        double cur_OfficialRate;    //1.8192

    }



    public int loginTest(String userName){
        System.out.println("login to store");
        boolean success = false;
        if(success){
            return 1;
        }
        return 0;
    }

    public int loginTest2(){
        System.out.println("login to store");
        boolean success = false;
        if(success){
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        MainClass m = new MainClass();
        String userName = "ss";//readFromFile;
        if(m.loginTest(userName)==0){
            System.out.println("asdgasdgasdg");
        }
        m.loginTest2();
    }


    public static void mai7(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("el1");
        list.add("el2");
        list.add("el3");

        List<String> sss = new ArrayList<>();
        for(String s: list){
            if(s.endsWith("2")) {
                String s2 = s+"Hello";
                sss.add(s2);
            }
        }
        System.out.println(sss);

        System.out.println("--------");
        list.stream()
//                .filter(s -> s.endsWith("2"))
//                .limit(10)
                .forEach(s->{
                    System.out.println(s);
                    if(s.length()==3){
                        System.out.println(123);
                    }
                });
//                .map(s ->
//                        "HHHH"
//                ).collect(Collectors.toList());
        //System.out.println(list1);



    }

    public static void mai3n(String[] args) {
        List<BankData> b = given()
                .auth().basic("name", "4f3gawegawegg")
                .get("https://www.nbrb.by/api/exrates/rates?periodicity=0").as(new TypeRef<List<BankData>>() {
                });
        System.out.println(b);

        BigDecimal bigDecimal = new BigDecimal(44.0d);

        bigDecimal.multiply(new BigDecimal(43.43632427d));
        System.out.println(bigDecimal.toPlainString());


    }


    public static void main3(String[] args) throws IOException {

        Path path = Paths.get("src/main/resources/users.json");
        //Path path = Paths.get("src/main/resources/user.csv");
        String fileContent = new String(Files.readAllBytes(path));
//        List<String> listLInes = Files.readAllLines(path);
//        for(String line: listLInes){
//            String[] cols = line.split(",");
//            System.out.println(cols[0] + "-- "+ cols[3]);
//        }

//        User u = new User();
//        u.setUsername("artem");

        ObjectMapper mapper = new ObjectMapper();
        List<User> users = mapper.readValue(fileContent, new TypeReference<List<User>>() {
        });

        System.out.println(users.size());
        //System.out.println(user.kids);

//        user.setUsername("testUser");
//        String newUserString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
//        System.out.println(newUserString);

//        RequestSpecification given = given();
//        Response getReq = given.get("sadas");
//        String s = getReq.asString();

//        ServiceResult result =
//                given().get("http://dummy.restapiexample.com/api/v1/employees")
//                        .as(ServiceResult.class);
//
//        System.out.println(result.getData().size());
//
//        for(Employee employee: result.getData()){
//            if(employee.getEmployee_salary().length()<6){
//                System.out.println(employee.getEmployee_name());
//
//            }
//        }


    }
}
