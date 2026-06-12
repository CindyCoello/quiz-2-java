# Quiz Battle - 2 Jugadores

Aplicacion de escritorio hecha en `Java Swing` para una tarea de quiz por turnos entre dos jugadores.

El proyecto esta construido con el patron `MVC` y usa una sola `JFrame` con `CardLayout` para mostrar las diferentes pantallas del juego.

## Descripcion general

El juego presenta `12 preguntas` de opcion multiple.

- Cada pregunta tiene `5 opciones`: `A`, `B`, `C`, `D` y `E`.
- El `Jugador 1` responde las preguntas 1, 3, 5, 7, 9 y 11.
- El `Jugador 2` responde las preguntas 2, 4, 6, 8, 10 y 12.
- Cada respuesta correcta suma `1 punto`.
- Al finalizar el quiz se muestran los puntajes y el ganador, o empate si ambos terminan con el mismo resultado.

## Funcionamiento

La aplicacion tiene tres vistas principales dentro de la misma ventana:

1. `Bienvenida`
   Muestra el titulo del juego, las reglas basicas y el boton para comenzar.

2. `Juego`
   Muestra el turno del jugador actual, el numero de pregunta, el marcador, el enunciado, las cinco opciones de respuesta y un campo para ingresar la letra elegida.

3. `Resultado`
   Muestra los puntajes finales y el mensaje con el ganador o empate, junto con la opcion de volver a jugar.

## Estructura del proyecto

```text
quiz/
├── .gitignore
├── README.md
├── src/
│   ├── App.java
│   ├── controlador/
│   │   └── ControladorQuiz.java
│   ├── modelo/
│   │   ├── JuegoQuiz.java
│   │   └── Pregunta.java
│   └── vista/
│       ├── PanelBienvenida.java
│       ├── PanelJuego.java
│       ├── PanelResultado.java
│       └── VentanaPrincipal.java
├── lib/
└── bin/
```

## Explicacion por capas

### Modelo

Contiene la logica del juego y los datos.

- `Pregunta.java`
  Representa una pregunta individual con su enunciado, arreglo de opciones y respuesta correcta.

- `JuegoQuiz.java`
  Controla el estado del juego:
  - banco de preguntas
  - indice de la pregunta actual
  - puntaje del jugador 1
  - puntaje del jugador 2
  - validacion de respuestas
  - avance entre preguntas
  - calculo del resultado final

### Vista

Contiene toda la interfaz grafica en Swing.

- `VentanaPrincipal.java`
  Es la unica `JFrame` del proyecto. Usa `CardLayout` para cambiar entre pantallas sin abrir nuevas ventanas.

- `PanelBienvenida.java`
  Muestra la pantalla inicial del juego.

- `PanelJuego.java`
  Muestra la pregunta actual, las opciones, el turno, el campo para escribir la letra y la retroalimentacion visual.

- `PanelResultado.java`
  Muestra el resultado final y permite reiniciar la partida.

### Controlador

Conecta la vista con el modelo.

- `ControladorQuiz.java`
  Se encarga de:
  - iniciar la partida
  - escuchar los eventos usando la interfaz `ActionListener`
  - validar respuestas usando el modelo
  - actualizar la vista
  - avanzar a la siguiente pregunta
  - mostrar el resultado final

## Flujo del juego

El flujo general es este:

1. `App.java` inicia la aplicacion.
2. Se crea `ControladorQuiz`.
3. El controlador crea `JuegoQuiz` y `VentanaPrincipal`.
4. Se muestra `PanelBienvenida`.
5. Al pulsar `Iniciar juego`, se reinicia el estado y se muestra `PanelJuego`.
6. Se carga la pregunta actual.
7. El jugador correspondiente escribe una letra entre `A` y `E` y pulsa `Responder`.
8. El controlador valida la letra ingresada y consulta al modelo si la respuesta es correcta.
9. La vista muestra el mensaje de acierto o error.
10. Al pulsar `Siguiente pregunta`, se avanza en el quiz.
11. Cuando terminan las 12 preguntas, se muestra `PanelResultado`.
12. Si el usuario pulsa `Jugar de nuevo`, el flujo vuelve a comenzar.

## Uso de arrays

La tarea pedia especificamente trabajar con arrays. Por eso, en `JuegoQuiz.java` se usan:

- `String[]` para los enunciados
- `String[][]` para las opciones
- `char[]` para las respuestas correctas

Despues esos datos se convierten en objetos `Pregunta` para mantener el codigo mas ordenado dentro de la arquitectura MVC.

## Interfaz grafica

La interfaz fue pensada con un estilo colorido tipo `neon arcade`.

- Fondo oscuro
- Paneles con colores vivos
- Marcador visible para ambos jugadores
- Opciones grandes y visibles en pantalla
- Campo de texto para responder con una letra
- Retroalimentacion visual para respuestas correctas e incorrectas

## Compilar y ejecutar

### Compilar

```bash
javac -d bin src/App.java src/controlador/*.java src/modelo/*.java src/vista/*.java
```

### Ejecutar

```bash
java -cp bin App
```

## Posibles mejoras futuras

- Personalizar nombres de jugadores
- Cambiar o ampliar el banco de preguntas
- Agregar sonido o animaciones
- Llevar temporizador por pregunta
- Cargar preguntas desde un archivo externo
