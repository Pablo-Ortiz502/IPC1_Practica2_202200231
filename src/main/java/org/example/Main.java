package org.example;
import Admin.Admin;
import Admin.AdminFrame;
import HistorialClass.HistorialClass;
import Login.LoginFrame;
import Ruta.Ruta;
import Usuario.UsuarioFrame;
import Vehiculo.Vehiculo;
import Viaje.GenerarViajeFrame;
import Viaje.Viaje;
import Viaje.ViajeFrame;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LinkedList<Viaje> listaViejes = new LinkedList<>();
        LinkedList<HistorialClass>historial = new LinkedList<>();
        LinkedList<Ruta> listaRutas = new LinkedList<>();




        FileInputStream fis = new FileInputStream("Historial.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        LinkedList<HistorialClass> historialdes = (LinkedList<HistorialClass>) ois.readObject();
        ois.close();


        new LoginFrame(listaRutas,Admin.getListaVehiculo(),listaViejes,historialdes);


    }
}