package sgaviria;

public class Logica {

	private Main app;
	
	private Caballo caballo;
	private Obstaculo obs;
	
	public Logica(Main app) {
		this.app = app;
		
		caballo = new Caballo(app, 0, 50);
		//obs = new Obstaculo(app, caballo.getY());
		//caballo.setObs(obs);
	}
	
	public void pintar() {
		app.background(200);
		//obs.pintar();
		caballo.pintar();
	}
	
	public void click() {
		//System.out.println(caballo.getState().name());
		if(caballo.getState().name().equals("NEW")) {			
			caballo.start();
		}
	}
}
