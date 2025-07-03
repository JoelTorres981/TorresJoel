import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formMenu extends JFrame {
    private JPanel menuPanel;
    private JButton registroButton;
    private JButton ventasButton;
    private JButton verProductosButton;

    public formMenu() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(menuPanel);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(200, 200);


        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new formProductos();
                dispose();
            }
        });

        ventasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new formFactura();
                dispose();
            }
        });

        verProductosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new formMostrarProductos();
                dispose();
            }
        });
    }
}
