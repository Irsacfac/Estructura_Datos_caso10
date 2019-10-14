package GUI;


import arboles.ArbolN_ario;
import controlador.Controlador;
import modelo.Sensor;
import otros.IConstants;

import javax.swing.*;

public class MainScreen extends JFrame implements IConstants {


    public MainScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

         this.setLayout(null);
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        controller = new Controlador();
        treeRepresentation = controller.getMiArbol().getGraphic();
        tree = controller.getMiArbol();

        btnAdd.setText("Agregar");
        btnDelete.setText("Eliminar");
        btnDelete.setBounds(BUTTON_POS_X,BUTTON_POS_Y,BUTTON_WIDTH, BUTTON_HEIGHT);
        btnAdd.setBounds(BUTTON_POS_X, BUTTON_POS_Y+(BUTTON_HEIGHT+5), BUTTON_WIDTH, BUTTON_HEIGHT);

        add(btnDelete);
        add(btnAdd);

        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {



    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private ArbolN_ario<Sensor> tree;
    private JTree treeRepresentation;
    private Controlador controller;
    // End of variables declaration
}
