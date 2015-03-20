package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	GPanel panel;
	JButton btn;

	public GFrame() {
		// ancho-alta de la ventana
		setSize(800, 600);
		// Titulo de la ventana
		setTitle("Probando...");
		// salir del programa al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Centrado en la ṕantalla
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		panel = new GPanel();
		panel.setSize(800, 463);
		panel.setLocation(0, 0);
		getContentPane().add(panel);

		btn = new JButton();
		btn.setSize(150, 50);
		btn.setLocation(200, 500);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.repaint();
			}
		});
		btn.setText("cambiar colores");
		getContentPane().add(btn);
	}

}
