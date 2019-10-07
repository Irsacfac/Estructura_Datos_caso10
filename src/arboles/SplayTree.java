package arboles;

import java.util.ArrayList;

//import com.sun.org.apache.bcel.internal.generic.ArrayInstruction;

import modelo.Sensor;

public class SplayTree<T> {
	private NodoSplay<T> raiz;
	
	public SplayTree() {
		// TODO Auto-generated constructor stub
		raiz = null;
	}
	
	public ArrayList<T> buscar(Object pLlave){
		ArrayList<T> matches = new ArrayList<>();
		NodoSplay<T> comparado = raiz;
		while(comparado!=null) {
			if(comparado.compareTo(pLlave)<0) {
				comparado = comparado.getHijoIzq();
			}else if(comparado.compareTo(pLlave)>0) {
				comparado = comparado.getHijoDer();
			}else {
				matches.add(comparado.getElemento());
				otrosMatch(comparado.getHijoIzq(), matches, pLlave);
				otrosMatch(comparado.getHijoDer(), matches, pLlave);
				splay(comparado);
				return matches;
			}
		}
		return matches;
		
	}
	private void otrosMatch(NodoSplay<T> pNodo, ArrayList<T> listMatches, Object pLlave) {
		if(pNodo == null) {
			return;
		}else if(pNodo.compareTo(pLlave)==0) {
			listMatches.add(pNodo.getElemento());
			otrosMatch(pNodo.getHijoIzq(), listMatches, pLlave);
			otrosMatch(pNodo.getHijoDer(), listMatches, pLlave);
			splay(pNodo);
		}else {
			return;
		}
	}
	
	public void agregar(NodoSplay<T> pNodo, Object pLlave) {
		if(raiz==null) {
			raiz = pNodo;
		}else if(raiz.getHijoIzq() == null && raiz.compareTo(pLlave)<0){
			//rotarDerecha(pNodo);
			raiz.setPadre(pNodo);
			pNodo.setHijoDer(raiz);
			raiz = pNodo;
		}else if(raiz.getHijoDer() == null && raiz.compareTo(pLlave)>0){
			//rotarIzquierda(pNodo);
			raiz.setPadre(pNodo);
			pNodo.setHijoIzq(raiz);
			raiz = pNodo;
		}else {
			NodoSplay<T> comparado = raiz;
			while(comparado.compareTo(pLlave)!=0) {
				if(comparado.compareTo(pLlave)<0) {
					if(comparado.getHijoIzq()==null) {
						comparado.setHijoIzq(pNodo);
						splay(pNodo);
						break;
					}
					comparado = comparado.getHijoIzq();
				}else{
					if(comparado.getHijoDer()==null) {
						comparado.setHijoDer(pNodo);
						splay(pNodo);
						break;
					}
					comparado = comparado.getHijoDer();
				}
			}
			
		}
	}
	public boolean eliminar(NodoSplay<T> pNodo, Object pLlave) {
		boolean result = false;
		if(pNodo == null) {
			return result;
		}
		NodoSplay<T> nodoEliminar = pNodo;
		if (nodoEliminar.getElemento() instanceof NodoN_ario) {
			//NodoN_ario<T> nodo = (NodoN_ario<T>)elemento;
			if(nodoEliminar.compareTo(pLlave) < 0) {
				eliminar(nodoEliminar.getHijoIzq(), pLlave);
			}else if(nodoEliminar.compareTo(pLlave) > 0) {
				eliminar(nodoEliminar.getHijoDer(), pLlave);
			}else {
				Sensor current = (Sensor)nodoEliminar.getElemento();
				if(current.getPath().compareTo(pLlave.toString()) == 0){
					splay(nodoEliminar);
					NodoSplay<T> hijoIzquierdo = nodoEliminar.getHijoIzq();
					if(hijoIzquierdo != null) {
						hijoIzquierdo.setPadre(null);
						nodoEliminar.setHijoIzq(null);
					}
					NodoSplay<T> hijoDerecho = nodoEliminar.getHijoDer();
					if(hijoDerecho != null) {
						hijoDerecho.setPadre(null);
						nodoEliminar.setHijoDer(null);
					}
					raiz = unir(nodoEliminar.getHijoIzq(), nodoEliminar.getHijoDer());
					nodoEliminar = null;
					return true;
				}
				result = eliminar(nodoEliminar.getHijoIzq(), pLlave);
				if(!result) {
					eliminar(nodoEliminar.getHijoDer(), pLlave);
				}
			}
			//result = current.getPath().toLowerCase().contains(pTextoBusqueda.toString().toLowerCase()) ? 0 : current.getPath().compareTo(pTextoBusqueda.toString());
		}return result;
	}
	
	private NodoSplay<T> unir(NodoSplay<T> pNodoIzquierdo, NodoSplay<T> pNodoDerecho) {
		if(pNodoIzquierdo == null) {
			return pNodoDerecho;
		}
		if(pNodoDerecho == null) {
			return pNodoIzquierdo;
		}
		NodoSplay<T> nuevaRaiz = maximum(pNodoIzquierdo);
		splay(nuevaRaiz);
		nuevaRaiz.setHijoDer(pNodoDerecho);
		pNodoDerecho.setPadre(nuevaRaiz);
		return nuevaRaiz;
	}
	
	private NodoSplay<T> maximum(NodoSplay<T> pNodo) {
		while(pNodo.getHijoDer() != null) {
			pNodo = pNodo.getHijoDer();
		}
		return pNodo;
	}

	//rotacion a la izquierda
	private void rotarIzquierda(NodoSplay<T> pNodo) {
		NodoSplay<T> izquierdo = pNodo.getHijoDer();
		pNodo.setHijoDer(izquierdo.getHijoIzq());
		if (izquierdo.getHijoIzq() != null) {
			izquierdo.getHijoIzq().setPadre(pNodo);
		}
		izquierdo.setPadre(pNodo.getPadre());
		if (pNodo.getPadre() == null) {
			this.raiz = izquierdo;
		} else if (pNodo == pNodo.getPadre().getHijoIzq()) {
			pNodo.getPadre().setHijoIzq(izquierdo);
		} else {
			pNodo.getPadre().setHijoDer(izquierdo);
		}
		izquierdo.setHijoIzq(pNodo);
		pNodo.setPadre(izquierdo);
	}
	
	//rotacion a la derecha
	private void rotarDerecha(NodoSplay<T> pNodo) {
		NodoSplay<T> derecho = pNodo.getHijoIzq();
		pNodo.setHijoIzq(derecho.getHijoDer());
		if(derecho.getHijoDer() != null) {
			derecho.getHijoDer().setPadre(pNodo);
		}
		derecho.setPadre(pNodo.getPadre());
		if(pNodo.getPadre() == null) {
			this.raiz = derecho;
		}else if(pNodo == pNodo.getPadre().getHijoDer()) {
			pNodo.getPadre().setHijoDer(derecho);
		}else {
			pNodo.getPadre().setHijoIzq(derecho);
		}
		derecho.setHijoDer(pNodo);
		pNodo.setPadre(derecho);
	}

	private void splay(NodoSplay<T> pNodo) {
		while(pNodo.getPadre() != null) {
			if(pNodo.getPadre().getPadre()==null) {
				if(pNodo == pNodo.getPadre().getHijoIzq()) {
					//zig
					rotarDerecha(pNodo.getPadre());
				}else {
					//zag
					rotarIzquierda(pNodo.getPadre());
				}
			}else if(pNodo == pNodo.getPadre().getHijoIzq() && pNodo.getPadre() == 
					pNodo.getPadre().getPadre().getHijoIzq()) {
				//zig-zig
				rotarDerecha(pNodo.getPadre().getPadre());
				rotarDerecha(pNodo.getPadre());
			}else if(pNodo == pNodo.getPadre().getHijoDer() && pNodo.getPadre() == 
					pNodo.getPadre().getPadre().getHijoDer()) {
				//zag-zag
				rotarIzquierda(pNodo.getPadre().getPadre());
				rotarIzquierda(pNodo.getPadre());
			}else if(pNodo==pNodo.getPadre().getHijoDer() && pNodo.getPadre() ==
					pNodo.getPadre().getPadre().getHijoIzq()) {
				//zig-zag
				rotarIzquierda(pNodo.getPadre());
				rotarDerecha(pNodo.getPadre());
			}else {
				//zag-zig
				rotarDerecha(pNodo.getPadre());
				rotarIzquierda(pNodo.getPadre());
			}
		}
	}
}
