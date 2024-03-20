package Admin;
import Ruta.Ruta;
import Vehiculo.Vehiculo;

import java.util.LinkedList;

public class Admin {

   private static String nombre = "Pablo";

   private static String contra = "1234";


   public static String getNombre() {
      return nombre;
   }


  public static LinkedList<Vehiculo> listaVehiculo = new LinkedList<Vehiculo>();;


   public static LinkedList<Vehiculo> getListaVehiculo() {

      Vehiculo vehiculo1 = new Vehiculo(6,"moto1",false);
      Vehiculo vehiculo2 = new Vehiculo(6,"moto2",false);
      Vehiculo vehiculo3 = new Vehiculo(6,"moto3",false);
      Vehiculo vehiculo4 = new Vehiculo(10,"carro1",false);
      Vehiculo vehiculo5 = new Vehiculo(10,"carro2",false);
      Vehiculo vehiculo6 = new Vehiculo(10,"carro3",false);
      Vehiculo vehiculo7 = new Vehiculo(12,"premium1",false);
      Vehiculo vehiculo8 = new Vehiculo(12,"premium2",false);
      Vehiculo vehiculo9 = new Vehiculo(12,"premium3",false);

      listaVehiculo.add(vehiculo1);
      listaVehiculo.add(vehiculo2);
      listaVehiculo.add(vehiculo3);
      listaVehiculo.add(vehiculo4);
      listaVehiculo.add(vehiculo5);
      listaVehiculo.add(vehiculo6);
      listaVehiculo.add(vehiculo7);
      listaVehiculo.add(vehiculo8);
      listaVehiculo.add(vehiculo9);

      return listaVehiculo;
   }




   public static String getContra() {
      return contra;
   }
}
