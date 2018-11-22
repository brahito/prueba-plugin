package brayan_moreno_quiz2;

import processing.core.PApplet;

public class Main extends PApplet {
	Logica log;

	public static void main(String[] args) {
		PApplet.main("brayan_moreno_quiz2.Main");

	}

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		log = new Logica(this);
	}

	public void draw() {
		background(255);
		log.pintar();
	}

	public void mousePressed() {
		log.pressed();
	}

}
