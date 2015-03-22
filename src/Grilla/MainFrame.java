package Grilla;

import java.io.File;
import java.io.IOException;

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
		grilla.setSize(800, 500);
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

	public static void main(String[] args) throws IOException {

		final double tamañoCelda = 0.01;
		// "y" vendría a ser latitud
		double latMin = -37.5108465428739;
		double latMax = -36.3764335428739;

		// "x" vendría a ser longitud
		double longMin = -62.3161004401404;
		double longMax = -61.7818980760294;

		int cantX = new Double(Math.floor(((longMax - longMin) / tamañoCelda))).intValue();
		int cantY = new Double(Math.floor(((latMax - latMin) / tamañoCelda))).intValue();

		CeldaGrilla[][] grilla = new CeldaGrilla[cantY + 1][cantX + 1];
		inicilizar(grilla, cantY, cantX);

//		if (true)
//			return;

		File file = new File("output");
		StringSetCreator output = new StringSetCreator();
		output.getStringSet(file);

		for (String linea : output.getStringSet(file)) {
			linea = linea.replace("<", "").replace(">", "");
			String[] datos = linea.split("	");
			int col = Integer.valueOf(datos[0].split(",")[0]);
			int fila = Integer.valueOf(datos[0].split(",")[1]);
			double rend = Double.valueOf(datos[1]);
//			System.out.println("rend "+rend);
			grilla[col][fila] = new CeldaGrilla(rend);
		}

		GrillaPanel gp = new GrillaPanel(cantX, cantY, tamañoCelda);
		gp.setCeldas(grilla);
		new MainFrame(gp).setVisible(true);

	}

	private static void inicilizar(CeldaGrilla[][] grilla, int cantY, int cantX) {
		for (int i = 0; i < cantY; i++) {
			for (int j = 0; j < cantX; j++) {
//				System.out.println(i + " - " + j);
				grilla[i][j] = new CeldaGrilla(0);
			}
		}
		System.out.println(grilla);
	}

}
