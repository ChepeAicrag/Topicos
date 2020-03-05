import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Garcia Garcia Jose Angel
 */
public class Ventana extends JFrame {

    private JCheckBox[] publicidades = new JCheckBox[3];
    private JTextField votos1;
    private JTextField votos2;
    private JTextField votos3;
    private JButton votar1;
    private JButton votar2;
    private JButton votar3;
    private JTextField por1;
    private JTextField por2;
    private JTextField por3;
    private JProgressBar bar1;
    private JProgressBar bar2;
    private JProgressBar bar3;
    private JTextField pro1;
    private JTextField pro2;
    private JTextField pro3;
    private JLabel votosT;
    private JLabel presT;
    private JTextField presText;
    private JTextField votosText;
    private JButton reiniciar;

    public Ventana() {
        setSize(550, 600);
        setVisible(true);
        setContentPane(Principal());
        setResizable(false);
    }

    public void arrancar() {
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void conectarControlador(Controlador c) {
        pro1.addKeyListener((KeyListener) c);
        pro2.addKeyListener((KeyListener) c);
        pro3.addKeyListener((KeyListener) c);
        votar1.addActionListener((ActionListener) c);
        votar2.addActionListener((ActionListener) c);
        votar3.addActionListener((ActionListener) c);
        reiniciar.addActionListener((ActionListener) c);
        
    }

    public String getVotar1() {
        return votar1.getName();
    }

    public String getVotar2() {
        return votar2.getName();
    }

    public String getVotar3() {
        return votar3.getName();
    }

    public void setBar1(int i) {
        bar1.setValue(i);

    }

    public void setBar2(int i) {
        bar2.setValue(i);
    }

    public void setBar3(int i) {
        bar3.setValue(i);
    }

    public void setPor1(String d) {
        por1.setText(d);
    }

    public void setPor2(String d) {
        por2.setText(d);
    }

    public void setPor3(String d) {
        por3.setText(d);
    }

    public void setPre1(String d) {
        pro1.setText(d);
    }

    public void setPre2(String d) {
        pro2.setText(d);
    }

    public void setPre3(String d) {
        pro3.setText(d);
    }

    public void setVotos1(String d) {
        votos1.setText(d);
    }

    public void setVotos2(String d) {
        votos2.setText(d);
    }

    public void setVotos3(String d) {
        votos3.setText(d);
    }

    public int votos1() {
        String a = votos1.getText();
        if (a.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(a);
    }

    public int votos2() {
        String a = votos2.getText();
        if (a.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(a);
    }

    public int votos3() {
        String a = votos3.getText();
        if (a.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(a);
    }

    public int getPresupuesto1() {
        String a = pro1.getText();
        if (a.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(a);
    }

    public int getPresupuesto2() {
        String a = pro2.getText();
        if (a.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(a);
    }

    public int getPresupuesto3() {
        String a = pro3.getText();
        if (a.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(a);
    }

    public void establecerPresupuestoTotal(String dato) {
        presText.setText(dato);
    }

    public void establecerVotacionTotal(String dato) {
        votosText.setText(dato);
    }

    private Container Principal() {
        Container pri = new Container();
        SpringLayout s = new SpringLayout();
        pri.setLayout(s);
        Container panel1 = panel1();
        pri.add(panel1);
        s.putConstraint(SpringLayout.WEST, panel1, 12, SpringLayout.WEST, pri);
        s.putConstraint(SpringLayout.EAST, panel1, -16, SpringLayout.EAST, pri);
        s.putConstraint(SpringLayout.NORTH, panel1, 10, SpringLayout.NORTH, pri);

        Container panel2 = panel2();
        pri.add(panel2);
        s.putConstraint(SpringLayout.NORTH, panel2, 12, SpringLayout.SOUTH, panel1);
        s.putConstraint(SpringLayout.WEST, panel2, 12, SpringLayout.WEST, pri);
        s.putConstraint(SpringLayout.EAST, panel2, -16, SpringLayout.EAST, pri);
        s.putConstraint(SpringLayout.SOUTH, panel2, -230, SpringLayout.SOUTH, pri);

        Container panel3 = panel3();
        pri.add(panel3);
        s.putConstraint(SpringLayout.NORTH, panel3, 12, SpringLayout.SOUTH, panel2);
        s.putConstraint(SpringLayout.WEST, panel3, 12, SpringLayout.WEST, pri);
        s.putConstraint(SpringLayout.EAST, panel3, -16, SpringLayout.EAST, pri);
        s.putConstraint(SpringLayout.SOUTH, panel3, -160, SpringLayout.SOUTH, pri);

        Container panel4 = panel4();
        pri.add(panel4);
        s.putConstraint(SpringLayout.NORTH, panel4, 12, SpringLayout.SOUTH, panel3);
        s.putConstraint(SpringLayout.WEST, panel4, 12, SpringLayout.WEST, pri);
        s.putConstraint(SpringLayout.EAST, panel4, -16, SpringLayout.EAST, pri);
        s.putConstraint(SpringLayout.SOUTH, panel4, -40, SpringLayout.SOUTH, pri);

        return pri;

    }

    private Container panel4() {
        SpringLayout s = new SpringLayout();
        JPanel c = new JPanel(s);
        Border b = new TitledBorder(new EtchedBorder(Color.black, Color.black), "Totales");
        c.setBorder(b);
        votosT = new JLabel("Votos");
        presT = new JLabel("Presupuesto");
        votosText = new JTextField(13);
        votosText.setEditable(false);
        presText = new JTextField(13);
        presText.setEditable(false);
        reiniciar = new JButton("Reiniciar");
        c.add(votosT);
        c.add(votosText);
        c.add(presT);
        c.add(presText);
        c.add(reiniciar);
        s.putConstraint(SpringLayout.WEST, votosT, 35, SpringLayout.WEST, c);
        s.putConstraint(SpringLayout.NORTH, votosT, 10, SpringLayout.NORTH, c);
        s.putConstraint(SpringLayout.WEST, votosText, 62, SpringLayout.EAST, votosT);
        s.putConstraint(SpringLayout.NORTH, votosText, 10, SpringLayout.NORTH, c);
        s.putConstraint(SpringLayout.WEST, presT, 35, SpringLayout.WEST, c);
        s.putConstraint(SpringLayout.NORTH, presT, 28, SpringLayout.NORTH, votosT);
        s.putConstraint(SpringLayout.WEST, presText, 95, SpringLayout.WEST, presT);
        s.putConstraint(SpringLayout.NORTH, presText, 28, SpringLayout.NORTH, votosText);
        s.putConstraint(SpringLayout.WEST, reiniciar, 62, SpringLayout.EAST, votosText);
        s.putConstraint(SpringLayout.NORTH, reiniciar, 18, SpringLayout.NORTH, c);
        return c;
    }

    private Container panel3() {
        JPanel c = new JPanel();
        Border b = new TitledBorder(new EtchedBorder(Color.BLACK, Color.black), "Presupuestos");
        c.setBorder(b);
        pro1 = new JTextField(9);
        pro2 = new JTextField(9);
        pro3 = new JTextField(9);
        c.setLayout(new FlowLayout(FlowLayout.CENTER, 65, 0));
        c.add(pro1);
        c.add(pro2);
        c.add(pro3);
        return c;
    }

    private Container panel2() {
        JPanel p = new JPanel(new GridLayout(1, 3, 10, 0)); // Panel central
        SpringLayout s = new SpringLayout();
        Border border = new EtchedBorder(Color.BLACK, Color.black);

        JPanel p1 = new JPanel(s);
        p1.setBorder(border);
        ImageIcon img1 = new ImageIcon("peña.jpg");
        ImageIcon icono1 = new ImageIcon(img1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel etq1 = new JLabel(icono1);
        votar1 = new JButton("Votar1");
        votos1 = new JTextField(9);
        votos1.setEditable(false);
        por1 = new JTextField(9);
        por1.setEditable(false);
        bar1 = new JProgressBar(0, 100);
        int sep = 36;
        p1.add(etq1);
        s.putConstraint(SpringLayout.WEST, etq1, sep, SpringLayout.WEST, p1);
        s.putConstraint(SpringLayout.EAST, etq1, -22, SpringLayout.EAST, p1);
        s.putConstraint(SpringLayout.NORTH, etq1, 15, SpringLayout.NORTH, p1);
        p1.add(votar1);
        s.putConstraint(SpringLayout.WEST, votar1, sep, SpringLayout.WEST, p1);
        s.putConstraint(SpringLayout.NORTH, votar1, 10, SpringLayout.SOUTH, etq1);
        s.putConstraint(SpringLayout.EAST, votar1, -22, SpringLayout.EAST, p1);
        p1.add(votos1);
        s.putConstraint(SpringLayout.WEST, votos1, sep, SpringLayout.WEST, p1);
        s.putConstraint(SpringLayout.NORTH, votos1, 10, SpringLayout.SOUTH, votar1);
        p1.add(por1);
        s.putConstraint(SpringLayout.WEST, por1, sep, SpringLayout.WEST, p1);
        s.putConstraint(SpringLayout.NORTH, por1, 10, SpringLayout.SOUTH, votos1);
        p1.add(bar1);
        s.putConstraint(SpringLayout.WEST, bar1, sep, SpringLayout.WEST, p1);
        s.putConstraint(SpringLayout.NORTH, bar1, 10, SpringLayout.SOUTH, por1);
        s.putConstraint(SpringLayout.EAST, bar1, -22, SpringLayout.EAST, p1);

        SpringLayout s2 = new SpringLayout();
        JPanel p2 = new JPanel(s2);
        p2.setBorder(border);
        ImageIcon img2 = new ImageIcon("obrador.jpg");
        ImageIcon icono2 = new ImageIcon(img2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel etq2 = new JLabel(icono2);
        votar2 = new JButton("Votar2");
        votos2 = new JTextField(9);
        votos2.setEditable(false);
        por2 = new JTextField(9);
        por2.setEditable(false);
        bar2 = new JProgressBar(0, 100);
        p2.add(etq2);
        s2.putConstraint(SpringLayout.WEST, etq2, sep, SpringLayout.WEST, p2);
        s2.putConstraint(SpringLayout.EAST, etq2, -22, SpringLayout.EAST, p2);
        s2.putConstraint(SpringLayout.NORTH, etq2, 15, SpringLayout.NORTH, p2);
        p2.add(votar2);
        s2.putConstraint(SpringLayout.WEST, votar2, sep, SpringLayout.WEST, p2);
        s2.putConstraint(SpringLayout.NORTH, votar2, 10, SpringLayout.SOUTH, etq2);
        s2.putConstraint(SpringLayout.EAST, votar2, -22, SpringLayout.EAST, p2);
        p2.add(votos2);
        s2.putConstraint(SpringLayout.WEST, votos2, sep, SpringLayout.WEST, p2);
        s2.putConstraint(SpringLayout.NORTH, votos2, 10, SpringLayout.SOUTH, votar2);
        p2.add(por2);
        s2.putConstraint(SpringLayout.WEST, por2, sep, SpringLayout.WEST, p2);
        s2.putConstraint(SpringLayout.NORTH, por2, 10, SpringLayout.SOUTH, votos2);
        p2.add(bar2);
        s2.putConstraint(SpringLayout.WEST, bar2, sep, SpringLayout.WEST, p2);
        s2.putConstraint(SpringLayout.NORTH, bar2, 10, SpringLayout.SOUTH, por2);
        s2.putConstraint(SpringLayout.EAST, bar2, -22, SpringLayout.EAST, p2);

        SpringLayout s3 = new SpringLayout();
        JPanel p3 = new JPanel(s3);
        p3.setBorder(border);
        ImageIcon img3 = new ImageIcon("salinas.jpg");
        ImageIcon icono3 = new ImageIcon(img3.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel etq3 = new JLabel(icono3);
        votar3 = new JButton("Votar3");
        votos3 = new JTextField(9);
        votos3.setEditable(false);
        por3 = new JTextField(9);
        por3.setEditable(false);
        bar3 = new JProgressBar(0, 100);
        p3.add(etq3);
        s3.putConstraint(SpringLayout.WEST, etq3, sep, SpringLayout.WEST, p3);
        s3.putConstraint(SpringLayout.EAST, etq3, -22, SpringLayout.EAST, p3);
        s3.putConstraint(SpringLayout.NORTH, etq3, 15, SpringLayout.NORTH, p3);
        p3.add(votar3);
        s3.putConstraint(SpringLayout.WEST, votar3, sep, SpringLayout.WEST, p3);
        s3.putConstraint(SpringLayout.NORTH, votar3, 10, SpringLayout.SOUTH, etq3);
        s3.putConstraint(SpringLayout.EAST, votar3, -22, SpringLayout.EAST, p3);
        p3.add(votos3);
        s3.putConstraint(SpringLayout.WEST, votos3, sep, SpringLayout.WEST, p3);
        s3.putConstraint(SpringLayout.NORTH, votos3, 10, SpringLayout.SOUTH, votar3);
        p3.add(por3);
        s3.putConstraint(SpringLayout.WEST, por3, sep, SpringLayout.WEST, p3);
        s3.putConstraint(SpringLayout.NORTH, por3, 10, SpringLayout.SOUTH, votos3);
        p3.add(bar3);
        s3.putConstraint(SpringLayout.WEST, bar3, sep, SpringLayout.WEST, p3);
        s3.putConstraint(SpringLayout.NORTH, bar3, 10, SpringLayout.SOUTH, por3);
        s3.putConstraint(SpringLayout.EAST, bar3, -22, SpringLayout.EAST, p3);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        return p;
    }

    private Container panel1() {
        JPanel c = new JPanel();
        Border b = new TitledBorder(new EtchedBorder(Color.BLACK, Color.black), "Indique la Fuente de Inforamción");
        c.setBorder(b);
        publicidades[0] = new JCheckBox("Publicidad por Radio");
        publicidades[1] = new JCheckBox("Publicidad por Prensa");
        publicidades[2] = new JCheckBox("Publicidad por Television");
        c.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        c.add(publicidades[0]);
        c.add(publicidades[1]);
        c.add(publicidades[2]);
        return c;
    }
  }

