import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formMostrarProductos extends JFrame {
    private JPanel mostrarProductosPanel;
    private JButton REGRESARALMENUButton;
    private JLabel codigoLabel;
    private JLabel nombreLabel;
    private JLabel detalleLabel;
    private JLabel stockLabel;

    public formMostrarProductos() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mostrarProductosPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(200, 200);

        codigoLabel.setText(formProductos.codigoG);
        nombreLabel.setText(formProductos.nombreG);
        detalleLabel.setText(formProductos.detalleG);
        stockLabel.setText(formProductos.stockG);

        REGRESARALMENUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new formMenu();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new formMostrarProductos();
    }
}
