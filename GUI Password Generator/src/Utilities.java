import java.util.Random;

public class Utilities {
    public static char generateRandomCharacter() {
        Random random = new Random(); // creating random object
        // charCategory dictates which section/region of the ASCII table to use to generate a random char
        int charCategory = random.nextInt(6);
        // if the random number matches any of the conditions, it will generate a random number
        // between the given bounds and cast the int as a char to finally output a random character
        if (charCategory == 0) return (char) (33 + random.nextInt(15)); // characters ! " # $ % & ' ( ) * + , - . /
        else if (charCategory == 1) return (char) (58 + random.nextInt(7)); // characters : ; < = > ? @
        else if (charCategory == 2) return (char) (91 + random.nextInt(6)); // characters [ \ ] ^ _ \
        else if (charCategory == 3) return (char) (97 + new Random().nextInt(26)); // characters a-z
        else if (charCategory == 4) return (char) (65 + new Random().nextInt(26)); // characters A-Z
        else return (char) (123 + random.nextInt(4));  // characters { | } ~
    }

    public static String generatePassword(int passwordLength) {
        // creating a char array to store a random ASCII character, given the length required for the password
        char[] passwordAsCharArray = new char[passwordLength];
        // here we loop through the array until the password length is reached
        // for each increment of the loop, add a random character to the specific index
        for (int i = 0; i < passwordLength; i++) passwordAsCharArray[i] = generateRandomCharacter();
        return new String(passwordAsCharArray); // return the char array cast as a String
    }
}
