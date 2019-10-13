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

		if((pElemento == null) || (pPadre == null && raiz != null) || (pLlave == null)) {
			return;
		}

		NodoN_ario<T> nodo = new NodoN_ario<T>(pElemento);
		if(raiz == null) {
			raiz = nodo;
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
	
	public ArrayList<NodoN_ario<T>> buscar(Object pLlave){
		ArrayList<NodoN_ario<T>> miArray = splayTree.buscar(pLlave);
		return miArray;
	}
	
	public ArrayList<NodoN_ario<T>> contenido(){
		ArrayList<NodoN_ario<T>> miArray = new ArrayList<NodoN_ario<T>>();
		splayTree.contenido(miArray, splayTree.getRaiz());
		return miArray;
	}
	
	public NodoN_ario<T> getRaiz(){
		return raiz;
	}



}
