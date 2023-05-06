/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package election.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author bassant
 */
public class main4 extends JFrame implements ActionListener {
     ImageIcon caricon;
    JLabel mylabel,back1;
    ImageIcon back;
    
   JButton b1=new JButton("back");
        JButton b2=new JButton("candidates");
            JButton b3=new JButton("voters");
                JButton b4=new JButton("results");
     main4(){
setLocation(400,200);
   caricon =new ImageIcon(this.getClass().getResource("vote3.jpg"));
   mylabel=new JLabel(caricon);
   mylabel.setSize(564,367);
  
  add(mylabel);
  
  
  
  
  b1.setBounds(20, 250, 150,30);
  mylabel.add(b1);
  
    setSize(583,375);
    setVisible (true);
//    b1.setBounds(10,60,150,30);
//    mylabel.add(b1);
//    b1.addActionListener( this);
     b2.setBounds(20,40,150,30);
    mylabel.add(b2);
        b2.addActionListener(this);

      b3.setBounds(20,110,150,30);
    mylabel.add(b3);
        b3.addActionListener(this);
 b1.addActionListener(this);
    b4.setBounds(20,180,150,30);
    mylabel.add(b4);
        b4.addActionListener(this);

    
     }
   


    
    
    
    
      public static void main(String[] args) {
               new main4();
                			
	}

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==b2){
         
         new elections1().setVisible(true);
         this.dispose();
     }else if(e.getSource()==b3){
         new voters().setVisible(true);
                  this.dispose();

         
     }else if(e.getSource()==b4){
         try {
             new result().setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(main4.class.getName()).log(Level.SEVERE, null, ex);
         }
         this.dispose();
     }else{
          new main1().setVisible(true);
         this.dispose();
         
     }
    }


   
    
}
