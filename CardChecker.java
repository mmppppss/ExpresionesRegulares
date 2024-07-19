
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class CardChecker extends JFrame {

    private JTextField cardNumberField;
    private JButton validateButton;
    private JLabel messageLabel;

    public CardChecker() {
        setTitle("Validar tarjetas visa/mastercard/american express");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardNumberField = new JTextField(20);
        validateButton = new JButton("Validar");
        messageLabel = new JLabel("");

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNumberField.getText().trim();
                if (validateCardNumber(cardNumber)) {
                    messageLabel.setText("Valido: " + cardNumber);
                } else {
                    messageLabel.setText("Invalido.");
                }
            }
        });

        setLayout(new FlowLayout());
        add(new JLabel("Numero de tarjeta:"));
        add(cardNumberField);
        add(validateButton);
        add(messageLabel);
    }

    private boolean validateCardNumber(String cardNumber) {
        // Basic regex for credit card number validation
        Pattern pattern = Pattern.compile("^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|3[47][0-9]{13})$");
        return pattern.matcher(cardNumber).matches();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CardChecker().setVisible(true);
            }
        });
    }
}
