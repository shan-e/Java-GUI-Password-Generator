import javax.swing.*;

public class PasswordScreen {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppWindow appWindow = new AppWindow();
            }
        });
    }
}
