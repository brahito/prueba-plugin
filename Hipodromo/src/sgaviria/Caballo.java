package sgaviria;

import java.util.ArrayList;

import processing.core.PApplet;

public class Caballo extends Thread {

	private Main app;
	private int y, col;
	private float vel, x;
	private boolean chocado;
	private ArrayList<Obstaculo> obs;
	
	public Caballo(Main app, int x, int y) {
		this.app = app;
		this.x = x;
		this.y = y;
		
		vel = (int) app.random(2, 10);
		col = app.color(255);
		chocado = false;
		
		obs = new ArrayList<Obstaculo>();
		for(int i = 0; i < 4; i++) {
			obs.add(new Obstaculo(app, y));
		}
	}
	
	public void pintar() {
		app.fill(col);
		app.ellipse(x, y, 30, 20);
		
		for(int i = 0; i < obs.size(); i++) {
			obs.get(i).pintar();
		}
	}
	
	public void run() {
		//System.out.println("antes del while");
		while(x < app.width) {
			//System.out.println("en el while");
			mover();
			for(int i = 0; i < obs.size(); i++) {
				float ran = app.random(1);
				if(validar(obs.get(i)) 
						&& ran < .2
						&& !obs.get(i).getChocado()) {
					System.out.println("choque");
					col = app.color(200,40,40);
					vel *= .5;
					obs.get(i).setChocado(true);
				}
			}
			try {
				sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println("después del while");
	}
	
	public boolean validar(Obstaculo obs) {
		return PApplet.dist(x, y, obs.getX(), obs.getY()) < 10;
	}
	
	public void mover() {
		x += vel;
	}
	
	public int getY() { return y; }
	public float getX() { return x; }

}
