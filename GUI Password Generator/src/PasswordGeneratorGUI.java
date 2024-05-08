import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class PasswordGeneratorGUI implements Runnable, ActionListener {
    @Override public void run() { jFrame.setVisible(true); } // overriding run method, jframe set to true to display window

    // my instance variables, which are later constructed
    // all variables are private to allow for class accessibility, final variables allow for blocking further modification to my variables
    private int passwordLength;
    private static String password;
    private final JFrame jFrame; // app window
    private static JPanel jPanel = null; // layout within the app window
    private static JLabel welcomeUserLabel;
    private static JLabel instructionsLabel;
    private static JComboBox passwordOptions;
    private static JSlider slider; // controls the password's length
    private static JLabel passwordLabel;
    protected static JButton generatePasswordButton;
    protected static JButton exitTheGUIBruh;
    protected static JButton copyToClipboardButton;
    private static int option;

    public PasswordGeneratorGUI() {
        jFrame = new JFrame("My GUI Password Generator :)");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when window is closed the whole program terminates
        jFrame.setSize(854, 480); // has a fixed 480p 16:9 size
        jFrame.setResizable(false); // ensures the app window will always stay at 854x480 resolution
        jFrame.setLocationRelativeTo(null); // centre window
        jFrame.setIconImage(new ImageIcon("GUI Password Generator/src/421648.png").getImage());
        jFrame.setBackground(Color.darkGray); // dark window bar

        jPanel = new JPanel();
        jPanel.setLayout(null); // allow elements to be placed anywhere on the panel
        jPanel.setSize(854, 480); // set max region
        jPanel.setBackground(Color.decode("#DEF3FD")); // blue background

        welcomeUserLabel = new JLabel("Welcome to Password Generator");
        welcomeUserLabel.setVerticalAlignment(SwingConstants.CENTER);
        welcomeUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeUserLabel.setBounds(277, 50, 300, 25);

        instructionsLabel = new JLabel("Please use the slider to choose password length");
        instructionsLabel.setVerticalAlignment(SwingConstants.CENTER);
        instructionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instructionsLabel.setBounds(227, 75, 400, 25);

        String[] options = {"Option 1 - Lower Case", "Option 2 - Upper Case", "Option 3 - Upper & Lower Case", "Option 4 - Lower & Special Characters", "Option 5 - Upper & Special Characters", "Option 6 - Special Characters", "Option 7 - All of the above"};
        passwordOptions = new JComboBox<>(options); // hold string array in combo box
        passwordOptions.setBounds(277, 90, 300, 75);
        passwordOptions.setSelectedIndex(2); // default setting
        option = 2; // default setting
        passwordOptions.addActionListener(e -> option = passwordOptions.getSelectedIndex()); // lambda checking what the current combo box option is

        slider = new JSlider(JSlider.HORIZONTAL, 10, 50, 32); // 10-50 slider with 32 default
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBounds(277, 130, 300, 100);

        passwordLength = slider.getValue(); // set password length to be current slider value

        // this is initially set so that it gives further instructions to generate the new password
        passwordLabel = new JLabel("Press Generate to create a random unique password consisting of " + passwordLength + " characters");
        passwordLabel.setVerticalAlignment(SwingConstants.CENTER);
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setBounds(52, 285, 750, 25);
        // lambda to detect slider value change and update the final text to the instructions to re-generate a new password
        slider.addChangeListener(e -> {
            passwordLength = slider.getValue();
            password = null;
            passwordLabel.setText("Press Generate to create a random unique password consisting of " + passwordLength + " characters");
        });

        generatePasswordButton = new JButton("Generate");
        generatePasswordButton.setBounds(377, 220, 100, 50);
        // lambda, if pressed, generate new password and show via jlabel
        generatePasswordButton.addActionListener(e -> {
            password = Utilities.generatePassword(passwordLength, option);
            passwordLabel.setText("Your unique password consisting of " + passwordLength + " characters is " + password);
            System.out.println("Generating new password, hope the password is secure enough (You're not meant to see this - run while you still can!!?!)"); // hee-hee
        });

        exitTheGUIBruh = new JButton("Exit");
        exitTheGUIBruh.setBounds(447, 330, 100, 50);
        exitTheGUIBruh.addActionListener(e -> System.exit(0)); // lambda, if pressed, exit program with status 0

        copyToClipboardButton = new JButton("Copy");
        copyToClipboardButton.setBounds(307, 330, 100, 50);
        // lambda, if pressed, copy password to clipboard
        copyToClipboardButton.addActionListener(e -> copyToClipboard(password));

        if (System.getProperty("os.name").equals("Mac OS X")) System.setProperty("apple.laf.useScreenMenuBar", "true"); // macOS menu bar
        JMenuBar menuBar = createMenuBar();

        jPanel.add(welcomeUserLabel);
        jPanel.add(instructionsLabel);
        jPanel.add(passwordOptions);
        jPanel.add(slider);
        jPanel.add(passwordLabel);
        jPanel.add(generatePasswordButton);
        jPanel.add(exitTheGUIBruh);
        jPanel.add(copyToClipboardButton);

        jFrame.setJMenuBar(menuBar);
        jFrame.add(jPanel);
    }

    private static void copyToClipboard(String password) {
        StringSelection stringSelection = new StringSelection(String.valueOf(password));
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    private static void writePasswordToFile(String password) throws IOException {
        if (password == null) JOptionPane.showMessageDialog(null, "Bruh. Generate a password first", "Nahhh frr 💀💀", JOptionPane.ERROR_MESSAGE, new ImageIcon("GUI Password Generator/src/me_asf.gif"));
        else {
            LocalDateTime localDateTime = LocalDateTime.now(); // get epoch time
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yy");
            String passwordWithTimestamp = "[" + localDateTime.format(dateTimeFormatter) + "] " + password + "\n";
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("GUI Password Generator/src/saved-passwords.csv", true))) { bufferedWriter.write(passwordWithTimestamp); }
            catch (IOException e) { System.err.println("Error: " + e.getMessage()); }
        }
    }

    private static JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem copyPassword = new JMenuItem("Copy Password");
        JMenuItem writeToFile = new JMenuItem("Write To File");
        writeToFile.addActionListener(e -> {
            try {
                writePasswordToFile(password);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        copyPassword.addActionListener(e -> copyToClipboard(password));
        fileMenu.add(copyPassword);
        fileMenu.add(writeToFile);

        JMenu viewMenu = new JMenu("View");
        JMenu appearance = new JMenu("Appearance");
        JMenuItem darkMode = new JMenuItem("Dark Mode");
        AtomicInteger count = new AtomicInteger(); // threadsafe int
        darkMode.addActionListener(e -> {
            count.getAndIncrement();
            if (count.get() % 2 == 0) { lightenUI(); darkMode.setText("Dark Mode"); }
            if (count.get() % 2 == 1) { darkenUI(); darkMode.setText("Light Mode"); }
        });
        appearance.add(darkMode);
        viewMenu.add(appearance);

        JMenu help = new JMenu("Help");
        JMenuItem resources = new JMenuItem("Get Password Resources");
        resources.addActionListener(e -> { // open webpage documentation on how to write a good password
            try { Desktop.getDesktop().browse(new URI("https://support.microsoft.com/en-us/windows/create-and-use-strong-passwords-c5cebb49-8c53-4f5e-2bc4-fe357ca048eb")); }
            catch (IOException | URISyntaxException ex) { throw new RuntimeException(ex); }
        });
        help.add(resources);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(help);

        return menuBar;
    }

    private static void darkenUI() {
        jPanel.setBackground(Color.darkGray);
        welcomeUserLabel.setForeground(Color.WHITE);
        instructionsLabel.setForeground(Color.WHITE);
        slider.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
    }

    private static void lightenUI() {
        jPanel.setBackground(Color.decode("#DEF3FD"));
        welcomeUserLabel.setForeground(Color.BLACK);
        instructionsLabel.setForeground(Color.BLACK);
        slider.setForeground(Color.BLACK);
        passwordLabel.setForeground(Color.BLACK);
    }

    @Override public void actionPerformed(ActionEvent e) { if (e.getSource() == passwordOptions) System.out.println("heyyy"); }
}