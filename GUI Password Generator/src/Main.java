import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Utilities utilities = new Utilities();
        RandomChars randomChars = new RandomChars();
        PasswordOptions passwordOptions = new PasswordOptions(randomChars, utilities);

        utilities.clearConsole();
        System.out.print("Welcome to Password Generator\nWhat password length do you require: ");
        Scanner scanner = new Scanner(System.in);

        int passLength = scanner.nextInt();
        char[] password = new char[passLength];
        utilities.printOptions();
        String choice = scanner.next();

        passwordOptions.switchCase(choice.toCharArray(), password);
        System.out.printf("Your newly generated password consisting of %d characters is:\n%s\n", password.length, new String(password));
    }
}