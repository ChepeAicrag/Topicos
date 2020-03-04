
public class Modelo {
	
	public Modelo() {
		
		
	}
	public void actualizarVotos(Ventana v,int i) {
		int d1 = v.votos1();
		int d2 = v.votos2();
		int d3 = v.votos3();
		if(i == 1) {
			v.setVotos1(""+(++d1));
		}
		else if(i == 2)
			v.setVotos2(""+(++d2));
		else if (i == 3)
			v.setVotos3(""+(++d3));
		}
	
	public void actualizarPorcentaje(Ventana v) {
		int d1 = v.votos1();
		int d2 = v.votos2();
		int d3 = v.votos3();
		int votosT = d1 + d2 + d3;
		v.setPor1("" + (d1 * 100/ votosT));
		v.setPor2("" + (d2 * 100/ votosT));
		v.setPor3("" + (d3 * 100/ votosT));
		}
		
	public void limpiar(Ventana v) {
		v.establecerPresupuestoTotal("");
		v.establecerVotacionTotal("");
		v.setVotos1("");
		v.setVotos2("");
		v.setVotos3("");
		v.setPre1("");
		v.setPre2("");
		v.setPre3("");
	}
	
}
