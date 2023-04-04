package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GeneradorDeArchivos {
    public static void generarArchivoInscripciones() {
        List<String> registros = Arrays.asList(
                "Alumno, Materia",
                "José Rodriguez, Programación I",
                "Vanesa Sosa, Bases de datos I",
                "Lucia Perez, Bases de datos I",
                "Vanesa Sosa, Programación II"
        );

        String nombreArchivo = "inscripciones.csv";

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (String registro : registros) {
                writer.write(registro + "\n");
            }
            System.out.println("Archivo generado exitosamente: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al generar el archivo: " + e.getMessage());
        }
    }
}
