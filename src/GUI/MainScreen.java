package GUI;


import arboles.ArbolN_ario;
import arboles.NodoN_ario;
import controlador.Controlador;
import modelo.Sensor;
import otros.IConstants;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainScreen extends JFrame implements IConstants {


    public MainScreen(Controlador pController) {
        controller = pController;
        initComponents();
        controller.start();

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

         this.setLayout(null);
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new JButton();

        treeRepresentation = new JTree(controller.getMiArbol().getRaiz().getNodeGraphic());
        tree = controller.getMiArbol();

        btnAdd.setText("Agregar");
        btnDelete.setText("Eliminar");
        btnSearch.setText("Buscar");
        btnDelete.setBounds(BUTTON_POS_X,BUTTON_POS_Y,BUTTON_WIDTH, BUTTON_HEIGHT);
        btnAdd.setBounds(BUTTON_POS_X, BUTTON_POS_Y + NEW_BUTTON_POSITION_VARIATION, BUTTON_WIDTH, BUTTON_HEIGHT);
        btnSearch.setBounds(BUTTON_POS_X, BUTTON_POS_Y + 2*NEW_BUTTON_POSITION_VARIATION, BUTTON_WIDTH, BUTTON_HEIGHT);
        btnAdd.addActionListener(this::buttonAddActionPerformed);
        btnDelete.addActionListener(this::buttonDeleteActionPerformed);
        btnSearch.addActionListener(this::buttonSearchActionPerformed);
        treeRepresentation.setBorder(new LineBorder(Color.BLACK));
        treeRepresentation.setBounds(TREE_POS_X,TREE_POS_Y,TREE_WIDTH,TREE_HEIGHT);

        add(btnDelete);
        add(btnAdd);
        add(btnSearch);
        add(treeRepresentation);

        this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setResizable(WINDOW_RESIZEABLE);

    }

    private void buttonSearchActionPerformed(ActionEvent pActionEvent) {
        String errorMessage = "ERROR: Path no existe";
        String path = JOptionPane.showInputDialog(null, "Ingrese el path del sensor a buscar");
        ArrayList<NodoN_ario<Sensor>> sensors = tree.buscar(path);
        System.out.println(sensors.size());
        if (sensors.isEmpty()){
            JOptionPane.showMessageDialog(null, errorMessage, "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<InfoDisplayPanel> panels = generatePanels(sensors);
            SensorDisplayScreen displayMatches = new SensorDisplayScreen(panels);
            displayMatches.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            displayMatches.setVisible(true);
        }



    }

    public ArrayList<InfoDisplayPanel> generatePanels(ArrayList<NodoN_ario<Sensor>> pSensors){
        ArrayList<InfoDisplayPanel> panels = new ArrayList<>();
        for (NodoN_ario<Sensor> sensor: pSensors){
            panels.add(new InfoDisplayPanel(sensor.getElemento(), sensor.getPadre().getElemento().getID()));
        }
        return panels;
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
    private JButton btnSearch;
    private ArbolN_ario<Sensor> tree;
    private JTree treeRepresentation;
    private Controlador controller;
    // End of variables declaration
}