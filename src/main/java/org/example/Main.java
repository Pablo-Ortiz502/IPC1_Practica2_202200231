package org.example;
import Admin.Admin;
import Admin.AdminFrame;
import Login.LoginFrame;
import Ruta.Ruta;
import Usuario.UsuarioFrame;
import Vehiculo.Vehiculo;
import Viaje.GenerarViajeFrame;
import Viaje.Viaje;
import Viaje.ViajeFrame;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Viaje> listaViejes = new LinkedList<>();
        LinkedList<Viaje>historial = new LinkedList<>();
        LinkedList<Ruta> listaRutas = new LinkedList<>();

        new LoginFrame(listaRutas,Admin.getListaVehiculo(),listaViejes,historial);


    }
}