package arboles;

public class ArbolN_ario <T> {
	private NodoN_ario<T> raiz;
	private SplayTree<T> splayTree;
	public ArbolN_ario() {
		// TODO Auto-generated constructor stub
		raiz = null;
		splayTree = new SplayTree<T>();
	}
	
	public void agregar(NodoN_ario<T> pNodo, NodoN_ario<T> pPadre) {
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
