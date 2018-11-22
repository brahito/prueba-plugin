package brayan_moreno_quiz2;

import processing.core.PApplet;
import processing.core.PVector;

public class Gato extends Thread {
	private PApplet app;
	private PVector pos, vel;
	private int tam, comidos;
	private boolean vivo, siguiendo;
	private Logica log;

	public Gato(PApplet app, Logica log) {
		this.app = app;
		this.log = log;
		tam = 50;
		pos = new PVector(app.width / 2, app.height / 2);
		vel = new PVector(0, 0);
		comidos = 0;
		vivo = true;
		siguiendo = false;
	}

	public void pintar() {
		if (siguiendo == true) {
			app.fill(250, 0, 0);
		} else {
			app.fill(0);
		}
		app.ellipse(pos.x, pos.y, tam, tam);
		app.fill(255);
		app.textSize(15);
		app.textAlign(PApplet.CENTER);
		app.text(comidos, pos.x, pos.y + 5);
	}

	public void run() {

		try {
			while (vivo) {

				if (log.getRatones().size() >= 1) {
					siguiendo = true;
				}
				
				if (siguiendo == true) {
					mover(log.getRatones().getFirst());
				}
				
				//
				sleep(17);
			}
		} catch (InterruptedException e) {
			// vivo = false;
			e.printStackTrace();
		}

	}

	public void mover(Raton r) {
		PVector seguir = new PVector(r.getposX(), r.getposY());
		PVector dir = PVector.sub(seguir, pos);
		dir.normalize();
		dir.mult((float) 0.5);
		vel.add(dir);
		pos.add(vel);
		// pos.x += r.getposX();
		// pos.y += r.getposY();
		// pos.normalize();

	}

	public boolean validar(Raton r) {
		if (PApplet.dist(pos.x, pos.y, r.getposX(), r.getposY())<tam/2) {
			return true;
		} else {
			return false;
		}
	}

}
