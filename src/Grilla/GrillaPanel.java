package Grilla;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GrillaPanel extends JPanel {
	CeldaGrilla[][] grilla;
	private int cantX;
	private int cantY;
	private double tamañoCelda;

	public CeldaGrilla[][] getGrilla() {
		return grilla;
	}

	public void setGrilla(CeldaGrilla[][] grilla) {
		this.grilla = grilla;
	}

	public GrillaPanel(int cantX, int cantY, double tamañoCelda) {
		this.cantX = cantX;
		this.cantY = cantY;
		this.tamañoCelda = tamañoCelda;
	}

	public GrillaPanel() {

	}

	public void paint(Graphics g) {
		System.out.println("paint!");
//		Graphics2D g2 = (Graphics2D) g;

		// Constructs a BufferedImage of one of the predefined image types.
	    BufferedImage bufferedImage = new BufferedImage(cantX, cantY, BufferedImage.TYPE_INT_RGB);

	    // Create a graphics which can be used to draw into the buffered image
	    Graphics2D g2 = bufferedImage.createGraphics();



		float alpha = 0;
		int tamañoCeldapx = 50;

		System.out.println(this.getGrilla().length + " - " + cantX + " - " + cantY);
		System.out.println("total = " + (this.cantX * this.cantY));
		int cont = 0;
		for (int i = 0, ipx = 0; i <= this.cantY; i++, ipx += tamañoCeldapx) {
			for (int j = 0, jpx = 0; j <= this.cantX; j++, jpx += tamañoCeldapx) {
				cont++;
//				alpha = (float) (new Random().nextInt(10) / 10.0);
				// System.out.println(i + " - " + j);
				System.out.println("ipx - jpx: " + ipx + " - " + jpx);
				alpha = (float) this.grilla[i][j].getRend();
				// assert(this.grilla[i][j].getRend() == alpha);
				// System.out.println(alpha + " - "+
				// this.grilla[i][j].getRend());
				// if (alpha > 0) {
				// System.out.println("alpha: " + alpha);
				// System.out.println("i - j: " + ipx + " - " + jpx);
				// }
				// if(alpha > 1){
				// alpha = 1f;
				// }
				System.out.println("alpha: " + alpha);
				g2.setColor(Color.black);
				g2.drawRect(ipx, jpx, tamañoCeldapx, tamañoCeldapx);

				AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
				g2.setComposite(ac);
				g2.setColor(Color.BLACK);
				g2.fillRect(ipx, jpx, tamañoCeldapx, tamañoCeldapx);
			}
		}
		System.out.println("fin: " + cont);

		// Save as PNG
	    File file = new File("myimage.png");
	    try {
			ImageIO.write(bufferedImage, "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
