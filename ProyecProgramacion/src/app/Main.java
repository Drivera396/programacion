package app;

import javax.swing.JOptionPane;
import modelo.ArchivoDatos;
import vista.Graficador;

public class Main {
    private static final String URL_DRIVE =
            "https://drive.google.com/uc?export=download&id=1W2I6XviLH90jphh6gyN9uEHpHN60nRP7";

 public static void main(String[] args) {   
      try {
          ArchivoDatos datos = new ArchivoDatos(URL_DRIVE, true);
          
          String[] opciones = {
                 "Ritmo sinusal normal",
                 "Taquicardia ventricular",
                 "Bradicardia sinusal"
          };

          int opc = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione el tipo de señal a graficar:",
                    "MENÚ ECG",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
          };
     if (opc == -1) return;

     String tipo = "";
     switch (opc) {
            case 0: tipo = "Normal"; break;
            case 1: tipo = "Taquicardia"; break;
            case 2: tipo = "Bradicardia"; break;
            }
     
     Graficador.mostrarGrafica(
                    datos.getTiempo(),
                    datos.getColumna(tipo),
                    "ECG - " + tipo,
                    "Tiempo (s)",
                    "Voltaje (mV)"
         );
     
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error cargando datos desde Drive:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}



