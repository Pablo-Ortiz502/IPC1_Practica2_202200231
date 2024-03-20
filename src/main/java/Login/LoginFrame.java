package Login;

import Admin.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JPanel loginPane;
    private JButton adminButton;
    private JButton usuarioButton;

    public LoginFrame() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(loginPane);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String codigo = JOptionPane.showInputDialog("Introduzca el codigo del Paciente");
                boolean estado = false;
                if(codigo != null){
                    if (codigo.equals(Admin.getContra())){
                        System.out.println("Bienbenido");

                    }

                }


            }
        });
        usuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
