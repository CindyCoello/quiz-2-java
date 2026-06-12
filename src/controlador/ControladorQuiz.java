package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.JuegoQuiz;
import vista.PanelJuego;
import vista.PanelResultado;
import vista.VentanaPrincipal;

public class ControladorQuiz implements ActionListener {
    private final JuegoQuiz juegoQuiz;
    private final VentanaPrincipal ventanaPrincipal;

    public ControladorQuiz() {
        juegoQuiz = new JuegoQuiz();
        ventanaPrincipal = new VentanaPrincipal();

        configurarEventos();
        ventanaPrincipal.mostrarVista(VentanaPrincipal.VISTA_BIENVENIDA);
        ventanaPrincipal.setVisible(true);
    }

    private void configurarEventos() {
        ventanaPrincipal.getPanelBienvenida().getBotonIniciar().addActionListener(this);
        ventanaPrincipal.getPanelResultado().getBotonReiniciar().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonSiguiente().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getBotonResponder().addActionListener(this);
        ventanaPrincipal.getPanelJuego().getCampoRespuesta().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object origen = e.getSource();

        if (origen == ventanaPrincipal.getPanelBienvenida().getBotonIniciar()) {
            iniciarJuego();
        } else if (origen == ventanaPrincipal.getPanelResultado().getBotonReiniciar()) {
            iniciarJuego();
        } else if (origen == ventanaPrincipal.getPanelJuego().getBotonSiguiente()) {
            continuarJuego();
        } else if (origen == ventanaPrincipal.getPanelJuego().getBotonResponder()) {
            procesarRespuesta();
        } else if (origen == ventanaPrincipal.getPanelJuego().getCampoRespuesta()) {
            procesarRespuesta();
        }
    }

    private void iniciarJuego() {
        // Reinicia puntajes e indice para empezar una nueva partida.
        juegoQuiz.reiniciar();
        actualizarPanelDeJuego();
        ventanaPrincipal.mostrarVista(VentanaPrincipal.VISTA_JUEGO);
    }

    // Lee la letra escrita por el jugador y valida que este entre A y E.
    private void procesarRespuesta() {
        PanelJuego panelJuego = ventanaPrincipal.getPanelJuego();
        String textoRespuesta = panelJuego.getTextoRespuesta();

        if (textoRespuesta.length() != 1) {
            panelJuego.mostrarErrorDeEntrada();
            return;
        }

        char respuestaSeleccionada = Character.toUpperCase(textoRespuesta.charAt(0));

        if (respuestaSeleccionada < 'A' || respuestaSeleccionada > 'E') {
            panelJuego.mostrarErrorDeEntrada();
            return;
        }

        boolean esCorrecta = juegoQuiz.verificarRespuesta(respuestaSeleccionada);
        boolean ultimaPregunta = juegoQuiz.getIndiceActual() == juegoQuiz.getTotalPreguntas() - 1;

        panelJuego.mostrarRetroalimentacion(
                esCorrecta,
                juegoQuiz.getRespuestaCorrectaActual(),
                ultimaPregunta);
    }

    private void continuarJuego() {
        if (juegoQuiz.avanzarPregunta()) {
            actualizarPanelDeJuego();
            return;
        }

        mostrarResultadoFinal();
    }

    private void actualizarPanelDeJuego() {
        PanelJuego panelJuego = ventanaPrincipal.getPanelJuego();
        panelJuego.mostrarPregunta(
                juegoQuiz.getPreguntaActual(),
                juegoQuiz.getIndiceActual() + 1,
                juegoQuiz.getTotalPreguntas(),
                juegoQuiz.getJugadorActual(),
                juegoQuiz.getPuntajeJugador1(),
                juegoQuiz.getPuntajeJugador2());
    }

    private void mostrarResultadoFinal() {
        PanelResultado panelResultado = ventanaPrincipal.getPanelResultado();
        panelResultado.mostrarResultado(
                juegoQuiz.getPuntajeJugador1(),
                juegoQuiz.getPuntajeJugador2(),
                juegoQuiz.getResultadoFinal());
        ventanaPrincipal.mostrarVista(VentanaPrincipal.VISTA_RESULTADO);
    }
}
