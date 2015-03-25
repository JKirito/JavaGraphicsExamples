package Grilla;

public class CeldaGrilla {

	private double valorRend;

	public CeldaGrilla(double valorRend) {
		this.valorRend = valorRend;
	}

	public void setRend(double valorRend) {
		this.valorRend = valorRend;
	}

	public CeldaGrilla() {
	}

	public float getRend() {
		float rend = (float) (this.valorRend / 10.0);
		if (this.valorRend != 0f) {
			if (rend > 1f)
				rend = 1f;
		} else if (this.valorRend == 0f)
			rend = 0f;
		return rend;
	}

}
