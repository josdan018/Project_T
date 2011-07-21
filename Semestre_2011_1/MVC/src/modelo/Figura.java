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
				MAQUINA=7,
				CONEXION_MAQUINA=8,
				CONEXION_OTRA=9
				;
	
	int tipoFigura;
	int tipoConexion;
	int ID;
	public enlace enlaces[];
	public int numeroEnlaces; 
	protected Point posicion;
	protected boolean seleccionada;
	public abstract boolean dentroFigura(Point p);
	
	public abstract void dibujar(Graphics g);
	public abstract void bloquear();
	public abstract int dentroCualFigura(Point p);
	
	public static Point translacionPto(Point posicion,int dx, int dy){
		//System.out.println(posicion);
		Point aMover=new Point(posicion);
		aMover.translate(dx, dy);
		return aMover;
	}
	
	public int getID() {
		return ID;
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

	public Point getPosicion(){
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
