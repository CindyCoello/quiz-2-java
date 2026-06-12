package modelo;

public class Pregunta {
    private final String enunciado;
    private final String[] opciones;
    private final char respuestaCorrecta;

    public Pregunta(String enunciado, String[] opciones, char respuestaCorrecta) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.respuestaCorrecta = Character.toUpperCase(respuestaCorrecta);
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public char getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}
