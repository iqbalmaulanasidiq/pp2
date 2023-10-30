package pertemuan6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowInputDialog extends JFrame { // membuat class ShowInputDialog yang merupakan turunan dari JFrame

    public ShowInputDialog(){ // membuat fungsi ShowInputDialog
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // operasi penutupan frame
        this.setLayout(new FlowLayout()); // mengatur layout frame

        JButton button = new JButton("Input"); // membuat button dengan nama Input
        button.setBounds(130, 100, 100, 40); // mengatur posisi button

        button.addActionListener(new ActionListener() {// menambahkan action listener
            @Override
            public void actionPerformed(ActionEvent e) {// membuat fungsi action performed
                String nama = JOptionPane.showInputDialog(ShowInputDialog.this, "Masukkan nama anda", "Input", JOptionPane.INFORMATION_MESSAGE);// menampilkan pesan dialog
                if (nama != null){// jika nama tidak kosong
                    JOptionPane.showMessageDialog(ShowInputDialog.this, "Halo " + nama);// menampilkan pesan dialog
                }
            }
        });
        // menambahkan button ke frame
        this.add(button);
        this.setSize(400, 400);

    }
    // main method untuk menjalankan program
    public static void main (String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShowInputDialog s = new ShowInputDialog();
                s.setVisible(true);
            }
        });
    }

}
