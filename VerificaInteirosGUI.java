import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VerificaInteirosGUI extends JFrame {
    private JLabel labelTamanho;
    private JTextField textFieldTamanho;
    private JButton buttonVerificar;
    private JLabel labelResultado;

    public VerificaInteirosGUI() {
        super("Verifica Inteiros");

        labelTamanho = new JLabel("Digite o tamanho do conjunto: ");
        textFieldTamanho = new JTextField(10);
        buttonVerificar = new JButton("Definir");
        labelResultado = new JLabel();

        JPanel panel = new JPanel();
        panel.add(labelTamanho);
        panel.add(textFieldTamanho);
        panel.add(buttonVerificar);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(labelResultado, BorderLayout.PAGE_END);

        buttonVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarConjunto();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void verificarConjunto() {
        ArrayList<Object> conjunto = new ArrayList<>();
        int n = Integer.parseInt(textFieldTamanho.getText());

        for (int i = 0; i < n; i++) {
            String valor = javax.swing.JOptionPane.showInputDialog("Digite um valor: ");

            try {
                int intValue = Integer.parseInt(valor);
                conjunto.add(intValue);
            } catch (NumberFormatException e) {
                conjunto.add(valor);
            }
        }

        int count = 0;
        for (Object obj : conjunto) {
            if (obj instanceof Integer) {
                count++;
            }
        }

        labelResultado.setText("O conjunto possui " + count + " valores inteiros.");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VerificaInteirosGUI();
            }
        });
    }
}

