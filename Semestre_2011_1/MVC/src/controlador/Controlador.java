package controlador;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.SwingUtilities;


import corotos.pieza;
import corotos.valor.tipoPieza;

import java.awt.event.MouseEvent;
import java.util.ListIterator;
import java.util.Vector;

import vista.Vista;

import modelo.Modelo;

public class Controlador {
	
	private Modelo modelo;
	private Vista vista;
	private pieza seleccionada;
	int tamanyoFig=40;
	boolean insercion;
	
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
		seleccionada=null;
		insercion=false;
	}
	
	public pieza obtenerFigura(Point posicion){
		ListIterator<pieza> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	pieza tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			tmp.setSeleccionada(true);
	    			return tmp;
	    		}
		    }
	    return null;
	}
	
	public pieza obtenerFigura(int ID){
		ListIterator<pieza> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	pieza tmp=it.next();
	    		if(tmp.getID()==ID){
	    			tmp.setSeleccionada(true);
	    			return tmp;
	    		}
		    }
	    return null;
	}
	public int cuantasFiguras(Point posicion){
		ListIterator<pieza> it=modelo.getListado().listIterator();
		int k=0;
	    while (it.hasNext()) {
	    	pieza tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			System.out.println("k aumento");
	    			k++;
	    		}
		    }
	    
	    return k;
	}

	public void cambiarPosicion(pieza f, Point p){
			
			f.mover(limitar(p));
	}
	
	public Vista getVista(){
		return vista;
	}
	
	public void anyadirFigura(pieza f){
		modelo.anyadirFigura(f);
	}
	
	public pieza getFiguraEn(Point p){
		return modelo.getFiguraEn(p);
	}
	
	public void eVmousePressed(MouseEvent ev) {
		//System.out.println(ev.getPoint());
		//if(insercion){
		if(SwingUtilities.isLeftMouseButton(ev)){ 			//Click boton izquierdo selecciona figura
			if(this.obtenerFigura(ev.getPoint())==null){
				Vector<String> vec=new Vector<String>(1, 1);
				vec.add("uno");
				vec.add("uno");
				vec.add("uno");
				
				this.anyadirFigura(new pieza(1, new Rectangle(limitar(ev.getPoint())), tipoPieza.COMPILADOR, vec));
			}else{
				seleccionada=this.getFiguraEn(ev.getPoint());
				System.out.println(""+seleccionada);
			}
			if(this.getFiguraEn(ev.getPoint())!=null);
				//detectaEnlaces(ev.getPoint());
			
		}else if(SwingUtilities.isRightMouseButton(ev)){		//click boton izquierdo añade figura tipo cuadrado
			Vector<String> vec=new Vector<String>(1, 1);
			vec.add("uno");
			vec.add("uno");
			vec.add("uno");
			
			if(this.obtenerFigura(ev.getPoint())==null)
				this.anyadirFigura(new pieza(1, new Rectangle(limitar(ev.getPoint())), tipoPieza.MAQUINA, vec));
							
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio añade figura tipo circulo
		{
			Vector<String> vec=new Vector<String>(1, 1);
			vec.add("uno");
			vec.add("uno");
			vec.add("uno");
			if(this.obtenerFigura(ev.getPoint())==null)
				this.anyadirFigura(new pieza(1, new Rectangle(limitar(ev.getPoint())), tipoPieza.PROGRAMA, vec));
		}
		vista.repaint();
		//}
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		
		if(seleccionada!=null)
			this.cambiarPosicion(seleccionada, ev.getPoint());
		vista.repaint();
		
	}

	public void eVmouseReleased (MouseEvent ev) {
		vista.repaint();
		if(seleccionada!=null){
			seleccionada.setSeleccionada(false);
			seleccionada=null;
			if(this.getFiguraEn(ev.getPoint())!=null)
				detectaEnlaces(ev.getPoint());
		}
	}
	
	public void detectaEnlaces(Point donde) {
		
		
	}
	
	public void modificarAlgo(Point figuraResidente, Point figuraVecina, int enlaceAfectado){
		
		
	}
	
	public Point limitar(Point original){
		Point auxiliar=new Point();
		auxiliar.setLocation((int)original.x/45*45+5, (int)original.y/45*45+5);
		return auxiliar;
	} 

}
