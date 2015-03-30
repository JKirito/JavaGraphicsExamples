package Grilla;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import utils.StringSetCreator;

public class MainFrame extends JFrame {

	GrillaPanel grilla;

	public void setGrillaPanel(GrillaPanel gp) {
		this.grilla = gp;
	}

	public MainFrame(GrillaPanel gp) {
		this.grilla = gp;

		// ancho-alta de la ventana
		setSize(800, 700);
		// Titulo de la ventana
		setTitle("Grilla");
		// salir del programa al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Centrado en la ṕantalla
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		// grilla = gp;
		// grilla = new GrillaPanel(10, 10, 0.0001);
		grilla.setSize(1300, 600);
		grilla.setLocation(0, 0);
		getContentPane().add(grilla);

		// btn = new JButton();
		// btn.setSize(150, 50);
		// btn.setLocation(200, 500);
		// btn.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// grilla.repaint();
		// }
		// });
		// btn.setText("cambiar colores");
		// getContentPane().add(btn);
	}

	public static BufferedImage drawOutline(int w, int h, Area area) {

		final BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = result.createGraphics();

		g.setColor(Color.white);
		AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
		g.setComposite(ac);

		g.fillRect(0, 0, w, h);

		g.setClip(area);
		g.setColor(Color.green);
		g.fillRect(0, 0, w, h);

		g.setClip(null);
		g.setStroke(new BasicStroke(1));
//		g.setColor(Color.blue);
		g.draw(area);

		return result;
	}

	public static void displayAndWriteImage(BufferedImage image, String fileName) throws Exception {

		 ImageIO.write(image, "png", new File(fileName));
//		JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(image)));
	}

	public static void main(String[] args) throws Exception {

		final double tamañoCelda = 0.001;
		// "y" vendría a ser latitud
		double latMin = -37.5108465428739;
		double latMax = -36.3764335428739;

		// "x" vendría a ser longitud
		double longMin = -62.3161004401404;
		double longMax = -61.7818980760294;

		int cantX = new Double(Math.floor(((longMax - longMin) / tamañoCelda))).intValue();
		int cantY = new Double(Math.floor(((latMax - latMin) / tamañoCelda))).intValue();
		System.out.println(cantX);
		System.out.println(cantY);

		int tamañoCeldaPx = 1;

		Area area = new Area();

		// if (true)
		// return;

		CeldaGrilla[][] grilla = new CeldaGrilla[cantY + 1][cantX + 1];
		inicializar(grilla, cantY, cantX);

		File file = new File("output");
		StringSetCreator output = new StringSetCreator();
		output.getStringSet(file);

		int cont = 0;
		for (String linea : output.getStringSet(file)) {
			cont++;
			linea = linea.replace("<", "").replace(">", "");
			String[] datos = linea.split("	");
			int col = Integer.valueOf(datos[0].split(",")[0]);
			int fila = Integer.valueOf(datos[0].split(",")[1]);
			double rend = Double.valueOf(datos[1]);
			grilla[col][fila].setRend(rend);// = new CeldaGrilla(rend);
			Rectangle r = new Rectangle(col * tamañoCeldaPx, fila * tamañoCeldaPx, tamañoCeldaPx, tamañoCeldaPx);
			area.add(new Area(r));
			System.out.println("rend[" + col + "," + fila + "]: " + grilla[col][fila].getRend());
			// System.out.println("REND: "+rend);
		}
		System.out.println("CONT: " + cont);

		BufferedImage result = drawOutline(cantY * tamañoCeldaPx, cantX * tamañoCeldaPx, area);

		displayAndWriteImage(result, "ejemplo");

		if (true)
			return;

		GrillaPanel gp = new GrillaPanel(cantX, cantY, tamañoCelda);
		System.out.println(grilla.length);
		gp.setGrilla(grilla);
		System.out.println(gp.getGrilla().length);
		new MainFrame(gp).setVisible(true);
		System.out.println(gp.getGrilla().length);

	}

	private static void inicializar(CeldaGrilla[][] grilla, int cantY, int cantX) {
		for (int i = 0; i <= cantY; i++) {
			for (int j = 0; j <= cantX; j++) {
				// System.out.println(i + " - " + j);
				grilla[i][j] = new CeldaGrilla(0);
			}
		}
		System.out.println(grilla);
	}

}
