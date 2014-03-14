package coverbar;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class CoverBar extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int MAX_HEIGHT = 500;
	public static final int DEFAULT_HEIGHT = 100;
	public static final int TOP = 0;
	public static final int BOTTOM = 1;
	
	private int height;
	private int screen = 0;
	private int position;
	private BarEventListener parent;

	public CoverBar(BarEventListener parent, int position) {
		super();
		this.height = DEFAULT_HEIGHT;
		init(parent, height, position);
	}
	
	public CoverBar(BarEventListener parent, int position, int height) {
		super();
		init(parent, height, position);
	}
	
	public void moveToScreen(int screen) {
		if(screen >= GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices().length) return;
		
		this.screen = screen;
		GraphicsDevice d = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[screen];
		
		int screenWidth = d.getDisplayMode().getWidth();
		int screenHeight = d.getDisplayMode().getHeight();
		setSize(screenWidth,height);
		
		int x = 0;
		for(int i=0; i<screen; i++) {
			x += GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[i].getDisplayMode().getWidth();
		}
		
		
		switch(position) {
		case TOP:
			setLocation(x,0);
			break;
		case BOTTOM:
			setLocation(x,screenHeight-height);
			break;
	}
	}
	
	public void resetSize() {
		height = DEFAULT_HEIGHT;
		moveToScreen(screen);
	}
	
	public void increaseSize() {
		if(height<MAX_HEIGHT) {
			height++;
		}
		moveToScreen(screen);
	}
	
	public void decreaseSize() {
		if(height>0) {
			height--;
		}
		moveToScreen(screen);
	}
	
	private void init(BarEventListener parent, int height, int position) {
		this.position = position;
		this.height = height;
		this.parent = parent;
		
		getContentPane().setBackground(Color.BLACK);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		setAlwaysOnTop(true);
		
		addKeySupport();
	}
	
	private void addKeySupport() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				parent.onKeyPressed(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
	}
}