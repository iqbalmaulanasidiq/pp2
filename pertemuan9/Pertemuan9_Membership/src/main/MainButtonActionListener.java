package main;

// Modul 8 (Pertemuan 9) - Latihan 1

// Mengimpor pustaka untuk event handling
import java.awt.event.*;

// Kelas yang mengimplementasikan antarmuka ActionListener
public class MainButtonActionListener implements ActionListener {
    // Variabel instance untuk mereferensikan objek MainFrame
    private MainFrame mainFrame;
    // Konstruktor dengan parameter MainFrame
    public MainButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
     // Metode yang diimplementasikan dari antarmuka ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        // Memeriksa apakah sumber event adalah tombol jenis member
        if(e.getSource() == mainFrame.getButtonJenisMember()) {
            // Memanggil metode showJenisMemberFrame() dari objek MainFrame
            mainFrame.showJenisMemberFrame();
        }
        // Jika sumber event bukan tombol jenis member
        else {
            // Memanggil metode showMemberFrame() dari objek MainFrame
            mainFrame.showMemberFrame();
        }
    }
}