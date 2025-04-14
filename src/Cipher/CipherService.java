package Cipher;

public class CipherService {


    public String encrypt(String text, int key){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if(Character.isLowerCase(current)){
                result.append(keyChar(current, Constants.alphabetLower, key));
            } else if (Character.isUpperCase(current)) {
                result.append(keyChar(current, Constants.alphabetUpper, key));
            } else if (isInArray(current, Constants.extraChars)) {
                result.append(keyChar(current, Constants.extraChars, key));
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
