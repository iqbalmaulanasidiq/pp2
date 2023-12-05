// Package ini untuk menempatkan akses seluruh data objek di dalam database
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
import member.Member;
import jenis_member.JenisMember;

// Deklarasi kelas MemberDao
public class MemberDao {
    // Method untuk memasukkan data member ke dalam database
    public int insert(Member member) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            // Menyiapkan pernyataan SQL untuk melakukan penambahan data member
            PreparedStatement statement = connection.prepareStatement("insert into member (id, nama, jenis_member_id) values (?, ?, ?)");
            statement.setString(1, member.getId());
            statement.setString(2, member.getNama());
            statement.setString(3, member.getJenisMember().getId());
        
            // Melakukan eksekusi pernyataan SQL
            result = statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method untuk memperbarui data member di dalam database
    public int update(Member member) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            // Menyiapkan pernyataan SQL untuk melakukan pembaruan data member
            PreparedStatement statement = connection.prepareStatement("update member set nama = ?, jenis_member_id = ? where id = ?");
            statement.setString(1, member.getNama());
            statement.setString(2, member.getJenisMember().getId());
            statement.setString(3, member.getId());
        
            // Melakukan eksekusi pernyataan SQL
            result = statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    // Method untuk menghapus data member dari database
    public int delete(Member member) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            // Menyiapkan pernyataan SQL untuk melakukan penghapusan data member
            PreparedStatement statement = connection.prepareStatement("delete from member where id = ?");
            statement.setString(1, member.getId());
        
            // Melakukan eksekusi pernyataan SQL
            result = statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    // Method untuk mengambil semua data member dari database
    public List<Member> findAll() {
        List<Member> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            // Menyiapkan pernyataan SQL untuk mengambil semua data member beserta jenis_member yang terkait
            try (ResultSet resultSet = statement.executeQuery("select member.id, member.nama, jenis_member.id AS jenis_member_id, jenis_member.nama AS jenis_member_nama " + 
            "from member join jenis_member on jenis_member.id = member.jenis_member_id");) {
                while(resultSet.next()) {
                    // Membaca hasil query dan memasukkan data ke dalam list
                    Member member = new Member();
                    member.setId(resultSet.getString("id"));
                    member.setNama(resultSet.getString("nama"));
                    
                    // Membuat objek JenisMember untuk menampung data jenis_member yang terkait
                    JenisMember jenisMember = new JenisMember();
                    jenisMember.setId(resultSet.getString("jenis_member_id"));
                    jenisMember.setNama(resultSet.getString("jenis_member_nama"));
                    
                    // Menghubungkan objek JenisMember dengan objek Member
                    member.setJenisMember(jenisMember);
                    
                    // Menambahkan objek Member ke dalam list
                    list.add(member);
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
