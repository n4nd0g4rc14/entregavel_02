import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FibonacciGUI extends JFrame {
    private JLabel labelNumero;
    private JTextField textFieldNumero;
    private JButton buttonCalcular;
    private JLabel labelResultado;

    public FibonacciGUI() {
        super("Cálculo de Fibonacci");

        labelNumero = new JLabel("Digite um número inteiro:");
        textFieldNumero = new JTextField(10);
        buttonCalcular = new JButton("Calcular");
        labelResultado = new JLabel();

        JPanel panel = new JPanel();
        panel.add(labelNumero);
        panel.add(textFieldNumero);
        panel.add(buttonCalcular);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(labelResultado, BorderLayout.PAGE_END);

        buttonCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularFibonacci();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calcularFibonacci() {
        int numero = Integer.parseInt(textFieldNumero.getText());

        int fibonacci = fibo(numero);
        labelResultado.setText("O número de Fibonacci correspondente é: " + fibonacci);
    }

    public static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FibonacciGUI();
            }
        });
    }
}
