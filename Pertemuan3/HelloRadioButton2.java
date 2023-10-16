package Pertemuan3;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HelloRadioButton2 extends JFrame {
    private DefaultTableModel tableModel;
    private JTable jTable;
    private int selectedRow = -1;

    public HelloRadioButton2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama : ");
        labelInput.setBounds(15, 40, 350, 10);

        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);

        JLabel labelInput1 = new JLabel("Nomor HP : ");
        labelInput1.setBounds(15, 95, 350, 10);

        JTextField textField1 = new JTextField();
        textField1.setBounds(15, 110, 350, 30);

        JLabel labelRadio = new JLabel("Jenis Kelamin");
        labelRadio.setBounds(15, 130, 350, 10);

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15, 145, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 175, 350, 30);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 205, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JButton buttonTambah = new JButton("Simpan");
        buttonTambah.setBounds(15, 240, 100, 40);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(125, 240, 100, 40);

        JButton buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(235, 240, 100, 40);

        // Create a table model with columns
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nama");
        tableModel.addColumn("Nomor HP");
        tableModel.addColumn("Jenis Kelamin");
        tableModel.addColumn("WNA");

        jTable = new JTable(tableModel);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(15, 290, 350, 200);

        buttonTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                } else if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }

                String nama = textField.getText();
                String noHp = textField1.getText();
                String wnaStatus = checkBox.isSelected() ? "Ya" : "Bukan";

                // Add data to the table model
                tableModel.addRow(new Object[]{nama, noHp, jenisKelamin, wnaStatus});

                textField.setText("");
                textField1.setText("");
                radioButton1.setSelected(true);
                checkBox.setSelected(false);
                
                JOptionPane.showMessageDialog(null, "Data telah ditambahkan.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedRow >= 0) {
                    String jenisKelamin = "";
                    if (radioButton1.isSelected()) {
                        jenisKelamin = radioButton1.getText();
                    } else if (radioButton2.isSelected()) {
                        jenisKelamin = radioButton2.getText();
                    }

                    String nama = textField.getText();
                    String noHp = textField1.getText();
                    String wnaStatus = checkBox.isSelected() ? "Ya" : "Bukan";

                    // Update data in the table model
                    tableModel.setValueAt(nama, selectedRow, 0);
                    tableModel.setValueAt(noHp, selectedRow, 1);
                    tableModel.setValueAt(jenisKelamin, selectedRow, 2);
                    tableModel.setValueAt(wnaStatus, selectedRow, 3);

                    textField.setText("");
                    textField1.setText("");
                    radioButton1.setSelected(true);
                    checkBox.setSelected(false);
                    selectedRow = -1; // Reset selected row
                    
                    JOptionPane.showMessageDialog(null, "Data telah diperbarui.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        buttonHapus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedRow >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION);
                    
                    if (confirm == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                        selectedRow = -1; // Reset selected row
                        
                        JOptionPane.showMessageDialog(null, "Data telah dihapus.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        jTable.getSelectionModel().addListSelectionListener(e -> {
            selectedRow = jTable.getSelectedRow();
            if (selectedRow >= 0) {
                textField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                textField1.setText(tableModel.getValueAt(selectedRow, 1).toString());
                String jenisKelamin = tableModel.getValueAt(selectedRow, 2).toString();
                if (jenisKelamin.equals("Laki-Laki")) {
                    radioButton1.setSelected(true);
                } else if (jenisKelamin.equals("Perempuan")) {
                    radioButton2.setSelected(true);
                }
                String wnaStatus = tableModel.getValueAt(selectedRow, 3).toString();
                checkBox.setSelected(wnaStatus.equals("Ya"));
            }
        });

        this.add(buttonTambah);
        this.add(buttonUpdate);
        this.add(buttonHapus);
        this.add(textField);
        this.add(textField1);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(labelInput);
        this.add(labelInput1);
        this.add(jScrollPane);

        this.setSize(400, 600);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloRadioButton2 h = new HelloRadioButton2();
                h.setVisible(true);
            }
        });
    }
}
