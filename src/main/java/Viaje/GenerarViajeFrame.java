package Viaje;
import HistorialClass.HistorialClass;
import Login.LoginFrame;
import Ruta.Ruta;
import Usuario.UsuarioFrame;
import Vehiculo.Vehiculo;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class GenerarViajeFrame extends JFrame {
    private JComboBox inicioComboBox;
    private JComboBox finalComboBox;
    private JComboBox vehiculoComboBox;
    private JButton viajesButton;
    private JPanel viajesPane;
    private JButton regresarButton;

    private LinkedList<Viaje> listaViajes;
    private LinkedList<Ruta> listaRuta;

    public LinkedList<Vehiculo> listaVehiculo;

    private int count;




    public GenerarViajeFrame(LinkedList<Ruta> listaRutas, LinkedList<Vehiculo> listaVeiculo, LinkedList<Viaje> listaViajes, LinkedList<HistorialClass>historial,LinkedList<HistorialClass> viajeHi) {

        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(viajesPane);
        this.pack();
        this.setVisible(true);
        setSize(225, 250);
        this.setLocationRelativeTo(null);
        this.listaViajes = listaViajes;
        this.listaRuta = listaRutas;
        this.listaVehiculo = listaVeiculo;
        count =0;


      DefaultComboBoxModel model = new DefaultComboBoxModel(inicioDsponible());
      inicioComboBox.setModel(model);

      DefaultComboBoxModel model2 = new DefaultComboBoxModel(tipoDisponible());
      vehiculoComboBox.setModel(model2);

        inicioComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultComboBoxModel model1 = new DefaultComboBoxModel(finDisponible());
                finalComboBox.setModel(model1);

            }
        });

        viajesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String inicio= (String) inicioComboBox.getSelectedItem();
                String fin = (String) finalComboBox.getSelectedItem();
                String tipo = (String) vehiculoComboBox.getSelectedItem();
                int id =  count++;

                if ( fin==null){
                    JOptionPane.showMessageDialog(null, "Llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);

                }else {
                    if (listaViajes.size()>=3){
                        JOptionPane.showMessageDialog(null, "Limite de viajes alcanzado", "Error", JOptionPane.ERROR_MESSAGE);
                    }else {



                        for (int i =0;i< listaVehiculo.size();i++){
                            if (tipo.equals(listaVeiculo.get(i).getTipo())){
                                listaVeiculo.get(i).setOcupado(true);
                            }
                        }
                            DefaultComboBoxModel model2 = new DefaultComboBoxModel(tipoDisponible());
                            vehiculoComboBox.setModel(model2);

                        for (int i =0;i<listaRutas.size();i++){
                            if (inicio.equals(listaRutas.get(i).getInicio()) && fin.equals(listaRutas.get(i).getFin())){
                                Viaje viaje = new Viaje(id,inicio,fin,tipo,listaRutas.get(i).getDistancia(),"");
                                HistorialClass historialClass = new HistorialClass(inicio,fin,tipo,listaRutas.get(i).getDistancia(),"");
                                listaViajes.add(viaje);
                                viajeHi.add(historialClass);
                            }
                        }

                        try {

                            FileOutputStream fos = new FileOutputStream("Viajes.ser");
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(viajeHi);
                            oos.close();
                        }catch (IOException ex){
                            throw new RuntimeException(ex);
                        }



                        JOptionPane.showMessageDialog(null, "Viaje creado", "Exito", JOptionPane.INFORMATION_MESSAGE);

                    }

                }



            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UsuarioFrame(listaRutas,listaVehiculo,listaViajes,historial,viajeHi);
                dispose();
            }
        });
    }

    private String[] inicioDsponible(){
        int contador =0;

        for (int i =0; i<listaRuta.size();i++){
                contador++;
        }
        String[] inicioDisponibles = new String[contador];
        contador =0;
        for(int o = 0; o<listaRuta.size();o++){
                inicioDisponibles[contador] = listaRuta.get(o).getInicio();
                contador++;
        }

        Set<String> set = new LinkedHashSet<>(Arrays.asList(inicioDisponibles));
        String[] resultado = set.toArray(new String[0]);

        return resultado;
    }

    private String[] finDisponible(){
        String inicio = (String) inicioComboBox.getSelectedItem();
        int contador =0;

        for (int i =0; i<listaRuta.size();i++){
            if(listaRuta.get(i).getInicio().equals(inicio)){
                contador++;
            }
        }
        String[] finDisponibles = new String[contador];
        contador =0;
        for(int o = 0; o<listaRuta.size();o++){
            if (listaRuta.get(o).getInicio().equals(inicio)){
                finDisponibles[contador] = listaRuta.get(o).getFin();
                contador++;
            }
        }



        return finDisponibles;
    }

    private String[] tipoDisponible() {
        int contador =0;
        for (int i=0; i<listaVehiculo.size();i++){
            if(!listaVehiculo.get(i).isOcupado()){
                contador++;
            }
        }
        String[] tipoDisponibles = new String[contador];
            contador =0;
            for(int o = 0; o<listaVehiculo.size();o++){
                if (!listaVehiculo.get(o).isOcupado()){
                    tipoDisponibles[contador] = listaVehiculo.get(o).getTipo();
                    contador++;
                }
            }

        return tipoDisponibles;
    }

}
