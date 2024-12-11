package chucknorris;

public class ChuckNorrisEncoder {
    private static String getPlainTextBinaryString(String plainText) {
        StringBuilder binaryString = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char character = plainText.charAt(i);
            String characterBinaryString = Integer.toBinaryString(character);
            binaryString.append(("0000000" + characterBinaryString).substring(characterBinaryString.length()));
        }
        return binaryString.toString();
    }

    public static String encode(String plainText) {
        String binaryString = getPlainTextBinaryString(plainText);
        StringBuilder encryptedBinaryString = new StringBuilder();
        char previousChar = ' ';
        for (int i = 0; i < binaryString.length(); i++) {
            char character = binaryString.charAt(i);
            if (character != previousChar) {
                encryptedBinaryString.append(character == '1' ? " 0 0" : " 00 0");
                previousChar = character;
            } else {
                encryptedBinaryString.append("0");
            }
        }
        return encryptedBinaryString.toString().trim();
    }

    public static String decode(String cipherText) {
        String[] parts = cipherText.split(" ");
        StringBuilder binaryString = new StringBuilder();
        for (int i = 0; i < parts.length; i += 2) {
            String character = parts[i].equals("0") ? "1" : "0";
            binaryString.append(character.repeat(parts[i + 1].length()));
        }
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i += 7) {
            char character = (char) Integer.parseInt(binaryString.substring(i, i + 7),2);
            plainText.append(character);
        }
        return plainText.toString();
    }
}
