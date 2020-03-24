package BarraHerramientas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyListener;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeListener;

/**
 * Clase del componente Barra de Herramientas
 *
 * @author Sanchez Lopez Laura Yessenia
 * @author Jimenez Rosas Juan Jose
 * @author Garcia Garcia Jose Angel
 * @author Chavez Sanchez Kevin Edilberto
 * @version 23/03/2020
 */
public class BarraHerramientas extends JPanel {

    // Variables de instancia
    private Vector<JButton> botones;
    private LayoutManager s = null;

    /**
     * Constructor de la clase BarraHerramienta
     */
    public BarraHerramientas() {
        botones = new Vector<>(1);
        JButton btn = new JButton("Boton 1");
        btn.setOpaque(true);
        btn.setBackground(Color.decode("#eca0b6"));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Sylfaen", Font.BOLD, 13));
        btn.setBorder(BorderFactory.createEtchedBorder(Color.decode("#ffc8bd"), Color.decode("#f3d1f4")));
        agregarBoton(btn);

        setVisible(true);
        updateUI();
    }

    /**
     * Constructor para una Barra de Herramientas con n botones
     *
     * @param nBotones Número de botones como máximo a tener
     */
    public BarraHerramientas(int nBotones) {
        botones = new Vector<>(nBotones); // Creamos el vector con el tamaño que desea el cliente

        setVisible(true);
        updateUI();
    }

    /**
     * Constructor de una Barra de Herramienta con los respectivos botones
     * solicitados
     *
     * @param botones Arreglo de botones que contendrá la Barra
     */
    public BarraHerramientas(JButton[] botones) {
        this.botones = new Vector(botones.length);
        for (int i = 0; i < botones.length; i++) {
            JButton btn = botones[i];
            btn.setOpaque(true);
            btn.setBackground(Color.decode("#eca0b6"));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Sylfaen", Font.BOLD, 13));
            btn.setBorder(BorderFactory.createEtchedBorder(Color.decode("#ffc8bd"), Color.decode("#f3d1f4")));
            btn.setBounds(i * 100, 0, 100, 80);
            agregarBoton(btn);
        }

        setVisible(true);
        updateUI();
    }

    /**
     * Constructor para una barra de Herramientas de botones con el texto/datos
     * deseados.
     *
     * @param datos Arreglo de String con información para cada boton
     */
    public BarraHerramientas(String[] datos) {
        int n[] = new int[datos.length];
        this.botones = new Vector(datos.length);
        for (int i = 0; i < datos.length; i++) {
            JButton btn = new JButton(datos[i]);
            btn.setOpaque(true);
            btn.setBackground(Color.decode("#eca0b6"));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Sylfaen", Font.BOLD, 13));
            btn.setBorder(BorderFactory.createEtchedBorder(Color.decode("#ffc8bd"), Color.decode("#f3d1f4")));
            btn.setBounds(i * 100, 0, 100, 80);
            agregarBoton(btn);
        }

        setVisible(true);
        updateUI();
    }

    /**
     * Constructor para una Barra de Herramientas de botones y sus respectivos
     * iconos
     *
     * @param iconos Arreglo de iconos que contendrá cada boton
     */
    public BarraHerramientas(ImageIcon[] iconos) {
        this.botones = new Vector(iconos.length);
        for (int i = 0; i < iconos.length; i++) {
            JButton btn = new JButton("boton " + (i + 1), iconos[i]);
            btn.setOpaque(true);
            btn.setBackground(Color.decode("#eca0b6"));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Sylfaen", Font.BOLD, 13));
            btn.setBorder(BorderFactory.createEtchedBorder(Color.decode("#ffc8bd"), Color.decode("#f3d1f4")));
            agregarBoton(btn);
        }

        setVisible(true);
        updateUI();
    }

    /**
     * Constructor de una Barra de Herramientas de botones con sus respectivos
     * iconos y etiquetas
     *
     * @param iconos Arreglo de iconos que contendrá cada boton
     * @param etq Arreglo de String con información para cada boton
     */
    public BarraHerramientas(ImageIcon[] iconos, String[] etq) {
        if (iconos.length != etq.length) {
            return;
        }
        this.botones = new Vector(iconos.length);
        for (int i = 0; i < iconos.length; i++) {
            ImageIcon ico = new ImageIcon(iconos[i].getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
            JButton btn = new JButton(etq[i], ico);
            btn.setOpaque(true);
            btn.setBackground(Color.decode("#204051"));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Sylfaen", Font.BOLD, 13));
            btn.setBorder(BorderFactory.createEtchedBorder(Color.decode("#cae8d5"), Color.decode("#84a9ac")));
            agregarBoton(btn);
        }
        setOpaque(true);

        this.setVisible(true);
        updateUI();
    }

    /**
     * Método para agregar un botón a la barra
     *
     * @param b Botón a agregar
     */
    public void agregarBoton(JButton b) {
        if (s != null) {
            setLayout(s);
        }
        if (botones.capacity() <= botones.size()) {
            return;
        }
        botones.add(b);
        add(b);
    }

    /**
     * Método para agregar un botón solo con texto a la barra
     *
     * @param txt Texto que tendrá el nuevo botón
     */
    public void agregarBoton(String txt) {
        agregarBoton(new JButton(txt));
    }

    /**
     * Método para agregar un botón solo con icono a la barra
     *
     * @param icon Icono que tendrá el nuevo botón
     */
    public void agregarBoton(Icon icon) {
        agregarBoton(new JButton(icon));
    }

    /**
     * Método para agregar un botón a la barra en una posición dada
     *
     * @param b Bóton a agregar
     * @param index Posición en donde se agregará el botón
     */
    public void agregarBoton(JButton b, int index) {
        if (s != null) {
            setLayout(s);
        }
        if (botones.capacity() <= botones.size() || botones.capacity() < index) {
            return;
        }
        botones.add(index, b);
        add(b, index);
    }

    /**
     * Método para retornar el botón de la posición dada
     *
     * @param i Posición del botón (Desde 1 hasta el número de botones
     * agregados)
     * @return Botón en dicha posición y null si la posición rompe los límites
     */
    public JButton getBotonPos(int i) {
        if (i <= 0 || i > botones.size()) {
            return this.botones.elementAt(0);
        }
        return botones.elementAt(i - 1);
    }

    /**
     * Método para eliminar el botón de la posición dada
     *
     * @param i Posición del botón (Desde 1 hasta el número de botones
     * agregados)
     */
    public void EliminarBotonPos(int i) {
        if (i <= 0 || i > botones.size()) {
            return;
        }
        botones.removeElementAt(i - 1);
    }

    /**
     * Método para eliminar todos los botones
     */
    public void EliminarBotones() {
        botones.removeAllElements();
    }

    /**
     * Método para retornar el número de botones que hay en la barra
     *
     * @return número de botones agregados
     */
    public int numBot() {
        return botones.size();
    }

    /**
     * Método para retornar el número máximo de botones en la barra
     *
     * @return número de máximo de botones para agregar
     */
    public int maxBot() {
        return botones.capacity();
    }

    /**
     * Método para cambiar el número máximo de botones en la barra
     *
     * @param n Número máximo de botones para agregar
     */
    public void CamMaxBot(int n) {
        botones.setSize(n);
    }

    /**
     * Método para cambiar las etiquetas del botón en posición dada
     *
     * @param p Dato/cadena de texto nuevo que contendrá etiqueta del botón
     * @param b Contine el índice del botón a cambiar
     */
    public void setEtiqueta(String p, int b) {
        getBotonPos(b).setText(p);
    }

    /**
     * Método para cambiar el fondo de la barra
     *
     * @param c El nuevo color de la barra
     */
    public void setFondo(Color c) {
        for (JButton b : botones) {
            b.setBackground(c);
        }
    }

    /**
     * Método para cambiar el diseño a la Barra, sin eliminar los botones
     *
     * @param lm El LayoutManager a utilizar
     */
    public void cambiarDiseño(LayoutManager lm) {
        s = lm;
        Vector<JButton> nuevo = new Vector<JButton>(botones.capacity());
        for (JButton x : botones) {
            nuevo.add(x);
        }
        botones.clear();
        updateUI();
        for (JButton b : nuevo) {
            agregarBoton(b);
        }
    }

    /**
     * Método para obtener los botones de la barra
     *
     * @return Vector con los botones
     */
    public Vector<JButton> getBotones() {
        return new Vector<JButton>(botones);
    }

    /**
     * Método que te permite conectar a la Barra de Herramientas con la clase
     * Controlador
     *
     * @param c Objeto de la clase Controlador que implementa un Listener
     */
    public void conectarControlador(Object c) {
        for (int i = 0; i < botones.size(); i++) {
            if (c instanceof ActionListener) {
                botones.elementAt(i).addActionListener((ActionListener) c);
            }
            if (c instanceof AncestorListener) {
                botones.elementAt(i).addAncestorListener((AncestorListener) c);
            }
            if (c instanceof ChangeListener) {
                botones.elementAt(i).addChangeListener((ChangeListener) c);
            }
            if (c instanceof ComponentListener) {
                botones.elementAt(i).addComponentListener((ComponentListener) c);
            }
            if (c instanceof ContainerListener) {
                botones.elementAt(i).addContainerListener((ContainerListener) c);
            }
            if (c instanceof FocusListener) {
                botones.elementAt(i).addFocusListener((FocusListener) c);
            }
            if (c instanceof HierarchyListener) {
                botones.elementAt(i).addHierarchyBoundsListener((HierarchyBoundsListener) c);
            }
            if (c instanceof HierarchyBoundsListener) {
                botones.elementAt(i).addHierarchyBoundsListener((HierarchyBoundsListener) c);
            }
            if (c instanceof InputMethodListener) {
                botones.elementAt(i).addInputMethodListener((InputMethodListener) c);
            }
            if (c instanceof ItemListener) {
                botones.elementAt(i).addItemListener((ItemListener) c);
            }
            if (c instanceof KeyListener) {
                botones.elementAt(i).addKeyListener((KeyListener) c);
            }
            if (c instanceof MouseListener) {
                botones.elementAt(i).addMouseListener((MouseListener) c);
            }
            if (c instanceof MouseMotionListener) {
                botones.elementAt(i).addMouseMotionListener((MouseMotionListener) c);
            }
            if (c instanceof MouseWheelListener) {
                botones.elementAt(i).addMouseWheelListener((MouseWheelListener) c);
            }
            botones.elementAt(i).setActionCommand("boton " + (i + 1));
        }
    }
}
