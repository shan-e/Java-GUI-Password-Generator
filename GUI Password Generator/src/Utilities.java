import java.util.Random;

public class Utilities {
    private static final Random random = new Random();

    private static char generateAnyPasswordCharacter() {
        int pickOption = random.nextInt(3);
        if (pickOption == 0) return generateLowerCaseCharacter();
        else if (pickOption == 1) return generateUpperCaseCharacter();
        else return generateSpecialCharacter();
    }
    private static char generateUpperCaseCharacter() { return (char) (65 + random.nextInt(26)); } // characters A-Z
    private static char generateLowerCaseCharacter() { return (char) (97 + random.nextInt(26)); } // characters a-z

    private static char generateSpecialCharacter() {
        int pickOption = random.nextInt(4);
        if (pickOption == 0) return (char) (33 + random.nextInt(15)); // characters ! " # $ % & ' ( ) * + , - . /
        else if (pickOption == 1) return (char) (58 + random.nextInt(7)); // characters : ; < = > ? @
        else if (pickOption == 2) return (char) (91 + random.nextInt(6)); // characters [ \ ] ^ _ \
        else return (char) (123 + random.nextInt(4));  // characters { | } ~
    }

    private static char generateUpperOrLowerCharacter() {
        int pickOption = random.nextInt(2);
        if (pickOption == 0) return generateLowerCaseCharacter();
        else return generateUpperCaseCharacter();
    }

    private static char generateUpperOrSpecialCharacter() {
        int pickOption = random.nextInt(2);
        if (pickOption == 0) return generateSpecialCharacter();
        else return generateUpperCaseCharacter();
    }

    private static char generateLowerOrSpecialCharacter() {
        int pickOption = random.nextInt(2);
        if (pickOption == 0) return generateSpecialCharacter();
        else return generateLowerCaseCharacter();
    }

    public static String generatePassword(int passwordLength, int option) {
        // password as a char array first to insert char at every increment
        char[] passwordAsCharArray = new char[passwordLength];
        switch (option) {
            case 0: for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateLowerCaseCharacter(); break;
            case 1: for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateUpperCaseCharacter(); break;
            case 2: for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateUpperOrLowerCharacter(); break;
            case 3: for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateLowerOrSpecialCharacter(); break;
            case 4: for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateUpperOrSpecialCharacter(); break;
            case 5: for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateSpecialCharacter(); break;
            case 6: for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateAnyPasswordCharacter(); break;
            default: System.err.println("Must be a numerical value passed into function"); // standard debug error checking
        }
        return new String(passwordAsCharArray); // return the char array cast as a String
    }
}
