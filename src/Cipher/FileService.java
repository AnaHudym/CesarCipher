package Cipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    public String readFromFile (String filePath){
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            System.out.println("Помилка при зчитуванні з файлу: " + e.getMessage());
        }
        return "";
    }

    public void writeToFile (String filePath, String text){
        try{
            Files.writeString(Path.of(filePath), text);
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл:" + e.getMessage());
        }
    }

}
