package arboles;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class NodoN_ario<T> {
	private T elemento;
	private ArrayList<NodoN_ario<T>> hijos;
	private NodoN_ario<T> padre;
	private DefaultMutableTreeNode nodeGraphic;

	public NodoN_ario(T pElemento) {
		// TODO Auto-generated constructor stub
		elemento = pElemento;
		hijos = new ArrayList<NodoN_ario<T>>();
		padre = null;
		nodeGraphic = new DefaultMutableTreeNode(elemento.toString());
	}

	public ArrayList<NodoN_ario<T>> getHijos() {
		return hijos;
	}

	public void addHijos(NodoN_ario<T> pHijo) {
		hijos.add(pHijo);
	}

	public NodoN_ario<T> getPadre() {
		return padre;
	}

	public DefaultMutableTreeNode getNodeGraphic() {
		return nodeGraphic;
	}

	public void setPadre(NodoN_ario<T> pPadre) {
		this.padre = pPadre;
	}

	public T getElemento() {
		return elemento;
	}


}
