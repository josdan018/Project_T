package controlador;

import java.awt.Point;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.util.ListIterator;

import vista.Vista;
import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Figura;
import modelo.Modelo;
import modelo.compilador;
import modelo.maquina;
import modelo.programa;

public class Controlador {
	
	private Modelo modelo;
	private Vista vista;
	private Figura seleccionada;
	int tamanyoFig=40;
	boolean insercion;
	
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
		seleccionada=null;
		insercion=false;
	}
	
	public Figura obtenerFigura(Point posicion){
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			tmp.setSeleccionada(true);
	    			return tmp;
	    		}
		    }
	    return null;
	}

	public void cambiarPosicion(Figura f, Point p){
			f.setPosicion(limitar(p));
	}
	
	public Vista getVista(){
		return vista;
	}
	
	public void anyadirFigura(Figura f){
		modelo.anyadirFigura(f);
	}
	
	public Figura getFiguraEn(Point p){
		return modelo.getFiguraEn(p);
	}
	
	public void eVmousePressed(MouseEvent ev) {
		//System.out.println(ev.getPoint());
		//if(insercion){
		if(SwingUtilities.isLeftMouseButton(ev)){ 			//Click boton izquierdo selecciona figura
			if(this.obtenerFigura(ev.getPoint())==null){
				this.anyadirFigura(new programa(limitar(ev.getPoint()), 40));
				//this.anyadirFigura(new maquina(limitar(ev.getPoint()),40));
				//this.anyadirFigura(new compilador(limitar(ev.getPoint()),40));
			}else{
				System.out.println("ya hay: " + modelo.getListado().size());
				seleccionada=this.getFiguraEn(ev.getPoint());
			}
		}else if(SwingUtilities.isRightMouseButton(ev)){		//click boton izquierdo a�ade figura tipo cuadrado
			if(this.obtenerFigura(ev.getPoint())==null)
				this.anyadirFigura(new maquina(limitar(ev.getPoint()),40));
							
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio a�ade figura tipo circulo
		{
			if(this.obtenerFigura(ev.getPoint())==null)
				this.anyadirFigura(new compilador(limitar(ev.getPoint()),40));
		}
		vista.repaint();
		//}
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		if(seleccionada!=null){
			//El movimiento puede ser mas fluido recalculando el pto
			this.cambiarPosicion(seleccionada, ev.getPoint());
			vista.repaint();
		}
	}

	public void eVmouseReleased (MouseEvent ev) {
		vista.repaint();
		if(seleccionada!=null){
			seleccionada.setSeleccionada(false);
			seleccionada=null;
		}
	}
	
	public Point limitar(Point original){
		Point auxiliar=new Point();
		auxiliar.setLocation((int)original.x/45*45+5, (int)original.y/45*45+5);
		return auxiliar;
	} 

}
