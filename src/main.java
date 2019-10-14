import GUI.InfoDisplayPanel;
import GUI.SensorDisplayScreen;
import JsonManager.JsonManager;
import modelo.Sensor;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        //JsonManager jsonManager = new JsonManager();
        //jsonManager.getCantons();

        Sensor s1 = new Sensor("12", "hola", 52);
        InfoDisplayPanel panel = new InfoDisplayPanel(s1, "adios");
        InfoDisplayPanel panel2 = new InfoDisplayPanel(s1, "adiosss");
        ArrayList<InfoDisplayPanel> array = new ArrayList<>();
        array.add(panel);
        array.add(panel2);
        SensorDisplayScreen screen = new SensorDisplayScreen(array);
        screen.setVisible(true);
        screen.setMatches(array);


    }
}
