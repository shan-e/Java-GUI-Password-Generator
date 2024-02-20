import javax.swing.*;

// info window about password stats
// have type of password chooser

public class PasswordGenerator implements Runnable {
    private int value;
    private String password;
    private final JFrame jFrame;
    private final JPanel jPanel;
    private final JLabel welcomingTheUser;
    private final JLabel detailedInstructions;
    private final JSlider slider;
    private final JLabel finalPasswordTextOutput;
    private final JButton generatePasswordButton;
    private final JButton exitTheGUIBruh;

    public PasswordGenerator() {
        jFrame = new JFrame("My GUI Password Generator :)");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(854, 480);
        jFrame.setLocationRelativeTo(null);
        jFrame.setIconImage(new ImageIcon("/Users/shane/Desktop/Projects/Java-GUI-Password-Generator/GUI Password Generator/src/421648.png").getImage());


        jPanel = new JPanel(); // Change JLabel to JPanel
        jPanel.setLayout(null); // You are using absolute positioning, so set layout to null
        jPanel.setSize(854, 480);

        welcomingTheUser = new JLabel("Welcome to Password Generator");
        welcomingTheUser.setHorizontalAlignment(SwingConstants.CENTER);
        welcomingTheUser.setBounds(277, 50, 300, 25);
        jPanel.add(welcomingTheUser);

        detailedInstructions = new JLabel("Please use the slider to choose password length");
        detailedInstructions.setHorizontalAlignment(SwingConstants.CENTER);
        detailedInstructions.setBounds(227, 75, 400, 25);
        jPanel.add(detailedInstructions);

        slider = new JSlider(JSlider.HORIZONTAL, 10, 50, 32); // min, max, initial value
        slider.setMinorTickSpacing(2); // spacing between ticks
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true); // paint ticks
        slider.setPaintLabels(true); // paint labels
        slider.setBounds(277, 100, 300, 100);
        jPanel.add(slider);

        value = slider.getValue();

        finalPasswordTextOutput = new JLabel("Press Generate to create a random unique password consisting of " + value + " characters");
        finalPasswordTextOutput.setHorizontalAlignment(SwingConstants.CENTER);
        finalPasswordTextOutput.setBounds(52, 260, 750, 25);
        slider.addChangeListener(e -> {
            value = slider.getValue();
            finalPasswordTextOutput.setText("Press Generate to create a random unique password consisting of " + value + " characters");
        });
        jPanel.add(finalPasswordTextOutput);

        generatePasswordButton = new JButton("Generate");
        generatePasswordButton.setBounds(377, 200, 100, 50);
        generatePasswordButton.addActionListener(e ->
        {
            password = Utilities.generatePassword(value);
            finalPasswordTextOutput.setText("Your unique password consisting of " + value + " characters is " + password);
            System.out.println("Generating new password, hope the password is secure enough (You're not meant to see this - run while you still can!!?!) BOOO!");
        });
        jPanel.add(generatePasswordButton);

        exitTheGUIBruh = new JButton("Exit");
        exitTheGUIBruh.setBounds(377, 290, 100, 50);
        exitTheGUIBruh.addActionListener(e -> {
            System.out.println("Button clicked (exit)");
            System.exit(0);
        });
        jPanel.add(exitTheGUIBruh);

        jFrame.add(jPanel);
    }

    @Override
    public void run() {
        jFrame.setVisible(true);
    }
}
