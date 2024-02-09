import java.util.Random;

public class PasswordOptions {
    private final RandomChars randomChars;
    private final Utilities utilities;

    public PasswordOptions(RandomChars randomChars, Utilities utilities) {
        this.randomChars = randomChars;
        this.utilities = utilities;
    }

    public void optionA(char[] password) {
        for (int i = 0; i < password.length; i++) password[i] = randomChars.randomLowerCase();
    }

    public void optionB(char[] password) {
        for (int i = 0; i < password.length; i++) password[i] = randomChars.randomUpperCase();
    }

    public void optionC(char[] password) {
        Random rand = new Random();
        int typeSwitcher;
        for (int i = 0; i < password.length; i++) {
            typeSwitcher = rand.nextInt(2);
            if (typeSwitcher == 0) password[i] = randomChars.randomUpperCase();
            else password[i] = randomChars.randomLowerCase();
        }
    }

    public void optionD(char[] password) {
        Random rand = new Random();
        int typeSwitcher;
        for (int i = 0; i < password.length; i++) {
            typeSwitcher = rand.nextInt(2);
            if (typeSwitcher == 0) password[i] = randomChars.randomLowerCase();
            else password[i] = randomChars.randomSpecialChar();
        }
    }

    public void optionE(char[] password) {
        Random rand = new Random();
        int typeSwitcher;
        for (int i = 0; i < password.length; i++) {
            typeSwitcher = rand.nextInt(2);
            if (typeSwitcher == 0) password[i] = randomChars.randomUpperCase();
            else password[i] = randomChars.randomSpecialChar();
        }
    }

    public void optionF(char[] password) {
        for (int i = 0; i < password.length; i++) password[i] = randomChars.randomSpecialChar();
    }

    public void optionG(char[] password) {
        Random rand = new Random();
        int typeSwitcher;
        for (int i = 0; i < password.length; i++) {
            typeSwitcher = rand.nextInt(3);
            if (typeSwitcher == 0) password[i] = randomChars.randomUpperCase();
            else if (typeSwitcher == 1) password[i] = randomChars.randomSpecialChar();
            else password[i] = randomChars.randomLowerCase();
        }
    }

    public void switchCase(char[] choice, char[] password) {
        System.out.println(choice[0]);
        switch (Character.toUpperCase(choice[0])) {
            case 'A': optionA(password); System.out.println("this one ran");break;
            case 'B': optionB(password); break;
            case 'C': optionC(password); break;
            case 'D': optionD(password); break;
            case 'E': optionE(password); break;
            case 'F': optionF(password); break;
            case 'G': optionG(password); break;
            default: utilities.printSwitchCaseErrorMsg(); break;
        }
    }
}


