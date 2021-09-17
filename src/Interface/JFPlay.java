package Interface;

import Source.Main;
import Source.MusicPlayer;
import Source.Player;
import Source.Song;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mate_
 */
public class JFPlay extends javax.swing.JFrame {

    public static boolean pausa = true;
    Song song;
    public static MusicPlayer music;

    Player player = new Player();
    boolean flag = false;
    JFNuevaCancion jFNueva = new JFNuevaCancion();

    public JFPlay() {

        initComponents();
        this.jTFAlbum.setEditable(false);
        this.jTFArtista.setEditable(false);
        this.jTFCancion.setEditable(false);
        this.jTFGenero.setEditable(false);
        this.jTFAlbum.setEnabled(false);
        this.jTFArtista.setEnabled(false);
        this.jTFCancion.setEnabled(false);
        this.jTFGenero.setEnabled(false);

        jBPlay.setEnabled(false);
        jBPausa.setEnabled(false);
        jBAtras.setEnabled(false);
        jBSiguiente.setEnabled(false);
        jBListaReproduccion.setEnabled(false);
    }

    public static void actualizar() {
        jTFCancion.setText(Main.lista.actualsong().getNombre());
        jTFArtista.setText(Main.lista.actualsong().getAutor());
        jTFAlbum.setText(Main.lista.actualsong().getAlbum());
        jTFGenero.setText(Main.lista.actualsong().getGenero());
        setImagen();
    }

    public static void setImagen() {
        BufferedImage img = null;
        try {
            img = (BufferedImage) Main.lista.actualsong().getImg();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(jLAlbum.getWidth(), jLAlbum.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        jLAlbum.setIcon(imageIcon);
    }

    public static String formatTime(long l) {
        String format = "00";
        DecimalFormat objDF = new DecimalFormat (format);
        String tiempo;
        long mili = l;  // obtained from StopWatch
        long min = (mili / 1000) / 60;
        int sec = (int) ((mili / 1000) % 60);
        tiempo = objDF.format(min) + ":" + objDF.format(sec);
        return tiempo;
    }

    public static void updateProgressBar(long actual, long total) {
        jPBProgreso.setMaximum((int) total);
        jPBProgreso.setValue((int) actual);
        jLTotal.setText(formatTime(total));
        jLActual.setText(formatTime(actual));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jBAtras = new javax.swing.JButton();
        jBSiguiente = new javax.swing.JButton();
        jBPlay = new javax.swing.JButton();
        jBPausa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTFCancion = new javax.swing.JTextField();
        jTFArtista = new javax.swing.JTextField();
        jTFAlbum = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFGenero = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jBListaReproduccion = new javax.swing.JButton();
        jPBProgreso = new javax.swing.JProgressBar();
        jLAlbum = new javax.swing.JLabel();
        jLTotal = new javax.swing.JLabel();
        jLActual = new javax.swing.JLabel();
        jSVolume = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reproductor de Música");
        setResizable(false);

        jBAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtrasActionPerformed(evt);
            }
        });

        jBSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSiguienteActionPerformed(evt);
            }
        });

        jBPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPlayActionPerformed(evt);
            }
        });

        jBPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPausaActionPerformed(evt);
            }
        });

        jTFCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFCancionActionPerformed(evt);
            }
        });

        jLabel2.setText("Canción:");

        jLabel3.setText("Artista:");

        jLabel4.setText("Álbum:");

        jLabel5.setText("Género:");

        jBAgregar.setText("Agregar Canción");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBListaReproduccion.setText("Lista de Reproducción");
        jBListaReproduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListaReproduccionActionPerformed(evt);
            }
        });

        jSVolume.setValue(75);
        jSVolume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSVolumeStateChanged(evt);
            }
        });
        jSVolume.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jSVolumeMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBListaReproduccion)
                    .addComponent(jBAgregar))
                .addGap(26, 26, 26)
                .addComponent(jBAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jBPausa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jBSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFCancion)
                                    .addComponent(jTFArtista)
                                    .addComponent(jTFAlbum)
                                    .addComponent(jTFGenero))))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLActual, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSVolume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPBProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTFArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTFAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jLAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBListaReproduccion)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBSiguiente, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jBPausa, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jBPlay))
                            .addComponent(jBAtras))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPBProgreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLTotal, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLActual)
                                .addContainerGap())))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        jFNueva.setVisible(true);
        jBPlay.setEnabled(true);
        jBAtras.setEnabled(true);
        jBSiguiente.setEnabled(true);
        jBListaReproduccion.setEnabled(true);
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPlayActionPerformed
        try {
            if (flag == false) {
                player.addFile(Main.lista.head.song);
                player.play();
                flag = true;
            } else {
                player.resume();
            }
            jBPlay.setEnabled(false);
            jBPausa.setEnabled(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No existen canciones en la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBPlayActionPerformed

    private void jBPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPausaActionPerformed
        player.pause();
        jBPausa.setEnabled(false);
        jBPlay.setEnabled(true);
    }//GEN-LAST:event_jBPausaActionPerformed

    private void jBSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSiguienteActionPerformed
        if (!Main.lista.head.isEmpty()) {
            player.nextSong();
            jBPlay.setEnabled(false);
            jBPausa.setEnabled(true);
            player.setVolume((double) jSVolume.getValue() / 100);
        } else {
            JOptionPane.showMessageDialog(null, "No existen canciones en la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBSiguienteActionPerformed

    private void jBAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtrasActionPerformed
        if (!Main.lista.head.isEmpty()) {
            player.previousSong();
            jBPlay.setEnabled(false);
            jBPausa.setEnabled(true);
            player.setVolume((double) jSVolume.getValue() / 100);
        } else {
            JOptionPane.showMessageDialog(null, "No existen canciones en la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBAtrasActionPerformed

    private void jTFCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCancionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCancionActionPerformed

    private void jBListaReproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListaReproduccionActionPerformed
        try{
            JFLista jFLista = new JFLista();
            jFLista.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No existen canciones en la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBListaReproduccionActionPerformed

    private void jSVolumeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSVolumeMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jSVolumeMouseMoved

    private void jSVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSVolumeStateChanged
        player.setVolume((double) jSVolume.getValue() / 100);
    }//GEN-LAST:event_jSVolumeStateChanged

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
            java.util.logging.Logger.getLogger(JFPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPlay().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBAtras;
    private javax.swing.JButton jBListaReproduccion;
    private javax.swing.JButton jBPausa;
    private javax.swing.JButton jBPlay;
    public static javax.swing.JButton jBSiguiente;
    public static javax.swing.JLabel jLActual;
    public static javax.swing.JLabel jLAlbum;
    public static javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JProgressBar jPBProgreso;
    private javax.swing.JSlider jSVolume;
    private javax.swing.JSlider jSlider1;
    public static javax.swing.JTextField jTFAlbum;
    public static javax.swing.JTextField jTFArtista;
    public static javax.swing.JTextField jTFCancion;
    public static javax.swing.JTextField jTFGenero;
    // End of variables declaration//GEN-END:variables
}
