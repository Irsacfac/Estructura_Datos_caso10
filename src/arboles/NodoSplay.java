package arboles;

public class NodoSplay<T> implements Comparable<NodoSplay<T>>{
	private T elemento;
	private NodoSplay<T> hijoIzq;
	private NodoSplay<T> hijoDer;
	
	public NodoSplay(T pElemento) {
		elemento = pElemento;
		hijoIzq = null;
		hijoDer = null;
	}
	
	public NodoSplay<T> getHijoIzq() {
		return hijoIzq;
	}

	public void setHijoIzq(NodoSplay<T> pHijoIzq) {
		this.hijoIzq = pHijoIzq;
	}

	public NodoSplay<T> getHijoDer() {
		return hijoDer;
	}

	public void setHijoDer(NodoSplay<T> pHijoDer) {
		this.hijoDer = pHijoDer;
	}

	public T getElemento() {
		return elemento;
	}

	@Override
	public int compareTo(NodoSplay<T> pNodo) {
		// TODO Auto-generated method stub
		Comparable comparado = (Comparable) elemento; 
		Comparable comparador = (Comparable) pNodo.getElemento();
		int result = 0;
		try {
			result = comparado.compareTo(comparador);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}

}
