package modelo;

public class JuegoQuiz {
    private final Pregunta[] preguntas;
    private int indiceActual;
    private int puntajeJugador1;
    private int puntajeJugador2;

    public JuegoQuiz() {
        preguntas = crearBancoDePreguntas();
        reiniciar();
    }

    public void reiniciar() {
        indiceActual = 0;
        puntajeJugador1 = 0;
        puntajeJugador2 = 0;
    }

    public Pregunta getPreguntaActual() {
        return preguntas[indiceActual];
    }

    public int getIndiceActual() {
        return indiceActual;
    }

    public int getTotalPreguntas() {
        return preguntas.length;
    }

    public int getPuntajeJugador1() {
        return puntajeJugador1;
    }

    public int getPuntajeJugador2() {
        return puntajeJugador2;
    }

    public int getJugadorActual() {
        return indiceActual % 2 == 0 ? 1 : 2;
    }

    /**
     * Verifica si la respuesta seleccionada por el jugador actual es correcta.
     * Compara el carácter de la respuesta (normalizado a mayúsculas) con la respuesta correcta
     * de la pregunta activa. Si coincide, incrementa el puntaje del jugador que tiene el turno.
     * 
     * @param respuesta El carácter ('A'-'E') seleccionado por el jugador.
     * @return true si la respuesta es correcta, false de lo contrario.
     */
    public boolean verificarRespuesta(char respuesta) {
        char respuestaNormalizada = Character.toUpperCase(respuesta);
        boolean esCorrecta = respuestaNormalizada == getPreguntaActual().getRespuestaCorrecta();

        if (esCorrecta) {
            if (getJugadorActual() == 1) {
                puntajeJugador1++;
            } else {
                puntajeJugador2++;
            }
        }

        return esCorrecta;
    }

    public char getRespuestaCorrectaActual() {
        return getPreguntaActual().getRespuestaCorrecta();
    }

    /**
     * Incrementa el índice para pasar a la siguiente pregunta si no se ha alcanzado
     * el límite del banco de preguntas.
     * 
     * @return true si se avanzó con éxito, false si ya se estaba en la última pregunta.
     */
    public boolean avanzarPregunta() {
        if (indiceActual < preguntas.length - 1) {
            indiceActual++;
            return true;
        }

        return false;
    }

    public String getResultadoFinal() {
        if (puntajeJugador1 > puntajeJugador2) {
            return "Ganador: Jugador 1";
        }

        if (puntajeJugador2 > puntajeJugador1) {
            return "Ganador: Jugador 2";
        }

        return "Empate";
    }

    /**
     * Crea e inicializa el banco de preguntas completo del juego.
     * Define enunciados, opciones y respuestas correctas en arreglos paralelos
     * y luego los consolida instanciando objetos de tipo Pregunta.
     * 
     * @return Un arreglo de objetos Pregunta que conforman el juego.
     */
    private Pregunta[] crearBancoDePreguntas() {
        // Arrays pedidos por la tarea para guardar preguntas, opciones y respuestas correctas.
        String[] enunciados = {
                "¿Cual es el planeta conocido como el planeta rojo?",
                "¿Cual es la capital de Francia?",
                "¿Cuantos lados tiene un hexagono?",
                "¿Cual es el oceano mas grande del mundo?",
                "¿Cual es el resultado de 9 x 7?",
                "¿Quien escribio Don Quijote de la Mancha?",
                "¿En que continente se encuentra Egipto?",
                "¿Cual es el simbolo quimico del oro?",
                "¿Cuantos dias tiene un año bisiesto?",
                "¿Cual es el idioma oficial de Brasil?",
                "¿Que instrumento tiene teclas, pedales y cuerdas?",
                "¿Cual es el rio mas largo del mundo segun la respuesta escolar mas comun?" };

        String[][] opciones = {
                { "Venus", "Marte", "Jupiter", "Mercurio", "Saturno" },
                { "Roma", "Paris", "Lisboa", "Berlin", "Madrid" },
                { "5", "6", "7", "8", "9" },
                { "Atlantico", "Indico", "Pacifico", "Artico", "Antartico" },
                { "54", "56", "63", "67", "72" },
                { "Pablo Neruda", "Julio Cortazar", "Miguel de Cervantes", "Gabriel Garcia Marquez", "Federico Garcia Lorca" },
                { "Europa", "Asia", "Africa", "America", "Oceania" },
                { "Ag", "Au", "O", "Fe", "Go" },
                { "364", "365", "366", "367", "368" },
                { "Español", "Portugues", "Ingles", "Frances", "Italiano" },
                { "Violin", "Flauta", "Tambor", "Piano", "Trompeta" },
                { "Nilo", "Amazonas", "Misisipi", "Danubio", "Yangtse" } };

        char[] respuestasCorrectas = { 'B', 'B', 'B', 'C', 'D', 'C', 'C', 'B', 'C', 'B', 'D', 'A' };

        Pregunta[] banco = new Pregunta[enunciados.length];

        // Se crea una pregunta por cada posicion de los arrays.
        for (int i = 0; i < enunciados.length; i++) {
            banco[i] = new Pregunta(enunciados[i], opciones[i], respuestasCorrectas[i]);
        }

        return banco;
    }
}
