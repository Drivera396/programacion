package varios;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class RetoMain {

//Clase estudiante
    static class Estudiante implements Serializable {
        private String id;
        private String nombre;
        private int puntosTotales;
        private String nivel;

        public Estudiante(String id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            this.puntosTotales = 0;
            this.nivel = "Novato";
        }

        public String getId() { return id; }
        public String getNombre() { return nombre; }
        public int getPuntosTotales() { return puntosTotales; }
        public String getNivel() { return nivel; }

//Metodos de Estudiante 
        public void agregarPuntos(int puntos) {
            this.puntosTotales += puntos;
            calcularNivel();
        }

        public void calcularNivel() {
            if (puntosTotales < 100) nivel = "Novato";
            else if (puntosTotales < 200) nivel = "Intermedio";
            else if (puntosTotales < 300) nivel = "Avanzado";
            else nivel = "Experto";
        }

        @Override
        public String toString() {
            return "ID: " + id +
                   "\nNombre: " + nombre +
                   "\nPuntos: " + puntosTotales +
                   "\nNivel: " + nivel + "\n";
        }
    }

 //Clase Evaluador
    static class Evaluador {
        private String nombreEvaluador;
        private ArrayList<Estudiante> listaEstudiantes;
        private final String archivoDatos = "estudiantes.dat";

        public Evaluador(String nombreEvaluador) {
            this.nombreEvaluador = nombreEvaluador;
            this.listaEstudiantes = new ArrayList<>();
            cargarDatosDesdeArchivo();
        }

//Metodos de Evaluador 
        public void registrarEstudiante() {
            String id = JOptionPane.showInputDialog("Ingrese el ID del estudiante:");
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            listaEstudiantes.add(new Estudiante(id, nombre));
            guardarDatosEnArchivo();
            JOptionPane.showMessageDialog(null, "El estudiante se encuentra registrado exitosamente.");
        }

        public void asignarPuntos() {
            String id = JOptionPane.showInputDialog("Ingrese el ID del estudiante:");
            Estudiante e = buscarEstudiantePorId(id);

            if (e != null) {
                int puntos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los puntos a asignar:"));
                e.agregarPuntos(puntos);
                guardarDatosEnArchivo();
                JOptionPane.showMessageDialog(null, "Puntos asignados correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
            }
        }

        public void mostrarRanking() {
            if (listaEstudiantes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
                return;
            }

            listaEstudiantes.sort((a, b) -> b.getPuntosTotales() - a.getPuntosTotales());
            StringBuilder ranking = new StringBuilder("RANKING DE ESTUDIANTES\n");

            for (Estudiante e : listaEstudiantes) {
                ranking.append(e.toString()).append("------------------\n");
            }

            JOptionPane.showMessageDialog(null, ranking.toString());
        }

        private Estudiante buscarEstudiantePorId(String id) {
            for (Estudiante e : listaEstudiantes) {
                if (e.getId().equalsIgnoreCase(id)) return e;
            }
            return null;
        }

        public void guardarDatosEnArchivo() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDatos))) {
                oos.writeObject(listaEstudiantes);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al momento de guardar los datos: " + e.getMessage());
            }
        }

        public void cargarDatosDesdeArchivo() {
            File archivo = new File(archivoDatos);
            if (!archivo.exists()) return;

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoDatos))) {
                listaEstudiantes = (ArrayList<Estudiante>) ois.readObject();
            } catch (Exception e) {
                listaEstudiantes = new ArrayList<>();
            }
        }
    }

//Metodo main 
    public static void main(String[] args) {
        Evaluador evaluador = new Evaluador("Profesor");

        String menu = """
        Elija la opcion que desea realizar: 
        1. Registrar estudiante
        2. Asignar puntos
        3. Mostrar ranking
        4. Salir
        """;

        int opcion;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1 -> evaluador.registrarEstudiante();
                    case 2 -> evaluador.asignarPuntos();
                    case 3 -> evaluador.mostrarRanking();
                    case 4 -> JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingresa un número válido.");
                opcion = 0;
            }
        } while (opcion != 4);
    }
}