# edd
Practicas-Estructuras de Datos
# Alumna
Karla Romina Juárez Torres
## Descripción

Este proyecto implementa diferentes tipos de progresiones matemáticas en Java, incluyendo **progresiones geométricas**, **progresiones de Fibonacci** y **progresiones de diferencia absoluta**. El programa incluye un **menú interactivo** en la línea de comandos para probar cada una de estas progresiones de manera sencilla.
---

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

```
src/
└── unam/
    └── fciencias/
        └── math/
            ├── Progresion.java                     # Clase abstracta base para las progresiones
            ├── ProgresionGeometrica.java           # Implementación de la progresión geométrica
            ├── ProgresionFibonacci.java            # Implementación de la progresión de Fibonacci
            ├── ProgresionDiferenciaAbsoluta.java   # Implementación de la progresión de diferencia absoluta
            └── Main.java                           # Punto de entrada del programa con el menú interactivo
```

---

## Requisitos

- **Java Development Kit (JDK) 21 o superior**.
- Una terminal o un IDE para compilar y ejecutar el programa.

---

### Ejecución
1. El **menú interactivo** se mostrará en la terminal. Selecciona una opción para probar las diferentes progresiones.
---

## Menú del Programa

El programa ofrece las siguientes opciones:

### 1. Progresión Geométrica
- Solicita un **factor de incremento** y muestra los primeros **15 valores** de la progresión geométrica.

### 2. Progresión de Fibonacci
- Ofrece dos opciones:
  1. Mostrar los primeros **15 números de Fibonacci**.
  2. Calcular la progresión dados dos números iniciales (`n` y `m`).

### 3. Progresión de Diferencia Absoluta
- Ofrece dos opciones:
  1. Usar el **constructor por omisión** (inicia con 2 y 200).
  2. Ingresar dos valores iniciales personalizados.

### 4. Salir
- Termina la ejecución del programa.

---

## Ejemplo de Uso

1. Al ejecutar el programa, verás el siguiente menú:

   ```
   Menú de Progresiones:
   1. Progresión Geométrica
   2. Progresión de Fibonacci
   3. Progresión de Diferencia Absoluta
   4. Salir
   Seleccione una opción: 
   ```

2. Selecciona una opción y sigue las instrucciones en pantalla.

---

## Ejemplos de Salida

### Progresión Geométrica
Si el usuario ingresa un factor de incremento de `2`, la salida será:

```
Progresión Geométrica: [0, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192]
```

### Progresión de Fibonacci Personalizada
Si el usuario ingresa `n = 5` y `m = 8`, la salida será:

```
Progresión de Fibonacci personalizada: [8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765]
```

### Progresión de Diferencia Absoluta
Si el usuario ingresa valores iniciales `10` y `15`, la salida será:

```
Progresión de Diferencia Absoluta personalizada: [15, 5, 10, 5, 5, 0, 5, 5, 0, 5, 5, 0, 5, 5, 0]
```

---


## Licencia

Este proyecto está bajo la licencia **GNU**. Consulta el archivo [LICENSE](LICENSE) para más detalles.