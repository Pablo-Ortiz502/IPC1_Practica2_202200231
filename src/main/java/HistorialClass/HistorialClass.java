package HistorialClass;

import java.io.Serializable;

public class HistorialClass implements Serializable {
    private String inicio;
    private String fin;
    private String tipoVehiculo;
    private double distancia;
    private String fecha;

    public HistorialClass(String inicio, String fin, String tipoVehiculo, double distancia, String fecha) {
        this.inicio = inicio;
        this.fin = fin;
        this.tipoVehiculo = tipoVehiculo;
        this.distancia = distancia;
        this.fecha = fecha;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "HistorialClass{" +
                "inicio='" + inicio + '\'' +
                ", fin='" + fin + '\'' +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", distancia=" + distancia +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
