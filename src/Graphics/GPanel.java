package Graphics;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class GPanel extends JPanel {

	Random random = new Random();

	public GPanel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics g) {
		Font font = new Font("Times New Roman", Font.BOLD, 200);
		g.setFont(font);
		// g.setColor(Color.blue);
		// g.drawString("JAVI!", 100, 200);
		// g.drawOval(23, 50, 50, 100);

		int j = 200;
		// Agrego nuevo texto cada 5px de diferencia en x,y y cambio el color de
		// cada uno aleatoriamente
		for (int i = 100; i < 200; i += 5, j += 5) {
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			g.drawString("JAVI!", i, j);
		}

		// // Sobrepongo otro texto
		// g.setColor(Color.RED);
		// g.setFont(font);
		// g.drawString("JAVI!", 95, 200);

		Graphics2D g2 = (Graphics2D) g;
		float alpha;
		int x = 0;
		for (alpha = 1f; alpha > 0f; alpha -= 0.1f) {
			g2.setColor(Color.BLACK);
			g2.fillOval(x, 300, 100, 100);
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
			g2.setComposite(ac);
			x += 50;
		}

		//Example

	}

	public GPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
