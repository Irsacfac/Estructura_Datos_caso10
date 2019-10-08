package arboles;

import java.util.ArrayList;

import modelo.Sensor;

public class ArbolN_ario <T> {
	private NodoN_ario<T> raiz;
	private SplayTree<NodoN_ario<T>> splayTree;
	public ArbolN_ario() {
		// TODO Auto-generated constructor stub
		raiz = null;
		splayTree = new SplayTree<NodoN_ario<T>>();
	}
	
	public void agregar(NodoN_ario<T> pNodo, NodoN_ario<T> pPadre, Object pLlave) {
		NodoSplay<NodoN_ario<T>> miNodoSplay = new NodoSplay<NodoN_ario<T>>(pNodo);
		ArrayList<NodoN_ario<T>> matches = splayTree.buscar(pLlave);
		Sensor current;
		for (int contador = 0; contador < matches.size(); contador++) {
			current = (Sensor)matches.get(contador).getElemento();
			if(current.getPath().compareTo(pLlave.toString()) == 0) {
				splayTree.agregar(miNodoSplay, pLlave);
			}
		} 
		if(raiz==null) {
			raiz = pNodo;
		}else if(pPadre==null){
			return;
		}else {
			pNodo.setPadre(pPadre);
			pPadre.addHijos(pNodo);
		}
	}
	public void eliminar(Object pLlave) {
		ArrayList<NodoN_ario<T>> matches = splayTree.buscar(pLlave);
		if(matches.size() != 0){
			for (int contador = 0; contador < matches.size(); contador++) {
				NodoN_ario<T> nodoEliminar = matches.get(contador);
				Sensor current = (Sensor)nodoEliminar.getElemento();
				if(current.getPath().compareTo(pLlave.toString()) == 0) {
					//NodoN_ario<T> nodoEliminar = matches.get(contador);
					splayTree.eliminar(splayTree.getRaiz(), pLlave);
				}
					//NodoN_ario<T> nodoEliminar = matches.get(contador);
					//splayTree.eliminar(nodoEliminar, pLlave);
					//Sensor current = (Sensor)nodo.getElemento();
					//result = current.getPath().toLowerCase().contains(pTextoBusqueda.toString().toLowerCase()) ? 0 : current.getPath().compareTo(pTextoBusqueda.toString());
			}
		}
	}
	public NodoN_ario<T> buscar(Object pLlave){
		splayTree.buscar(pLlave);
		return null;
	}
}
