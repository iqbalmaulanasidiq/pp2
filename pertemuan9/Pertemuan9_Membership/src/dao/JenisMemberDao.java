package dao;

// Modul 8 (Pertemuan 9) - Latihan 1

// Import library untuk menyambungkan database dan fungsi lainnya
import db.MySqlConnection;  // Import koneksi ke database MySQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jenis_member.JenisMember;

// Deklarasi kelas JenisMemberDao
public class JenisMemberDao {
    // Method untuk memasukkan data JenisMember ke dalam database
    public int insert(JenisMember jenisMember) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            // Menyiapkan pernyataan SQL untuk melakukan penambahan data
            PreparedStatement statement = connection.prepareStatement("insert into jenis_member (id, nama) values (?, ?)");
            statement.setString(1, jenisMember.getId());
            statement.setString(2, jenisMember.getNama());
        
            // Melakukan eksekusi pernyataan SQL
            result = statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    // Method untuk memperbarui data JenisMember di dalam database berdasarkan ID
    public int update(JenisMember jenisMember) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            // Menyiapkan pernyataan SQL untuk melakukan pembaruan data
            PreparedStatement statement = connection.prepareStatement("update jenis_member set nama = ? where id = ?");
            statement.setString(1, jenisMember.getNama());
            statement.setString(2, jenisMember.getId());
        
            // Melakukan eksekusi pernyataan SQL
            result = statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    // Method untuk menghapus data JenisMember dari database berdasarkan ID
    public int delete(JenisMember jenisMember) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            // Menyiapkan pernyataan SQL untuk melakukan penghapusan data
            PreparedStatement statement = connection.prepareStatement("delete from jenis_member where id = ?");
            statement.setString(1, jenisMember.getId());
        
            // Melakukan eksekusi pernyataan SQL
            result = statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    // Method untuk mengambil semua data JenisMember dari database
    public List<JenisMember> findAll() {
        List<JenisMember> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            // Menyiapkan pernyataan SQL untuk mengambil semua data
            try(ResultSet resultSet = statement.executeQuery("select * from jenis_member");) {
                // Membaca hasil query dan memasukkan data ke dalam list
                while(resultSet.next()) {
                    JenisMember jenisMember = new JenisMember();
                    jenisMember.setId(resultSet.getString("id"));
                    jenisMember.setNama(resultSet.getString("nama"));
                    list.add(jenisMember);
                }
            }
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    } 
}
