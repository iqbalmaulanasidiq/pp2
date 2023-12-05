package member;

// Modul 8 (Pertemuan 9) - Latihan 1

import javax.swing.table.*;
import java.util.List;

public class MemberTableModel extends AbstractTableModel {
    // Array untuk menyimpan nama-nama kolom tabel
    private String[] columnNames = {"Nama", "Jenis Member"};
    // List untuk menyimpan data anggota (objek Member)
    private List<Member> data;
    
    // Konstruktor kelas yang menerima parameter berupa List<Member> untuk inisialisasi data
    public MemberTableModel(List<Member> data) {
        this.data = data;
    }
    
    // Mengimplementasikan metode dari kelas induk AbstractTableModel untuk mendapatkan jumlah kolom
    public int getColumnCount() {
        return columnNames.length;
    }
    
    // Mengimplementasikan metode dari kelas induk AbstractTableModel untuk mendapatkan jumlah baris
    public int getRowCount() {
        return data.size();
    }
    
    // Mengimplementasikan metode dari kelas induk AbstractTableModel untuk mendapatkan nama kolom
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    // Mengimplementasikan metode dari kelas induk AbstractTableModel untuk mendapatkan nilai pada sel tertentu
    public Object getValueAt(int row, int col) {
        // Mendapatkan objek Member pada baris tertentu
        Member rowItem = data.get(row);
        String value = "";
        
        // Switch case untuk menentukan nilai sesuai dengan kolom
        switch(col) {
            case 0: 
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getJenisMember().getNama();
        }
        return value;
    }
    
    // Mengimplementasikan metode dari kelas induk AbstractTableModel untuk menentukan apakah sel dapat diubah isinya
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    // Metode untuk menambahkan data Member ke dalam tabel
    public void add(Member value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}