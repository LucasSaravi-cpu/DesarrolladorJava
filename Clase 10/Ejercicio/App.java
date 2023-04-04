package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class App
{
    public static void main( String[] args ) {
        // Generamos el archivo de inscripciones
        GeneradorDeArchivos.generarArchivoInscripciones();

        // Cargamos los datos de las materias y alumnos en memoria
        Materia programacion1 = new Materia("Programación I", new ArrayList<Materia>());
        Materia programacion2 = new Materia("Programación II", Arrays.asList(programacion1));
        Materia programacion3 = new Materia("Programación III", Arrays.asList(programacion2));
        Materia basesDeDatos1 = new Materia("Bases de datos I", new ArrayList<Materia>());
        Materia basesDeDatos2 = new Materia("Bases de datos II", Arrays.asList(basesDeDatos1));
        List<Materia> materias = new ArrayList<>();
        materias.add(programacion1);
        materias.add(programacion2);
        materias.add(programacion3);
        materias.add(basesDeDatos1);
        materias.add(basesDeDatos2);

        Alumno jose = new Alumno("José Rodriguez", "123456");
        Alumno vanesa = new Alumno("Vanesa Sosa", "789012");
        Alumno lucia = new Alumno("Lucia Perez", "345678");
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(jose);
        alumnos.add(vanesa);
        alumnos.add(lucia);

        // Agregar Programación I a las materias aprobadas de Vanesa Sosa
        vanesa.agregarMateriaAprobada(programacion1);

        // Cargamos los datos del archivo de inscripciones y procesamos
        String nombreArchivo = "inscripciones.csv";
        Map<String, Alumno> alumnosMap = new HashMap<>();
        for (Alumno alumno : alumnos) {
            alumnosMap.put(alumno.getNombre(), alumno);
        }
        Map<String, Materia> materiasMap = new HashMap<>();
        for (Materia materia : materias) {
            materiasMap.put(materia.getNombre(), materia);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] campos = line.split(", ");
                String nombreAlumno = campos[0];
                String nombreMateria = campos[1];

                // Buscamos el alumno y la materia en la colección
                Alumno alumno = alumnosMap.get(nombreAlumno);
                Materia materia = materiasMap.get(nombreMateria);

                // Validamos que existan el alumno y la materia en la colección
                if (alumno == null) {
                    System.out.println(nombreAlumno + "\t" + nombreMateria + "\tNo existe el/la alumno/a");
                } else if (materia == null) {
                    System.out.println(nombreAlumno + "\t" + nombreMateria + "\tNo existe la materia");
                } else {
                    Inscripcion inscripcion = new Inscripcion(alumno, materia);

                    // Verificamos si la inscripción fue aprobada
                    if (inscripcion.aprobada()) {
                        System.out.println(alumno.getNombre() + "\t" + materia.getNombre() + "\tAprobado");
                    } else {
                        System.out.println(alumno.getNombre() + "\t" + materia.getNombre() + "\tRechazado");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de inscripciones: " + e.getMessage());
        }
    }
}
