package proyectoaplicado;

import com_grafico.Grafico;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author Garcia Garcia Jose Angel
 */
public class Vista extends JFrame {

    private JTextField txt1;
    private JTextField txt2[];
    private JTextField txtLeyendas[];
    private JLabel etqG[];
    private JLabel etq1;
    private JLabel etq2;
    private JPanel p;
    private Grafico g;
    private JButton graficar;
    private JTextField titulo;
    private JLabel etqTitulo;
    private JLabel valor;
    private JLabel leyen;

    SpringLayout s;

    public Vista() {
        super("Aplicación con el complemento \"Grafico\"");
        setResizable(false);
        setVisible(true);
        s = new SpringLayout();
        g = new Grafico();
        add(componente());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p.updateUI();
    }

    public int getTxt1() {
        if (txt1.getText().isEmpty()) {
            return 0;
        }
        int a = Integer.parseInt(txt1.getText());
        if (a < 11 && a > 0) {
            return a;
        }
        return 0;
    }

    public String getTitulo() {
        if (titulo.getText().isEmpty()) {
            return "Sin titulo";
        }
        return titulo.getText();
    }

    public Container componente() {
        setSize(400, 100);
        p = new JPanel();
        p.setLayout(s);
        graficar = new JButton("Graficar");
        etqTitulo = new JLabel("Introduce el titulo");
        titulo = new JTextField(10);
        etq1 = new JLabel("Introduce la cantidad de barras");
        txt1 = new JTextField(10);
        p.add(etqTitulo);
        s.putConstraint(SpringLayout.WEST, etqTitulo, 12, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.NORTH, etqTitulo, 12, SpringLayout.NORTH, p);
        p.add(titulo);
        s.putConstraint(SpringLayout.WEST, titulo, 90, SpringLayout.EAST, etqTitulo);
        s.putConstraint(SpringLayout.NORTH, titulo, 12, SpringLayout.NORTH, p);
        p.add(etq1);
        s.putConstraint(SpringLayout.WEST, etq1, 12, SpringLayout.WEST, p);
        s.putConstraint(SpringLayout.NORTH, etq1, 12, SpringLayout.SOUTH, etqTitulo);
        p.add(txt1);
        s.putConstraint(SpringLayout.NORTH, txt1, 12, SpringLayout.SOUTH, titulo);
        s.putConstraint(SpringLayout.WEST, txt1, 12, SpringLayout.EAST, etq1);
        etq2 = new JLabel("Introduce los datos de las barras");
        p.add(etq2);
        s.putConstraint(SpringLayout.NORTH, etq2, 25, SpringLayout.SOUTH, etq1);
        s.putConstraint(SpringLayout.WEST, etq2, 140, SpringLayout.WEST, p);
        valor = new JLabel("Valor");
        p.add(valor);
        s.putConstraint(SpringLayout.NORTH, valor, 12, SpringLayout.SOUTH, etq2);
        s.putConstraint(SpringLayout.WEST, valor, 145, SpringLayout.WEST, p);
        leyen = new JLabel("Leyenda");
        p.add(leyen);
        s.putConstraint(SpringLayout.NORTH, leyen, 12, SpringLayout.SOUTH, etq2);
        s.putConstraint(SpringLayout.WEST, leyen, 90, SpringLayout.EAST, valor);
        return p;
    }

    public void agregarOpciones() {
        setSize(430, 470);
        int nBarras = getTxt1();
        txt2 = new JTextField[nBarras];
        etqG = new JLabel[nBarras];
        txtLeyendas = new JTextField[nBarras];
        for (int i = 0; i < nBarras; i++) {
            etqG[i] = new JLabel("Datos Barra " + (i + 1));
            txt2[i] = new JTextField(10);
            txtLeyendas[i] = new JTextField(15);
            p.add(etqG[i]);
            p.add(txt2[i]);
            p.add(txtLeyendas[i]);
            s.putConstraint(SpringLayout.WEST, etqG[i], 12, SpringLayout.WEST, p);
            s.putConstraint(SpringLayout.WEST, txt2[i], 15, SpringLayout.EAST, etqG[i]);
            s.putConstraint(SpringLayout.WEST, txtLeyendas[i], 15, SpringLayout.EAST, txt2[i]);
            if (i == 0) {
                s.putConstraint(SpringLayout.NORTH, txt2[i], 12, SpringLayout.SOUTH, leyen);
                s.putConstraint(SpringLayout.NORTH, etqG[i], 15, SpringLayout.SOUTH, leyen);
                s.putConstraint(SpringLayout.NORTH, txtLeyendas[i], 12, SpringLayout.SOUTH, leyen);
            } else {
                s.putConstraint(SpringLayout.NORTH, txt2[i], 10, SpringLayout.SOUTH, txt2[i - 1]);
                s.putConstraint(SpringLayout.NORTH, etqG[i], 14, SpringLayout.SOUTH, etqG[i - 1]);
                s.putConstraint(SpringLayout.NORTH, txtLeyendas[i], 10, SpringLayout.SOUTH, txtLeyendas[i - 1]);
            }
            if (getTxt1() == 0) {
                graficar.setEnabled(false);
            }
            p.add(graficar);
            s.putConstraint(SpringLayout.WEST, graficar, 15, SpringLayout.EAST, txt1);
            s.putConstraint(SpringLayout.NORTH, graficar, 12, SpringLayout.NORTH, p);
            p.updateUI();
        }

    }

    private String[] txtLeyendas() {
        String[] l = new String[getTxt1()];
        for (int i = 0; i < l.length; i++) {
            try {
                if (txtLeyendas[i].getText().isEmpty()) {
                    throw new Exception();
                }
                l[i] = txtLeyendas[i].getText();
            } catch (Exception e) {
                l[i] = "Sin titulo";
            }
        }
        return l;
    }

    public void printf() {
        g = new Grafico(getTitulo(), txtLeyendas());
        g.setValores(valoresDeText());
        JFrame ex = new JFrame();
        ex.setTitle("Grafico solicitado");
        ex.setSize(800, 600);
        ex.setVisible(true);
        ex.setResizable(false);
        ex.setLocationRelativeTo(null);
        ex.setDefaultCloseOperation(HIDE_ON_CLOSE);
        ex.add(g);
        p.updateUI();
    }

    private int[] valoresDeText() {
        int nBarras = getTxt1();
        int valores[] = new int[nBarras];
        for (int i = 0; i < nBarras; i++) {
            int val;
            try {
                val = Integer.parseInt(txt2[i].getText());
            } catch (Exception e) {
                val = 0;
            }
            valores[i] = val;
        }
        return valores;
    }

    public void bloquearTxt(boolean b) {
        txt1.setEditable(b);
        titulo.setEditable(b);
    }

    public void conectarControlador(Controlador c) {
        txt1.addKeyListener((KeyListener) c);
        graficar.addActionListener((ActionListener) c);
    }
}
