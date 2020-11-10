package by.issoft.files;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    @JsonProperty("userName")
    String username;
    String pass;
    double age;

    @JsonProperty("isMale")
    boolean isMale;

    List<Child> kids;
    List<String> roles;


    @Data
    public static class Child{
        String name;
        int age;
    }



}
