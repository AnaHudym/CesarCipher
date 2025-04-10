package Cipher;

public class Main {

    public static void main(String[] args) {

        CipherService cipherService = new CipherService();
        FileService fileService = new FileService();

        String inputPath = "C:/Users/Dima0/IdeaProjects/CesarCipher/test.txt";
        String outputPath = "C:/Users/Dima0/IdeaProjects/CesarCipher/test[ENCRYPTED].txt";
        int key = 2;

        String originalText = fileService.readFromFile(inputPath);
        String encryptedText = cipherService.encrypt(originalText, key);

        fileService.writeToFile(outputPath, encryptedText);

    }
}
