# edd
Practicas-Estructuras de Datos
# Alumna
Karla Romina Juárez Torres
## Descripción
Practicas de la materia estructuras de datos.

# Güol-Mart

Güol-Mart es un proyecto de Maven que simula el funcionamiento de colas en un supermercado. El proyecto fue desarrollado para la asignatura de Estructuras de Datos y permite gestionar clientes en varias cajas, actualizando sus artículos, asignando automáticamente la caja con menos carga y removiendo clientes de las colas.

## Características

- **Gestión de colas:** Se asignan clientes a la caja disponible con menos artículos en cola.
- **Actualización y eliminación:** Permite actualizar el número de artículos de un cliente y remover clientes específicos de la cola.
- **Interfaz de usuario en consola:** Implementación interactiva para simular la experiencia en un supermercado.

## Estructura del Proyecto

El proyecto sigue la siguiente estructura:

```
guolmart/
├── pom.xml
├── .mvn/
│   ├── jvm.config
│   └── maven.config
├── src/
│   ├── main/
│   │   └── java/
│   │       └── mx/
│   │           └── unam/
│   │               └── fciencias/
│   │                   └── edd/
│   │                       ├── App.java
│   │                       ├── logica/
│   │                       │   └── GestorColas.java
│   │                       ├── modelo/
│   │                       │   ├── Caja.java
│   │                       │   └── Cliente.java
│   │                       └─ vista/
│   │                           └─ InterfazUsuario.java
│   └── test/
│       └── java/
│           └── mx/
│               └── unam/
│                   └── fciencias/
│                       └── edd/
│                           └── AppTest.java
└── target/
```

## Requisitos

- **Java 21:** Se usa la versión 21 del JDK.
- **Maven:** El proyecto utiliza Maven para la gestión de dependencias y la compilación.

## Compilación y Ejecución

Para compilar y ejecutar el proyecto, utiliza los siguientes comandos desde la raíz del proyecto:

1. **Compilar el proyecto:**

    ```sh
    cd /guolmart
    mvn clean compile package
    ```

2. **Ejecutar la aplicación:**

    Desde la clase principal `App.java`, puedes ejecutar la aplicación con:

    ```sh
    mvn exec:java -Dexec.mainClass="mx.unam.fciencias.edd.App"
    ```

## Licencia

Este proyecto está licenciado bajo los términos de la GNU General Public License, versión 3. Para más información, consulta el archivo [LICENSE](LICENSE).

## Alumna

Karla Romina Juárez Torres 318013712
