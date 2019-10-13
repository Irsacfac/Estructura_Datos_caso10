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
	
	public void agregar(T pElemento, NodoN_ario<T> pPadre, Object pLlave) {
		if((pElemento == null) || (pPadre == null && raiz != null) || (pLlave == null)) {
			return;
		}
		NodoN_ario<T> pNodo = new NodoN_ario<T>(pElemento);
		if(raiz == null) {
			raiz = pNodo;
			return;
		}
		NodoSplay<NodoN_ario<T>> miNodoSplay = new NodoSplay<NodoN_ario<T>>(pNodo);
		splayTree.agregar(miNodoSplay, pLlave);
		pNodo.setPadre(pPadre);
		pPadre.addHijos(pNodo);
		
	}
	
	public void eliminar(NodoN_ario<T> nodoEliminar, Object pLlave) {
		boolean aEliminar = splayTree.eliminar(nodoEliminar, pLlave);
		if(aEliminar) {
			ArrayList<NodoN_ario<T>> hijos = nodoEliminar.getHijos();
			NodoN_ario<T> padre = nodoEliminar.getPadre();
			while(!hijos.isEmpty()) {
				padre.addHijos(hijos.get(0));
				hijos.get(0).setPadre(padre);
				hijos.remove(0);
			}
			padre.getHijos().remove(nodoEliminar);
			nodoEliminar = null;
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
