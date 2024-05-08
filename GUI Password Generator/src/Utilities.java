import java.util.Random;

public class Utilities {
    private static final Random random = new Random(); // global random object instance that can be used anywhere within the class

    public static char generateAnyPasswordCharacter() {
        // charCategory dictates which section/region of the ASCII table to use to generate a random char
        int charCategory = random.nextInt(3);
        // if the random number matches any of the conditions, it will generate a random number
        // between the given bounds and cast the int as a char to finally output a random character
        if (charCategory == 0) return generateLowerCaseCharacter();
        else if (charCategory == 1) return generateUpperCaseCharacter();
        else return generateSpecialCharacter();
    }
    public static char generateUpperCaseCharacter() { return (char) (65 + random.nextInt(26)); } // characters A-Z
    public static char generateLowerCaseCharacter() { return (char) (97 + random.nextInt(26)); } // characters a-z

    public static char generateSpecialCharacter() {
        // charCategory dictates which section/region of the ASCII table to use to generate a random char
        int charCategory = random.nextInt(4);
        // if the random number matches any of the conditions, it will generate a random number
        // between the given bounds and cast the int as a char to finally output a random character
        if (charCategory == 0) return (char) (33 + random.nextInt(15)); // characters ! " # $ % & ' ( ) * + , - . /
        else if (charCategory == 1) return (char) (58 + random.nextInt(7)); // characters : ; < = > ? @
        else if (charCategory == 2) return (char) (91 + random.nextInt(6)); // characters [ \ ] ^ _ \
        else return (char) (123 + random.nextInt(4));  // characters { | } ~
    }

    public static char generateUpperOrLowerCharacter() {
        // charCategory dictates which section/region of the ASCII table to use to generate a random char
        int charCategory = random.nextInt(2);
        // if the random number matches any of the conditions, it will generate a random number
        // between the given bounds and cast the int as a char to finally output a random character
        if (charCategory == 0) return generateLowerCaseCharacter();
        else return generateUpperCaseCharacter();
    }

    public static char generateUpperOrSpecialCharacter() {
        // charCategory dictates which section/region of the ASCII table to use to generate a random char
        int charCategory = random.nextInt(2);
        // if the random number matches any of the conditions, it will generate a random number
        // between the given bounds and cast the int as a char to finally output a random character
        if (charCategory == 0) return generateSpecialCharacter();
        else return generateUpperCaseCharacter();
    }

    public static char generateLowerOrSpecialCharacter() {
        // charCategory dictates which section/region of the ASCII table to use to generate a random char
        int charCategory = random.nextInt(2);
        // if the random number matches any of the conditions, it will generate a random number
        // between the given bounds and cast the int as a char to finally output a random character
        if (charCategory == 0) return generateSpecialCharacter();
        else return generateLowerCaseCharacter();
    }

    public static String generatePassword(int passwordLength, int option) {
        // creating a char array to store a random ASCII character, given the length required for the password
        char[] passwordAsCharArray = new char[passwordLength]; // password first a char array to insert char at every increment
        // switch case dictates which option should be run from combo-box
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
