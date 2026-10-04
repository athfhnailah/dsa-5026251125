package asd;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main (String [] args) {
        Path filepath = Path.of("word.txt");

        List<String> words = null;

        try{
            String content = Files.readString(filepath);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
