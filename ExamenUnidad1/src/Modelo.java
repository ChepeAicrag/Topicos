
public class Modelo {
    private int votosT;
    private int d1;
    private int d2;
    private int d3;
    
	public Modelo() {
	
	
}
public void actualizarVotos(Ventana v,int i) {
	d1 = v.votos1();
	d2 = v.votos2();
	d3 = v.votos3();
	if(i == 1) {
		v.setVotos1(""+(++d1));
	}
	else if(i == 2)
		v.setVotos2(""+(++d2));
	else if (i == 3)
		v.setVotos3(""+(++d3));
	}

public void actualizarPorcentaje(Ventana v) {
	votosT = d1 + d2 + d3;
	v.setPor1("" + (d1 * 100/ votosT));
	v.setPor2("" + (d2 * 100/ votosT));
	v.setPor3("" + (d3 * 100/ votosT));
	}
	
    
    public void actualizarBarras(Ventana v){
        v.setBar1((d1 * 100/ votosT));
        v.setBar2((d2 * 100/ votosT));
        v.setBar3((d3 * 100/ votosT));
    }
    
    public void actualizarTotalesVotos(Ventana v){
        v.establecerVotacionTotal("" + votosT);
    }
    
    public void actualizarPresuTotolaes(Ventana v){
        int presupuestos = v.getPresupuesto1() + v.getPresupuesto2() + v.getPresupuesto3();
        v.establecerPresupuestoTotal("" + presupuestos);
    }
    
public void limpiar(Ventana v) {
	v.establecerPresupuestoTotal("");
	v.establecerVotacionTotal("");
	v.setVotos1("0");
	v.setVotos2("0");
	v.setVotos3("0");
	v.setPre1("");
	v.setPre2("");
	v.setPre3("");
            v.setPor1("");
            v.setPor2("");
            v.setPor3("");
            v.setBar1(0);
            v.setBar2(0);
            v.setBar3(0);
            
}
	
}
