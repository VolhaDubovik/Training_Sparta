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

        //List<String> listLines = Files.readAllLines(path);
        //System.out.println(listLines);

        // String item[] = fileContent.split(" ");




        HashMap<String, Integer> map = new HashMap<>();

        for (String t : fileContent.split(" ")) {
            if (map.containsKey(t)) {
                System.out.println(map.put(t, map.get(t) + 1));

            } else {
                map.put(t, 1);
            }
        }
        System.out.println("---------------------------------");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);
            System.out.println(map.get(key));
        }



 /*   Map<String, Integer> wordToCount = new TreeMap<>();

        for ( String word : fileContent.split(", ")) {

            wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
            }
        System.out.println(wordToCount);*/

/*        List<String> words = new ArrayList<>();
        for (String s : fileContent.split(" ")) {
            words.add(s.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "").toLowerCase());
        }

        Map<String, Long> frequency = countDuplicates(words);
        System.out.println(frequency);
    }

    public static Map<String, Long> countDuplicates(List<String> inputList) {
        return inputList.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
    }*/

}

}
