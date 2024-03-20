package Vehiculo;

public class Vehiculo {

    private double gasilina;
    private String tipo;

    public Vehiculo(double gasilina, String tipo) {
        this.gasilina = gasilina;
        this.tipo = tipo;
    }

    public double getGasilina() {
        return gasilina;
    }

    public void setGasilina(double gasilina) {
        this.gasilina = gasilina;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
