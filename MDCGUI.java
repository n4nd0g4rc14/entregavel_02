import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MDCGUI extends JFrame {
    private JLabel labelPrimeiroNumero;
    private JTextField textFieldPrimeiroNumero;
    private JLabel labelSegundoNumero;
    private JTextField textFieldSegundoNumero;
    private JButton buttonCalcularMDC;
    private JLabel labelResultado;

    public MDCGUI() {
        super("Cálculo do MDC");

        labelPrimeiroNumero = new JLabel("Digite o primeiro número:");
        textFieldPrimeiroNumero = new JTextField(10);
        labelSegundoNumero = new JLabel("Digite o segundo número:");
        textFieldSegundoNumero = new JTextField(10);
        buttonCalcularMDC = new JButton("Calcular MDC");
        labelResultado = new JLabel();

        JPanel panel = new JPanel();
        panel.add(labelPrimeiroNumero);
        panel.add(textFieldPrimeiroNumero);
        panel.add(labelSegundoNumero);
        panel.add(textFieldSegundoNumero);
        panel.add(buttonCalcularMDC);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(labelResultado, BorderLayout.PAGE_END);

        buttonCalcularMDC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularMDC();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calcularMDC() {
        int primeiroNumero = Integer.parseInt(textFieldPrimeiroNumero.getText());
        int segundoNumero = Integer.parseInt(textFieldSegundoNumero.getText());

        int mdc = calcularMDC(primeiroNumero, segundoNumero);
        labelResultado.setText("O máximo divisor comum entre " + primeiroNumero + " e " + segundoNumero + " é: " + mdc);
    }

    public static int calcularMDC(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calcularMDC(b, a % b);
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MDCGUI();
            }
        });
    }
}

