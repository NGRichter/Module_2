package ss.week7.mandel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//7.2 Every time you click draw it creates a new thread that will draw all the pixels.
//It does not matter what other threads do it just changes the pixel color of a certain pixel.

//7.3 The program becomes unresponsive, because the only thread there is is busy calculating the pixel colors.
//After the pixels are calculated you program becomes responsive again for mouse clicks.

/**
 * Drawing the mandelbrot set is a time consuming process.
 * The program is meant to illustrate the use of a thread for this proces
 * so the GUI buttons are still responsive to user actions.
 * @author: Martin Kalin
 */
public class MandelSet {
	public MandelSet() {
		canvas = new MandelPanel();
		win = new JFrame("Mandelbrot Set");
		Container c = win.getContentPane();
		c.setBackground(Color.white);
		c.setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem draw = new JMenuItem("Draw", 'D');
		draw.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(canvas);
				t.start();
			}
		});
		JMenuItem exit = new JMenuItem("Exit", 'E');
		exit.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(draw);
		menu.add(exit);
		menuBar.add(menu);
		win.setJMenuBar(menuBar);
		c.add(canvas, BorderLayout.CENTER);
		win.setSize(400, 400);
		win.setVisible(true);
	}

	private JFrame win;
	private MandelPanel canvas;

	public static void main(String[] args) {
		new MandelSet();
	}
}
