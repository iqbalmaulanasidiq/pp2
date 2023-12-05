// Package ini untuk membuat setter dan getter pada member
package member;

// Modul 8 (Pertemuan 9) - Latihan 1

// Mengimpor kelas JenisMember dari package jenis_member untuk digunakan di dalam kelas ini
import jenis_member.JenisMember;

// Deklarasi kelas Member
public class Member {
    // Atribut id untuk menyimpan identitas member
    public String id;
    // Atribut nama untuk menyimpan nama member
    public String nama;
    // Atribut jenisMember untuk menyimpan objek JenisMember yang menentukan jenis member
    private JenisMember jenisMember;

    // Method untuk mengatur nilai id
    public void setId(String id) {
        this.id = id;
    }

    // Method untuk mendapatkan nilai id
    public String getId() {
        return id;
    }
    
    // Method untuk mengatur nilai nama
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    // Method untuk mendapatkan nilai nama
    public String getNama() {
        return nama;
    }

    // Method untuk mengatur jenis member dengan objek JenisMember yang diberikan
    public void setJenisMember(JenisMember jenisMember) {
        this.jenisMember = jenisMember;
    }

    // Method untuk mendapatkan jenis member dengan objek JenisMember yang diberikan
    public JenisMember getJenisMember() {
        return jenisMember;
    }
}