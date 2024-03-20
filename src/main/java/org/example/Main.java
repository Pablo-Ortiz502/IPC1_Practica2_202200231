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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedList<Viaje> listaViejes = new LinkedList<>();
        LinkedList<HistorialClass>historial = new LinkedList<>();
        LinkedList<Ruta> listaRutas = new LinkedList<>();

        FileOutputStream fos = new FileOutputStream("Historial.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(historial);
        oos.close();
        new LoginFrame(listaRutas,Admin.getListaVehiculo(),listaViejes,historial);


    }
}