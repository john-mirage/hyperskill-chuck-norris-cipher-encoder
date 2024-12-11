package chucknorris;

import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    private static int getBinaryStringLength(String input) throws UserInterfaceException {
        String[] parts = input.split(" ");
        if (parts.length % 2 != 0) {
            throw new UserInterfaceException("Error: The encoded text is not valid, it only contains even sequences");
        }
        int length = 0;
        for (int i = 0; i < parts.length; i += 2) {
            if (parts[i].matches("^0{1,2}$") && parts[i + 1].matches("^0+$")) {
                length += parts[i + 1].length();
            } else {
                throw new UserInterfaceException("Error: The encoded text is not valid, it only contains valid sequences");
            }
        }
        return length;
    }

    public static String askForPlainTextToEncode() throws UserInterfaceException {
        System.out.println("Input string:");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new UserInterfaceException("Error: the plain text is empty");
        }
        return input;
    }

    public static String askForEncodedTextToDecode() throws UserInterfaceException {
        System.out.println("Input encoded string:");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new UserInterfaceException("Error: the encoded text is not valid, it only contains non-empty string");
        }
        if (!input.matches("[0 ]+")) {
            throw new UserInterfaceException("Error: The encoded text is not valid, it only contains '0' and ' '");
        }
        int length = getBinaryStringLength(input);
        if (length % 7 != 0) {
            throw new UserInterfaceException("Error: The encoded text is not valid, it only contains valid binary strings");
        }
        return input;
    }

    public static String askForAction() throws UserInterfaceException {
        System.out.println("Please input operation (encode/decode/exit):");
        String input = scanner.nextLine();
        if (!input.equals("encode") && !input.equals("decode") && !input.equals("exit")) {
            throw new UserInterfaceException("There is no '%s' operation".formatted(input));
        }
        return input;
    }
}
