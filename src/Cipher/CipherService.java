package Cipher;

public class CipherService {
    private final char[] alphabetLower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final char[] alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final char[] extraChars = {'.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public String encrypt(String text, int key){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if(Character.isLowerCase(current)){
                result.append(keyChar(current, alphabetLower, key));
            } else if (Character.isUpperCase(current)) {
                result.append(keyChar(current, alphabetUpper, key));
            } else if (isInArray(current, extraChars)) {
                result.append(keyChar(current, extraChars, key));
            } else {
                result.append(current);
            }
        }
        return result.toString();
    }

    private char keyChar (char ch, char[] alphabet, int key){
        for (int i = 0; i < alphabet.length; i++) {
            if (ch == alphabet[i]){
                return alphabet[(i + key)%alphabet.length];
            }
        }
        return ch;
    }
    private boolean isInArray (char ch, char[] array){
        for (char c : array){
            if (c == ch) return true;
        }
        return false;
    }
}
