package vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {
    public static final String VISTA_BIENVENIDA = "bienvenida";
    public static final String VISTA_JUEGO = "juego";
    public static final String VISTA_RESULTADO = "resultado";

    private final CardLayout cardLayout;
    private final JPanel contenedor;
    private final PanelBienvenida panelBienvenida;
    private final PanelJuego panelJuego;
    private final PanelResultado panelResultado;

    public VentanaPrincipal() {
        setTitle("Quiz Battle - 2 Jugadores");
        setSize(960, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        panelBienvenida = new PanelBienvenida();
        panelJuego = new PanelJuego();
        panelResultado = new PanelResultado();

        contenedor.add(panelBienvenida, VISTA_BIENVENIDA);
        contenedor.add(panelJuego, VISTA_JUEGO);
        contenedor.add(panelResultado, VISTA_RESULTADO);

        setContentPane(contenedor);
    }

    public void mostrarVista(String nombreVista) {
        cardLayout.show(contenedor, nombreVista);
    }

    public PanelBienvenida getPanelBienvenida() {
        return panelBienvenida;
    }

    public PanelJuego getPanelJuego() {
        return panelJuego;
    }

    public PanelResultado getPanelResultado() {
        return panelResultado;
    }
}
