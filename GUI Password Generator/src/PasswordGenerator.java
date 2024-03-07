/**
 * Author:  Shane Easo
 * Email:   shane.easo@ucdconnect.ie
 * GitHub:  shan-e
 * Created:   08.02.2024
 * Description:
 * This is a small project I had been working on in my spare time.
 * It is a GUI interface for a very basic password generator.
 * Resources were obtained from my lecture notes and Oracle documentation
 **/

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// info window about password stats
// have type of password chooser
// regions with numerical values will be measured in pixels

public class PasswordGenerator implements Runnable, ActionListener {
    // implementation below allows GUI to run properly
    // when this implemented run function is run, the JFrame's visibility
    // property is set to true, hence displaying the app window
    @Override
    public void run() {
        jFrame.setVisible(true);
    }

    // my instance variables, which are later constructed
    // all variables are private to allow for class accessibility
    // final variables allow for blocking further modification to my variables
    private int passwordLength; // password length
    private String password; // password as a string
    private final JFrame jFrame; // app window
    private final JPanel jPanel; // layout within the app window
    private final JLabel welcomingTheUser; // greets the user
    private final JLabel detailedInstructions; // tells user how to use the app
    private final JComboBox passwordOptions;
    private final JSlider slider; // JSlider that controls the password's length
    private final JLabel finalPasswordTextOutput;// gives the formatted "toString" containing the new password
    private final JButton generatePasswordButton; // when pressed generates a new unique password
    private final JButton exitTheGUIBruh; // exits the window and entire program
    private final JButton copyToClipboard;
    private static int option;

    public PasswordGenerator() {
        jFrame = new JFrame("My GUI Password Generator :)"); // window title
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when window is closed the whole program terminates
        jFrame.setSize(854, 480); // has a fixed 480p 16:9 size
        jFrame.setResizable(false); // ensures the app window will always stay at 854x480 resolution
        jFrame.setLocationRelativeTo(null); // when window is opened initially it is centred
        // sets app icon using Image and ImageIcon objects
        jFrame.setIconImage(new ImageIcon("GUI Password Generator/src/421648.png").getImage());

        jPanel = new JPanel(); // creates new JPanel object
        jPanel.setLayout(null); // setting null allows elements to be placed anywhere on the panel
        jPanel.setSize(854, 480); // sets max region to add elements to panel

        welcomingTheUser = new JLabel("Welcome to Password Generator"); // label to greet the user
        welcomingTheUser.setVerticalAlignment(SwingConstants.CENTER); // centres label according to the height of the label
        welcomingTheUser.setHorizontalAlignment(SwingConstants.CENTER); // centres label according to the width of the label
        // sets region where label should be placed **in pixels**
        welcomingTheUser.setBounds(277, 50, 300, 25); //
        jPanel.add(welcomingTheUser);

        detailedInstructions = new JLabel("Please use the slider to choose password length"); // gives instructions on how to use slider
        detailedInstructions.setVerticalAlignment(SwingConstants.CENTER); // centres label according to the height of the label
        detailedInstructions.setHorizontalAlignment(SwingConstants.CENTER); // centres label according to the width of the label
        // sets region where label should be placed **in pixels**
        // this label is 400x25 with the top-left corner going across 227 and 75 down
        detailedInstructions.setBounds(227, 75, 400, 25);
        jPanel.add(detailedInstructions); // adds this label to the panel

        String[] options = {
                "Option 1 - Lower Case",
                "Option 2 - Upper Case",
                "Option 3 - Upper & Lower Case",
                "Option 4 - Lower & Special Characters",
                "Option 5 - Upper & Special Characters",
                "Option 6 - Special Characters",
                "Option 7 - All of the above"
        };
        passwordOptions = new JComboBox<>(options);
        passwordOptions.setBounds(277, 90, 300, 75);
        passwordOptions.setSelectedIndex(2);
        option = 2;
        passwordOptions.addActionListener(e -> option = passwordOptions.getSelectedIndex());
        jPanel.add(passwordOptions);


        slider = new JSlider(JSlider.HORIZONTAL, 10, 50, 32); // slider with 10-50 range initially at 32
        slider.setMinorTickSpacing(2); // for every 2nd value, there will be a minor tick
        slider.setMajorTickSpacing(10); // for every 10th value, there will be a major tick
        slider.setPaintTicks(true); // allows the ticks to be displayed
        slider.setPaintLabels(true); // allows the numerical checkpoints to show
        // sets region where slider should be placed **in pixels**
        // this slider is 300x100 with the top-left corner going across 227 and 100 down
        slider.setBounds(277, 130, 300, 100);
        jPanel.add(slider); // adds slider to the panel

        // whatever value the slider is on (32 now, due to initial), save that as the password length
        passwordLength = slider.getValue();

        // final output given as the formatted "toString" containing the new password and length
        // this is initially set so that it gives further instructions to generate the new password
        finalPasswordTextOutput = new JLabel("Press Generate to create a random unique password consisting of " + passwordLength + " characters");
        finalPasswordTextOutput.setVerticalAlignment(SwingConstants.CENTER); // centres label according to the height of the label
        finalPasswordTextOutput.setHorizontalAlignment(SwingConstants.CENTER); // centres label according to the width of the label
        // sets region where label should be placed **in pixels**
        // this label is 750x25 with the top-left corner going across 52 and 260 down
        finalPasswordTextOutput.setBounds(52, 285, 750, 25);
        slider.addChangeListener(e -> {
            // lambda function which detects change in the slider values
            // whatever the new password length value is, update that as the password length
            passwordLength = slider.getValue();
            // and update the final text to the instructions to re-generate a new password
            finalPasswordTextOutput.setText("Press Generate to regenerate a random unique password consisting of " + passwordLength + " characters");
        });
        jPanel.add(finalPasswordTextOutput); // adds label to the panel

        generatePasswordButton = new JButton("Generate"); // generate button
        // sets region where label should be placed **in pixels**
        // this label is 100x50 with the top-left corner going across 377 and 200 down
        generatePasswordButton.setBounds(377, 220, 100, 50);
        // this lambda expression detects whether the generate button is pressed or not
        generatePasswordButton.addActionListener(e -> {
            // if pressed, let a new password be generated based on the current password length
            // this int will run through generatePassword and be saved to the password String
            password = Utilities.generatePassword(passwordLength, option);
            // change the output text to contain the newly generated password
            finalPasswordTextOutput.setText("Your unique password consisting of " + passwordLength + " characters is " + password);
            System.out.println("Generating new password, hope the password is secure enough (You're not meant to see this - run while you still can!!?!)"); // hee-hee
        });
        jPanel.add(generatePasswordButton); // add the generate button to the JPanel

        exitTheGUIBruh = new JButton("Exit"); // Exit button to terminate program
        // sets region where label should be placed **in pixels**
        // this label is 100x50 with the top-left corner going across 377 and 290 down
        exitTheGUIBruh.setBounds(377, 330, 100, 50);
        // lambda expression to check when pressed, if-so, exit the program with status 0.
        exitTheGUIBruh.addActionListener(e -> System.exit(0));
        jPanel.add(exitTheGUIBruh);// add the button to the panel

        copyToClipboard = new JButton("Copy"); // Exit button to terminate program
        // sets region where label should be placed **in pixels**
        // this label is 100x50 with the top-left corner going across 377 and 290 down
        copyToClipboard.setBounds(377, 370, 100, 50);
        // lambda expression to check when pressed, if-so, exit the program with status 0.
        copyToClipboard.addActionListener(e -> {
            StringSelection stringSelection = new StringSelection(String.valueOf(password));
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        });
        jPanel.add(copyToClipboard);// add the button to the panel


        jFrame.add(jPanel); // add the JPanel to the JFrame to display its contents
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == passwordOptions) System.out.println("hey");
    }
}