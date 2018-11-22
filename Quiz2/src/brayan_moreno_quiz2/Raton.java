package brayan_moreno_quiz2;

import processing.core.PApplet;
import processing.core.PVector;

public class Raton {
	private PApplet app;
	private PVector pos;
	private int tam;

	public Raton(PApplet app, int x, int y) {
		this.app = app;
		pos = new PVector(x, y);
		tam=25;
	}

	public void pintar() {
		app.fill(0,0,240);
		app.ellipse(pos.x, pos.y, tam, tam);
	}

	public float getposX() {
		return pos.x;
	}
	public float getposY() {
		return pos.y;
	}

}
