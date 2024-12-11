package chucknorris;

public class Main {
    public static void main(String[] args) {
        mainLoop:
        while (true) {
            try {
                String choice = UserInterface.askForAction();
                switch (choice) {
                    case "encode":
                        String plainText = UserInterface.askForPlainTextToEncode();
                        System.out.println("Encoded string:");
                        System.out.println(ChuckNorrisEncoder.encode(plainText));
                        break;
                    case "decode":
                        String encodedText = UserInterface.askForEncodedTextToDecode();
                        System.out.println("Decoded string:");
                        System.out.println(ChuckNorrisEncoder.decode(encodedText));
                        break;
                    case "exit":
                        break mainLoop;
                }
                System.out.println();
            } catch (UserInterfaceException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Bye!");
    }
}
