package Interface;

import Source.Main;
import Source.MusicPlayer;
import Source.Song;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
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

    public void actualizar() {
        this.jTFCancion.setText(Main.lista.actualsong().getNombre());
        this.jTFArtista.setText(Main.lista.actualsong().getAutor());
        this.jTFAlbum.setText(Main.lista.actualsong().getAlbum());
        this.jTFGenero.setText(Main.lista.actualsong().getGenero());
        setImagen();
    }

    public void setImagen() {
        BufferedImage img = null;
        try {
            img = (BufferedImage) Main.lista.actualsong().getImg();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(jLAlbum.getWidth(), jLAlbum.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        jLAlbum.setIcon(imageIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reproductor de Música");

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
                        .addComponent(jLActual, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPBProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
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
                        .addGap(26, 26, 26))))
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
                .addGap(9, 21, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLActual)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPBProgreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLTotal, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(39, 39, 39))))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        JFNuevaCancion jFNueva = new JFNuevaCancion();
        jFNueva.setVisible(true);
        jBPlay.setEnabled(true);
        jBAtras.setEnabled(true);
        jBSiguiente.setEnabled(true);
        jBListaReproduccion.setEnabled(true);
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPlayActionPerformed
        if (music == null) {
            music = new MusicPlayer(Main.lista.actualsong().getArchivo());
        }
        music.play();
        actualizar();
        new Thread() {
            public void run() {
                while (true) {
                    if (music.complete() && Main.lista.head!=null) {
                        music.close();
                        music = new MusicPlayer(Main.lista.nextSong().getArchivo());
                        music.play();
                        actualizar();

                        System.out.println("test");
                        break;
                    }
                }
            }
        }.start();
        try {
            music.getDurationWithMp3Spi(Main.lista.actualsong().getArchivo());
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(JFPlay.class.getName()).log(Level.SEVERE, null, ex);
        }

        Thread thread1 = new Thread() {
            public void run() {
                while (true) {
                    //if(music.complete()){
                    try {
                        jPBProgreso.setMaximum(music.getDurationWithMp3Spi(Main.lista.actualsong().getArchivo()));
                        jLTotal.setText(music.getTotalTime(Main.lista.actualsong().getArchivo()));
                        jPBProgreso.setValue(music.getPosition());
                        jLActual.setText(music.getActualTime());
                    } catch (UnsupportedAudioFileException | IOException ex) {
                        Logger.getLogger(JFPlay.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //break;
                    //}
                }
            }
        };
        thread1.start();
        jBPlay.setEnabled(false);
        jBPausa.setEnabled(true);
    }//GEN-LAST:event_jBPlayActionPerformed

    private void jBPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPausaActionPerformed
        music.pause();
        jBPausa.setEnabled(false);
        jBPlay.setEnabled(true);
    }//GEN-LAST:event_jBPausaActionPerformed

    private void jBSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSiguienteActionPerformed
        if (Main.lista.head != null) {
            music.close();
            music = new MusicPlayer(Main.lista.nextSong().getArchivo());
            music.play();
            actualizar();
            jBPlay.setEnabled(false);
            jBPausa.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "No existen canciones en la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBSiguienteActionPerformed

    private void jBAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtrasActionPerformed
        if (Main.lista.head != null) {
            music.close();
            music = new MusicPlayer(Main.lista.previousSong().getArchivo());
            music.play();
            actualizar();
            jBPlay.setEnabled(false);
            jBPausa.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "No existen canciones en la lista", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBAtrasActionPerformed

    private void jTFCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFCancionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFCancionActionPerformed

    private void jBListaReproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListaReproduccionActionPerformed
        JFLista jFLista = new JFLista();
        jFLista.setVisible(true);
    }//GEN-LAST:event_jBListaReproduccionActionPerformed

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
    private javax.swing.JButton jBSiguiente;
    private javax.swing.JLabel jLActual;
    private javax.swing.JLabel jLAlbum;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jPBProgreso;
    private javax.swing.JTextField jTFAlbum;
    private javax.swing.JTextField jTFArtista;
    private javax.swing.JTextField jTFCancion;
    private javax.swing.JTextField jTFGenero;
    // End of variables declaration//GEN-END:variables
}
