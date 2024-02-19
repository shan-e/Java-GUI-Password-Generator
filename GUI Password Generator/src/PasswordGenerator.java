import javax.swing.*;

// info window about password stats

public class PasswordGenerator implements Runnable{
    static int value;
    static String password;

    private final JFrame jFrame;

    public PasswordGenerator() {
        jFrame = new JFrame("My GUI Password Generator :)");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(854, 480);
        jFrame.setLocationRelativeTo(null);
        jFrame.setIconImage(new ImageIcon("/Users/shane/Desktop/Projects/Java-GUI-Password-Generator/GUI Password Generator/src/421648.png").getImage());


        JPanel jPanel = new JPanel(); // Change JLabel to JPanel
        jPanel.setLayout(null); // You are using absolute positioning, so set layout to null
        jPanel.setSize(854, 480);

        JLabel welcomingTheUser = new JLabel("Welcome to Password Generator");
        welcomingTheUser.setHorizontalAlignment(SwingConstants.CENTER);
        welcomingTheUser.setBounds(277, 50, 300, 25);
        jPanel.add(welcomingTheUser);

        JLabel detailedInstructions = new JLabel("Please use the slider to choose password length");
        detailedInstructions.setHorizontalAlignment(SwingConstants.CENTER);
        detailedInstructions.setBounds(227, 75, 400, 25);
        jPanel.add(detailedInstructions);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 10, 50, 32); // min, max, initial value
        slider.setMinorTickSpacing(2); // spacing between ticks
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true); // paint ticks
        slider.setPaintLabels(true); // paint labels
        slider.setBounds(277, 100, 300, 100);
        jPanel.add(slider);

        value = slider.getValue();

        JLabel finalPasswordTextOutput = new JLabel("Press Generate to create a random unique password consisting of " + value + " characters");
        finalPasswordTextOutput.setHorizontalAlignment(SwingConstants.CENTER);
        finalPasswordTextOutput.setBounds(52, 260, 750, 25);
        slider.addChangeListener(e -> {
            value = slider.getValue();
            finalPasswordTextOutput.setText("Press Generate to create a random unique password consisting of " + value + " characters");
        });
        jPanel.add(finalPasswordTextOutput);

        JButton generatePasswordButton = new JButton("Generate");
        generatePasswordButton.setBounds(377, 200, 100, 50);
        generatePasswordButton.addActionListener(e ->
        {
            password = Utilities.generatePassword(value);
            finalPasswordTextOutput.setText("Your unique password consisting of " + value + " characters is " + password);
            System.out.println("Generating new password, hope the password is secure enough (You're not meant to see this - run while you still can!!?!)");
        });
        jPanel.add(generatePasswordButton);

        JButton exitTheGUIBruh = new JButton("Exit");
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
