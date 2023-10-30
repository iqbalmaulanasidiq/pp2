package pertemuan6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ShowConfirmDialog extends  JFrame { // membuat class ShowConfirmDialog yang merupakan turunan dari JFrame
    public ShowConfirmDialog(){ // membuat fungsi ShowConfirmDialog
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// operasi penutupan frame
        this.setLayout(new FlowLayout());// mengatur layout frame

        JButton button = new JButton("Exit");// membuat button dengan nama Exit
        button.setBounds(130, 100, 100, 40);// mengatur posisi button

        button.addActionListener(new ActionListener() { // menambahkan action listener
            @Override
            public void actionPerformed(ActionEvent e) { // membuat fungsi action performed
                int confirmation = JOptionPane.showConfirmDialog(ShowConfirmDialog.this, "Apakah anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);// menampilkan pesan dialog
                if (confirmation == JOptionPane.YES_OPTION){ // jika menekan tombol yes
                    System.exit(0); // keluar dari program
                }else { // jika menekan tombol no
                    JOptionPane.showMessageDialog(ShowConfirmDialog.this, "Anda menekan tombol no");// menampilkan pesan dialog
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
                ShowConfirmDialog s = new ShowConfirmDialog();
                s.setVisible(true);
            }
        });
    }

}
