package by.issoft.repeatedText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainClassText {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/text.txt");
        String fileContent = new String(Files.readAllBytes(path));

        List<String> listLines = Files.readAllLines(path);

        List<String> listLines1 = listLines.stream().limit(10).map(s -> s+"Hello").collect(Collectors.toList());
        System.out.println(listLines1);


}

}
