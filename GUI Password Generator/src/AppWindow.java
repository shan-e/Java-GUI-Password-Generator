import javax.swing.*;

public class AppWindow {
    public AppWindow() {
        JFrame appWindow = new JFrame();
        appWindow.setTitle("My Java GUI Password Generator :)");
        appWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appWindow.setSize(854, 480);
        appWindow.setResizable(false);
        appWindow.setLocationRelativeTo(null);
        appWindow.setVisible(true);
        ImageIcon imageIcon = new ImageIcon("icon.png");
        appWindow.setIconImage(imageIcon.getImage());
    }
}
