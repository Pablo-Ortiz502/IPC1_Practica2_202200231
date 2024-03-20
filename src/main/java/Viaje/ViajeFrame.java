package Viaje;

import Ruta.Ruta;
import Usuario.UsuarioFrame;
import Vehiculo.Vehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class ViajeFrame extends JFrame  implements Observer {
    private JButton todosButton;
    private JButton recargar1Button;
    private JButton recargar2Button;
    private JButton recargar3Button;
    private JProgressBar progressBar3;
    private JProgressBar progressBar2;
    private JProgressBar progressBar1;
    private JTextField distancia3TextField;
    private JTextField gas3TextField;
    private JTextField gas2TextField;
    private JTextField distancia2TextField;
    private JTextField distancia1TextField;
    private JTextField gas1TextField;
    private JButton viaje3Button;
    private JButton viaje2Button;
    private JButton viaje1Button;
    private JLabel tituloLabel;
    private JLabel inicio1Label;
    private JLabel final1Label;
    private JLabel inicio2Label;
    private JLabel final2Label;
    private JLabel inicio3Label;
    private JLabel final3Label;
    private JPanel viajesJpane;
    private JButton regresarButton;
    private JTextField tipoVtextField1;
    private JTextField tipoVtextField2;
    private JTextField tipoVtextField3;

    private Thread[] hilos;

    private int numero;
    private LinkedList<Viaje>listaViajes;


    public ViajeFrame(Viaje[] listaViajes1, LinkedList<Ruta> listaRutas, LinkedList<Vehiculo> listaVeiculo, LinkedList<Viaje> listaViajes, LinkedList<Viaje>historial) {



        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(viajesJpane);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        hilos = new Thread[3];
        this.listaViajes = listaViajes;
        setSize(800,400);

        gas1TextField.setEnabled(false);
        gas2TextField.setEnabled(false);
        gas3TextField.setEnabled(false);

        distancia1TextField.setEnabled(false);
        distancia2TextField.setEnabled(false);
        distancia3TextField.setEnabled(false);

        tipoVtextField1.setEnabled(false);
        tipoVtextField2.setEnabled(false);
        tipoVtextField3.setEnabled(false);

        viaje1Button.setEnabled(false);
        viaje2Button.setEnabled(false);
        viaje3Button.setEnabled(false);

        if(listaViajes.size() ==1){
            viaje1Button.setEnabled(true);
            inicio1Label.setText(listaViajes1[0].getInicio());
            final1Label.setText(listaViajes1[0].getFin());
            tipoVtextField1.setText(listaViajes1[0].getTipoVehiculo());
            distancia1TextField.setText(String.valueOf(listaViajes1[0].getDistancia()));
        }else
        if (listaViajes.size()==2){
            viaje1Button.setEnabled(true);
            inicio1Label.setText(listaViajes1[0].getInicio());
            final1Label.setText(listaViajes1[0].getFin());
            tipoVtextField1.setText(listaViajes1[0].getTipoVehiculo());
            distancia1TextField.setText(String.valueOf(listaViajes1[0].getDistancia()));
            viaje2Button.setEnabled(true);
            inicio2Label.setText(listaViajes1[1].getInicio());
            final2Label.setText(listaViajes1[1].getFin());
            tipoVtextField2.setText(listaViajes1[1].getTipoVehiculo());
            distancia2TextField.setText(String.valueOf(listaViajes1[1].getDistancia()));

        }else
        if(listaViajes.size() ==3){
            viaje1Button.setEnabled(true);
            inicio1Label.setText(listaViajes1[0].getInicio());
            inicio2Label.setText(listaViajes1[1].getInicio());
            inicio3Label.setText(listaViajes1[2].getInicio());
            viaje2Button.setEnabled(true);
            final1Label.setText(listaViajes1[0].getFin());
            final2Label.setText(listaViajes1[1].getFin());
            final3Label.setText(listaViajes1[2].getFin());
            viaje3Button.setEnabled(true);
            tipoVtextField1.setText(listaViajes1[0].getTipoVehiculo());
            tipoVtextField2.setText(listaViajes1[1].getTipoVehiculo());
            tipoVtextField3.setText(listaViajes1[2].getTipoVehiculo());
            distancia1TextField.setText(String.valueOf(listaViajes1[0].getDistancia()));
            distancia2TextField.setText(String.valueOf(listaViajes1[1].getDistancia()));
            distancia3TextField.setText(String.valueOf(listaViajes1[2].getDistancia()));
        }




        viaje1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viaje1Button.setEnabled(false); todosButton.setEnabled(false);

                 Date date = new Date();
                 listaViajes1[0].setFecha(date.toString());
                 historial.add(listaViajes1[0]);

                listaViajes1[0].addObserver(ViajeFrame.this::update);


                numero = 1;
                hilos[0] = new Thread(listaViajes1[0]);
                hilos[0].start();

            }
        });
        viaje2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viaje2Button.setEnabled(false); todosButton.setEnabled(false);

                Date date = new Date();
                listaViajes1[1].setFecha(date.toString());
                historial.add(listaViajes1[1]);


                listaViajes1[1].addObserver(ViajeFrame.this::update);
                numero = 2;
                hilos[1] = new Thread(listaViajes1[1]);
                hilos[1].start();

            }
        });
        viaje3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viaje3Button.setEnabled(false); todosButton.setEnabled(false);

                Date date = new Date();
                listaViajes1[2].setFecha(date.toString());
                historial.add(listaViajes1[2]);


                listaViajes1[2].addObserver(ViajeFrame.this::update);
                numero = 3;
                hilos[2] = new Thread(listaViajes1[2]);
                hilos[2].start();

            }
        });
        recargar1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        recargar2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        recargar3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



        todosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viaje1Button.setEnabled(false);
                viaje2Button.setEnabled(false);
                viaje3Button.setEnabled(false);
                todosButton.setEnabled(false);
                numero =0;
                Date date = new Date();
                for (int i = 0; i< listaViajes.size(); i++){

                    listaViajes1[i].setFecha(date.toString());
                    historial.add(listaViajes1[i]);


                    listaViajes1[i].addObserver(ViajeFrame.this::update);

                    hilos[i] = new Thread(listaViajes1[i]);
                    hilos[i].start();
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               new UsuarioFrame(listaRutas,listaVeiculo,listaViajes,historial);


            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

        Viaje viaje = (Viaje) o;
        int porcentaje = (int)arg;



        switch (viaje.getId()){ // Id solo de 1-3
            case 1:
                progressBar1.setValue(porcentaje);
                break;
            case 2:
                progressBar2.setValue(porcentaje);
                break;
            case 3:
                progressBar3.setValue(porcentaje);
                break;
            default:
                progressBar3.setValue(porcentaje);
                progressBar2.setValue(porcentaje);
                progressBar1.setValue(porcentaje);
                break;
        }

       if(porcentaje>=100){

            switch (viaje.getId()){ // Id solo de 1-3
                case 1:
                    for (int i =0;i<listaViajes.size();i++){
                        if(listaViajes.get(i).getId()==1){
                            listaViajes.remove(i);
                        }
                    }

                    break;
                case 2:
                    for (int i =0;i<listaViajes.size();i++){
                        if(listaViajes.get(i).getId()==2){
                            listaViajes.remove(i);
                        }
                    }
                    break;
                case 3:
                    for (int i =0;i<listaViajes.size();i++){
                        if(listaViajes.get(i).getId()==3){
                            listaViajes.remove(i);
                        }
                    }
                default:
                    break;
            }


            }

    }

}
