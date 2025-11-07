package vista;
import javax.swing*;
import java.awt*;

public class Pantalla {

private JLabel etiqueta;

    public VentanaECG() {
        setTitle("Monitor ECG");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        etiqueta = new JLabel("ECG: ---", SwingConstants.CENTER);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 22));

        add(etiqueta, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actualizarLectura(double valor) {
        etiqueta.setText("ECG: " + valor + " mV");
    }
}
