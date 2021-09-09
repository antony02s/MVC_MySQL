
package modelo;

public class Carreras {
    private int id_carrera;
    private String nombre;
    private double capacidad_asistentes;
    private double nivel_dificultad;
    private boolean bajo_techo;

    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCapacidad_asistentes() {
        return capacidad_asistentes;
    }

    public void setCapacidad_asistentes(double capacidad_asistentes) {
        this.capacidad_asistentes = capacidad_asistentes;
    }

    public double getNivel_dificultad() {
        return nivel_dificultad;
    }

    public void setNivel_dificultad(double nivel_dificultad) {
        this.nivel_dificultad = nivel_dificultad;
    }

    public boolean isBajo_techo() {
        return bajo_techo;
    }

    public void setBajo_techo(boolean bajo_techo) {
        this.bajo_techo = bajo_techo;
    }
    
    
}
