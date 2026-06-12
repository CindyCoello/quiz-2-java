@echo off
title Quiz Battle Runner
cls
echo ===================================================
echo             QUIZ BATTLE RUNNER
echo ===================================================
echo.
echo Compilando los archivos Java...
if not exist build\classes mkdir build\classes
javac -d build\classes -sourcepath src src\App.java src\controlador\ControladorQuiz.java src\modelo\JuegoQuiz.java src\modelo\Pregunta.java src\vista\PanelBienvenida.java src\vista\PanelJuego.java src\vista\PanelResultado.java src\vista\VentanaPrincipal.java

if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Error durante la compilacion.
    echo Asegurese de tener instalado el JDK (javac) y que este configurado en las variables de entorno (PATH).
    echo.
    pause
    exit /b %errorlevel%
)

echo Compilacion exitosa.
echo.
echo Iniciando la aplicacion...
start javaw -cp build\classes App
echo.
echo [INFO] La ventana de la aplicacion se esta abriendo.
echo ===================================================
timeout /t 3
