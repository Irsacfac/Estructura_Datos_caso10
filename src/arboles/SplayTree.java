package arboles;

import java.util.ArrayList;

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
				splay(comparado);
				otrosMatch(comparado.getHijoIzq(), matches, pLlave);
				otrosMatch(comparado.getHijoDer(), matches, pLlave);
				return matches;
			}
		}
		return matches;
		
	}

	private void otrosMatch(NodoSplay<T> pNodo, ArrayList<T> listMatches, Object pLlave) {
		if(pNodo == null || pLlave == null) {
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
	
	public void agregar(T pElemento, Object pLlave) {
		if(pElemento == null) {
			return;
		}
		NodoSplay<T> pNodo = new NodoSplay<T>(pElemento);
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
						pNodo.setPadre(comparado);
						splay(pNodo);
						return;
					}
					else {
						comparado = comparado.getHijoIzq();
					}
				}else{
					if(comparado.getHijoDer()==null) {
						comparado.setHijoDer(pNodo);
						pNodo.setPadre(comparado);
						splay(pNodo);
						return;
					}
					comparado = comparado.getHijoDer();
				}
			}
			if(comparado.getHijoDer() != null && comparado.getHijoDer().compareTo(pLlave) == 0) {
				comparado = comparado.getHijoDer();
				while(comparado.getHijoIzq() != null) {
					if(comparado.getHijoIzq().compareTo(pLlave) != 0) {
						NodoSplay<T> pNodoIzquierdo = comparado.getHijoIzq();
						pNodo.setPadre(comparado);
						pNodo.setHijoIzq(pNodoIzquierdo);
						pNodoIzquierdo.setPadre(pNodo);
						splay(pNodo);
						return;
					}
					comparado = comparado.getHijoIzq();
				}
				comparado.setHijoIzq(pNodo);
				pNodo.setPadre(comparado);
				splay(pNodo);
			}else {
				NodoSplay<T> pNodoDerecho = comparado.getHijoDer();
				pNodo.setPadre(comparado);
				pNodo.setHijoDer(pNodoDerecho);
				pNodoDerecho.setPadre(pNodo);
				splay(pNodo);
			}
		}
	}
	public boolean eliminar(T nodoEliminar, Object pLlave) {
		return eliminar(nodoEliminar, raiz, pLlave);
	}
	
	private boolean eliminar(T nodoEliminar, NodoSplay<T> pNodo, Object pLlave) {
		boolean result = false;
		if(pNodo == null) {
			return result;
		}else if(pNodo.compareTo(pLlave) < 0) {
			result = eliminar(nodoEliminar, pNodo.getHijoIzq(), pLlave);
		}else if(pNodo.compareTo(pLlave) > 0) {
			result = eliminar(nodoEliminar, pNodo.getHijoDer(), pLlave);
		}else if(pNodo.compareTo(pLlave) == 0) {
			if(pNodo.getElemento().equals(nodoEliminar)) {
				splay(pNodo);
				NodoSplay<T> hijoIzquierdo = pNodo.getHijoIzq();
				NodoSplay<T> hijoDerecho = pNodo.getHijoDer();
				if(hijoIzquierdo != null) {
					hijoIzquierdo.setPadre(null);
					pNodo.setHijoIzq(null);
				}
				if(hijoDerecho != null) {
					hijoDerecho.setPadre(null);
					pNodo.setHijoDer(null);
				}
				raiz = unir(hijoIzquierdo, hijoDerecho);
				pNodo = null;
				return true;
			}
			result = eliminar(nodoEliminar, pNodo.getHijoIzq(), pLlave);
			if(!result) {
				result = eliminar(nodoEliminar, pNodo.getHijoDer(), pLlave);
			}
		}
		return result;
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
	
	public void contenido(ArrayList<T> pArray, NodoSplay<T> pNodo){
		if(pNodo.getHijoIzq() != null) {
			contenido(pArray, pNodo.getHijoIzq());
		}
		pArray.add(pNodo.getElemento());
		if(pNodo.getHijoDer() != null) {
			contenido(pArray, pNodo.getHijoDer());
		}
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
	public NodoSplay<T> getRaiz(){
		return raiz;
	}
}
