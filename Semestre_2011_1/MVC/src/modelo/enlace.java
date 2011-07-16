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
		ENLACE_VOLATIL_INCORRECTO=3,
		ENLACE_VOLATIL_NO_ACTIVO=4,
		ENLACE_TRIANGULAR=5,//solo para maquinas
		ENLACE_BLOQUEADO=6
		;
	 
	int ancho, alto, orientacion, estado;
	
	public enlace(Point posicion, int ancho, int orientacion, int estado) {
		this.posicion=posicion;
		this.orientacion=orientacion;
		this.estado=estado;
		this.tipoFigura=Figura.ENLACE;
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
		if(estado!=ENLACE_BLOQUEADO){
			if(estado==ENLACE_SOLIDO||estado==ENLACE_TRIANGULAR)
				g.setColor(Color.BLUE);
			else if(estado==ENLACE_VOLATIL_CORRECTO)
				g.setColor(Color.GREEN);
			else if(estado==ENLACE_VOLATIL_INCORRECTO)
				g.setColor(Color.RED);
			else if(estado==ENLACE_VOLATIL_NO_ACTIVO){
				g.setColor(new Color(0.1F, 0.1F, 0.1F, 0.1F));
			}
	
			
			if(ENLACE_TRIANGULAR==estado){
				int[] x={posicion.x,posicion.x+ancho/2,posicion.x+ancho};
				int[] y={posicion.y,posicion.y+alto,posicion.y};
				g.fillPolygon(x,y, 3);
			}else
				g.fillRect(posicion.x,posicion.y,ancho,alto);
			}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bloquear() {
		// TODO Auto-generated method stub
		
	}

}
