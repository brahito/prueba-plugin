package sgaviria;
import processing.core.PApplet;

public class Main extends PApplet{
	
	private Logica logica; 

	public static void main(String[] args) {
		PApplet.main("sgaviria.Main");
	}
	
	public void settings() {
		size(500, 100);
	}
	
	public void setup() {
		logica = new Logica(this);
	}
	
	public void draw() {
		logica.pintar();
	}
	
	public void mouseClicked() {
		logica.click();
	}

}
