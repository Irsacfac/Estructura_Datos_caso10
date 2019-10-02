package arboles;

public class SplayTree<T> {
	private NodoSplay<T> raiz;
	
	public SplayTree() {
		// TODO Auto-generated constructor stub
		raiz = null;
	}
	
	public NodoSplay<T> buscar(T llave){
		NodoSplay<T> comparado = raiz;
		if(comparado == null) {
			return null;
		}
		return comparado;
		
	}
	public void agregar(NodoSplay<T> pNodo) {
		if(raiz==null) {
			raiz = pNodo;
		}else {
			NodoSplay<T> comparador = raiz;
			int resultComparation = comparador.compareTo(pNodo);
			while(resultComparation != 0) {
				if(resultComparation < 0) {
					if(comparador.getHijoIzq() == null) {
						comparador.setHijoIzq(pNodo);
						break;
					}else {
						comparador = comparador.getHijoIzq();
					}
				}else{
					if(comparador.getHijoDer() == null) {
						comparador.setHijoDer(pNodo);
						break;
					}else {
						comparador = comparador.getHijoDer();
					}
				}
			}
		}
	}
	public void eliminar() {}
}
