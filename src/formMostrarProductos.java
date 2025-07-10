import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formMostrarProductos extends JFrame {
    private JPanel mostrarPanel;
    private JLabel codigoValorLabel;
    private JLabel nombreValorLabel;
    private JLabel detalleValorLabel;
    private JLabel precioValorLabel;
    private JLabel stockValorLabel;
    private JButton REGRESARALMENUButton;

    public formMostrarProductos() {
        setTitle("VER PRODUCTOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mostrarPanel);
        setLocationRelativeTo(null);
        setSize(350, 250); // Tamaño adecuado
        setVisible(true);

        codigoValorLabel.setText(formProductos.codigoG);
        nombreValorLabel.setText(formProductos.nombreG);
        detalleValorLabel.setText(formProductos.detalleG);
        precioValorLabel.setText(formProductos.precioUnitarioG);
        stockValorLabel.setText(formProductos.stockG);

        REGRESARALMENUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new formMenu();
                dispose();
            }
        });
    }
}