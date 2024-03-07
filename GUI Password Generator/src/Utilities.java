import java.util.Random;

public class Utilities {
    public static char generateAnyCharacter() {
        Random random = new Random(); // creating random object
        // charCategory dictates which section/region of the ASCII table to use to generate a random char
        int charCategory = random.nextInt(3);
        // if the random number matches any of the conditions, it will generate a random number
        // between the given bounds and cast the int as a char to finally output a random character
        if (charCategory == 0) return generateLowerCaseCharacter();
        else if (charCategory == 1) return generateUpperCaseCharacter();
        else return generateSpecialCharacter();
    }

    public static char generateUpperCaseCharacter() {
        return (char) (65 + new Random().nextInt(26)); // characters A-Z
    }

    public static char generateLowerCaseCharacter() {
        return (char) (97 + new Random().nextInt(26)); // characters a-z
    }

    public static char generateSpecialCharacter() {
        Random random = new Random(); // creating random object
        // charCategory dictates which section/region of the ASCII table to use to generate a random char
        int charCategory = random.nextInt(4);
        // if the random number matches any of the conditions, it will generate a random number
        // between the given bounds and cast the int as a char to finally output a random character
        if (charCategory == 0) return (char) (33 + random.nextInt(15)); // characters ! " # $ % & ' ( ) * + , - . /
        else if (charCategory == 1) return (char) (58 + random.nextInt(7)); // characters : ; < = > ? @
        else if (charCategory == 2) return (char) (91 + random.nextInt(6)); // characters [ \ ] ^ _ \
        else return (char) (123 + random.nextInt(4));  // characters { | } ~
    }

    public static char upperOrLowerCharacter() {
        Random random = new Random(); // creating random object
        // charCategory dictates which section/region of the ASCII table to use to generate a random char
        int charCategory = random.nextInt(2);
        // if the random number matches any of the conditions, it will generate a random number
        // between the given bounds and cast the int as a char to finally output a random character
        if (charCategory == 0) return generateLowerCaseCharacter();
        else return generateUpperCaseCharacter();
    }

    public static char upperOrSpecialCharacter() {
        Random random = new Random(); // creating random object
        // charCategory dictates which section/region of the ASCII table to use to generate a random char
        int charCategory = random.nextInt(2);
        // if the random number matches any of the conditions, it will generate a random number
        // between the given bounds and cast the int as a char to finally output a random character
        if (charCategory == 0) return generateSpecialCharacter();
        else return generateUpperCaseCharacter();
    }

    public static char lowerOrSpecialCharacter() {
        Random random = new Random(); // creating random object
        // charCategory dictates which section/region of the ASCII table to use to generate a random char
        int charCategory = random.nextInt(2);
        // if the random number matches any of the conditions, it will generate a random number
        // between the given bounds and cast the int as a char to finally output a random character
        if (charCategory == 0) return generateSpecialCharacter();
        else return generateLowerCaseCharacter();
    }

    public static String generatePassword(int passwordLength, int option) {
        // creating a char array to store a random ASCII character, given the length required for the password
        char[] passwordAsCharArray = new char[passwordLength];

        switch (option) {
            case 0:
                for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateLowerCaseCharacter();
                break;
            case 1:
                for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateUpperCaseCharacter();
                break;

            case 2:
                for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = upperOrLowerCharacter();
                break;
            case 3:
                for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = lowerOrSpecialCharacter();
                break;

            case 4:
                for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = upperOrSpecialCharacter();
                break;
            case 5:
                for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateSpecialCharacter();
                break;

            case 6:
                for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateAnyCharacter();
                break;

            default:
                System.err.println("Must be a numerical value passed into function");

        }
        // here we loop through the array until the password length is reached
        // for each increment of the loop, add a random character to the specific index
//        for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateRandomCharacter();
        return new String(passwordAsCharArray); // return the char array cast as a String
    }
}
