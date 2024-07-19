import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
	private JTextField mailField;
	private JPasswordField passwordField;
	private JButton loginButton;
	Pattern mailFormat = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
	Matcher matcher;
	public static void main(String[] args) {
		new Login();
	}
	public Login() {
		init();
		eventHandler();
		loginButton.setEnabled(false);

	}
	public void eventHandler() {
		mailField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				matcher = mailFormat.matcher(mailField.getText());
				if(matcher.matches()) 
					mailField.setBackground(Color.GREEN);
				else
					mailField.setBackground(Color.RED);
				loginButton.setEnabled(matcher.matches());
			}
		});
	}

	public void init(){
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		JLabel mailLabel = new JLabel("E-mail:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(mailLabel, gbc);

		mailField = new JTextField();
		mailField.setPreferredSize(new Dimension(200, 20));
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(mailField, gbc);

		JLabel passwordLabel = new JLabel("Password:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(passwordLabel, gbc);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setPreferredSize(new Dimension(200, 20));
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(passwordField, gbc);

		loginButton = new JButton("Login");
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(loginButton, gbc);

		loginButton.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Iniciando sesion ...");
		});

		pack();
		setVisible(true);
	}
}
