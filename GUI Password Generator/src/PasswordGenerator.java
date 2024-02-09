import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        clearConsole();
        System.out.print("Welcome to Password Generator\nWhat password length do you require: ");
        Scanner scanner = new Scanner(System.in);
        int passLength = scanner.nextInt();
        char[] password = new char[passLength];
        printOptions();
        String choice = scanner.next();
        switchCase(choice.toCharArray(), password);
        System.out.printf("Your newly generated password consisting of %d characters is:\n%s\n", password.length, new String(password));
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printOptions() {
        System.out.println("\nWhat password layout do you require");
        System.out.println("A. Lower case only");
        System.out.println("B. Upper case only");
        System.out.println("C. Upper case & lower case");
        System.out.println("D. Lower case & special characters");
        System.out.println("E. Upper case & special characters");
        System.out.println("F. Only special characters");
        System.out.println("G. All of the above");
    }

    public static void switchCase(char[] choice, char[] password) {
        System.out.println(choice[0]);
        switch (Character.toUpperCase(choice[0])) {
            case 'A': optionA(password); System.out.println("this one ran");break;
            case 'B': optionB(password); break;
            case 'C': optionC(password); break;
            case 'D': optionD(password); break;
            case 'E': optionE(password); break;
            case 'F': optionF(password); break;
            case 'G': optionG(password); break;
            default: printSwitchCaseErrorMsg(); break;
        }
    }

    public static void optionA(char[] password) {
        for (int i = 0; i < password.length; i++) password[i] = randomLowerCase();
    }

    public static void optionB(char[] password) {
        for (int i = 0; i < password.length; i++) password[i] = randomUpperCase();
    }

    public static void optionC(char[] password) {
        Random rand = new Random();
        int typeSwitcher;
        for (int i = 0; i < password.length; i++) {
            typeSwitcher = rand.nextInt(2);
            if (typeSwitcher == 0) password[i] = randomUpperCase();
            else password[i] = randomLowerCase();
        }
    }

    public static void optionD(char[] password) {
        Random rand = new Random();
        int typeSwitcher;
        for (int i = 0; i < password.length; i++) {
            typeSwitcher = rand.nextInt(2);
            if (typeSwitcher == 0) password[i] = randomLowerCase();
            else password[i] = randomSpecialChar();
        }
    }

    public static void optionE(char[] password) {
        Random rand = new Random();
        int typeSwitcher;
        for (int i = 0; i < password.length; i++) {
            typeSwitcher = rand.nextInt(2);
            if (typeSwitcher == 0) password[i] = randomUpperCase();
            else password[i] = randomSpecialChar();
        }
    }

    public static void optionF(char[] password) {
        for (int i = 0; i < password.length; i++) password[i] = randomSpecialChar();
    }

    public static void optionG(char[] password) {
        Random rand = new Random();
        int typeSwitcher;
        for (int i = 0; i < password.length; i++) {
            typeSwitcher = rand.nextInt(3);
            if (typeSwitcher == 0) password[i] = randomUpperCase();
            else if (typeSwitcher == 1) password[i] = randomSpecialChar();
            else password[i] = randomLowerCase();
        }
    }


    public static char randomLowerCase(){
        return (char) (97 + new Random().nextInt(26));
    }

    public static char randomUpperCase(){
        return (char) (65 + new Random().nextInt(26));
    }

    public static char randomSpecialChar() {
        Random rand = new Random();
        int charCategory = rand.nextInt(4);
        if (charCategory == 0) return (char) (33 + rand.nextInt(15));
        else if (charCategory == 1) return (char) (58 + rand.nextInt(7));
        else if (charCategory == 2) return (char) (91 + rand.nextInt(6));
        else return (char) (123 + rand.nextInt(4));
    }

    public static void printSwitchCaseErrorMsg() {
        System.out.println("Must be a letter between A and G!!");
    }
}


