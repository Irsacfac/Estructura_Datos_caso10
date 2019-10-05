package arboles;

public class ArbolN_ario <T> {
	private NodoN_ario<T> raiz;
	private SplayTree<NodoN_ario<T>> splayTree;
	public ArbolN_ario() {
		// TODO Auto-generated constructor stub
		raiz = null;
		splayTree = new SplayTree<NodoN_ario<T>>();
	}
	
	public void agregar(NodoN_ario<T> pNodo, Object pPadre, Object pLlave) {
		NodoSplay<NodoN_ario<T>> miNodoSplay = new NodoSplay<NodoN_ario<T>>(pNodo);
		splayTree.buscar(pLlave);
		splayTree.agregar(miNodoSplay, pLlave); 
		if(raiz==null) {
			raiz = pNodo;
		}else if(pPadre==null){
			return;
		}else {
			pNodo.setPadre(pPadre);
			pPadre.addHijos(pNodo);
		}
	}
	public void eliminar() {
		
	}
	public NodoN_ario<T> buscar(){
		return null;
	}
}
