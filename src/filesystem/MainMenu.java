/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.File;
import java.nio.file.FileSystems;
import javax.swing.JFileChooser;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author Pedro Feliciano
 */
public class MainMenu extends javax.swing.JFrame {

    FileSystem fs;
    //FileData fd;
    //Metadata md;

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        fs = new FileSystem();
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

        btnInsertFile = new javax.swing.JButton();
        btnCreateFile = new javax.swing.JButton();
        btnOpenFile = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtQtyOfFiles = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCreationDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContentBox = new javax.swing.JTextArea();
        txtFName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnInsertFile.setText("Inserir Arquivo");
        btnInsertFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnInsertFileMouseReleased(evt);
            }
        });

        btnCreateFile.setText("Criar arquivo");
        btnCreateFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFileActionPerformed(evt);
            }
        });

        btnOpenFile.setText("Abrir Arquivo");
        btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade de arquivos");

        txtQtyOfFiles.setEditable(false);
        txtQtyOfFiles.setText("00");

        jLabel4.setText("Criação");

        txtCreationDate.setEditable(false);
        txtCreationDate.setText("00/00/0000");

        jLabel5.setText("Conteúdo");

        txtContentBox.setColumns(20);
        txtContentBox.setRows(5);
        jScrollPane1.setViewportView(txtContentBox);

        txtFName.setText("Nome");
        txtFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOpenFile, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateFile, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnInsertFile, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtQtyOfFiles, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(txtCreationDate))
                    .addComponent(jScrollPane1)
                    .addComponent(txtFName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOpenFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreateFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsertFile, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtQtyOfFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertFileMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertFileMouseReleased
        //open file chooser window
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        String path = chooser.getSelectedFile().getAbsolutePath();
        fs.insertFile(path);
        //get selected file
        //fs.insertFile(chooser.getSelectedFile());


    }//GEN-LAST:event_btnInsertFileMouseReleased

    private void btnCreateFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFileActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        String path = chooser.getSelectedFile().getAbsolutePath();
        fs.createFile(path);
        System.out.println(chooser.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_btnCreateFileActionPerformed

    private void btnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFileActionPerformed
        // Opening the file
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        String path = chooser.getSelectedFile().getAbsolutePath();
        fs.openFile(path);    
        System.out.println(chooser.getSelectedFile().getAbsolutePath());
        //Showing metadata
        txtContentBox.removeAll();
        ArrayList<FileData> fd = fs.getFileData();
        String dados = "";
        for (FileData f : fd) {
            dados += "Caminho do arquivo" + "\t \t \t" + "Data de adicao" + "\t" + "Tamanho" + "\t\n";
            dados += f.getName() + "\t" + f.getCreationDate() + "\t" + f.getSize() + "\n";
        }
        //System.out.println(dados + "\n desligando swap...");
        txtContentBox.setText(dados);
        String DpName = "";
        int i;
        i = path.length() -1;
        System.out.println(i);
        while('/' != path.charAt(i) && path.charAt(i) != '\\') {
            System.out.println(i);
            i--;
        }
        for (/*i = 0*/; i != path.length(); i++){
            DpName += path.charAt(i);
        }
        txtFName.setText(DpName);
        

    }//GEN-LAST:event_btnOpenFileActionPerformed

    private void txtFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFNameActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateFile;
    private javax.swing.JButton btnInsertFile;
    private javax.swing.JButton btnOpenFile;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtContentBox;
    private javax.swing.JTextField txtCreationDate;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtQtyOfFiles;
    // End of variables declaration//GEN-END:variables
}
