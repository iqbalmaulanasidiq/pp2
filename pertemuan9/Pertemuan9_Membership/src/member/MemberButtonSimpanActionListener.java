package member;

// Modul 8 (Pertemuan 9) - Latihan 1

import jenis_member.JenisMember;
import java.awt.event.*;
import java.util.UUID;
import dao.MemberDao;

// ActionListener untuk tombol simpan pada MemberFrame
public class MemberButtonSimpanActionListener implements ActionListener {
    // Frame Member yang akan diatur oleh ActionListener ini
    private MemberFrame memberFrame;
    // Objek MemberDao untuk berinteraksi dengan database
    private MemberDao memberDao;
    
    // Konstruktor untuk inisialisasi ActionListener dengan MemberFrame dan MemberDao
    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }
    
    // Method yang dipanggil ketika tombol simpan ditekan
    @Override
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan nama dari MemberFrame
        String nama = this.memberFrame.getNama();
        // Memeriksa apakah nilai nama kosong
        if(nama.isEmpty()) {
            this.memberFrame.showAlert("Nama Tidak Boleh Kosong");
        }
        else {
            // Jika nama tidak kosong, mendapatkan jenis member dari objek memberFrame
            JenisMember jenisMember = this.memberFrame.getJenisMember();
            // Membuat objek member dan mengatur nilai ID, nama, dan jenisMember
            Member member = new Member();
            member.setId(UUID.randomUUID().toString());
            member.setNama(nama);
            member.setJenisMember(jenisMember);

            // Menambahkan member ke objek memberFrame dan menyimpannya ke dalam database menggunakan memberDao
            this.memberFrame.addMember(member);
            this.memberDao.insert(member);
        }
    }
}