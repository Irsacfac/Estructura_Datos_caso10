package arboles;

import java.util.ArrayList;

import modelo.Sensor;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class ArbolN_ario <T> {
	private NodoN_ario<T> raiz;
	private SplayTree<NodoN_ario<T>> splayTree;
	private JTree graphic;


	public ArbolN_ario(NodoN_ario<T> pRaiz) {
		raiz = pRaiz;
		splayTree = new SplayTree<NodoN_ario<T>>();
		graphic = new JTree(pRaiz.getNodeGraphic());
	}
	
	public void agregar(T pElemento, NodoN_ario<T> pPadre, Object pLlave) {

		NodoN_ario<T> nodo = new NodoN_ario<T>(pElemento);

		if(pPadre == null) {
			return;
		}

		NodoSplay<NodoN_ario<T>> miNodoSplay = new NodoSplay<NodoN_ario<T>>(nodo);
		splayTree.agregar(miNodoSplay, pLlave);

		nodo.setPadre(pPadre);
		pPadre.addHijos(nodo);

		pPadre.getNodeGraphic().add(nodo.getNodeGraphic());

	}
	
	public void eliminar(NodoN_ario<T> pNodoEliminar, Object pLlave) {
		boolean aEliminar = splayTree.eliminar(pNodoEliminar, pLlave);
		if(aEliminar) {
			ArrayList<NodoN_ario<T>> hijos = pNodoEliminar.getHijos();
			NodoN_ario<T> padre = pNodoEliminar.getPadre();
			while(!hijos.isEmpty()) {
				padre.addHijos(hijos.get(0));
				hijos.get(0).setPadre(padre);
				hijos.remove(0);
			}
			padre.getHijos().remove(pNodoEliminar);
			pNodoEliminar = null;
		}
	}
	
	public NodoN_ario<T> buscar(Object pLlave){
		splayTree.buscar(pLlave);
		return null;
	}
	public NodoN_ario<T> getRaiz() {
		return raiz;
	}



}
