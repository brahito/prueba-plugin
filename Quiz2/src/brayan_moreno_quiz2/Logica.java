package brayan_moreno_quiz2;

import java.util.LinkedList;

import processing.core.PApplet;

public class Logica {
	private PApplet app;
	private LinkedList<Raton> ratones;
	private Gato gato;

	public Logica(PApplet app) {
		this.app = app;
		ratones = new LinkedList<Raton>();
		gato = new Gato(app,this);
		gato.start();
	}

	public void pintar() {
		gato.pintar();
		for (int i = 0; i < ratones.size(); i++) {
			ratones.get(i).pintar();
		}

	}

	public void pressed() {
		ratones.add(new Raton(app, app.mouseX, app.mouseY));
	}

	public void eliminarRaton() {
		ratones.removeFirst();
	}

	public LinkedList<Raton> getRatones() {
		return ratones;
	}

}
