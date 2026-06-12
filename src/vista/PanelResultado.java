package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelResultado extends JPanel {
    private final JLabel etiquetaTitulo;
    private final JLabel etiquetaPuntajes;
    private final JLabel etiquetaGanador;
    private final JButton botonReiniciar;

    public PanelResultado() {
        setLayout(new BorderLayout());
        setBackground(new Color(10, 14, 33));

        JPanel tarjetaCentral = new JPanel();
        tarjetaCentral.setOpaque(true);
        tarjetaCentral.setBackground(new Color(25, 32, 61));
        tarjetaCentral.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(250, 204, 21), 3),
                BorderFactory.createEmptyBorder(30, 40, 30, 40)));
        tarjetaCentral.setLayout(new BoxLayout(tarjetaCentral, BoxLayout.Y_AXIS));

        etiquetaTitulo = new JLabel("Fin del juego", SwingConstants.CENTER);
        etiquetaTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaTitulo.setForeground(new Color(34, 211, 238));
        etiquetaTitulo.setFont(new Font("SansSerif", Font.BOLD, 34));

        etiquetaPuntajes = new JLabel("J1: 0  |  J2: 0", SwingConstants.CENTER);
        etiquetaPuntajes.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaPuntajes.setForeground(Color.WHITE);
        etiquetaPuntajes.setFont(new Font("SansSerif", Font.BOLD, 24));

        etiquetaGanador = new JLabel("Ganador: Jugador 1", SwingConstants.CENTER);
        etiquetaGanador.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiquetaGanador.setForeground(new Color(232, 121, 249));
        etiquetaGanador.setFont(new Font("SansSerif", Font.BOLD, 28));

        botonReiniciar = new JButton("Jugar de nuevo");
        botonReiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonReiniciar.setFont(new Font("SansSerif", Font.BOLD, 20));
        botonReiniciar.setBackground(new Color(34, 211, 238));
        botonReiniciar.setForeground(new Color(17, 24, 39));
        botonReiniciar.setFocusPainted(false);
        botonReiniciar.setBorder(BorderFactory.createEmptyBorder(14, 28, 14, 28));

        tarjetaCentral.add(etiquetaTitulo);
        tarjetaCentral.add(Box.createRigidArea(new Dimension(0, 20)));
        tarjetaCentral.add(etiquetaPuntajes);
        tarjetaCentral.add(Box.createRigidArea(new Dimension(0, 20)));
        tarjetaCentral.add(etiquetaGanador);
        tarjetaCentral.add(Box.createRigidArea(new Dimension(0, 25)));
        tarjetaCentral.add(botonReiniciar);

        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setOpaque(false);
        contenedor.setBorder(BorderFactory.createEmptyBorder(90, 160, 90, 160));
        contenedor.add(tarjetaCentral, BorderLayout.CENTER);

        add(contenedor, BorderLayout.CENTER);
    }

    public void mostrarResultado(int puntajeJugador1, int puntajeJugador2, String resultadoFinal) {
        etiquetaPuntajes.setText("Puntaje final - Jugador 1: " + puntajeJugador1 + " | Jugador 2: " + puntajeJugador2);
        etiquetaGanador.setText(resultadoFinal);
    }

    public JButton getBotonReiniciar() {
        return botonReiniciar;
    }
}
