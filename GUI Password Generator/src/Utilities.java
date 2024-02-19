import java.util.Random;

public class Utilities {

    public static char randomChar() {
        Random rand = new Random();
        int charCategory = rand.nextInt(6);
        if (charCategory == 0) return (char) (33 + rand.nextInt(15));
        else if (charCategory == 1) return (char) (58 + rand.nextInt(7));
        else if (charCategory == 2) return (char) (91 + rand.nextInt(6));
        else if (charCategory == 3) return (char) (97 + new Random().nextInt(26));
        else if (charCategory == 4) return (char) (65 + new Random().nextInt(26));
        else return (char) (123 + rand.nextInt(4));
    }

    public static String generatePassword(int length) {
        char[] password = new char[length];
        for (int i = 0; i < length; i++) password[i] = randomChar();
        return new String(password);
    }
}
