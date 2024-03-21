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
        LinkedList<Ruta> listaRutas = new LinkedList<>();
        LinkedList<HistorialClass> viajesHi1 = new LinkedList<>();

//        try {
//           FileOutputStream fos = new FileOutputStream("Viajes.ser");
//           ObjectOutputStream oos = new ObjectOutputStream(fos);
//           oos.writeObject(viajesHi1);
//            oos.close();
//      }catch (IOException ex){
//            throw new RuntimeException(ex);
//        }

        FileInputStream fis = new FileInputStream("Historial.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        LinkedList<HistorialClass> historialdes = (LinkedList<HistorialClass>) ois.readObject();
        ois.close();

        FileInputStream fis1 = new FileInputStream("Viajes.ser");
        ObjectInputStream ois1 = new ObjectInputStream(fis1);
        LinkedList<HistorialClass> viajesHi = (LinkedList<HistorialClass>) ois1.readObject();
        ois1.close();

        if(!viajesHi.isEmpty()){
            int contador =1;
            for (int i =0; i < viajesHi.size(); i++){
                Viaje viaje = new Viaje(contador,viajesHi.get(i).getInicio(),viajesHi.get(i).getFin(),viajesHi.get(i).getTipoVehiculo(),viajesHi.get(i).getDistancia(),viajesHi.get(i).getFecha());
                listaViejes.add(viaje);
                contador++;
            }
        }

        new LoginFrame(listaRutas,Admin.getListaVehiculo(),listaViejes,historialdes,viajesHi);


    }
}