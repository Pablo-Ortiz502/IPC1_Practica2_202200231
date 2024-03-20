package org.example;

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
        LinkedList<Vehiculo> listaVehiculo = new LinkedList<>();
        int contador =0;

        Vehiculo vehiculo1 = new Vehiculo(6,"moto1");
        Vehiculo vehiculo2 = new Vehiculo(6,"moto2");
        Vehiculo vehiculo3 = new Vehiculo(6,"moto3");
        Vehiculo vehiculo4 = new Vehiculo(10,"carro1");
        Vehiculo vehiculo5 = new Vehiculo(10,"carro2");
        Vehiculo vehiculo6 = new Vehiculo(10,"carro3");
        Vehiculo vehiculo7 = new Vehiculo(12,"premium1");
        Vehiculo vehiculo8 = new Vehiculo(12,"premium2");
        Vehiculo vehiculo9 = new Vehiculo(12,"premium3");

        listaVehiculo.add(vehiculo1);
        listaVehiculo.add(vehiculo2);
        listaVehiculo.add(vehiculo3);
        listaVehiculo.add(vehiculo4);
        listaVehiculo.add(vehiculo5);
        listaVehiculo.add(vehiculo6);
        listaVehiculo.add(vehiculo7);
        listaVehiculo.add(vehiculo8);
        listaVehiculo.add(vehiculo9);

        Ruta ruta1 = new Ruta(1,"Guatemala","Xela",250);
        Ruta ruta2 = new Ruta(1,"Guatemala","El Salvador",300);
        Ruta ruta3 = new Ruta(1,"Guatemala","Peten",500);
        Ruta ruta4 = new Ruta(1,"Xela","Guatemala",250);
        Ruta ruta5 = new Ruta(1,"Xela","peten",400);

        listaRutas.add(ruta1);
        listaRutas.add(ruta2);
        listaRutas.add(ruta3);
        listaRutas.add(ruta4);
        listaRutas.add(ruta5);


       //new UsuarioFrame(listaRutas,listaVehiculo,listaViejes,historial);

        new AdminFrame();


    }
}