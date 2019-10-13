package controlador;

import java.util.ArrayList;

import arboles.ArbolN_ario;
import arboles.NodoN_ario;
import modelo.Sensor;
import otros.IConstants;

public class Controlador extends Thread implements IConstants{
	private ArbolN_ario<Sensor> miArbol;
	private int cm3Total;
	
	Controlador(){
		miArbol = new ArbolN_ario<Sensor>();
		cm3Total = miArbol.getRaiz().getElemento().getCm3Actual();
	}
	
	public void run() {
		try {
			sleep(CANT_MIN);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int cm3Actual = 0;
		Sensor actual;
		ArrayList<NodoN_ario<Sensor>> sensores = miArbol.contenido();
		/*
		 * hay que modificar
		 * */
		for(int cantidad = 0; cantidad < sensores.size(); cantidad++) {
			actual = sensores.get(cantidad).getElemento();
			actual.actualizar();
			cm3Actual += actual.getCm3Actual();
			if(cm3Actual>cm3Total) {
				actual.setColor(1);
			}else {
				actual.setColor(0);
			}
		}
	}
}
