package PertemuanII;
// Latihan 4

import java.awt.event.*;
import javax.swing.*;

public class BiodataApp extends JFrame {
    public BiodataApp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(30, 40, 100, 10);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(130, 40, 200, 30);

        JLabel labelNomorTelepon = new JLabel("Nomor Telepon:");
        labelNomorTelepon.setBounds(30, 80, 100, 10);

        JTextField textFieldNomorTelepon = new JTextField();
        textFieldNomorTelepon.setBounds(130, 80, 200, 30);

        JButton button = new JButton("Klik");
        button.setBounds(30, 120, 150, 40);

        JTextArea txtBiodata = new JTextArea("");
        txtBiodata.setEditable(false);
        txtBiodata.setBounds(30, 180, 300, 200);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String nomorTelepon = textFieldNomorTelepon.getText();
                if(!nama.isEmpty() && !nomorTelepon.isEmpty()) {
                    String biodata = "Nama: " + nama + "\nNomor Telepon: " + nomorTelepon + "\n";
                    txtBiodata.append(biodata);
                    txtBiodata.append("===================================\n");
                    textFieldNama.setText("");
                    textFieldNomorTelepon.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Silahkan isi semua kolom.");
                }
            }
        });

        this.add(labelNama);
        this.add(labelNomorTelepon);
        this.add(textFieldNama);
        this.add(textFieldNomorTelepon);
        this.add(button);
        this.add(txtBiodata);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BiodataApp b = new BiodataApp();
                b.setVisible(true);
            }
        });
    }
}
