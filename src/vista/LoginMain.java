/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import db.Conexion;
import db.DataUsu;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author RullRoice
 */
public class LoginMain extends javax.swing.JFrame {

    private DataUsu dataUsu;
    private Conexion conexion;
    private Admin admin;
    private Vendedor vende;

    public LoginMain() {
        initComponents();
        setSize(635, 430);  
        try {
            conexion = new Conexion("automotora");
            this.dataUsu = new DataUsu(conexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar la base de datos.");
        }
        admin = new Admin(this);
        vende = new Vendedor(this);
    }
    public void abrirVentana(){
        this.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPLogin = new javax.swing.JPanel();
        jLogo = new javax.swing.JLabel();
        jLRut = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLContra = new javax.swing.JLabel();
        txtContraLog = new javax.swing.JPasswordField();
        btnLog = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cars_Haven BIG LOGO.png"))); // NOI18N

        jLRut.setText("Correo");

        jLContra.setText("Contraseña");

        btnLog.setText("Entrar");
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPLoginLayout = new javax.swing.GroupLayout(jPLogin);
        jPLogin.setLayout(jPLoginLayout);
        jPLoginLayout.setHorizontalGroup(
            jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPLoginLayout.createSequentialGroup()
                .addGap(0, 244, Short.MAX_VALUE)
                .addComponent(jLogo)
                .addGap(241, 241, 241))
            .addGroup(jPLoginLayout.createSequentialGroup()
                .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPLoginLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addGroup(jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLContra)
                            .addComponent(jLRut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(txtContraLog)))
                    .addGroup(jPLoginLayout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(btnLog)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPLoginLayout.setVerticalGroup(
            jPLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLoginLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLRut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLContra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLog)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        String email = txtCorreo.getText();
        String contraseña = new String(txtContraLog.getPassword());

        try {
            if (dataUsu.iniciarSesion(email, contraseña)) {
                JOptionPane.showMessageDialog(this, "¡Inicio de sesión correcto!");
                String userTipo = dataUsu.getUserTipo(email);
                if (userTipo.equals("Administrador")) {
                    admin.setVisible(true);
                    this.setVisible(false);
                } 
                if (userTipo.equals("Vendedor")){
                    vende.setVisible(true);
                    this.setVisible(false);
                    
                    
                }    
            } else {
                JOptionPane.showMessageDialog(this, "Datos incorrectos, por favor revisar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al iniciar sesión, pruebe otra vez.");
        }

    }//GEN-LAST:event_btnLogActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            FlatOneDarkIJTheme.setup();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginMain().setVisible(true);
            }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLog;
    private javax.swing.JLabel jLContra;
    private javax.swing.JLabel jLRut;
    private javax.swing.JLabel jLogo;
    private javax.swing.JPanel jPLogin;
    private javax.swing.JPasswordField txtContraLog;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables

}
