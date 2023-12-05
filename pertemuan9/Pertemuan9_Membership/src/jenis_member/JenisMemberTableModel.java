package jenis_member;

// Modul 8 (Pertemuan 9) - Latihan 1

import javax.swing.table.*;
import java.util.List;

public class JenisMemberTableModel extends AbstractTableModel {
    // Array yang berisi nama kolom tabel
    private String[] columnNames = {"Nama"};
    // List yang berisi data JenisMember yang akan ditampilkan di tabel
    private List<JenisMember> data;
    
    // Konstruktor kelas JenisMemberTableModel
    public JenisMemberTableModel(List<JenisMember> data) {
        this.data = data;
    }
    
    // Mengembalikan jumlah kolom dalam tabel
    public int getColumnCount() {
        return columnNames.length;
    }
    
    // Mengembalikan jumlah baris dalam tabel sesuai dengan jumlah data JenisMember
    public int getRowCount() {
        return data.size();
    }
    
    // Mengembalikan nama kolom pada indeks kolom tertentu
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    // Mengembalikan nilai yang akan ditampilkan pada sel tabel pada baris dan kolom tertentu
    public Object getValueAt(int row, int col) {
        JenisMember rowItem = data.get(row);
        String value = "";
        
        // Switch case untuk menentukan nilai yang akan ditampilkan berdasarkan indeks kolom
        switch(col) {
            case 0: 
                value = rowItem.getNama();
                break;
        }
        return value;
    }
    
    // Mendefinisikan apakah sel tabel dapat di-edit (dalam hal ini, tidak bisa di-edit)
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    // Menambahkan data JenisMember ke tabel dan memberi tahu tampilan untuk memperbarui dirinya
    public void add(JenisMember value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}