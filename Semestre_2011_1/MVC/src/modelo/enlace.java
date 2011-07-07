package modelo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class enlace extends Figura{
	static int 
		ENLACE_HORIZONTAL=1,
		ENLACE_VERTICAL=2,
		ENLACE_SOLIDO=1,
		ENLACE_VOLATIL_CORRECTO=2,
		ENLACE_VOLATIL_INCORRECTO=3
		;
	 
	int ancho, alto, orientacion, estado;
	
	public enlace(Point posicion, int ancho, int orientacion, int estado) {
		this.posicion=posicion;
		this.orientacion=orientacion;
		this.estado=estado;
		if(orientacion==ENLACE_VERTICAL){
			this.ancho=ancho/8;
			this.alto=ancho;
		}else if(orientacion==ENLACE_HORIZONTAL){
			this.alto=ancho/8;
			this.ancho=ancho;
		}
		
		
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
		
		return new Rectangle(posicion,new Dimension(ancho, alto)).contains(p);
	}

	@Override
	public void dibujar(Graphics g) {
		if(estado==ENLACE_SOLIDO)
			g.setColor(Color.BLACK);
		else if(estado==ENLACE_VOLATIL_CORRECTO)
			g.setColor(Color.GREEN);
		else if(estado==ENLACE_VOLATIL_INCORRECTO)
			g.setColor(Color.RED);
		 
		g.fillRect(posicion.x,posicion.y,ancho,alto);
		// TODO Auto-generated method stub
		
	}

}
