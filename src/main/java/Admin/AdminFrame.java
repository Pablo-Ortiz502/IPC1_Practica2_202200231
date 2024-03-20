package Admin;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AdminFrame extends JFrame {
    private JButton editarDistanciaButton;
    private JButton cargarButton;
    private JPanel taablaPane;
    private JPanel adminPane;
    private JButton regresarButton;

    public AdminFrame() {

        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(adminPane);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        setSize(1000, 300);
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                JFileChooser fileChooser = new JFileChooser();

                fileChooser.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));

                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
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

            }
        });
    }
}
