import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class somaNumerosGUI extends JFrame {
    private JLabel labelQuantidade;
    private JTextField textFieldQuantidade;
    private JButton buttonSomar;
    private JLabel labelResultado;

    public somaNumerosGUI() {
        super("Soma de Números");

        labelQuantidade = new JLabel("Quantos números você deseja somar?");
        textFieldQuantidade = new JTextField(10);
        buttonSomar = new JButton("Somar");
        labelResultado = new JLabel();

        JPanel panel = new JPanel();
        panel.add(labelQuantidade);
        panel.add(textFieldQuantidade);
        panel.add(buttonSomar);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(labelResultado, BorderLayout.PAGE_END);

        buttonSomar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                somarNumeros();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void somarNumeros() {
        int quantidade = Integer.parseInt(textFieldQuantidade.getText());
        int[] numeros = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            String valor = javax.swing.JOptionPane.showInputDialog("Digite o número " + (i + 1) + ": ");
            numeros[i] = Integer.parseInt(valor);
        }

        int resultado = somarNumeros(numeros);
        labelResultado.setText("A soma dos " + quantidade + " números é igual a: " + resultado);
    }

    public static int somarNumeros(int... numeros) {
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return soma;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new somaNumerosGUI();
            }
        });
    }
}

