/* Christiaan Gouws 4332981.
 * This program calculates the user's number of words,
 * characters with spaces and characters without spaces
 * that he or she typed in the message box. */


import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

class WordCountApplication {
    private static Map<String, String> userDatabase = new HashMap<>();

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createLoginFrame();
            }
        });
    }

    public static void createLoginFrame() {
        JFrame loginFrame = new JFrame("Login or Signup");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton signUpButton = new JButton("Sign Up");

        usernameLabel.setBounds(50, 100, 100, 30);
        passwordLabel.setBounds(50, 150, 100, 30);
        usernameField.setBounds(150, 100, 150, 30);
        passwordField.setBounds(150, 150, 150, 30);
        loginButton.setBounds(100, 200, 80, 30);
        signUpButton.setBounds(250, 200, 80, 30);

        loginFrame.add(usernameLabel);
        loginFrame.add(passwordLabel);
        loginFrame.add(usernameField);
        loginFrame.add(passwordField);
        loginFrame.add(loginButton);
        loginFrame.add(signUpButton);

        loginFrame.setSize(400, 400);
        loginFrame.setResizable(false);
        loginFrame.setLayout(null);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                    loginFrame.dispose();
                    createMainFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login credentials.");
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a username and password.");
                } else if (userDatabase.containsKey(username)) {
                    JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different username.");
                } else {
                    userDatabase.put(username, password);
                    JOptionPane.showMessageDialog(null, "Account created successfully. You can now log in.");
                }
            }
        });
    }

    public static void createMainFrame() {
        // Create the main frame
        JFrame f = new JFrame("InterstellarCount Prototype");

        // Initialize GUI components
        JLabel l2, l3, l4;
        JTextArea text;
        JLabel l1;
        JButton submit, clear;
        text = new JTextArea("");
        submit = new JButton("SUBMIT");
        clear = new JButton("CLEAR");
        l1 = new JLabel("Start creating...");
        l2 = new JLabel("Character with Spaces : ");
        l3 = new JLabel("Character Without Spaces : ");
        l4 = new JLabel("Words : ");
        
        // Set font for labels
        Font txtFont = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
        l1.setFont(txtFont);
        l2.setFont(txtFont);
        l3.setFont(txtFont);
        l4.setFont(txtFont);

        // Set positions of components
        l1.setBounds(10, 25, 200, 30);
        text.setBounds(18, 60, 450, 300);
        l2.setBounds(10, 370, 400, 30);
        l3.setBounds(10, 400, 400, 30);
        l4.setBounds(10, 430, 400, 30);
        submit.setBounds(100, 470, 100, 50);
        clear.setBounds(275, 470, 100, 50);

        // Set text area properties
        text.setLineWrap(true);
        text.setWrapStyleWord(true);

        // Action listener for the SUBMIT button
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get input text and remove leading/trailing spaces
                String str = text.getText().strip();
                int count = 0, i, word = 0;
                
                // Update label with character count (including spaces)
                l2.setText("Character with Spaces : " + str.length());
                
                // Calculate character count and word count
                for (i = 0; i < str.length(); i++) {
                    if (str.charAt(i) != ' ')
                        count++;
                    else
                        word++;
                }
                // Update labels with calculated counts
                l3.setText("Character Without Spaces : " + count);
                l4.setText("Words : " + (word + 1));
            }
        });

        // Action listener for the CLEAR button
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear text area and reset labels
                text.setText("");
                l2.setText("Character with Spaces : ");
                l3.setText("Character Without Spaces : ");
                l4.setText("Words : ");
            }
        });

        // Add components to the frame
        f.add(l1);
        f.add(text);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(submit);
        f.add(clear);

        // Configure frame settings
        f.setSize(500, 570);
        f.setResizable(false);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
