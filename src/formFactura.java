import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font; // Importar para cambiar el tamaño de fuente

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

    // Variables para almacenar temporalmente
    private String currentProductCodigo = "";
    private String currentProductName = "";
    private double currentProductPrice = 0.0;
    private int currentProductStock = 0;

    public formFactura() {
        setTitle("VENTAS (FACTURA)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(facturaPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(500, 350);

        totalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        totalLabel.setText("0.00");

        codigoText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarDatosProducto();
            }
        });

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Asegurarse de que los datos del producto estén cargados antes de calcular
                if (currentProductCodigo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Primero ingrese un código de producto válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                calcularVenta();
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

    private void cargarDatosProducto() {
        String codigoIngresado = codigoText.getText().trim();

        if (codigoIngresado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un código de producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            limpiarCamposCalculo();
            return;
        }

        if (codigoIngresado.equals(formProductos.codigoG)) {
            currentProductCodigo = formProductos.codigoG;
            currentProductName = formProductos.nombreG;
            currentProductPrice = Double.parseDouble(formProductos.precioUnitarioG);
            currentProductStock = Integer.parseInt(formProductos.stockG);

            productoLabel.setText(currentProductName);
            precioLabel.setText(String.format("%.2f", currentProductPrice)); // Formatear a 2 decimales
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.", "Error de Búsqueda", JOptionPane.ERROR_MESSAGE);
            limpiarCamposCalculo();
        }
    }

    private void calcularVenta() {
        String cantidadStr = cantidadText.getText().trim();

        if (cantidadStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad a comprar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int cantidadComprar;
        try {
            cantidadComprar = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero válido.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            cantidadText.setText("");
            return;
        }

        if (cantidadComprar <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que cero.", "Error de Cantidad", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cantidadComprar > currentProductStock) {
            JOptionPane.showMessageDialog(null, "La cantidad ingresada supera el stock disponible (" + currentProductStock + " unidades).", "Stock Insuficiente", JOptionPane.WARNING_MESSAGE);
            return;
        }

        double subtotal = cantidadComprar * currentProductPrice;
        double iva = subtotal * 0.15;
        double total = subtotal + iva;

        subtotalLabel.setText(String.format("%.2f", subtotal));
        ivaLabel.setText(String.format("%.2f", iva));
        totalLabel.setText(String.format("%.2f", total));

        formProductos.stockG = String.valueOf(currentProductStock - cantidadComprar);

        currentProductStock = currentProductStock - cantidadComprar;

        JOptionPane.showMessageDialog(null, "Venta calculada exitosamente. Stock actualizado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void limpiarCamposCalculo() {
        productoLabel.setText("");
        precioLabel.setText("");
        subtotalLabel.setText("");
        ivaLabel.setText("");
        totalLabel.setText("");
        cantidadText.setText("");

        currentProductCodigo = "";
        currentProductName = "";
        currentProductPrice = 0.0;
        currentProductStock = 0;
    }
}