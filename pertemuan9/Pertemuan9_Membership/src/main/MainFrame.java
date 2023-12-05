package main;

// Modul 8 (Pertemuan 9) - Latihan 1

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import jenis_member.JenisMemberFrame;
import member.MemberFrame;
import dao.*;

public class MainFrame extends JFrame {
    // List untuk melakukan manajemen dan membuka frame, serta mengakses data dari database
    private JenisMemberFrame jenisMemberFrame;
    private MemberFrame memberFrame;
    private JButton buttonJenisMember;
    private JButton buttonMember;
    private JenisMemberDao jenisMemberDao;
    private MemberDao memberDao;
    
    // Konstruktor kelas MainFrame
    public MainFrame() {
        // Mengatur operasi default saat tombol close di klik
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Mengatur ukuran frame
        this.setSize(400, 500);
        
        // Inisialisasi objek dao untuk jenis member dan member
        this.jenisMemberDao = new JenisMemberDao();
        this.memberDao = new MemberDao();
        
        // Inisialisasi frame jenis member dan member
        this.jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        this.memberFrame = new MemberFrame(memberDao, jenisMemberDao);
        
        // Mengatur layout frame menggunakan FlowLayout
        this.setLayout(new FlowLayout());
        // Membuat objek listener untuk menangani aksi tombol
        MainButtonActionListener actionListener = new MainButtonActionListener(this);
        
        // Membuat tombol untuk membuka frame jenis member dan member
        this.buttonJenisMember = new JButton("Jenis Member");
        this.buttonMember = new JButton("Member");
        
        // Menambahkan listener ke tombol-tombol
        this.buttonJenisMember.addActionListener(actionListener);
        this.buttonMember.addActionListener(actionListener);
        
        // Menambahkan tombol-tombol ke frame
        this.add(buttonJenisMember);
        this.add(buttonMember);
    }
    
    // Getter untuk tombol jenis member
    public JButton getButtonJenisMember() {
        return buttonJenisMember;
    }
    
    // Getter untuk tombol member
    public JButton getButtonMember() {
        return buttonMember;
    }
    
    // Menampilkan frame jenis member
    public void showJenisMemberFrame() {
        if (jenisMemberFrame == null) {
            jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        }
        jenisMemberFrame.setVisible(true);
    }

    // Menampilkan frame member
    public void showMemberFrame() {
        if (memberFrame == null) {
            memberFrame = new MemberFrame(memberDao, jenisMemberDao);
        }
        // Mengisi combo box jenis member di frame member
        memberFrame.populateComboJenis();
        memberFrame.setVisible(true);
    }

    // Metode main untuk menjalankan aplikasi Swing    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }
        });
    }
}