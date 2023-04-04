package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InscripcionTest {
    @Test
    public void testMateriaSinCorrelativas() {
        Materia materia = new Materia("Programación I", new ArrayList<Materia>());
        Alumno alumno = new Alumno("Juan", "123456");
        Inscripcion inscripcion = new Inscripcion(alumno, materia);
        assertTrue(inscripcion.aprobada());
        //afirmación a cerca de lo que esta en parámetro me da un valor bool TRUE
    }

    @Test
    public void testMateriaConCorrelativas() {
        Materia materia1 = new Materia("Programación I", new ArrayList<Materia>());
        Materia materia2 = new Materia("Programación II", Arrays.asList(materia1));
        Materia materia3 = new Materia("Programación III", Arrays.asList(materia2));
        Alumno alumno = new Alumno("Juan", "123456");
        alumno.agregarMateriaAprobada(materia1);
        alumno.agregarMateriaAprobada(materia2);
        Inscripcion inscripcion = new Inscripcion(alumno, materia3);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testMateriaConCorrelativasNoAprobadas() {
        Materia materia1 = new Materia("Programación I", new ArrayList<Materia>());
        Materia materia2 = new Materia("Programación II", Arrays.asList(materia1));
        Materia materia3 = new Materia("Programación III", Arrays.asList(materia2));
        Alumno alumno = new Alumno("Juan", "123456");
        alumno.agregarMateriaAprobada(materia1);
        //alumno.agregarMateriaAprobada(materia2);
        Inscripcion inscripcion = new Inscripcion(alumno, materia3);
        assertFalse(inscripcion.aprobada());
        //afirmación a cerca de lo que esta en parámetro me da un valor bool FALSE
    }
}
