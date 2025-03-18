# Practica 2
Practicas-Estructuras de Datos
# Alumna
Karla Romina Juárez Torres 318013712
## Descripción
Practicas de la materia estructuras de datos.


# Juego del Gato

Este es un proyecto de Java que implementa el juego del Gato utilizando Maven como herramienta de construcción, adicionalmente se agrega que fué realizado en visual studio code.


## Estructura del Proyecto
La carpeta gato tiene la siguiente estructura.

```
gato
├── .mvn
├── src
│   ├── main
│   │   └── java
│   │       └── mx
│   │           └── unam
│   │               └── fciencias
│   │                   └── edd
│   │                       └── gato
│   │                           ├── logica
│   │                           │   └── Reglas.java
│   │                           ├── modelo
│   │                           │   └── Matriz.java
│   │                           ├── vista
│   │                           │   └── InterfazUsuario.java
│   │                           └── App.java
│   └── test
│       └── java
│           └── mx
│               └── unam
│                   └── fciencias
│                       └── edd
│                           └── gato
│                               └── AppTest.java
├── target
├── pom.xml
├── .gitignore
├── LICENSE
└── README.md
```

## Requisitos

- Java JDK 17 o superior
- Maven 3.9.9

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/kr-iptonita/edd.git
   ```

2. Navega al directorio del proyecto en la rama p02 y entra a la carpeta:

   ```bash
   cd /edd/gato
   ```

3. Compila el proyecto con Maven:

   ```bash
   mvn compile
   mvn package
   ```


### Maven

   En caso de no tener maven instalado puedes seguir estas instrucciones para:

Archlinux
```
sudo pacman -S maven
```
APT
```
sudo apt install maven
```

windows
```
choco install maven
```


## Ejecución

Verifique que ya haya compilado y empaquetado el programa es necesario para obtener y correr el .jar
```bash
java -jar target/gato-1.0-SNAPSHOT.jar
```
### Salida
```
Gatito. ¡Juega conmigo!
╔═══╦═══╦═══╗
║ 1 ║ 2 ║ 3 ║
╠═══╬═══╬═══╣
║ 4 ║ 5 ║ 6 ║
╠═══╬═══╬═══╣
║ 7 ║ 8 ║ 9 ║
╚═══╩═══╩═══╝
Es el turno de X. Ingresa una posición (1-9):
```
Cada jugador podrá elegir entre cada una de las casillas y se actualizará el tablero con su simbolo correspondiente.


## Descripción del Código

### Clases Principales

- **Reglas.java**: Contiene la lógica del juego, incluyendo la gestión de turnos, movimientos y la verificación de ganadores o empates.
- **Matriz.java**: Representa la matriz del juego y maneja el estado de las celdas.
- **InterfazUsuario.java**: Gestiona la interacción con el usuario y muestra el tablero.
- **App.java**: Clase principal que inicia la aplicación.

### Funcionalidades

- **Cambio de jugador**: Alterna entre los jugadores "X" y "O".
- **Validación de movimientos**: Verifica si un movimiento es válido antes de realizarlo.
- **Detección de ganador**: Verifica si hay un ganador después de cada movimiento.
- **Detección de empate**: Verifica si el juego ha terminado en empate.

## Licencia

Este proyecto está bajo la Licencia GPL. Consulta el archivo [LICENSE](LICENSE) para más detalles.

