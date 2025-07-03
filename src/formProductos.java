import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formProductos extends JFrame {
    private JPanel productosPanel;
    private JTextField codigoText;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JTextField nombreText;
    private JTextField detalleText;
    private JTextField PrecioUnitarioText;
    private JTextField StockText;
    private JButton REGRESARALMENUButton;

    private String codigoG = codigoText.getText();
    private String nombreG = nombreText.getText();
    private String detalleG = detalleText.getText();
    private String precioUnitarioG = PrecioUnitarioText.getText();
    private String stockG = StockText.getText();

    public formProductos() {
        setTitle("PRODUCTOS (ADMIN)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(productosPanel);
        setLocationRelativeTo(null);
        setSize(400, 250);
        setVisible(true);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoText.getText();
                String nombre = nombreText.getText();
                String detalle = detalleText.getText();
                String precioUnitario = PrecioUnitarioText.getText();
                String stock = StockText.getText();
                if (codigo.isEmpty() || nombre.isEmpty() || detalle.isEmpty() || precioUnitario.isEmpty() || stock.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Ingrese los datos");
                    return;
                } else if (precioUnitario.length() > 4) {
                    JOptionPane.showMessageDialog(null,"Precio unitario no valido");
                    return;
                } else if (stock.length() > 3) {
                    JOptionPane.showMessageDialog(null,"Stock no valido");
                    return;
                }

                codigoG = codigo;
                nombreG = nombre;
                detalleG = detalle;
                precioUnitarioG = precioUnitario;
                stockG = stock;

                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente");
                codigoText.setText("");
                nombreText.setText("");
                detalleText.setText("");
                PrecioUnitarioText.setText("");
                StockText.setText("");
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigoText.setText("");
                nombreText.setText("");
                detalleText.setText("");
                PrecioUnitarioText.setText("");
                StockText.setText("");
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
}
