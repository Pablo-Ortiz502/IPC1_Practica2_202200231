package Admin;

import HistorialClass.HistorialClass;
import Login.LoginFrame;
import Ruta.Ruta;
import Vehiculo.Vehiculo;
import Viaje.Viaje;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class AdminFrame extends JFrame {
    private JButton editarDistanciaButton;
    private JButton cargarButton;
    private JPanel taablaPane;
    private JPanel adminPane;
    private JButton regresarButton;
    private JTable rutasTable;
    private JScrollPane scrollPane;

    private DefaultTableModel tableModel;

    private LinkedList<Ruta>listaRutas;

    public AdminFrame(LinkedList<Ruta>listaRutas, LinkedList<Vehiculo> listaVeiculo, LinkedList<Viaje> listaViajes, LinkedList<HistorialClass>historial,LinkedList<HistorialClass> viajeHi) {

        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(adminPane);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        setSize(800, 300);
        this.listaRutas = listaRutas;

        if (!listaRutas.isEmpty()){
            String[] columnNames = {"id","Inicio","fin","distancia"};
            int contador=0;
            for (int i = 0; i< listaRutas.size(); i++){
                contador++;
            }
            String[][] datos1 = new String[contador][4];
            contador =0;
            for (int i = 0; i < listaRutas.size(); i++) {
                for (int j = 0; j < 5; j++) {

                    if(contador==0){datos1[i][j]= String.valueOf(listaRutas.get(i).getId());}

                    if(contador==1){datos1[i][j]= listaRutas.get(i).getInicio(); }

                    if(contador==2){datos1[i][j]=listaRutas.get(i).getFin();}

                    if(contador==3){datos1[i][j]=String.valueOf(listaRutas.get(i).getDistancia())+"Km";}



                    contador++;
                }
                contador = 0;
            }
            tableModel = new DefaultTableModel(datos1, columnNames);
            rutasTable.setModel(tableModel);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    setHorizontalAlignment(SwingConstants.CENTER);
                    return this;
                }
            };
            for (int i = 0; i < rutasTable.getColumnCount(); i++) {
                rutasTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            rutasTable.setEnabled(false);
        }

        cargarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int a = listaRutas.size()-1;

                for (int i =a;i >= 0; i--){
                    listaRutas.remove(i);

                }

                JFileChooser fileChooser = new JFileChooser();

                fileChooser.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));

                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File rutasCSV = fileChooser.getSelectedFile();

                    Ruta ruta;
                    String[] datos;


                    try (Scanner scCSV = new Scanner(rutasCSV)){
                        while (scCSV.hasNextLine()){
                            datos = scCSV.nextLine().split(",");
                            ruta = new Ruta(Integer.parseInt(datos[0]),datos[1],datos[2],Double.parseDouble(datos[3]));

                            listaRutas.add(ruta);

                        }
                    }catch (Exception b){
                        JOptionPane.showMessageDialog(null, "  Error al cargar archivo", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    String[] columnNames = {"id","Inicio","fin","distancia"};
                    int contador=0;
                    for (int i = 0; i< listaRutas.size(); i++){
                        contador++;
                    }
                    String[][] datos1 = new String[contador][4];
                    contador =0;
                    for (int i = 0; i < listaRutas.size(); i++) {
                        for (int j = 0; j < 5; j++) {

                            if(contador==0){datos1[i][j]= String.valueOf(listaRutas.get(i).getId());}

                            if(contador==1){datos1[i][j]= listaRutas.get(i).getInicio(); }

                            if(contador==2){datos1[i][j]=listaRutas.get(i).getFin();}

                            if(contador==3){datos1[i][j]=String.valueOf(listaRutas.get(i).getDistancia())+"Km";}



                            contador++;
                        }
                        contador = 0;
                    }
                    tableModel = new DefaultTableModel(datos1, columnNames);
                    rutasTable.setModel(tableModel);
                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {
                        @Override
                        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                            setHorizontalAlignment(SwingConstants.CENTER);
                            return this;
                        }
                    };
                    for (int i = 0; i < rutasTable.getColumnCount(); i++) {
                        rutasTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                    }
                    JOptionPane.showMessageDialog(null, "Rutats cargadas con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    rutasTable.setEnabled(false);
                }


            }
        });


        editarDistanciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFrame( listaRutas,  listaVeiculo, listaViajes, historial,viajeHi);

            }
        });
    }

}
