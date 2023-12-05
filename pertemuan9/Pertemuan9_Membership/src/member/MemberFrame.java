package member;

// Modul 8 (Pertemuan 9) - Latihan 1

import jenis_member.JenisMember;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import dao.MemberDao;
import dao.JenisMemberDao;

public class MemberFrame extends JFrame {
    // List jenisMemberList untuk menyimpan data jenis member dari database
    private List<JenisMember> jenisMemberList;
    // List memberList untuk menyimpan data member dari database
    private List<Member> memberList;
    // JTextField untuk input nama
    private JTextField textFieldNama;
    // MemberTableModel untuk mengatur model tabel
    private MemberTableModel tableModel;
    // JComboBox untuk mengatur jenis member
    private JComboBox comboJenis;
    // MemberDao untuk mengakses data member dari database
    private MemberDao memberDao;
    // JenisMemberDao untuk mengakses data jenis member dari database
    private JenisMemberDao jenisMemberDao;
    
    public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
        // Mengatur operasi penutupan frame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.memberDao = memberDao;
        this.jenisMemberDao = jenisMemberDao;
        
        // Mengambil daftar member dan jenis member dari database
        this.memberList = memberDao.findAll();
        this.jenisMemberList = jenisMemberDao.findAll();
        
        // Label untuk input nama
        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15, 40, 350, 10);
        
        // JTextField untuk memasukkan nama
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);
        
        // Membuat label dan combo box untuk Jenis Member
        JLabel labelJenis = new JLabel("Jenis Member: ");
        labelJenis.setBounds(15, 100, 350, 10);
        
        comboJenis = new JComboBox();
        comboJenis.setBounds(15, 120, 150, 30);
        
        // Tombol untuk menyimpan data jenis member
        JButton button = new JButton("Simpan");
        button.setBounds(15, 160, 100, 40);
        
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 220, 350, 200);
        
        // Mengatur model tabel dengan MemberTableModel
        tableModel = new MemberTableModel(memberList);
        table.setModel(tableModel);
        
        // Menggunakan actionListener dari tombol simpan
        MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this, memberDao);
        
        button.addActionListener(actionListener);
        
        // Menambahkan komponen-komponen ke frame
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(labelJenis);
        this.add(comboJenis);
        this.add(scrollableTable);
        
        // Mengatur ukuran dan layout frame
        this.setSize(400, 500);
        this.setLayout(null);
    }
    
    // Mengisi combo box Jenis Member dengan data dari database
    public void populateComboJenis() {
        this.jenisMemberList = this.jenisMemberDao.findAll();
        comboJenis.removeAllItems();
        for(JenisMember jenisMember : this.jenisMemberList) {
            comboJenis.addItem(jenisMember.getNama());
        }
    }
    
    // Mendapatkan nilai dari input field Nama
    public String getNama() {
        return textFieldNama.getText();
    }
    
    // Mendapatkan jenis member yang dipilih dari combo box
    public JenisMember getJenisMember() {
        return jenisMemberList.get(comboJenis.getSelectedIndex());
    }
    
    // Menambahkan data member ke dalam tabel
    public void addMember(Member member) {
        tableModel.add(member);
        textFieldNama.setText("");
    }
    
    // Menampilkan pesan peringatan menggunakan JOptionPane
    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}