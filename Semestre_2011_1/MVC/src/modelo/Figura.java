package modelo;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Figura {
	public static final int	
				NINGUNA=0,
				CUADRADO=1,
				CIRCULO=2,
				ENLACE=3,
				INTERPRETE=4,
				PROGRAMA=5,
				COMPILADOR=6,
				MAQUINA=7
				;
	int tipoFigura; 
	int ID;
	protected Point posicion;
	protected boolean seleccionada;
	public abstract boolean dentroFigura(Point p);
	public abstract void dibujar(Graphics g);
	public abstract void bloquear();
	public static Point translacionPto(Point posicion,int dx, int dy){
		//System.out.println(posicion);
		Point aMover=new Point(posicion);
		aMover.translate(dx, dy);
		return aMover;
	}
	
	public void setPosicion(Point posicion)
	{
		this.posicion=posicion;
	}
	
	public int getX(){
		return posicion.x;
	}
	
	public int getY(){
		return posicion.y;
	}

	Point getPosicion(){
		return posicion;
	}
	
	public boolean getSeleccionada(){
		return seleccionada;
	}

	public void setSeleccionada(boolean sel){
		seleccionada=sel;
	}

	public int getTipoFigura() {
		return tipoFigura;
	}
	
	
}
