package proyectoaplicado;

/**
 *
 * @author Garcia Garcia Jose Angel
 */
public class Modelo {

    public Modelo() {

    }

    public void mostrar(Vista v) {
        v.printf();
    }

    public void agregarCuadros(Vista v) {
        v.agregarOpciones();
        v.bloquearTxt(false);
    }
}
