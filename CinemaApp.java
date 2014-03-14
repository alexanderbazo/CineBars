import java.awt.event.KeyEvent;

import coverbar.BarEventListener;
import coverbar.CoverBar;


public class CinemaApp implements BarEventListener {

	CoverBar top;
	CoverBar bottom;
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		CinemaApp app = new CinemaApp();
	}
	
	public CinemaApp() {
		init();
	}
	
	private void init() {
		top = new CoverBar(this,CoverBar.TOP);	
		bottom = new CoverBar(this,CoverBar.BOTTOM);	
		
		top.moveToScreen(0);
		bottom.moveToScreen(0);
	}

	@Override
	public void onKeyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
	    {
	      System.exit(0);
	    }
		
		if(e.getKeyCode() == KeyEvent.VK_1)
	    {
	      top.moveToScreen(0);
	      bottom.moveToScreen(0);
	    }
		
		if(e.getKeyCode() == KeyEvent.VK_2)
	    {
			top.moveToScreen(1);
		    bottom.moveToScreen(1);
	    }
		
		if(e.getKeyCode() == KeyEvent.VK_UP)
	    {
			top.increaseSize();
		    bottom.increaseSize();
	    }
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
	    {
			top.decreaseSize();
		    bottom.decreaseSize();
	    }
		
		if(e.getKeyCode() == KeyEvent.VK_R)
	    {
			top.resetSize();
		    bottom.resetSize();
	    }
	}

}