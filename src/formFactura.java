import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formFactura extends JFrame {
    private JPanel facturaPanel;
    private JTextField codigoText;
    private JTextField cantidadText;
    private JButton calcularButton;
    private JButton REGRESARALMENUButton;
    private JLabel productoLabel;
    private JLabel precioLabel;
    private JLabel subtotalLabel;
    private JLabel ivaLabel;
    private JLabel totalLabel;

    public formFactura() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(facturaPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(500, 300);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoText.getText();
                if (codigo.equals(formProductos.codigoG)) {
                    productoLabel.setText(formProductos.nombreG);
                    precioLabel.setText(formProductos.precioUnitarioG);
                }
                String cantidad = cantidadText.getText();
                int stock = Integer.parseInt(formProductos.stockG);
                double precio = Double.parseDouble(formProductos.precioUnitarioG);

                int cant = Integer.parseInt(cantidad);

                if (cant < stock) {
                    subtotalLabel.setText(String.valueOf(cant * precio));
                    double subtotal = Double.parseDouble(subtotalLabel.getText());

                    ivaLabel.setText(String.valueOf(subtotal * 0.15));
                    double iva = Double.parseDouble(ivaLabel.getText());

                    totalLabel.setText(String.valueOf(subtotal + iva));
                    double total = Double.parseDouble(totalLabel.getText());
                }

            }
        });

        REGRESARALMENUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new formMenu();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new formFactura();
    }
}
