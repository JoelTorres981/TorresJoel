import javax.swing.*;

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
        setSize(800, 600);


    }
}
