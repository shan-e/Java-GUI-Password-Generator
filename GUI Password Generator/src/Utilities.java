public class Utilities {
    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void printOptions() {
        System.out.println("\nWhat password layout do you require");
        System.out.println("A. Lower case only");
        System.out.println("B. Upper case only");
        System.out.println("C. Upper case & lower case");
        System.out.println("D. Lower case & special characters");
        System.out.println("E. Upper case & special characters");
        System.out.println("F. Only special characters");
        System.out.println("G. All of the above");
    }

    public void printSwitchCaseErrorMsg() {
        System.out.println("Must be a letter between A and G!!");
    }

}
