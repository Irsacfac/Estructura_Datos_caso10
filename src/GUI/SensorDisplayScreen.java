package GUI;

import javax.swing.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class SensorDisplayScreen extends JFrame implements IPanelDimensions {

    private ArrayList<InfoDisplayPanel> matches;

    public SensorDisplayScreen(ArrayList<InfoDisplayPanel> pMatches ) {
        matches = pMatches;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {



        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 520, Short.MAX_VALUE)
        );

        addSensorsInfo();

        pack();
    }// </editor-fold>



    public void addSensorsInfo(){

        matches.get(0).setBounds(INITIAL_POSITION_IN_X,INITIAL_POSITION_IN_Y, PANEL_WIDTH, PANEL_HEIGHT);
        this.add(matches.get(0));
        System.out.println(matches.size());
        for (int index = 1; index < matches.size(); index++){
            System.out.println("...");
            matches.get(index).setBounds(INITIAL_POSITION_IN_X,
                                        INITIAL_POSITION_IN_Y + (PANEL_HEIGHT + 5),
                                        PANEL_WIDTH,
                                        PANEL_HEIGHT);
            this.add(matches.get(index));

        }

    }

    public void setMatches(ArrayList<InfoDisplayPanel> matches) {
        this.matches = matches;
    }
}
