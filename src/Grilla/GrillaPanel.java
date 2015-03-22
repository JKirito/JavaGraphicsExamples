package Grilla;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GrillaPanel extends JPanel {
	CeldaGrilla[][] grilla;
	private int cantX;
	private int cantY;
	private double tamañoCelda;

	public void setCeldas(CeldaGrilla[][] celdas) {
		this.grilla = celdas;
	}

	public GrillaPanel(int cantX, int cantY, double tamañoCelda) {
		this.cantX = cantX;
		this.cantY = cantY;
		this.tamañoCelda = tamañoCelda;
	}

	public GrillaPanel() {

	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		float alpha = 0;
		int tamañoCeldapx = 10;

		int ipx = 0;
		int jpx = 0;

		for (int i = 0; i < this.cantY; i++, ipx += tamañoCeldapx) {
			for (int j = 0; j < this.cantX; j++, jpx += tamañoCeldapx) {
				// alpha = (float) (new Random().nextInt(10) / 10.0);
				// System.out.println(i + " - " + j);
				alpha = 0.5f;//this.grilla[i][j].getRend();
//				System.out.println(alpha + " - "+ this.grilla[i][j].getRend());
//				if (alpha > 0) {
//					System.out.println("alpha: " + alpha);
//					System.out.println("i - j: " + ipx + " - " + jpx);
//				}
				// if(alpha > 1){
				// alpha = 1f;
				// }
				g2.setColor(Color.RED);
				g2.drawRect(ipx, jpx, tamañoCeldapx, tamañoCeldapx);

				AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
				g2.setComposite(ac);
				g2.setColor(Color.BLACK);
				g2.fillRect(ipx, jpx, tamañoCeldapx, tamañoCeldapx);
			}
		}

		// for (alpha = 1f; alpha > 0f; alpha -= 0.1f) {
		// g2.setColor(Color.BLACK);
		// g2.fillRect(x, 300, 100, 100);
		// AlphaComposite ac =
		// AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
		// g2.setComposite(ac);
		// x += 50;
		// }
	}

}
