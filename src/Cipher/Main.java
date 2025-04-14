package Cipher;

public class Main {

    public static void main(String[] args) {

        CipherService cipherService = new CipherService();
        FileService fileService = new FileService();

        String command = args[0];
        String filePath = args[1];
        int key = Integer.parseInt(args[2]);

        String originalText = fileService.readFromFile(filePath);
        String resultText;

        if (command.equalsIgnoreCase("ENCRYPT")){
            resultText = cipherService.encrypt(originalText, key);
            fileService.writeToFile(filePath, resultText, "[ENCRYPTED]");
            System.out.println("Файл зашифровано!");
        } else if (command.equalsIgnoreCase("DECRYPT")) {
            resultText = cipherService.decrypt(originalText, key);
            fileService.writeToFile(filePath, resultText, "[DECRYPTED]");
            System.out.println("Файл розшифровано");
        } else{
            System.out.println("Невідома команда. Використовуйте ENCRYPT/DECRYPT");
        }

    }
}
