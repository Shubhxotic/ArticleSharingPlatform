
import java.awt.Component;
import java.awt.Container;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubham
 */
public class Frame3 extends javax.swing.JFrame {

    /**
     * Creates new form Frame3
     */
    public Frame3() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        done = new javax.swing.JButton();
        wildlife = new javax.swing.JCheckBox();
        sports = new javax.swing.JCheckBox();
        news = new javax.swing.JCheckBox();
        technology = new javax.swing.JCheckBox();
        smu = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        done.setText("DONE");
        done.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneMouseClicked(evt);
            }
        });
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });

        wildlife.setText("Wildlife");
        wildlife.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wildlifeActionPerformed(evt);
            }
        });

        sports.setText("Sports");

        news.setText("News");

        technology.setText("Technology");

        smu.setText("Social Media Updates");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sports)
                            .addComponent(wildlife)
                            .addComponent(news)
                            .addComponent(technology)
                            .addComponent(smu)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(done)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {news, smu, sports, technology, wildlife});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(wildlife)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sports)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(news)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(technology)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(smu)
                .addGap(23, 23, 23)
                .addComponent(done)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doneActionPerformed

    private void doneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneMouseClicked
        // TODO add your handling code here:
        
        try{
            Class.forName("java.sql.Driver");
            //System.out.println("Correct till here");
            Connection conn=(Connection)  DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsProject","root","shubh123");
            //System.out.println("Correct till here");
            Statement st=conn.createStatement();
            //String username=usrname.getText().toString();
           // String password=new String(psword.getPassword());
           String x="";
            if(wildlife.isSelected())
                x=x+"wildlife,";
            if(sports.isSelected())
                x=x+"sports,";
            if(news.isSelected())
                x=x+"news,";
            if(technology.isSelected())
                x=x+"technology,";
            if(smu.isSelected())
                x=x+"social media update,";
            System.out.println("genre formed="+x);
            String query="Update users set genre = \""+x+"\" where username= \""+Frame1.uname+"\";";
            System.out.println(query);
            PreparedStatement pdt=conn.prepareStatement(query);
            int n1=pdt.executeUpdate();
            if(n1>0)
            {
                if(Frame1.sorl==0){
                    JOptionPane.showMessageDialog(null,"Choice changed successfully");
                }
                //JOptionPane.showMessageDialog(null,"SignedUp Successfully!");
            }
            else{
                System.out.println("nooooooo");
            }
                   /* ResultSet rs=st.executeQuery(query);
                      
            
            rs.close();*/
            st.close();
            conn.close();
            
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "error in connection");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(Frame1.sorl==0){
            setVisible(false);
            new Frame2().setVisible(true);}
        else{
            setVisible(false);
            new Frame1().setVisible(true);}
    }//GEN-LAST:event_doneMouseClicked

    private void wildlifeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wildlifeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wildlifeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton done;
    private javax.swing.JCheckBox news;
    private javax.swing.JCheckBox smu;
    private javax.swing.JCheckBox sports;
    private javax.swing.JCheckBox technology;
    private javax.swing.JCheckBox wildlife;
    // End of variables declaration//GEN-END:variables
}
