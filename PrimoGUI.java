import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrimoGUI extends JFrame {
    private JLabel labelNumero;
    private JTextField textFieldNumero;
    private JButton buttonVerificar;
    private JLabel labelResultado;

    public PrimoGUI() {
        super("Verificar Número Primo");

        labelNumero = new JLabel("Digite um número inteiro:");
        textFieldNumero = new JTextField(10);
        buttonVerificar = new JButton("Verificar");
        labelResultado = new JLabel();

        JPanel panel = new JPanel();
        panel.add(labelNumero);
        panel.add(textFieldNumero);
        panel.add(buttonVerificar);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(labelResultado, BorderLayout.PAGE_END);

        buttonVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarNumeroPrimo();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void verificarNumeroPrimo() {
        int numero = Integer.parseInt(textFieldNumero.getText());

        if (isPrimo(numero)) {
            labelResultado.setText(numero + " é primo.");
        } else {
            labelResultado.setText(numero + " não é primo.");
        }
    }

    public static boolean isPrimo(int n) {
        if (n <= 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PrimoGUI();
            }
        });
    }
}