package GUI;


import arboles.ArbolN_ario;
import arboles.NodoN_ario;
import controlador.Controlador;
import modelo.Sensor;
import otros.IConstants;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.Position;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
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
        btnAdd.addActionListener(this::buttonAddActionPerformed);
        btnDelete.addActionListener(this::buttonDeleteActionPerformed);
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


        String errorMessage = "ERROR: ID no existe";
        DefaultTreeModel model = (DefaultTreeModel)treeRepresentation.getModel();
        String ID = JOptionPane.showInputDialog(null, "Ingrese el ID del sensor a eliminar");
        NodoN_ario<Sensor> node = controller.getNodeByID(ID);
        String nodeName = controller.getNodeByID(ID).getElemento().getID();
        System.out.println(nodeName);

        if (node == null){
            JOptionPane.showMessageDialog(null, errorMessage, "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        else{
            TreePath path = treeRepresentation.getNextMatch(nodeName, 0, Position.Bias.Forward);
            System.out.println(path == null);
            MutableTreeNode mNode = (MutableTreeNode)path.getLastPathComponent();
            if (!node.getHijos().isEmpty()){
                for (NodoN_ario<Sensor> hijo: node.getHijos()){
                    model.insertNodeInto(hijo.getNodeGraphic(), node.getPadre().getNodeGraphic(), 0);
                }
            }
            model.removeNodeFromParent(mNode);
            tree.eliminar(node, node.getElemento().getPath());
        }



    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private ArbolN_ario<Sensor> tree;
    private JTree treeRepresentation;
    private Controlador controller;
    // End of variables declaration
}