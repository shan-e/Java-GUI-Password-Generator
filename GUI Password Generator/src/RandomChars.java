import java.util.Random;

public class RandomChars {
    public char randomLowerCase() {
        return (char) (97 + new Random().nextInt(26));
    }

    public char randomUpperCase() {
        return (char) (65 + new Random().nextInt(26));
    }

    public char randomSpecialChar() {
        Random rand = new Random();
        int charCategory = rand.nextInt(4);
        if (charCategory == 0) return (char) (33 + rand.nextInt(15));
        else if (charCategory == 1) return (char) (58 + rand.nextInt(7));
        else if (charCategory == 2) return (char) (91 + rand.nextInt(6));
        else return (char) (123 + rand.nextInt(4));
    }
}
