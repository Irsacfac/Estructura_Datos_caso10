package arboles;
import modelo.Sensor;

public class NodoSplay<T> implements Comparable {
	private T elemento;
	private NodoSplay<T> padre;
	private NodoSplay<T> hijoIzq;
	private NodoSplay<T> hijoDer;
	
	public NodoSplay(T pElemento) {
		elemento = pElemento;
		hijoIzq = null;
		hijoDer = null;
		padre = null;
	}
	
	public NodoSplay<T> getPadre(){
		return padre;
	}
	
	public void setPadre(NodoSplay<T> pPadre) {
		this.padre = pPadre;
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
	public int compareTo(Object pTextoBusqueda) {
		// TODO Auto-generated method stub
		int result = -1;
		
		if (elemento instanceof NodoN_ario) {
			NodoN_ario<T> nodo = (NodoN_ario<T>)elemento;
			Sensor current = (Sensor)nodo.getElemento();
			result = current.getPath().toLowerCase().contains(pTextoBusqueda.toString().toLowerCase()) ? 0 : current.getPath().compareTo(pTextoBusqueda.toString());
		}
		
		return result;
	}

}
