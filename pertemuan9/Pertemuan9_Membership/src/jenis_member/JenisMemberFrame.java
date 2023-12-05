package jenis_member;

// Modul 8 (Pertemuan 9) - Latihan 1

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import dao.JenisMemberDao;

public class JenisMemberFrame extends JFrame {
    // List jenisMemberList untuk menyimpan data jenis member dari database
    private List<JenisMember> jenisMemberList;
    // JTextField untuk input nama
    private JTextField textFieldNama;
    // JenisMemberTableModel untuk mengatur model tabel
    private JenisMemberTableModel tableModel;
    // JenisMemberDao untuk mengakses data jenis member dari database
    private JenisMemberDao jenisMemberDao;
    
    // Konstruktor JenisMemberFrame, menerima JenisMemberDao sebagai parameter
    public JenisMemberFrame(JenisMemberDao jenisMemberDao) {
        this.jenisMemberDao = jenisMemberDao;
        // Mengambil semua data jenis member dari database
        this.jenisMemberList = jenisMemberDao.findAll();
        // Mengatur operasi penutupan frame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Label untuk input nama
        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15, 40, 350, 10);
        
        // JTextField untuk memasukkan nama
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);
        
        // Tombol untuk menyimpan data jenis member
        JButton button = new JButton("Simpan");
        button.setBounds(15, 100, 100, 40);
        
        // Tabel untuk menampilkan data jenis member
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 150, 350, 200);
        
        // Mengatur model tabel dengan JenisMemberTableModel
        tableModel = new JenisMemberTableModel(jenisMemberList);
        table.setModel(tableModel);
        
        // Menggunakan actionListener dari tombol simpan
        JenisMemberButtonSimpanActionListener actionListener = new JenisMemberButtonSimpanActionListener(this, jenisMemberDao);
        
        button.addActionListener(actionListener);
        
        // Menambahkan komponen ke frame
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);
        
        // Mengatur ukuran dan layout frame
        this.setSize(400, 500);
        this.setLayout(null);
    }
    
    // Metode untuk mendapatkan nilai dari input nama
    public String getNama() {
        return textFieldNama.getText();
    }
    
    // Metode untuk menambahkan data jenis member ke dalam tabel
    public void addJenisMember(JenisMember jenisMember) {
        tableModel.add(jenisMember);
        textFieldNama.setText("");
    }
}