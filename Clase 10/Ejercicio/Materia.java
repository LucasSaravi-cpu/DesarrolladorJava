package org.example;

import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }


    public String getNombre() {
        return nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public boolean puedeCursar(Alumno alumno) {
        if (correlativas.isEmpty()) {
            return true;
        } else {
            for (Materia materia : correlativas) {
                if (!alumno.getMateriasAprobadas().contains(materia)) {
                    return false;
                }
            }
            return true;
        }
    }
}
