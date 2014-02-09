/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erp;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.*;




/**
 *
 * @author Prudhvi
 */
public class Erp {

    /**
     * @param args the command line arguments
     */
    public static s x;
    public static void main(String[] args) {
        // TODO code application logic here
        try 
    { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
    } 
    catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){ 
        JOptionPane.showMessageDialog(null, e);
    }
       x=new s();
        x.pack();
        Student y=new Student();
//       JFrame f=new JFrame();
       
//       JPanel rp=(JPanel)new DeanPanelUI();
//       
//       
//       rp.setVisible(true);
//       rp.show();
//       x.setContentPane(rp);
//       x.show();
//       x.setTitle("ERP Software");
//       x.pack();
//       x.setResizable(false);
//       x.setLocation(200, 200);
      
//       f.setContentPane(rp);
//       f.show();
    }
    
}
