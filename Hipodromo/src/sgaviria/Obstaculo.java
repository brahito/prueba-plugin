package sgaviria;

public class Obstaculo {
	
	private Main app;
	private int x, y;
	private boolean chocado;
	
	public Obstaculo(Main app, int y) {
		this.app = app;
		this.y = y;
		
		chocado = false;
		x = (int) app.random(50, app.width - 50);
	}
	
	public void pintar() {
		app.fill(0);
		app.ellipse(x, y, 10, 10);
	}
	
	public int getY() { return y; }
	public int getX() { return x; }
	public boolean getChocado() { return chocado; }
	public void setChocado(boolean chocado) {
		this.chocado = chocado;
	}
	
}
