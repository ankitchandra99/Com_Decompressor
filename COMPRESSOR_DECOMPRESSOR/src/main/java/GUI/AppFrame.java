/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import comp_decomp.compressor;
import comp_decomp.decompressor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import javax.swing.JTextField;
/**
 *
 * @author ANKIT CHANDRA
 */
public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;
    JTextField s;

    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.setTitle("Compressor & Decompressor");
        compressButton=new JButton("Select file to compress");
        compressButton.setLayout(null);
        compressButton.setSize(100, 50);
        compressButton.setBounds(50, 100, 200, 50);
        compressButton.setBackground(Color.RED);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select File To Decompress");
        decompressButton.setLayout(null);
        decompressButton.setSize(100, 50);
        decompressButton.setBounds(500, 100, 200, 50);
        s=new JTextField();
        s.setLocation(500,50);
        s.setSize(100,50);
        this.add(s);
        decompressButton.setBackground(Color.GREEN);
        decompressButton.addActionListener(this);
        
        

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000, 500);
        this.getContentPane().setBackground(Color.BLACK);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);

                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());

                }

            }

        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    
                    decompressor.method(file,s.getText());
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());

                }
            }

        }
    }
}

