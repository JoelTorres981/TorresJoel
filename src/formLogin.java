import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formLogin extends JFrame {
    private JPanel loginPanel;
    private JTextField usuarioText;
    private JButton accesoButton;
    private JButton limpiarButton;
    private JPasswordField passwordField1;

    public formLogin() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(loginPanel);
        setLocationRelativeTo(null);
        setSize(300, 200);
        setVisible(true);

        accesoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioText.getText();
                String password = passwordField1.getText();
                if (usuario.equals("torres") && password.equals("esfot123")) {
                    new formMenu();
                    dispose();
                } else if (usuario.isEmpty() || password.isEmpty() ) {
                    JOptionPane.showMessageDialog(null,"Ingrese los datos");
                }
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioText.setText("");
                passwordField1.setText("");
            }
        });
    }
    public static void main(String[] args) {
        new formLogin();
    }
}
