// Package ini untuk membuat setter dan getter pada jenis member
package jenis_member;

// Modul 8 (Pertemuan 9) - Latihan 1

// Deklarasi kelas JenisMember
public class JenisMember {
    // Atribut id untuk menyimpan identitas jenis member
    private String id;
    // Atribut nama untuk menyimpan nama jenis member
    private String nama;
    
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
}