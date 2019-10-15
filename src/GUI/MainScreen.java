package GUI;


import arboles.ArbolN_ario;
import controlador.Controlador;
import modelo.Sensor;
import otros.IConstants;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame implements IConstants {


    public MainScreen(Controlador pController) {
        controller = pController;
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

         this.setLayout(null);
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        treeRepresentation = new JTree(controller.getMiArbol().getRaiz().getNodeGraphic());
        tree = controller.getMiArbol();

        btnAdd.setText("Agregar");
        btnDelete.setText("Eliminar");
        btnDelete.setBounds(BUTTON_POS_X,BUTTON_POS_Y,BUTTON_WIDTH, BUTTON_HEIGHT);
        btnAdd.setBounds(BUTTON_POS_X, BUTTON_POS_Y+(BUTTON_HEIGHT+5), BUTTON_WIDTH, BUTTON_HEIGHT);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonAddActionPerformed(event);
            }
        });
        treeRepresentation.setBorder(new LineBorder(Color.BLACK));
        treeRepresentation.setBounds(0,0,200,500);

        add(btnDelete);
        add(btnAdd);
        add(treeRepresentation);

        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setResizable(WINDOW_RESIZEABLE);

    }

    private void buttonAddActionPerformed(ActionEvent event){
        new AddScreen(controller).setVisible(true);
        this.dispose();
    }

    private void buttonDeleteActionPerformed(ActionEvent event){

    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private ArbolN_ario<Sensor> tree;
    private JTree treeRepresentation;
    private Controlador controller;
    // End of variables declaration
}
