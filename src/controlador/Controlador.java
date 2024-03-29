package controlador;

import java.util.ArrayList;

import JsonManager.JsonManager;
import arboles.ArbolN_ario;
import arboles.NodoN_ario;
import modelo.Sensor;
import otros.IConstants;

public class Controlador extends Thread implements IConstants{
	private ArbolN_ario<Sensor> miArbol;
	private int cm3Total;
	private JsonManager jsonManager;

	public ArbolN_ario<Sensor> getMiArbol() {
		return miArbol;
	}

	private boolean isRunning;
	
	public Controlador(){
		jsonManager = new JsonManager();
		Sensor tomaPrincipal = new Sensor("0", jsonManager.getPlantName(), jsonManager.getPlantCapacity());
		NodoN_ario<Sensor> root = new NodoN_ario<Sensor>(tomaPrincipal);
		miArbol = new ArbolN_ario<Sensor>(root);
		cm3Total = miArbol.getRaiz().getElemento().getCm3Actual();
		isRunning = true;
	}

	public void setRunning(boolean running) {
		isRunning = running;
	}

	public void run() {
		//int contador = 0;
		while(isRunning) {
			try {
				sleep(CANT_MIN);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("cm3 Planta: " + miArbol.getRaiz().getElemento().getCm3Actual());
			int cm3Actual = 0;
			Sensor actual;
			ArrayList<NodoN_ario<Sensor>> sensores =  new ArrayList<>();// = miArbol.contenido();
			sensores.addAll(miArbol.getRaiz().getHijos());
			while(sensores.size()!=0) {
				actual = sensores.get(0).getElemento();
				actual.actualizar();
				if(sensores.get(0).getHijos().size() != 0) {
					sensores.addAll(sensores.get(0).getHijos());
				}
				System.out.println(actual.getID() + ": " + actual.getCm3Actual());
				cm3Actual += actual.getCm3Actual();
				if(cm3Actual>cm3Total) {
					actual.setColor(1);
				}else {
					actual.setColor(0);
				}
				sensores.remove(0);
			}



			System.out.println("cm3 Actual: " + cm3Actual);
			//contador++;
		}
	}
	public void agregar(Sensor pSensor, NodoN_ario<Sensor> pPadre, String pLlave) {

		miArbol.agregar(pSensor, pPadre, pLlave);
	}

	public NodoN_ario<Sensor> getNodeByID(String pID){

		for (NodoN_ario<Sensor> node: miArbol.getNodosActivos()){
			if (node.getElemento().getID().equals(pID)){
				return node;
			}
		}
		return null;
	}

}
