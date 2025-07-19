import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBot extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private ResponseEngine responseEngine;

    public ChatBot() {
        responseEngine = new ResponseEngine();
        initUI();
    }

    private void initUI() {
        setTitle("Java ChatBot");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);
        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // Action listener for button
        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String userText = inputField.getText().trim();
        if (userText.isEmpty()) return;

        chatArea.append("You: " + userText + "\n");
        String botReply = responseEngine.getResponse(userText);
        chatArea.append("Bot: " + botReply + "\n\n");
        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChatBot().setVisible(true));
    }
}
