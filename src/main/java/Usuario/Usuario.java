package Usuario;

import Viaje.Viaje;

import java.util.LinkedList;

public class Usuario {
private String coodigo;
private String contra;

private  String nombre;
private  String Apellido;



    public Usuario(String coodigo, String contra, String nombre, String apellido) {
        this.coodigo = coodigo;
        this.contra = contra;
        this.nombre = nombre;
        Apellido = apellido;
    }

    public String getCoodigo() {
        return coodigo;
    }

    public void setCoodigo(String coodigo) {
        this.coodigo = coodigo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }
}
