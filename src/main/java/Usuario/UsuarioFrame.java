package Usuario;
import Login.LoginFrame;
import Viaje.GenerarViajeFrame;
import Ruta.Ruta;
import Vehiculo.Vehiculo;
import Viaje.Viaje;
import Viaje.ViajeFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class UsuarioFrame extends JFrame {
    private JButton generarViajesButton;
    private JButton seguirViajesButton;
    private JPanel menuFrame;
    private JButton historialButton;
    private JButton salirButton;

    public UsuarioFrame(LinkedList<Ruta> listaRutas, LinkedList<Vehiculo> listaVeiculo, LinkedList<Viaje> listaViajes, LinkedList<Viaje>historial) {

        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(menuFrame);
        this.pack();
        this.setVisible(true);
        setSize(200, 200);
        this.setLocationRelativeTo(null);

        generarViajesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!listaRutas.isEmpty()){
                    new GenerarViajeFrame(listaRutas,listaVeiculo,listaViajes,historial);
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "No hay rutas disponibles", "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        seguirViajesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Viaje[] listaViajes1 = new Viaje[3];

                if (!listaViajes.isEmpty()){
                   int contador =1;
                    for (int i =0; i<listaViajes.size(); i++){
                       listaViajes1[i] = listaViajes.get(i);
                       listaViajes1[i].setId(contador);
                       contador++;
                    }
                    new ViajeFrame(listaViajes1,listaRutas,listaVeiculo,listaViajes,historial);
                    dispose();

                }else {
                    JOptionPane.showMessageDialog(null, "No se han encontado viajes pendientes", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        historialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!historial.isEmpty()){
                    dispose();
                    new Historial(listaRutas,listaVeiculo,listaViajes,historial).setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null, "No se han encontado viajes finalizados", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginFrame(listaRutas,listaVeiculo,listaViajes,historial);
            }
        });
    }


}
