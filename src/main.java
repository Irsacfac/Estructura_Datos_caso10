import GUI.InfoDisplayPanel;
import GUI.MainScreen;
import GUI.SensorDisplayScreen;
import JsonManager.JsonManager;
import controlador.Controlador;
import modelo.Sensor;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        //JsonManager jsonManager = new JsonManager();
        //jsonManager.getCantons();

        new MainScreen(new Controlador()).setVisible(true);


    }
}
