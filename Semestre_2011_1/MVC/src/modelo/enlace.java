package modelo;

import java.awt.Graphics;
import java.awt.Point;

public class enlace extends Figura{
	
	int ancho, alto;
	
	public enlace(Point posicion, int ancho, int alto) {
		this.posicion=posicion;
		this.alto=alto;
		this.ancho=ancho;
		
		// TODO Auto-generated constructor stub
	}
	
	public void setAlto(int alto) {
		this.alto = alto;
	}
	
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	@Override
	public boolean dentroFigura(Point p) {
		// TODO Auto-generated method stub
		return (true);
	}

	@Override
	public void dibujar(Graphics g) {
		g.drawRect(posicion.x,posicion.y,ancho,alto);
		// TODO Auto-generated method stub
		
	}

}
