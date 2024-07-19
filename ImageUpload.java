import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageUpload extends JFrame {

    private JButton uploadButton;
    private JLabel messageLabel;

    public ImageUpload() {
        setTitle("Image Upload");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        uploadButton = new JButton("Subir imagen");
        messageLabel = new JLabel("Esperando archivo...");

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    if (validateFileName(selectedFile.getName())) {
                        messageLabel.setText("Imagen seleccionada: " + selectedFile.getName());
                    } else {
                        messageLabel.setText("Archivo no valido, solo se permiten imagenes.");
                    }
                }
            }
        });

        setLayout(new BorderLayout());
        add(uploadButton, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);
    }

    private boolean validateFileName(String fileName) {
        Pattern pattern = Pattern.compile("([^\\s]+(\\.(?i)(jpg|png))$)");
        Matcher matcher = pattern.matcher(fileName);
        return matcher.matches();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageUpload().setVisible(true);
            }
        });
    }
}
