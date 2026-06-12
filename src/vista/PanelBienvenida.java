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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PanelBienvenida extends JPanel {
    private final JButton botonIniciar;

    public PanelBienvenida() {
        setLayout(new BorderLayout());
        setBackground(new Color(10, 14, 33));

        JPanel tarjetaCentral = new JPanel();
        tarjetaCentral.setOpaque(true);
        tarjetaCentral.setBackground(new Color(25, 32, 61));
        tarjetaCentral.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(34, 211, 238), 3),
                BorderFactory.createEmptyBorder(30, 40, 30, 40)));
        tarjetaCentral.setLayout(new BoxLayout(tarjetaCentral, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("QUIZ BATTLE", SwingConstants.CENTER);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setForeground(new Color(232, 121, 249));
        titulo.setFont(new Font("SansSerif", Font.BOLD, 36));

        JLabel subtitulo = new JLabel("Desafio de 2 jugadores", SwingConstants.CENTER);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitulo.setForeground(new Color(186, 230, 253));
        subtitulo.setFont(new Font("SansSerif", Font.BOLD, 22));

        JTextArea reglas = new JTextArea(
                "Reglas del juego:\n"
                        + "- Son 12 preguntas de opcion multiple.\n"
                        + "- Cada pregunta tiene 5 respuestas posibles: A, B, C, D y E.\n"
                        + "- El Jugador 1 responde las preguntas 1, 3, 5...\n"
                        + "- El Jugador 2 responde las preguntas 2, 4, 6...\n"
                        + "- Cada respuesta correcta suma 1 punto.\n"
                        + "- Gana quien tenga el mayor puntaje al final.");
        reglas.setEditable(false);
        reglas.setFocusable(false);
        reglas.setOpaque(false);
        reglas.setForeground(Color.WHITE);
        reglas.setFont(new Font("SansSerif", Font.PLAIN, 18));
        reglas.setLineWrap(true);
        reglas.setWrapStyleWord(true);
        reglas.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonIniciar = new JButton("Iniciar juego");
        botonIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonIniciar.setFont(new Font("SansSerif", Font.BOLD, 20));
        botonIniciar.setBackground(new Color(34, 211, 238));
        botonIniciar.setForeground(new Color(17, 24, 39));
        botonIniciar.setFocusPainted(false);
        botonIniciar.setBorder(BorderFactory.createEmptyBorder(14, 28, 14, 28));

        tarjetaCentral.add(titulo);
        tarjetaCentral.add(Box.createRigidArea(new Dimension(0, 10)));
        tarjetaCentral.add(subtitulo);
        tarjetaCentral.add(Box.createRigidArea(new Dimension(0, 25)));
        tarjetaCentral.add(reglas);
        tarjetaCentral.add(Box.createRigidArea(new Dimension(0, 25)));
        tarjetaCentral.add(botonIniciar);

        JPanel contenedor = new JPanel(new BorderLayout());
        contenedor.setOpaque(false);
        contenedor.setBorder(BorderFactory.createEmptyBorder(70, 120, 70, 120));
        contenedor.add(tarjetaCentral, BorderLayout.CENTER);

        add(contenedor, BorderLayout.CENTER);
    }

    public JButton getBotonIniciar() {
        return botonIniciar;
    }
}
