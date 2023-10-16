/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan2;

import javax.swing.*;
import java.awt.event.*;


/**
 *
 * @author Iqbal Maulana Sidiq
 */
public class ButtonEventSwing extends JFrame {
    public ButtonEventSwing(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel label =new JLabel("Hello World");
        label.setBounds(130,40,400,10);
        
        JButton button = new JButton("Klik");
        button.setBounds(130,100,100,40);
        
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                label.setText("hello Pemrograman 2");
            }
        });
        
        this.add(button);
        this.add(label);
        
        this.setSize(400,500);
        this.setLayout(null);
    }
    
    public static void main(String[]args){
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run(){
                ButtonEventSwing b = new ButtonEventSwing();
                b.setVisible(true);
            }
        });
    }
    
}
