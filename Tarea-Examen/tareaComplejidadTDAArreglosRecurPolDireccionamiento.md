## Tarea Examen1. Complejidad, TDA, Arreglos, Recursión y Polinomio de Direccionamiento
## Karla Romina Juárez Torres
### Tarea Examen 

1. Suponga que T1 (n) y T2 (n) son el tiempo de ejecución para dos fragmentos
de algoritmos A1 y A2 , respectivamente, tales que T1 (n) = O(f (n)) y T2 (n) =
O(g(n)). Pruebe que T1 (n)T2 (n) es O(f (n)g(n)) .

- sea $ n_0 = \max(n_1, n_2) $, de modo que ambas desigualdades sean válidas para $ n \geq n_0 $.
- y $ c = c_1 c_2 $.

Podemos darnos cuenta que para todo $ n \geq n_0 $:
$$T_1(n)T_2(n) \leq c_1 f(n) \cdot c_2 g(n) = c f(n)g(n)$$

Por definición de Big O, $ T_1(n)T_2(n) \leq c f(n)g(n) $ para todo $ n \geq n_0 $. 

Es decir:
$T_1(n)T_2(n) \text{ es } O(f(n)g(n)$

2. Para cada uno de los siguientes fragmentos de programas, dé un análisis
del tiempo de ejecución (O(n)). Justifique con sumas (sumatorias) y muestre la solución paso a paso de dichas sumas.

(a)
```{r}
  sum = 0 ;
  f o r ( i =0; i <n ; i ++)
      sum++;
```

- El bucle `for` externo se ejecuta **$n$ veces**.
- Cada iteración del bucle realiza una operación constante (`sum++`).
Entonces:
$$
T(n) = \sum_{i=0}^{n-1} 1 = n
$$

$$
O(n)
$$


(b)
```{r}
  sum = 0 ;
  f o r ( i =0; i <n ; i ++)
      f o r ( j =0; j <n ; j ++)
          sum++;
```
- El bucle externo se ejecuta **$n$ veces**.
- Para cada iteración del bucle externo, el bucle interno también se ejecuta **$n$ veces**.

$$
T(n) = \sum_{i=0}^{n-1} \sum_{j=0}^{n-1} 1 = \sum_{i=0}^{n-1} n = n \cdot n = n^2
$$

$$
O(n^2)
$$

(c)
```{r}
  sum = 0 ;
  f o r ( i =0; i <n ; i ++)
    f o r ( j =0; j <n∗n ; j ++)
      sum++;
```
- El bucle externo se ejecuta **$n$ veces**.
- Para cada iteración del bucle externo, el bucle interno se ejecuta **$n^2$ veces**.
$$
T(n) = \sum_{i=0}^{n-1} \sum_{j=0}^{n^2-1} 1 = \sum_{i=0}^{n-1} n^2 = n \cdot n^2 = n^3
$$

$$
O(n^3)
$$

(d)
```{r}
  sum = 0 ;
  f o r ( i =0; i <n ; i ++)
    f o r ( j =0; j <i ; j ++)
      sum++;
```
- El bucle externo se ejecuta **$n$ veces**.
- El bucle interno se ejecuta **$i$ veces** para cada $i$ (desde $0$ hasta $n-1$).

$$
T(n) = \sum_{i=0}^{n-1} \sum_{j=0}^{i-1} 1 = \sum_{i=0}^{n-1} i = \frac{(n-1) \cdot n}{2} = \frac{n^2 - n}{2}
$$

$$
O(n^2)
$$

(e)
```{r}
  sum = 0 ;
  f o r ( i =0; i <n ; i ++)
    f o r ( j =0; j <i ∗ i ; j ++)
      f o r ( k=0; k<j ; k++)
        sum++;
```
- Bucle externo ($i$): Se ejecuta **$n$ veces**.
- Bucle medio ($j$): Para cada $i$, se ejecuta **$i^2$ veces**.
- Bucle interno ($k$): Para cada $j$, se ejecuta $j$ veces.

$$
T(n) = \sum_{i=0}^{n-1} \sum_{j=0}^{i^2-1} \sum_{k=0}^{j-1} 1 = \sum_{i=0}^{n-1} \sum_{j=0}^{i^2-1} j = \sum_{i=0}^{n-1} \frac{(i^2 - 1) \cdot i^2}{2}
$$

- La suma interna $\sum_{j=0}^{i^2-1} j$ es $\approx \frac{i^4}{2}$.
- La suma total es $\sum_{i=0}^{n-1} \frac{i^4}{2} \approx \frac{n^5}{10}$ (integral de $i^4$).

$$
\boxed{O(n^5)}
$$

3. Defina un TDA para una Lista Ligada.



4. Suponga que se desea almacenar eficientemente una matriz triangular inferior (incluyendo la diagonal) en la que, además, todas las entradas de los
renglones de ı́ndice impar son cero. Obtenga el polinomio de direccionamiento para almacenar esta matriz en un arreglo unidimensional (Tip: la suma de los primeros k números naturales impares es $k^2$ ).

Notemos que solo las filas con índice par ($i = 2, 4, 6, \dots, n$) tienen elementos no nulos, y cada una de estas filas contiene entradas desde la columna $1$ hasta la columna $i$.
   - Para una fila par $i$, el número de filas pares anteriores es $k - 1$, donde $k = \frac{i}{2}$.
   - La suma de elementos en estas filas anteriores es $\sum_{m=1}^{k-1} 2m = (k-1)k$.
   - La posición dentro de la fila $i$ (base 0) para la columna $j$ es $j - 1$.

**Combinar los conteos**
   - La dirección total es la suma de los elementos antes de la fila \(i\) y la posición dentro de la fila \(i\).

con esto el polinomio de direccionamiento queda como:


$\text{dirección}(i, j) = \left( \frac{i}{2} - 1 \right) \frac{i}{2} + (j - 1)$


Simplificando esta expresión:


$\text{dirección}(i, j) = \frac{i^2}{4} - \frac{i}{2} + j - 1$


Por lo tanto, el polinomio de direccionamiento es:


$\frac{i^2}{4} - \frac{i}{2} + j - 1$


5. Calcular la complejidad del siguiente método, (Tip: Identifique casos para T(n) y luego vaya igualando en términos de T(n − 1), etc, hasta llegar al caso base):
```{r}
  int metodo ( i n t n ) {
    int x , i ;
    if( n <= 1 ) {
      return 1;
    }
    else{
      for( i =1; i<=n ; i++ ) {
        x = 1;
        while ( x < n ){
          x = x∗2;
        }
      }
      r e t u r n ( metodo ( n/2)+ metodo ( n / 2 ) ) ;
    }
  }
```

Caso base:
   - Si $ n \leq 1 $, el método retorna 1. Esto es $ T(1) = O(1) $.
Caso recursivo:
   - Si $ n > 1 $, el método realiza lo siguiente:
     - Un bucle `for` que itera desde $ i = 1 $ hasta $ i = n $.
     - Dentro del bucle `for`, hay un bucle `while` que multiplica $ x $ por 2 hasta que $ x \geq n $.
     - Luego, el método llama recursivamente a `metodo(n/2)` dos veces.
#### Desglose de la complejidad
   - El bucle `for` se ejecuta $ n $ veces.
   - Dentro del bucle `for`, el bucle `while` multiplica $ x $ por 2 hasta que $ x \geq n $. Esto significa que el número de iteraciones del bucle `while` es $ \log_2(n) $, ya que $ x $ se duplica en cada iteración.
   - Por lo tanto, la complejidad del bucle `while` es $ O(\log n) $.
   - Después del bucle `for`, el método llama recursivamente a `metodo(n/2)` dos veces. Esto contribuye con $ 2T(n/2) $ a la complejidad total.
#### Ecuación de recurrencia

Combinando todo lo anterior, la ecuación de recurrencia para $ T(n) $ es:

$
T(n) = 2T\left(\frac{n}{2}\right) + O(n \log n)
$

#### Resolución de la ecuación de recurrencia

   - La ecuación tiene la forma $ T(n) = aT(n/b) + f(n) $, donde $ a = 2 $, $ b = 2 $, y $ f(n) = O(n \log n) $.
   - así obtenemos $ n^{\log_b a} = n^{\log_2 2} = n^1 = n $.
   
   Comparando $ f(n) = O(n \log n) $ con $ n^{\log_b a} = n $, vemos que $ f(n) $ crece más rápido que $ n $, por lo que estamos en el Caso 3 del Teorema Maestro.
   - Por lo tanto, $ T(n) = \Theta(f(n)) = \Theta(n \log n) $.

   - Ahora si expandimos la recurrencia, obtenemos:
     $T(n) = 2T\left(\frac{n}{2}\right) + O(n \log n)$
     $T(n) = 2\left(2T\left(\frac{n}{4}\right) + O\left(\frac{n}{2} \log \frac{n}{2}\right)\right) + O(n \log n)$
     $T(n) = 4T\left(\frac{n}{4}\right) + O(n \log n) + O(n \log n)$
     - De esta forma, llegamos a:
     $T(n) = nT(1) + O(n \log n) \cdot \log n$
     - Dado que $ T(1) = O(1) $, la complejidad final es $ O(n \log^2 n) $.


La complejidad temporal del método es $ O(n \log^2 n) $.


6. Dé los polinomios de direccionamiento para:

- a) encontrar el elemento i-ésimo en:
f l o a t [ ] m i s F l o t a n t e s = new f l o a t [ 8 9 ] ;
   - Al ser un arreglo unidimensional, los elementos se almacenan en posiciones contiguas de memoria.
   - Si el arreglo comienza en la dirección base (`Base`), la posición del elemento `i` se puede obtener tal que:
     $\text{Direccion} = \text{Base} + (\text{Tamaño del elemento `float`} \times i)$
   - Sustituyendo el tamaño del elemento:
     $\text{Direccion} = \text{Base} + 4i$

3. Polinomio de direccionamiento:
   - El polinomio representa el desplazamiento en bytes desde la dirección base:
     $4i$
- b) encontrar el elemento (i, j) en:
int [ ] [ ] m i s E n t e r o s = new i n t [ 1 0 ] [ 5 ] ;

Disposición en memoria:
   - El arreglo bidimensional se almacena en orden de filas (row-major), es decir, primero se almacena la fila 0, luego la fila 1, y así sucesivamente.
   - El arreglo tiene 10 filas y 5 columnas, por lo que cada fila contiene 5 elementos.
   - Para acceder al elemento `(i, j)`, se puede obtener su posición en memoria como:
     $$
     \text{Direccion} = \text{Base} + (\text{Tamaño del elemento} \times (\text{Número de columnas} \times i + j))
     $$
   - Sustituyendo los valores:
     $$
     \text{Direccion} = \text{Base} + 4(5i + j)
     $$
     $$
     \text{Direccion} = \text{Base} + 20i + 4j
     $$

Polinomio de direccionamiento:
     $20i + 4j$