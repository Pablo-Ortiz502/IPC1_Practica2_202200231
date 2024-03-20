package Usuario;

import Ruta.Ruta;
import Vehiculo.Vehiculo;
import Viaje.Viaje;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Historial extends JFrame {

    private JTable hsitorialTable;
    private DefaultTableModel tableModel;
    private LinkedList<Viaje> historial;
    private JButton regresar;

    public Historial(LinkedList<Ruta> listaRutas, LinkedList<Vehiculo> listaVeiculo, LinkedList<Viaje> listaViajes, LinkedList<Viaje>historial){
        this.historial = historial;
        regresar = new JButton("Regresar");
        setTitle("Lista de Doctores");
        setSize(1000, 300);
        setLocationRelativeTo(null);
        String[] columnNames = {"Feecha","Inicio","fin","Tipo de Vhiculo","distancia"};
        int contador=0;
        for (int i = 0; i< this.historial.size(); i++){
            contador++;
        }
        String[][] datos = new String[contador][5];
        contador =0;
        for (int i = 0; i < this.historial.size(); i++) {
            for (int j = 0; j < 5; j++) {

                if(contador==0){datos[i][j]= this.historial.get(i).getFecha(); }

                if(contador==1){datos[i][j]= this.historial.get(i).getInicio(); }

                if(contador==2){datos[i][j]=this.historial.get(i).getFin();}

                if(contador==3){datos[i][j]=this.historial.get(i).getTipoVehiculo();}

                if(contador==4){datos[i][j]= String.valueOf(this.historial.get(i).getDistancia())+"Km";}


                contador++;
            }
            contador = 0;
        }
        tableModel = new DefaultTableModel(datos, columnNames);
        hsitorialTable = new JTable(tableModel);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);
                return this;
            }
        };
        for (int i = 0; i < hsitorialTable.getColumnCount(); i++) {
            hsitorialTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }



        hsitorialTable.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(hsitorialTable);
        add(scrollPane, BorderLayout.CENTER);
        add(regresar,BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new UsuarioFrame(listaRutas,listaVeiculo,listaViajes,historial);
                dispose();
            }
        });



    }
}