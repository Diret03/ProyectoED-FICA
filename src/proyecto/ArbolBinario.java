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
    
 
    public NodoAB IngresarBalanceado(ArrayList<Persona> lista, int inicio, int fin)
    {               
        if (inicio > fin) {
            return null;
        }        
        
        int medio = (inicio+fin)/2;
        Persona valorMedio = lista.get(medio);
        
        NodoAB nodo = new NodoAB(valorMedio);
        
        if (raiz == null) {
            raiz = nodo;
        }
        
        nodo.setHijoIzq(IngresarBalanceado(lista, inicio, medio-1));
        nodo.setHijoDer(IngresarBalanceado(lista, medio+1, fin));
        
     
        return nodo;
        
    }
    
    public NodoAB IngresarBalanceado(ArrayList<Persona> lista)
    {
        if (lista.isEmpty()) {
            return null;
        }
        
        return IngresarBalanceado(lista, 0, lista.size()-1);
    }
    
   
    public Persona BuscarPersona(String cedula)
    {
        NodoAB aux = raiz;
        Persona personaBuscada = null;
        
        while (aux != null) {            
            
            int r = cedula.compareTo(((Persona) aux.getInfo()).getCedula());  //se realiza comparacion entre cedula y la cedula actual de aux
            
            if (r == 0)  //si son iguales..
            {
                personaBuscada = (Persona)(aux.getInfo());  //se almacena la persona de aux en la variable personaBuscada
                break; //se termina el ciclo
            }
            else
            {
                if (r > 0) {    //si la comparacion es mayor, significa que la cedula ingresada es mayor al nodo aux actual
                    aux = aux.getHijoDer();   //aux apunta a su hijo derecho
                }
                else            //si la comparacion es menor, significa que la cedula ingresada es menor al nodo aux actual
                    aux = aux.getHijoIzq();  //aux apunta a su hijo izquierdo
            }
        }
        
        
        return personaBuscada;
    }  
     

}


