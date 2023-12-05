package jenis_member;

// Modul 8 (Pertemuan 9) - Latihan 1

import java.awt.event.*;
import java.util.UUID;
import dao.JenisMemberDao;

// ActionListener untuk tombol simpan pada JenisMemberFrame
public class JenisMemberButtonSimpanActionListener implements ActionListener {
    // Frame JenisMember yang akan diatur oleh ActionListener ini
    private JenisMemberFrame jenisMemberFrame;
    // Objek JenisMemberDao untuk berinteraksi dengan database
    private JenisMemberDao jenisMemberDao;
    
    // Konstruktor untuk inisialisasi ActionListener dengan JenisMemberFrame dan JenisMemberDao
    public JenisMemberButtonSimpanActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao) {
        this.jenisMemberFrame = jenisMemberFrame;
        this.jenisMemberDao = jenisMemberDao;
    }
    
    // Method yang dipanggil ketika tombol simpan ditekan
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan nama dari JenisMemberFrame
        String nama = this.jenisMemberFrame.getNama();
        // Membuat objek JenisMember dengan ID acak dan nama yang diambil dari JenisMemberFrame
        JenisMember jenisMember = new JenisMember();
        jenisMember.setId(UUID.randomUUID().toString());
        jenisMember.setNama(nama);
        
        // Menambahkan JenisMember ke JenisMemberFrame
        this.jenisMemberFrame.addJenisMember(jenisMember);
        // Menyimpan JenisMember ke database menggunakan JenisMemberDao
        this.jenisMemberDao.insert(jenisMember);
    }
}