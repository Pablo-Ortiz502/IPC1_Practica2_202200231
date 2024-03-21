package Login;

import Admin.Admin;
import HistorialClass.HistorialClass;
import Ruta.Ruta;
import Usuario.UsuarioFrame;
import Vehiculo.Vehiculo;
import Viaje.Viaje;
import Admin.AdminFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class LoginFrame extends JFrame {

    private JPanel loginPane;
    private JButton adminButton;
    private JButton usuarioButton;

    public LoginFrame(LinkedList<Ruta> listaRutas, LinkedList<Vehiculo> listaVeiculo, LinkedList<Viaje> listaViajes, LinkedList<HistorialClass>historial,LinkedList<HistorialClass> viajeHi) {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(loginPane);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String codigo = JOptionPane.showInputDialog("Introduzca su codigo de Admin");
                if(codigo != null){
                    if (codigo.equals(Admin.getContra())){
                        dispose();
                        new AdminFrame(listaRutas,  listaVeiculo, listaViajes, historial,viajeHi);

                    }else {
                        JOptionPane.showMessageDialog(null, "Codigo incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });
        usuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UsuarioFrame(listaRutas,  listaVeiculo, listaViajes, historial,viajeHi);

            }
        });
    }
}
