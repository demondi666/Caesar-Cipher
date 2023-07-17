public class BruteForce {

    private int offset = 0;

    public StringBuilder decoding(StringBuilder encryptedText){
        boolean isPoint = false;
        boolean isComma = false;
        boolean isWhitespace = false;
        for (int i = 0; i < encryptedText.length(); i++) {
            int symbol = encryptedText.charAt(i);
            char indentedChar = (char)(symbol - offset);
            switch (indentedChar){
                case '.'-> isPoint =true;
                case ','-> isComma = true;
                case ' '-> isWhitespace = true;
            }
        }
        if((isWhitespace == true && isPoint == true) || (isWhitespace ==true && isComma == true)){
            return getDecryptedText(encryptedText);
        }
        offset++;
        return decoding(encryptedText);
    }

    private StringBuilder getDecryptedText(StringBuilder lines){
        StringBuilder decryptedText = new StringBuilder();
            for (int i = 0; i< lines.length(); i++) {
                char symbol = lines.charAt(i);
                char symbolWithOffset = (char) ((int) symbol - offset);
                decryptedText.append(symbolWithOffset);
            }
        return decryptedText;
    }

}
