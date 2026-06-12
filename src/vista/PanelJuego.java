package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import modelo.Pregunta;

public class PanelJuego extends JPanel {
    private final JLabel etiquetaTurno;
    private final JLabel etiquetaPregunta;
    private final JLabel etiquetaMarcador;
    private final JTextArea etiquetaEnunciado;
    private final JLabel etiquetaRetroalimentacion;
    private final JLabel[] etiquetasOpciones;
    private final JTextField campoRespuesta;
    private final JButton botonResponder;
    private final JButton botonSiguiente;

    public PanelJuego() {
        setLayout(new BorderLayout(20, 20));
        setBackground(new Color(10, 14, 33));
        setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        // Parte superior con turno, numero de pregunta y marcador.
        JPanel panelSuperior = new JPanel(new GridLayout(1, 3, 15, 0));
        panelSuperior.setOpaque(false);

        etiquetaTurno = crearTarjeta("Turno del Jugador 1", new Color(232, 121, 249));
        etiquetaPregunta = crearTarjeta("Pregunta 1 de 12", new Color(250, 204, 21));
        etiquetaMarcador = crearTarjeta("J1: 0  |  J2: 0", new Color(34, 211, 238));

        panelSuperior.add(etiquetaTurno);
        panelSuperior.add(etiquetaPregunta);
        panelSuperior.add(etiquetaMarcador);

        // Parte central con el enunciado y las cinco opciones.
        JPanel panelCentral = new JPanel(new BorderLayout(0, 20));
        panelCentral.setOpaque(true);
        panelCentral.setBackground(new Color(25, 32, 61));
        panelCentral.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(99, 102, 241), 3),
                BorderFactory.createEmptyBorder(25, 25, 25, 25)));

        JLabel titulo = new JLabel("Zona de preguntas", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setForeground(new Color(191, 219, 254));

        etiquetaEnunciado = new JTextArea();
        etiquetaEnunciado.setEditable(false);
        etiquetaEnunciado.setFocusable(false);
        etiquetaEnunciado.setLineWrap(true);
        etiquetaEnunciado.setWrapStyleWord(true);
        etiquetaEnunciado.setOpaque(false);
        etiquetaEnunciado.setFont(new Font("SansSerif", Font.BOLD, 24));
        etiquetaEnunciado.setForeground(Color.WHITE);
        etiquetaEnunciado.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        JPanel panelContenido = new JPanel(new BorderLayout(0, 10));
        panelContenido.setOpaque(false);
        panelContenido.add(etiquetaEnunciado, BorderLayout.NORTH);

        JPanel panelOpciones = new JPanel(new GridLayout(5, 1, 0, 12));
        panelOpciones.setOpaque(false);
        etiquetasOpciones = new JLabel[5];

        for (int i = 0; i < etiquetasOpciones.length; i++) {
            etiquetasOpciones[i] = new JLabel("", SwingConstants.CENTER);
            etiquetasOpciones[i].setOpaque(true);
            etiquetasOpciones[i].setFont(new Font("SansSerif", Font.BOLD, 18));
            etiquetasOpciones[i].setBackground(new Color(55, 65, 81));
            etiquetasOpciones[i].setForeground(Color.WHITE);
            etiquetasOpciones[i].setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(34, 211, 238), 2),
                    BorderFactory.createEmptyBorder(12, 14, 12, 14)));
            panelOpciones.add(etiquetasOpciones[i]);
        }

        etiquetaRetroalimentacion = new JLabel("Escribe una letra entre A y E para responder.", SwingConstants.CENTER);
        etiquetaRetroalimentacion.setFont(new Font("SansSerif", Font.BOLD, 18));
        etiquetaRetroalimentacion.setForeground(new Color(186, 230, 253));

        campoRespuesta = new JTextField();
        campoRespuesta.setHorizontalAlignment(JTextField.CENTER);
        campoRespuesta.setFont(new Font("SansSerif", Font.BOLD, 18));
        campoRespuesta.setBackground(new Color(55, 65, 81));
        campoRespuesta.setForeground(Color.WHITE);
        campoRespuesta.setCaretColor(Color.WHITE);
        campoRespuesta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(232, 121, 249), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        botonResponder = new JButton("Responder");
        botonResponder.setFocusPainted(false);
        botonResponder.setFont(new Font("SansSerif", Font.BOLD, 18));
        botonResponder.setBackground(new Color(34, 211, 238));
        botonResponder.setForeground(new Color(17, 24, 39));

        botonSiguiente = new JButton("Siguiente pregunta");
        botonSiguiente.setFocusPainted(false);
        botonSiguiente.setFont(new Font("SansSerif", Font.BOLD, 18));
        botonSiguiente.setBackground(new Color(250, 204, 21));
        botonSiguiente.setForeground(new Color(17, 24, 39));
        botonSiguiente.setVisible(false);

        JPanel panelEntrada = new JPanel(new GridLayout(1, 2, 12, 0));
        panelEntrada.setOpaque(false);
        panelEntrada.add(campoRespuesta);
        panelEntrada.add(botonResponder);

        JPanel panelInferior = new JPanel(new BorderLayout(0, 12));
        panelInferior.setOpaque(false);
        panelInferior.add(panelEntrada, BorderLayout.NORTH);
        panelInferior.add(etiquetaRetroalimentacion, BorderLayout.CENTER);
        panelInferior.add(botonSiguiente, BorderLayout.SOUTH);

        panelContenido.add(panelOpciones, BorderLayout.CENTER);

        panelCentral.add(titulo, BorderLayout.NORTH);
        panelCentral.add(panelContenido, BorderLayout.CENTER);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private JLabel crearTarjeta(String texto, Color borde) {
        JLabel etiqueta = new JLabel(texto, SwingConstants.CENTER);
        etiqueta.setOpaque(true);
        etiqueta.setBackground(new Color(25, 32, 61));
        etiqueta.setForeground(Color.WHITE);
        etiqueta.setFont(new Font("SansSerif", Font.BOLD, 18));
        etiqueta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borde, 3),
                BorderFactory.createEmptyBorder(16, 12, 16, 12)));
        etiqueta.setPreferredSize(new Dimension(100, 70));
        return etiqueta;
    }

    /**
     * Actualiza y dibuja los componentes visuales del panel para presentar una nueva pregunta.
     * Restablece el campo de texto de respuesta, habilita los botones correspondientes,
     * enfoca el campo de entrada y actualiza las etiquetas de los marcadores y el turno del jugador.
     * 
     * @param pregunta Objeto de tipo Pregunta a mostrar.
     * @param numeroPregunta El índice visual de la pregunta (1-based).
     * @param totalPreguntas El número total de preguntas del juego.
     * @param jugadorActual El identificador del jugador que tiene el turno actual.
     * @param puntajeJugador1 El puntaje acumulado del jugador 1.
     * @param puntajeJugador2 El puntaje acumulado del jugador 2.
     */
    public void mostrarPregunta(Pregunta pregunta, int numeroPregunta, int totalPreguntas, int jugadorActual,
            int puntajeJugador1, int puntajeJugador2) {
        etiquetaTurno.setText("Turno del Jugador " + jugadorActual);
        etiquetaPregunta.setText("Pregunta " + numeroPregunta + " de " + totalPreguntas);
        etiquetaMarcador.setText("J1: " + puntajeJugador1 + "  |  J2: " + puntajeJugador2);
        etiquetaEnunciado.setText(pregunta.getEnunciado());
        etiquetaEnunciado.setCaretPosition(0);

        char[] letras = { 'A', 'B', 'C', 'D', 'E' };
        String[] opciones = pregunta.getOpciones();

        for (int i = 0; i < etiquetasOpciones.length; i++) {
            etiquetasOpciones[i].setText(letras[i] + ") " + opciones[i]);
        }

        campoRespuesta.setText("");
        campoRespuesta.setEnabled(true);
        campoRespuesta.requestFocusInWindow();
        botonResponder.setEnabled(true);
        etiquetaRetroalimentacion.setText("Escribe una letra entre A y E para responder.");
        etiquetaRetroalimentacion.setForeground(new Color(186, 230, 253));
        botonSiguiente.setVisible(false);
        revalidate();
        repaint();
    }

    public String getTextoRespuesta() {
        return campoRespuesta.getText().trim();
    }

    public void mostrarErrorDeEntrada() {
        etiquetaRetroalimentacion.setText("Ingresa solo una letra entre A y E.");
        etiquetaRetroalimentacion.setForeground(new Color(239, 68, 68));
        campoRespuesta.requestFocusInWindow();
    }

    /**
     * Muestra visualmente la retroalimentación al jugador después de enviar una respuesta.
     * Cambia el color de la retroalimentación (verde si es correcta, rojo si es incorrecta),
     * inhabilita el campo de entrada y el botón de responder para evitar envíos múltiples,
     * y hace visible el botón para avanzar a la siguiente pregunta o finalizar.
     * 
     * @param esCorrecta Indica si la respuesta del usuario coincide con la correcta.
     * @param respuestaCorrecta El carácter de la respuesta correcta de la pregunta actual.
     * @param ultimaPregunta true si es la última pregunta del quiz, false en caso contrario.
     */
    public void mostrarRetroalimentacion(boolean esCorrecta, char respuestaCorrecta, boolean ultimaPregunta) {
        if (esCorrecta) {
            etiquetaRetroalimentacion.setText("Respuesta correcta. Sumaste 1 punto.");
            etiquetaRetroalimentacion.setForeground(new Color(34, 197, 94));
        } else {
            etiquetaRetroalimentacion.setText("Respuesta incorrecta. La correcta era: " + respuestaCorrecta);
            etiquetaRetroalimentacion.setForeground(new Color(239, 68, 68));
        }

        campoRespuesta.setEnabled(false);
        botonResponder.setEnabled(false);

        botonSiguiente.setText(ultimaPregunta ? "Ver resultado" : "Siguiente pregunta");
        botonSiguiente.setVisible(true);
    }

    public JButton getBotonResponder() {
        return botonResponder;
    }

    public JTextField getCampoRespuesta() {
        return campoRespuesta;
    }

    public JButton getBotonSiguiente() {
        return botonSiguiente;
    }
}
