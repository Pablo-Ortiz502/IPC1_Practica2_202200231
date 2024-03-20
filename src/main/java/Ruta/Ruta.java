package Ruta;

public class Ruta {
    private int id;
    private String inicio;
    private String fin;
    private double distancia;

    public Ruta(int id, String inicio, String fin, double distancia) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.distancia = distancia;
    }

    public String rutaToCSV(){
        return id+","+inicio+","+fin+","+distancia;
    }
    public int getId() {
        return id;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFin() {
        return fin;
    }

    public double getDistancia() {
        return distancia;
    }
}
