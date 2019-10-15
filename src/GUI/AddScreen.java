package GUI;

import JsonManager.JsonManager;
import arboles.ArbolN_ario;
import arboles.NodoN_ario;
import arboles.NodoSplay;
import arboles.SplayTree;
import controlador.Controlador;
import modelo.Sensor;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.remainderUnsigned;

public class AddScreen extends javax.swing.JFrame {

    private ArrayList<JTextField> inputs;

    public AddScreen(Controlador pController) {
        initComponents();
        inputs = new ArrayList<>();
        tree = pController.getMiArbol();
        controller = pController;
        generateInputsArray();
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cantonLabel = new javax.swing.JLabel();
        districtLabel = new javax.swing.JLabel();
        neighbourhoodLabel = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        fatherLabel = new javax.swing.JLabel();
        cantonInput = new javax.swing.JTextField();
        districtInput = new javax.swing.JTextField();
        IDInput = new javax.swing.JTextField();
        neighbourhoodInput = new javax.swing.JTextField();
        fatherInput = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        labelAddSensor = new javax.swing.JLabel();
        instructionsLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jsonManager = new JsonManager();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cantonLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cantonLabel.setText("Canton");

        districtLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        districtLabel.setText("Distrito");

        neighbourhoodLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        neighbourhoodLabel.setText("Barrio");

        IDLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IDLabel.setText("ID");

        fatherLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fatherLabel.setText("Toma");

        IDInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        labelAddSensor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelAddSensor.setText("Agregar Sensor");

        instructionsLabel.setText("Rellene la información solicitada y presione agregar.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(instructionsLabel)
                                        .addComponent(labelAddSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelAddSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(instructionsLabel)
                                .addGap(0, 8, Short.MAX_VALUE))
        );

        addButton.setText("agregar");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(103, 103, 103)
                                                .addComponent(addButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(fatherLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(fatherInput, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(cantonLabel)
                                                                        .addComponent(IDLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(IDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cantonInput, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(neighbourhoodLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(neighbourhoodInput, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(districtLabel)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(districtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cantonLabel)
                                        .addComponent(cantonInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(IDLabel)
                                        .addComponent(IDInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(districtLabel)
                                        .addComponent(districtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(neighbourhoodLabel)
                                        .addComponent(neighbourhoodInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fatherLabel)
                                        .addComponent(fatherInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void addButtonActionPerformed(java.awt.event.ActionEvent pEvt) {

        if (somethingEmpty()){
            markEmptyInputs();
        } else {
            Sensor newSensor = createSensor();
            createNode(newSensor, fatherInput.getText());
            this.dispose();
            new MainScreen(controller).setVisible(true);
            resetInputs();
        }

    }



    private void createNode(Sensor pSensor, String pFatherID){
        NodoN_ario<Sensor> newSensor = new NodoN_ario<>(pSensor);
        NodoN_ario<Sensor> father = getNodeByID(pFatherID);
        newSensor.setPadre(father);
        tree.agregar(newSensor.getElemento(), newSensor.getPadre(), newSensor.getElemento().getPath());

    }

    private Sensor createSensor(){

        String ID = IDInput.getText();
        String canton = cantonInput.getText();
        String district = districtInput.getText();
        String neighborhood = neighbourhoodInput.getText();
        int consumption = getConsumptionByName(canton,district, neighborhood);

        Sensor sensor = new Sensor(ID, canton, consumption);
        if (!district.equals(""))
        sensor.setDistrito(district);
        if (!neighborhood.equals(""))
        sensor.setBarrio(neighborhood);

        return sensor;

    }

    private int getConsumptionByName(String pCanton, String pDistrict, String pNeighborhood) {
        if (!pNeighborhood.equals("")) return jsonManager.getConsumptionByName(pNeighborhood);
        if (!pDistrict.equals("")) return jsonManager.getConsumptionByName(pDistrict);
        return jsonManager.getConsumptionByName(pCanton);
    }

    private NodoN_ario<Sensor> getNodeByID(String pID){
        for (NodoN_ario<Sensor> nodo : tree.getNodosActivos()){
            if(nodo.getElemento().getID().equals(pID)) return nodo;
        }
        return null;
    }

    private void resetInputs(){
        for (JTextField input : inputs){
            input.setText("");
            input.setBorder(defaultBorder);
        }
    }

    private boolean somethingEmpty(){
        return isEmpty(cantonInput)
                || isEmpty(IDInput)
                || isEmpty(fatherInput);
    }

    private ArrayList<JTextField> emptyInputs(){
        ArrayList<JTextField> emptyInputs = new ArrayList<>();
        for (JTextField input:inputs){
            if (isEmpty(input) && !(input.equals(districtInput) || input.equals(neighbourhoodInput))){
                emptyInputs.add(input);
            }
        }
        return emptyInputs;
    }

    private void markEmptyInputs(){
        ArrayList<JTextField> emptyInputs = emptyInputs();
        javax.swing.border.LineBorder required = new LineBorder(Color.RED);
        unmarkAlreadyEntered();
        for (JTextField input:emptyInputs){
            input.setBorder(required);
        }
    }

    private void unmarkAlreadyEntered(){
        for (JTextField input:inputs){
            if (!(isEmpty(input))){
                input.setBorder(defaultBorder);
            }
        }
    }


    private boolean isEmpty(JTextField pTextField){
        if (pTextField.getText().equals("")){
            return true;
        } else return false;
    }

    private void generateInputsArray(){
        inputs.add(cantonInput);
        inputs.add(IDInput);
        inputs.add(districtInput);
        inputs.add(neighbourhoodInput);

        inputs.add(fatherInput);
    }


    // Variables declaration - do not modify
    private javax.swing.JTextField IDInput;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField cantonInput;
    private javax.swing.JLabel cantonLabel;

    private javax.swing.JLabel consumptionLabel;
    private javax.swing.JTextField districtInput;
    private javax.swing.JLabel districtLabel;
    private javax.swing.JTextField fatherInput;
    private javax.swing.JLabel fatherLabel;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelAddSensor;
    private javax.swing.JTextField neighbourhoodInput;
    private javax.swing.JLabel neighbourhoodLabel;
    private LineBorder defaultBorder;
    private ArbolN_ario<Sensor> tree;
    private Controlador controller;
    private JsonManager jsonManager;
    // End of variables declaration


}
