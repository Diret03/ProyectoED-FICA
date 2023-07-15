/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class ArbolBinario {
    
    public NodoAB raiz;
 
    public ArbolBinario()
    {
        raiz = null;
    }
   
    public void Ingresar(Persona per)
    {
        NodoAB nuevo = new NodoAB(per);
        String resp = "Nodo Ingresado Correctamente";
        
        if (raiz == null) {
            raiz = nuevo;
            System.out.println(resp);
        }
        else
        {
            NodoAB aux = raiz;
              
            while (aux != null) {
                
                int r = ((Persona) (nuevo.getInfo())).getCedula().compareTo(((Persona) (aux.getInfo())).getCedula());
               
                if (r > 0) 
                {
                    if (aux.getHijoDer() == null) 
                    {
                        aux.setHijoDer(nuevo);
                        System.out.println(resp);
                        break;
                    } else 
                    {
                        aux = aux.getHijoDer();
                    }
                } else if (r < 0) 
                {
                    if (aux.getHijoIzq() == null) {
                        
                        aux.setHijoIzq(nuevo);                     
                        System.out.println(resp);
                        break;
                    } else {
                          aux = aux.getHijoIzq();
                    }
                } else 
                {
                    JOptionPane.showMessageDialog(null, "No puede haber elementos repetidos", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
    }
    
    public void Vaciar()
    {
        raiz = null;
    }
    
    public int Size(NodoAB nodo)
    {      
        if (nodo == null) {
            return 0;
        } else {
            return Size(nodo.getHijoIzq()) + Size(nodo.getHijoDer()) + 1;
        }
    }
    
    public int Size()
    {
        return Size(raiz);
    }
    
    public int Altura(NodoAB nodo)
    {
        if (nodo == null) {
            return -1;
        }
        else
        {
            if (nodo.getHijoIzq() == null && nodo.getHijoDer() == null) {
                return 0;
            }
            else
            {
                return Math.max(Altura(nodo.getHijoIzq()), Altura(nodo.getHijoDer()))+1;
            }
        }
    }
    
    public int Altura()
    {
        return Altura(raiz);
    }
    
    public int NumHojas(NodoAB nodo)
    {
        if (nodo == null) {
            return 0;
        } else {
            int cont = 0;
            
            if (nodo.getHijoIzq() == null && nodo.getHijoDer() == null) 
                cont++;

            cont += NumHojas(nodo.getHijoIzq()) + NumHojas(nodo.getHijoDer());
          
            return cont;        
        }
    }
    
    public int NumHojas()
    {
        return NumHojas(raiz);
    }

    public boolean esHoja(NodoAB nodo)
    {
        return nodo.getHijoIzq() == null && nodo.getHijoDer() == null;
    }
    
    public NodoAB HijoNoVacio(NodoAB nodo)
    {
        if (nodo.getHijoIzq()!=null) {
            return nodo.getHijoIzq();
        }
        else
            return nodo.getHijoDer();
    }
    
    public void Eliminar(String cod)
    {
        NodoAB padre = raiz;
        NodoAB aux = raiz;
        boolean encontrado = false;
        
        while(aux != null)
        {
            int r = cod.compareTo(((Persona) (aux.getInfo())).getCedula());
            if (r == 0) {
                
                if (aux.getHijoIzq() == null && aux.getHijoDer() == null) {
                    
                    if (aux != raiz) {
                        if (padre.getHijoIzq() == aux) {
                            padre.setHijoIzq(null);
                        } else {
                            padre.setHijoDer(null);
                        }
                    }
                    else
                        raiz = null;
                
                    encontrado = true;
                    break;
                }

                else if(aux.getHijoDer() == null || aux.getHijoIzq() == null ) { //caso2 
    
                    int r2 = ((Persona)(aux.getInfo())).getCedula().compareTo(((Persona)(padre.getInfo())).getCedula());
                    if (aux != raiz) {

                        if (r2 < 0) {
                            padre.setHijoIzq(HijoNoVacio(aux));
                        }
                        else
                             padre.setHijoDer(HijoNoVacio(aux));
                  
                        
                    } else {
                       raiz=HijoNoVacio(aux);

                    }
                    encontrado = true;
                    break;
                }
//                else if(aux.getHijoIzq() == null && aux.getHijoDer() != null)
//                {
//                    padre.setHijoDer(aux.getHijoDer());
//                    aux = null;
//                    encontrado = true;
//                }
                
                else
                {
                    NodoAB pa = aux;
                    NodoAB a = aux.getHijoIzq();
                    
                    while (a.getHijoDer() != null) {       //nodo mayor en el subarbol izquierdo               
                        pa = a;
                        a= a.getHijoDer();
                    }
            
                    int r2 = ((Persona)(a.getInfo())).getCedula().compareTo(((Persona)(pa.getInfo())).getCedula());
                    
                    if (r2 < 0) {
                        pa.setHijoIzq(a.getHijoIzq());
                    }
                    else
                        pa.setHijoDer(a.getHijoIzq());
                    
                    
                    aux.setInfo(a.getInfo());
                    
                   // a = null;
                    encontrado = true;
                    break;
                }
                
            }
            
            else if(r< 0)
            {
              padre = aux;
              aux = aux.getHijoIzq();
                
            }
            else {
                padre = aux;
                aux = aux.getHijoDer();
            }
                
        }
        
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró el nodo...", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void EliminarAux()
    {
        raiz = null;
    }
            
    
    public String PreOrder(NodoAB nodo)
    {
        String r = "";
        
        if (nodo != null) {
                            
            r += (nodo.getInfo())+"\n";
            
            if (nodo.getHijoIzq() != null) {
                r += ArbolBinario.this.PreOrder(nodo.getHijoIzq());
            }
          
            if (nodo.getHijoDer()!=null) {
                r += ArbolBinario.this.PreOrder(nodo.getHijoDer());
            }
          
        }
        else
            r = "Vacio";
      
        return r;
    }
    
    public String PreOrder()
    {
        return PreOrder(raiz);
    }
    
    
    private String InOrder(NodoAB nodo) {
        String r = "";
        
        if (nodo != null) {
            if (nodo.getHijoIzq() != null) {
                r += InOrder(nodo.getHijoIzq());
            }
            
            r += nodo.getInfo()+"\n";
            
            if (nodo.getHijoDer() != null) {
                 r += InOrder(nodo.getHijoDer());
            }
        }
        else r = "Vacio";
        
        return r;
    }
    
    public String InOrder()
    {
        return InOrder(raiz);
    }
    
    
    public String PostOrder(NodoAB nodo)
    {
        String r = "";
        
        if (nodo != null) {
                                          
            if (nodo.getHijoIzq() != null) {
                r += PostOrder(nodo.getHijoIzq());
            }
          
            if (nodo.getHijoDer()!=null) {
                r += PostOrder(nodo.getHijoDer());
            }

            r += (nodo.getInfo())+"\n";
          
        }
        else
            r = "Vacio";
      
        return r;
    }
    
    public String PostOrder()
    {
        return PostOrder(raiz);
    }
    
     /**
     * Método que ingresa elementos al árbol de forma balanceada a partir de una lista ordenada de Personas
     * @param lista ArrayList de personas, ordenadas de menor a mayor por su cédula.
     * @param inicio índice de inicio de la lista.
     * @param fin índice del final de la lista.
     * @return NodoAB nodo -> Nodo el cual se retorna pues este se asignará recursivamente en los subárboles izquierdos y derechos
     */
    public NodoAB IngresarBalanceado(ArrayList<Persona> lista, int inicio, int fin)
    {               
        if (inicio > fin) { /*verificación inicial para asegurarse de que el índice de inicio no sea mayor que 
                            el índice de fin. Si esto ocurre, significa que no hay más elementos para agregar y se devuelve null*/
            return null;
        }        
        
        int medio = (inicio+fin)/2;       //se calcula el índice medio entre el inicio y el fin
        Persona valorMedio = lista.get(medio);  //el valor correspondiente a la posición media se obtiene de la lista.
         
        NodoAB nodo = new NodoAB(valorMedio);  //se crea un nuevo nodo con el valor medio
        
        if (raiz == null) {   //Si la raíz del árbol aún no ha sido establecida:
            raiz = nodo;      // se asigna el nodo actual como raíz.
        }
        
        
        /*Llamada recursiva al método utilizando los índices de inicio y medio-1 para construir el subárbol izquierdo. 
           Estos índices definen una nueva sección de la lista 
          que incluye todos los elementos desde el inicio hasta el elemento anterior al medio.
        */
        nodo.setHijoIzq(IngresarBalanceado(lista, inicio, medio-1)); 
      
        /*Llamada recursiva al método utilizando los índices de medio +1 y fin para construir el subárbol derecho. 
           Estos índices definen una nueva sección de la lista 
           que incluye todos los elementos desde el elemento siguiente al medio hasta el final de la lista.
        */
        nodo.setHijoDer(IngresarBalanceado(lista, medio+1, fin));
         
        return nodo; 
        
    }
    
    public NodoAB IngresarBalanceado(ArrayList<Persona> lista)
    {
        return IngresarBalanceado(lista, 0, lista.size()-1);  //se llama al método anterior, 
                                                                     //desde la posición inicial 0 hasta la última de la lista
    }
      

    private int calcularNivel(NodoAB actual, NodoAB nodo) {
        if (actual == null) {
            return -1; // Nodo no encontrado, devuelve un valor indicativo (-1 en este caso)
        }

        if (actual == nodo) {
            return 0; // Nodo encontrado, devuelve el nivel actual (0 en este caso)
        }

        // Recursivamente busca en los subárboles izquierdo y derecho
        int nivelIzquierda = calcularNivel(actual.getHijoIzq(), nodo);
        int nivelDerecha = calcularNivel(actual.getHijoDer(), nodo);

        // Si el nodo no fue encontrado en ninguno de los subárboles, devuelve -1
        if (nivelIzquierda == -1 && nivelDerecha == -1) {
            return -1;
        }

        // Retorna el nivel encontrado (mayor nivel entre los subárboles) + 1
        return Math.max(nivelIzquierda, nivelDerecha) + 1;
    }
    
    public int Nivel(NodoAB raiz, NodoAB nodo) {
        return calcularNivel(raiz, nodo);
    }
    
    
    public int Profundidad(NodoAB nodo)
    {
        String cedula = nodo.getInfo().getCedula();
        boolean encontrado = false;
        NodoAB aux = raiz;
        int profundidad = 0;
        
        while (aux != null) 
        {            
            int r = cedula.compareTo( aux.getInfo().getCedula());
            
            if (r == 0) 
            {
                encontrado = true;
                break;
            }
            else 
            {
                if (r>0) {                  
                    aux = aux.getHijoDer();                 
                }
                
                else
                {
                    aux = aux.getHijoIzq();
                }
                
                profundidad++;
            }
        }
        
        if (encontrado) {
            return profundidad;
        }
        return -1;
        

    }
    
    
    /**
     * Método que busca mediante la cédula a un estudiante almacenado en el árbol 
     * @param cedula Cedula mediante la cual se buscará al estudiante.
     * @return Object[] arreglo -> Arreglo cuya primera posición almacena la persona a buscar, 
     * y la segunda posición almacena el nivel del árbol en que dicha persona fue encontrada.
     */
    public Object[] BuscarPersona2(String cedula)  
    {
        NodoAB aux = raiz;       //el nodo aux va a recorrer el árbol, empieza en la raíz.
        Object[] arreglo = new Object[6];     //se crea un arreglo de Object el cual contiene a la persona encontrada y el nivel en el que fue encontrado
        Persona personaBuscada = null;        //se inicializa a un objeto de Persona, el cual contendrá la persona a buscar
        int nivel = 0;                        //se inicializa el nivel en 1
        int numComparaciones = 0;
        int altura = 0;
        int tamanio = 0;
        int profundidad = 0;
        
        
        while (aux != null) {            
            
            int r = cedula.compareTo( aux.getInfo().getCedula());  //se realiza comparacion entre cedula y la cedula actual del nodo aux
            
            if (r == 0)  //si son iguales..
            {
                personaBuscada = aux.getInfo();  //se almacena la persona de aux en la variable personaBuscada
                nivel = Nivel(raiz, aux);
                numComparaciones = nivel +1;
                altura = Altura(aux);
                tamanio = Size(aux);
                profundidad = Profundidad(aux);
    
                break; //se termina el ciclo
            }
            else
            {
                if (r > 0) {    //si la comparacion es mayor, significa que la cedula ingresada es mayor al nodo aux actual
                    aux = aux.getHijoDer();   //aux apunta a su hijo derecho
                } 
                else {     //si la comparacion es menor, significa que la cedula ingresada es menor al nodo aux actual
                    aux = aux.getHijoIzq();  //aux apunta a su hijo izquierdo
                    
                }
             //se incrementa el nivel debido a que la persona no fue encontrada en el nivel actual
            }
        }        
        arreglo[0] = personaBuscada;     //se asigna la personaBuscada a la posicion 0 del arreglo   
        arreglo[1] = nivel;              //se asigna el nivel en el que fue encontrado la persona en la posicion 1 del arreglo
        arreglo[2] = numComparaciones;    //se asigna numero de comparaciones
        arreglo[3] = altura;             //se asigna la altura del nodo de la persona encontrada en la posicion 3 de arreglo
        arreglo[4] = tamanio;            //se asigna el tamaño del nodo de la persona encontrada en la posicion 4 de arreglo
        arreglo[5] = profundidad;
        
        return arreglo;
    }  
     

}


