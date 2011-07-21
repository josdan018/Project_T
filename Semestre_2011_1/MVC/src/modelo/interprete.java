package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class interprete extends Figura{//un cuadrado (2 enlaces ocultos?)
	Cuadrado cuadrados;
	
	String lenguajeFuente,lenguajeBase;
	
	public interprete(Point posicion,int ancho, int id) {
		this.tipoFigura=Figura.INTERPRETE;
		this.posicion = posicion;
		this.ID=id;
		cuadrados=new Cuadrado(posicion, ancho);
		
		enlaces=new enlace[4];
		enlaces[0]=new enlace(translacionPto(posicion, 0, -5),ancho,enlace.ENLACE_HORIZONTAL,enlace.ENLACE_VOLATIL_NO_ACTIVO, ID);
		enlaces[1]=new enlace(translacionPto(posicion, -5, 0),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_VOLATIL_NO_ACTIVO, ID);
		enlaces[2]=new enlace(translacionPto(posicion, 40, 0),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_VOLATIL_NO_ACTIVO, ID);
		enlaces[3]=new enlace(translacionPto(posicion, 0, 40),ancho,enlace.ENLACE_HORIZONTAL,enlace.ENLACE_VOLATIL_NO_ACTIVO, ID);
		numeroEnlaces=4;
		lenguajeBase="Facilon";
		lenguajeFuente="Facilon";
	}
	
	
	
	@Override
	public void setPosicion(Point posicion) {
		super.setPosicion(posicion);
		cuadrados.setPosicion(posicion);	
		enlaces[0].setPosicion(translacionPto(posicion, 0, -5));
		enlaces[1].setPosicion(translacionPto(posicion, -5, 0));
		enlaces[2].setPosicion(translacionPto(posicion, 40, 0));
		enlaces[3].setPosicion(translacionPto(posicion, 0, 40));
		//deberian haber enlaces invisibles para poder activarlos digo no . . .  
	}
	
	
	

	@Override
	public boolean dentroFigura(Point p) {
		return 
			cuadrados.dentroFigura(p);
		
	}

	@Override
	public void dibujar(Graphics g) {
		cuadrados.dibujar(g);
		enlaces[0].dibujar(g);
		enlaces[1].dibujar(g);
		enlaces[2].dibujar(g);
		enlaces[3].dibujar(g);
		
		g.setColor(Color.BLACK);
		
		//Para el lenguaje base
		g.drawString(lenguajeBase, translacionPto(posicion, -40, 23).x,translacionPto(posicion, -40, 23).y);
		
		//Para el lenguaje Fuente
		g.drawString(lenguajeFuente, translacionPto(posicion, -40, 23).x,translacionPto(posicion, -40, 23).y);
				
		
				
	}



	@Override
	public void bloquear() {
		// TODO Auto-generated method stub
		
	}
	
	public int dentroCualFigura(Point p){
		return 0;
	}
}
