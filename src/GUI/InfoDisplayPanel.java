package GUI;

import modelo.Sensor;

import javax.swing.*;

public class InfoDisplayPanel extends JPanel {

    public int ID;
    private String location;
    private int consumption;
    private String fatherID;

    public JLabel IDDisplayLabel;
    private JLabel consumptionDisplayLabel;
    private JLabel fatherDisplayLabel;
    private JLabel locationDisplayLabel;

    public InfoDisplayPanel(Sensor pSensor, String pFatherID){

        initPanelComponents();

        ID = pSensor.getID();
        location = pSensor.getCanton()+"/"+pSensor.getDistrito()+"/"+pSensor.getBarrio();
        consumption = pSensor.getCm3Base();
        fatherID = pFatherID;

        setLabelsText();

    }
    private void setLabelsText(){

        IDDisplayLabel.setText("ID: " + ID);
        locationDisplayLabel.setText("Ubicación: " + location);
        consumptionDisplayLabel.setText("cm3/min: " + consumption);
        fatherDisplayLabel.setText("Toma Padre:" + fatherID);

    }
    private void initPanelComponents(){

        IDDisplayLabel = new JLabel();
        consumptionDisplayLabel = new JLabel();
        fatherDisplayLabel = new JLabel();
        locationDisplayLabel = new JLabel();

        javax.swing.GroupLayout infoDisplayPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(infoDisplayPanelLayout);
        infoDisplayPanelLayout.setHorizontalGroup(
                infoDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoDisplayPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(infoDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(IDDisplayLabel)
                                        .addComponent(fatherDisplayLabel)
                                        .addComponent(consumptionDisplayLabel)
                                        .addComponent(locationDisplayLabel))
                                .addContainerGap(157, Short.MAX_VALUE))
        );
        infoDisplayPanelLayout.setVerticalGroup(
                infoDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(infoDisplayPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(IDDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(locationDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(consumptionDisplayLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fatherDisplayLabel)
                                .addGap(114, 114, 114))
        );
    }

}
