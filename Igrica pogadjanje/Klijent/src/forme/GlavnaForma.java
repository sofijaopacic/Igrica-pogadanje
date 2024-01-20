/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import controller.ClientController;
import domen.OdgovorNaPogadjanje;
import domen.Pogadjanje;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofija
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    private TableModelIgraKlijent tableModelIgraKlijent;
    
    private int [] niz = new int [3];
    private int brojac=0;
    
    private int brojPogadjanja = 0;
    
    public GlavnaForma() {
        initComponents();
        setLocationRelativeTo(null);
        
        tableModelIgraKlijent = new TableModelIgraKlijent();
        tblIgra.setModel(tableModelIgraKlijent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblIgra = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblIgra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblIgra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIgraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIgra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblIgraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIgraMouseClicked
        int red = tblIgra.getSelectedRow();
        int kolona = tblIgra.getSelectedColumn();
        
        if(red>-1 && kolona>-1){
            try{
                Object podatak = tableModelIgraKlijent.getValueAt(red, kolona);
                if(podatak instanceof String){
                    if(brojPogadjanja == 5){
                        throw new Exception("Nemate vise pokusaja");
                    }
                    brojPogadjanja++;
                    Pogadjanje pogadjanje = new Pogadjanje(red, kolona);
                    OdgovorNaPogadjanje odgovorNaPogadjanje = ClientController.getInstanca().pogodi(pogadjanje);
                    if(odgovorNaPogadjanje.getBroj()!=-1){
                        niz[brojac] = odgovorNaPogadjanje.getBroj();
                        brojac++;
                        if(brojac == 3){
                            int najveci = niz[0];
                            int najmanji = niz[0];
                            int srednji = 0;
                            for(int i=0;i<3;i++){
                                if(niz[i]> najveci){
                                    najveci = niz[i];
                                }
                                if(niz[i]<najmanji){
                                    najmanji = niz[i];
                                }

                            }
                            
                            for(int i=0;i<3;i++){
                                if(niz[i] != najveci && niz[i]!=najmanji){
                                    srednji = niz[i];
                                }
                            }
                            JOptionPane.showMessageDialog(rootPane, "Pobedili ste sifra je:"+srednji+""+najveci+""+najmanji);
                            System.exit(0);
                        }
                    }
                    tableModelIgraKlijent.setValueAt(odgovorNaPogadjanje.getBroj(),red, kolona);
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                System.exit(0);
            }
        }
    }//GEN-LAST:event_tblIgraMouseClicked

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
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlavnaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblIgra;
    // End of variables declaration//GEN-END:variables
}