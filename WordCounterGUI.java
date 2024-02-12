import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterGUI extends JFrame {
    private JLabel inputLabel;
    private JTextField inputTextField;
    private JButton countButton;
    private JButton clearButton;
    private JLabel resultLabel;

    public WordCounterGUI() {
        setTitle("Word Counter");
        setSize(500, 400); // Increase window size
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(null);

        inputLabel = new JLabel("Enter a sentence:");
        inputLabel.setBounds(20, 20, 120, 25);
        inputTextField = new JTextField();
        inputTextField.setBounds(150, 20, 300, 25); // Increase text field width
        countButton = new JButton("Count Words");
        countButton.setBounds(100, 60, 120, 25);
        clearButton = new JButton("Clear");
        clearButton.setBounds(250, 60, 120, 25); // Adjust button position
        resultLabel = new JLabel();
        resultLabel.setBounds(200, 100, 300, 25); // Increase result label width

        add(inputLabel);
        add(inputTextField);
        add(countButton);
        add(clearButton);
        add(resultLabel);

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sentence = inputTextField.getText();
                int wordCount = countWords(sentence);
                resultLabel.setText("Word Count: " + wordCount);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputTextField.setText("");
                resultLabel.setText("");
            }
        });
    }

    private int countWords(String sentence) {
        int wordCount = 1;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ' && sentence.charAt(i + 1) != ' ') {
                if ((sentence.charAt(i - 1) != ',') && (sentence.charAt(i - 1) != '?')) {
                    wordCount++;
                }
            }
        }
        return wordCount;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordCounterGUI().setVisible(true);
            }
        });
    }
}
