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

    public void writeToFile (String filePath, String text, String tag){
        try{
            String newFilePath = generateOutputPath(filePath, tag);
            Files.writeString(Path.of(newFilePath), text);
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл:" + e.getMessage());
        }
    }

    private String generateOutputPath (String originalPath, String tag){
        int dotIndex = originalPath.lastIndexOf(".");
        return originalPath.substring(0, dotIndex) + tag + originalPath.substring(dotIndex);
    }

}
