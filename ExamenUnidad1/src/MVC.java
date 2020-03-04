
public class MVC {

	public static void main(String[] args) {
		Ventana v = new Ventana();
		Modelo m = new Modelo();
		Controlador c = new Controlador(v, m);
		v.conectarControlador(c);
		

	}

}
