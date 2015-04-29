package Grilla;

public class CeldaGrilla {

	private double valorRend;
	private boolean vacio;

	public CeldaGrilla(double valorRend, boolean isVacio) {
		this.valorRend = valorRend;
		this.vacio = isVacio;
	}

	public void setRend(double valorRend) {
		this.valorRend = valorRend;
	}

	public boolean isVacio() {
		return vacio;
	}

	public void setVacio(boolean vacio) {
		this.vacio = vacio;
	}

	public CeldaGrilla() {
	}

	public float getRend() {
		return (float) this.valorRend;
	}

}
