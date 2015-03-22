package Grilla;

public class CeldaGrilla {

	private double valorRend;

	public CeldaGrilla(double valorRend) {
		this.valorRend = valorRend;
	}

	public CeldaGrilla() {
	}

	public float getRend() {
		if (this.valorRend != 0.0) {
			return 1f;
		} else if (this.valorRend == 0.0)
			return 0f;
		float rend = (float) (this.valorRend / 10.0);
		if (rend > 1f)
			return 1f;

		if (rend != 0.0)
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA " + rend);
		return rend;
	}

}
