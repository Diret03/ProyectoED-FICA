/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

public class NodoAB {
    
    private Persona info;
    private NodoAB hijoIzq;
    private NodoAB hijoDer;
 
    public NodoAB(Persona obj)
    {
        this.info = obj;
        hijoIzq = null;
        hijoDer =  null;
    }
    
    public NodoAB()
    {
        hijoIzq = hijoDer = null;
    }

    public Persona getInfo() {
        return info;
    }

    public void setInfo(Persona info) {
        this.info = info;
    }

    public NodoAB getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoAB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoAB getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoAB hijoDer) {
        this.hijoDer = hijoDer;
    }


       
}
