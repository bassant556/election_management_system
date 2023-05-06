/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package election.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java .util.AbstractCollection.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bassant
 */
public class main1 extends JFrame implements ActionListener{
//    JFrame frame;
    ImageIcon caricon;
    JLabel mylabel;
  JLabel l1=new JLabel("user name");
  JLabel l2=new JLabel("password");
    JLabel l3=new JLabel("password");

   JTextField f1=new JTextField();
   JPasswordField p1=new JPasswordField();
   JButton b1=new JButton("login");
   JButton b2=new JButton("cancel");
   String s[]={"Admin","Voter"};
   JComboBox j1=new JComboBox(s);
//   JLabel l6=new JLabel();

//    JLabel l1 =new JLabel ();
//    SwingProgressBarExample it = new SwingProgressBarExample();
    main1(){
        setTitle("election management system");
setLocation(400,200);
   caricon =new ImageIcon(this.getClass().getResource("online.jpg"));
   mylabel=new JLabel(caricon);
   mylabel.setSize(583,375);
  
  add(mylabel);
   
   l1.setBounds(180,150,100,30);
   mylabel. add(l1);
   l1.setForeground(Color.DARK_GRAY);
   f1.setBounds(250,150 ,150 ,30 );
    mylabel. add(f1);
    
    
     l2.setBounds(180,200,100,30);
   mylabel. add(l2);
   l1.setForeground(Color.DARK_GRAY);
   p1.setBounds(250,200 ,150 ,30 );
    mylabel. add(p1);
    b1.setBounds(190,250 ,90 ,40 );
     mylabel. add(b1);
   b2.setBounds(310,250,90,40);
    mylabel. add(b2);
    b1.addActionListener(this);
    b2.addActionListener(this);
     j1.setBounds(465, 10, 90, 40);
         mylabel. add(j1);

//     l6.setBounds(180, 40, 250, 20);
//    mylabel.add(l6);
//    l6.setForeground(Color.darkGray);
 setSize(583,375);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 
}
     public static void main(String[] args) {
               new main1();
                			
	}

     @Override
   public void actionPerformed(ActionEvent ae){
       if (ae.getSource()==b1){
           if(j1.getSelectedIndex()==-1){
               JOptionPane.showMessageDialog(this,"Admin or Voter? " );
               
           }else if(j1.getSelectedIndex()==0){
                String user = f1.getText();
           String pass = p1.getText();
           if(user.isEmpty()||pass.isEmpty()){
                              JOptionPane.showMessageDialog(this,"please fill empty fields" );

           }else{
               
                connection c = new connection();
               
               String query = "select * from login where username = '"+ user + "' and password = '"+ pass +"'";
               
                   
                    try {
                                     ResultSet  rs = c.s.executeQuery(query);

                        if (rs.next()){
                            new main4().setVisible(true);
                          this.dispose();
                            
                        } else{
                                                                                      JOptionPane.showMessageDialog(this,"wrong username or password" );

                            
                        }} catch (SQLException ex) {
                        Logger.getLogger(main1.class.getName()).log(Level.SEVERE, null, ex);
                    }
               
           }
  
       }else{
               String user = f1.getText();
           String pass = p1.getText();
                  connection c = new connection();
               
               String query = "select * from voters where name = '"+ user + "' and pass = '"+ pass +"'";
                 try {
                                     ResultSet  rs = c.s.executeQuery(query);

                        if (rs.next()){
                            int id=rs.getInt("id");
                            
                            new vote(id).setVisible(true);
                          this.dispose();
                          
                            
                        }else{
                                                          JOptionPane.showMessageDialog(this,"wrong username or password" );

                            
                        }       
                 
                 
                 
                 
                 } catch (SQLException ex) {
                        Logger.getLogger(main1.class.getName()).log(Level.SEVERE, null, ex);
                    }
               
           }
  
               
       
       }else if(ae.getSource()==b2){
           System.exit(0);
       }
   }
}

