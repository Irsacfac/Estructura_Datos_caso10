package arboles;

public class NodoBinario<T> {
	private T elemento;
	private NodoBinario<T> hijoIzq;
	private NodoBinario<T> hijoDer;

	public NodoBinario(T pElemento) {
		elemento = pElemento;
		hijoIzq = null;
		hijoDer = null;
	}

	public NodoBinario<T> getHijoIzq() {
		return hijoIzq;
	}

	public void setHijoIzq(NodoBinario<T> pHijoIzq) {
		this.hijoIzq = pHijoIzq;
	}

	public NodoBinario<T> getHijoDer() {
		return hijoDer;
	}

	public void setHijoDer(NodoBinario<T> pHijoDer) {
		this.hijoDer = pHijoDer;
	}

	public T getElemento() {
		return elemento;
	}
	
}
