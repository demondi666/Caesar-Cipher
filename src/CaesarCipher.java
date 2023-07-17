import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class CaesarCipher {
    private int offset;

    public CaesarCipher(int offset) {
        this.offset = offset;
    }
    public StringBuilder encrypt(StringBuilder lines){
        StringBuilder encryptedText = new StringBuilder();
            for (int i = 0; i< lines.length(); i++) {
                char symbol = lines.charAt(i);
                char symbolWithOffset = (char) ((int) symbol + offset);
                encryptedText.append(symbolWithOffset);
            }
        return encryptedText;
    }
    public StringBuilder decoding(StringBuilder lines){
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i< lines.length(); i++) {
            char symbol = lines.charAt(i);
            char symbolWithOffset = (char) ((int) symbol - offset);
            decryptedText.append(symbolWithOffset);
        }
        return decryptedText;
    }

}
