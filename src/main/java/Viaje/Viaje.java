package Viaje;

import java.awt.event.ActionListener;
import java.util.Observable;

public class Viaje extends Observable implements Runnable {

    private int id;
   private String inicio;
   private String fin;
   private String tipoVehiculo;
   private double distancia;
   private String fecha;

    public Viaje(int id,String inicio, String fin, String tipoVehiculo, double distancia, String fecha) {
        this.inicio = inicio;
        this.fin = fin;
        this.tipoVehiculo = tipoVehiculo;
        this.id = id;
        this.distancia = distancia;
        this.fecha = fecha;
    }

    public String viajeToCSV(){
        return fecha+","+inicio+","+fin+","+distancia+","+tipoVehiculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
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



    @Override
    public void run() {
        int porcentage = 0;
        try {
        while (porcentage<=100){
            porcentage += 10;
            this.setChanged();
            this.notifyObservers(porcentage);
            this.clearChanged();
                Thread.sleep(500);

            }

        }catch (InterruptedException e) {
        }
    }


    @Override
    public String toString() {
        return "Viaje{" +
                "id=" + id +
                ", inicio='" + inicio + '\'' +
                ", fin='" + fin + '\'' +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", distancia=" + distancia +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
