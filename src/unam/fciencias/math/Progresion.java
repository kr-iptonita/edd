package src.unam.fciencias.math;

public abstract class Progresion {

/*
  * Valor actual de la progresión
  */
protected int valorActual;

/*
* Constructor de la clase
*/
public Progresion () {
  valorActual = 0;
}

/*
  * Método que devuelve el valor actual de la progresión
  */
public  int getValorActual(){
  return  valorActual;
}

/*
* Método para reestablecer el valor incial de la progresión
*/
public  void reestablecerValor(){
  valorActual = 0;
}

/*
 * Método que devuelve el siguiente valor de la progresión
*/
public abstract int getSiguiente();


/*
* Método que regresa el i-ésimo valor de la progresión 
* Empieza en el valor incial y cuenta i-1
*/
public   int getIesimo(int i){
  reestablecerValor();
  for(int j =0; j <= i-1 ; j ++){
    getSiguiente();
  }
  return getValorActual();
   
}

/*
* Método para imprimir los primeros n-valores de la progresión
*/
public  void imprimeNValores(int n){
   for(int i =0; i <= n; i ++){
    System.out.println(getValorActual());
    getSiguiente();
   }
}

} 