package arboles;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.ArrayInstruction;

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
	public void eliminar() {}

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
