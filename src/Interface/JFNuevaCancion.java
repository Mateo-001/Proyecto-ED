/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import static Interface.JFPlay.music;
import Source.*;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Bryan
 */
public class JFNuevaCancion extends javax.swing.JFrame {

    String carpeta;
    File carpetaLista;
    String[] canciones;

    public JFNuevaCancion() {
        initComponents();
        this.jTFDireccion.setEditable(false);
        AutoCompleteDecorator.decorate(jCBBuscar);
        //getTabla();
        //cargarCanciones();
    }

    public String getCarpeta() {
        String direccion = "";
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                direccion = fc.getSelectedFile().getAbsolutePath();
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
        System.out.println(direccion);
        return direccion;
    }

    public void getTabla() {
        String col[] = {"Nº", "Nombre", "Autor", "Álbum", "Género", "Año"};
        DefaultTableModel modelo = new DefaultTableModel(col, 0);
        Object[] obj = new Object[6];

        
        for (int i = 0; i < canciones.length; i++) {
            System.out.println(canciones[i]);
        }
        for (int i = 0; i < canciones.length && canciones[i].contains(".mp3"); i++) {
            Song aux = new Song(carpeta + "/" + canciones[i]);
            obj[0] = i + 1;
            obj[1] = aux.getNombre().replace(".mp3", "");
            obj[2] = aux.getAutor();
            obj[3] = aux.getAlbum();
            obj[4] = aux.getGenero();
            obj[5] = aux.getAnio();
            modelo.addRow(obj);
        }
        this.jTCanciones.setModel(modelo);
    }

    public void cargarCanciones() {
        File carpetaLista = new File(this.carpeta);
        String[] canciones = carpetaLista.list();
        for (int i = 0; i < canciones.length && canciones[i].contains(".mp3"); i++) {
            this.jCBBuscar.addItem(canciones[i].replace(".mp3", ""));
        }
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
        jTCanciones = new javax.swing.JTable();
        jCBBuscar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jBInsertar = new javax.swing.JButton();
        jBDireccion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTFDireccion = new javax.swing.JTextField();
        jBRegresar = new javax.swing.JButton();

        setTitle("Nueva canción");
        setResizable(false);

        jTCanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTCanciones);

        jLabel1.setText("Busque la canción que desea insertar:");

        jBInsertar.setText("Insertar canción");
        jBInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInsertarActionPerformed(evt);
            }
        });

        jBDireccion.setText("···");
        jBDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDireccionActionPerformed(evt);
            }
        });

        jLabel2.setText("Escoja la carpeta de su biblioteca:");

        jBRegresar.setText("Regresar");
        jBRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jBInsertar)
                                .addGap(26, 26, 26)
                                .addComponent(jBRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addGap(14, 14, 14)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBDireccion)
                                .addGap(34, 34, 34)
                                .addComponent(jTFDireccion))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDireccion)
                    .addComponent(jTFDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBInsertar)
                    .addComponent(jBRegresar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDireccionActionPerformed
        carpeta = getCarpeta();
        this.carpetaLista = new File(this.carpeta);
        this.canciones = carpetaLista.list();
        getTabla();
        cargarCanciones();
        this.jTFDireccion.setText(carpeta);
    }//GEN-LAST:event_jBDireccionActionPerformed

    private void jBInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInsertarActionPerformed
        try {
            Song song = new Song(carpeta + "/" + jCBBuscar.getSelectedItem().toString() + ".mp3");
            Main.lista.insertSong(song);
            //music = new MusicPlayer(Main.lista.head.song.getArchivo());
            JOptionPane.showMessageDialog(null, jCBBuscar.getSelectedItem().toString() + " agregada correctamente", "Insertar nueva canción", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al insertar la canción", "Insertar nueva canción", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBInsertarActionPerformed

    private void jBRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegresarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jBRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(JFNuevaCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFNuevaCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFNuevaCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFNuevaCancion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFNuevaCancion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDireccion;
    private javax.swing.JButton jBInsertar;
    private javax.swing.JButton jBRegresar;
    private javax.swing.JComboBox<String> jCBBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCanciones;
    private javax.swing.JTextField jTFDireccion;
    // End of variables declaration//GEN-END:variables
}
