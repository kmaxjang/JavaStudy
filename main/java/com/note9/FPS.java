package com.note9;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;

public class FPS implements Runnable {

	private int fps = 0;
	private int frames = 0;
	private long totaltime = 0;
	private long curtime = System.currentTimeMillis();
	private long lasttime = curtime;

	private JFrame app;
	private BufferStrategy buffer;
	private BufferedImage bi;
	private Graphics graphics = null;
	private Graphics2D g2d = null;

	private Color background;

	private boolean keypressed = true;

	private Random rand = new Random();
	private int r, g, b;
	private int x, y;
	private int w = 20, h = 20;

	public FPS() {
		app = new JFrame();
		app.setIgnoreRepaint(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Canvas canvas = new Canvas();
		canvas.setIgnoreRepaint(true);
		canvas.setSize(640, 480);

		app.add(canvas);
		app.pack();
		app.setVisible(true);

		canvas.createBufferStrategy(2);
		buffer = canvas.getBufferStrategy();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		bi = gc.createCompatibleImage(640, 480);
		background = Color.BLACK;

		app.setFocusable(true);
		app.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent arg0) {
				keypressed = false;
				System.out.println("KeyPressed ");
			}

			public void keyReleased(KeyEvent arg0) {
				keypressed = false;
				System.out.println("keyReleased");

			}

			public void keyTyped(KeyEvent arg0) {
				keypressed = false;
				System.out.println("keyTyped");
			}
		});

		app.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				keypressed = false;
				System.out.println("MouseClicked");
			}

			public void mouseEntered(MouseEvent arg0) {
				keypressed = false;
				System.out.println("MouseEntered");
			}

			public void mouseExited(MouseEvent arg0) {
				keypressed = false;
				System.out.println("MouseExited");
			}

			public void mousePressed(MouseEvent arg0) {
				keypressed = false;
				System.out.println("MousePressed");
			}

			public void mouseReleased(MouseEvent arg0) {
				keypressed = false;
				System.out.println("MouseReleased");
			}

		});

		app.addWindowListener(new WindowListener() {

			public void windowActivated(WindowEvent e) {
				System.out.println("activated Ȱ��ȭ");
			}

			public void windowClosed(WindowEvent e) {
				System.out.println("closed ����");
			}

			public void windowClosing(WindowEvent e) {
				System.out.println("closing ����");
			}

			public void windowDeactivated(WindowEvent e) {
				System.out.println("deactivated ��Ȱ��ȭ");
			}

			public void windowDeiconified(WindowEvent e) {
				System.out.println("deiconified �� ������");
			}

			public void windowIconified(WindowEvent e) {
				System.out.println("iconified ������");
			}

			public void windowOpened(WindowEvent e) {
				System.out.println("opened ����");
			}

		});
		app.addComponentListener(new ComponentListener() {

			public void componentHidden(ComponentEvent e) {
				System.out.println("hidden ����");
			}

			public void componentMoved(ComponentEvent e) {
				System.out.println("moved �̵�");
			}

			public void componentResized(ComponentEvent e) {
				System.out.println("resized ũ�⺯��");
			}

			public void componentShown(ComponentEvent e) {
				System.out.println("shown ����");
			}
		});

	}

	public void run() {
		while (keypressed) {
			lasttime = curtime;
			curtime = System.currentTimeMillis();
			// ===================
//			System.out.println("FPS: "+fps+" Frames: "+frames);

			// ===================
			totaltime += curtime - lasttime;
			if (totaltime > 1000) {
				totaltime -= 1000;
				fps = frames;
				frames = 0;
			}
			frames++;

			g2d = bi.createGraphics();
			g2d.setColor(background);
			g2d.fillRect(0, 0, 639, 479);

			for (int i = 0; i < 20; i++) {
				r = rand.nextInt(256);
				g = rand.nextInt(256);
				b = rand.nextInt(256);

				g2d.setColor(new Color(r, g, b));
				/*
				 * int x = rand.nextInt(640/2); int y = rand.nextInt(480/2);
				 * 
				 * int w = rand.nextInt(640/2); int h = rand.nextInt(480/2);
				 */
				if (x > 600) {
					x = 0;
					w = 20;
					h += 10;
					y += h;
				} else {
					w += 10;
					x += w;
				}
				if (y > 440) {
					h = 20;
					y = 0;
				}
				g2d.fillRect(x, y, w, h);
			}
			g2d.setFont(new Font("Courier New", Font.PLAIN, 16));
			g2d.setColor(Color.GREEN);
			g2d.drawString(String.format("FPS: %5s Frames: %5s", fps, frames), 20, 20);

			graphics = buffer.getDrawGraphics();
			graphics.drawImage(bi, 0, 0, null);
			if (!buffer.contentsLost()) {
				buffer.show();
			}
			Thread.yield();
		}
		try {

		} finally {
			if (graphics != null) {
				graphics.dispose();
				System.out.println("�׷��� ����");
			}
			if (g2d != null) {
				g2d.dispose();
				System.out.println("2d ����");
			}
		}
	}

	public static void main(String[] ags) {
		new Thread(new FPS()).start();
	}

}
