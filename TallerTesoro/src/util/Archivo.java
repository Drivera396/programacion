package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Archivo {

    private final BufferedWriter writer;

    public Archivo(String archivo) throws IOException {
        this.writer = new BufferedWriter(new FileWriter(archivo));
        log("Inicio de registro.");
    }

    public void log(String contenido) {
        try {
            writer.write(LocalDateTime.now() + " - " + contenido);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error escribiendo en archivo.");
        }
    }

    public void close() {
        try {
            writer.write("Fin del registro.");
            writer.newLine();
            writer.close();
        } catch (IOException ignored) {}
    }
}
