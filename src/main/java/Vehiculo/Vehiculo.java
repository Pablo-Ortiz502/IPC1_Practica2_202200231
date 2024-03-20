package Vehiculo;

public class Vehiculo {

    private double gasilina;
    private String tipo;

    private boolean ocupado;

    public Vehiculo(double gasilina, String tipo, boolean ocupado) {
        this.gasilina = gasilina;
        this.tipo = tipo;
        this.ocupado=ocupado;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
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
