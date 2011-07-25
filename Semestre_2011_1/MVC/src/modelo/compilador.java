/*package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class compilador extends Figura{
	Cuadrado cuadrados[];
	
	
	
	 
	String lenguajeObjeto,lenguajeFuente,lenguajeBase;
	
	public compilador(Point posicion,int ancho, int id) {
		this.tipoFigura=Figura.COMPILADOR;
		
		this.posicion = posicion;
		cuadrados=new Cuadrado[4];
		
		cuadrados[0]=new Cuadrado(posicion, ancho);		
		cuadrados[1]=new Cuadrado(translacionPto(posicion, 45, 0), ancho);
		cuadrados[2]=new Cuadrado(translacionPto(posicion, -45, 0), ancho);
		cuadrados[3]=new Cuadrado(translacionPto(posicion, 0, 45), ancho);
		
		enlaces=new enlace[8];
		
		enlaces[0]=new enlace(translacionPto(posicion, -5, 0),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_SOLIDO, ID);
		enlaces[1]=new enlace(translacionPto(posicion, 40, 0),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_SOLIDO, ID);
		enlaces[2]=new enlace(translacionPto(posicion, 0, 40),ancho,enlace.ENLACE_HORIZONTAL,enlace.ENLACE_SOLIDO, ID);
		
		enlaces[3]=new enlace(translacionPto(posicion, -50, 0),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_VOLATIL_NO_ACTIVO, ID);
		enlaces[4]=new enlace(translacionPto(posicion, 85, 0),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_VOLATIL_NO_ACTIVO, ID);
		enlaces[5]=new enlace(translacionPto(posicion, 0, 85),ancho,enlace.ENLACE_HORIZONTAL,enlace.ENLACE_VOLATIL_NO_ACTIVO, ID);
		enlaces[6]=new enlace(translacionPto(posicion, -5, 45),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_VOLATIL_NO_ACTIVO, ID);
		enlaces[7]=new enlace(translacionPto(posicion, 40, 45),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_VOLATIL_NO_ACTIVO, ID);
		numeroEnlaces=8;
		lenguajeBase="linux";
		lenguajeObjeto="linux";
		lenguajeFuente="Facilon";
	}
	
	
	
	@Override
	public void setPosicion(Point posicion) {
		super.setPosicion(posicion);
		cuadrados[0].setPosicion(posicion);		
		cuadrados[1].setPosicion(translacionPto(posicion, 45, 0));
		cuadrados[2].setPosicion(translacionPto(posicion, -45, 0));
		cuadrados[3].setPosicion(translacionPto(posicion, 0, 45));
		
		
		
		enlaces[0].setPosicion(translacionPto(posicion, -5, 0));
		enlaces[1].setPosicion(translacionPto(posicion, 40, 0));
		enlaces[2].setPosicion(translacionPto(posicion, 0, 40));
		enlaces[3].setPosicion(translacionPto(posicion, -50, 0));
		enlaces[4].setPosicion(translacionPto(posicion, 85, 0));
		enlaces[5].setPosicion(translacionPto(posicion, 0, 85));
		enlaces[6].setPosicion(translacionPto(posicion, -5, 45));
		enlaces[7].setPosicion(translacionPto(posicion, 40, 45));
		//deberian haber enlaces invisibles para poder activarlos digo no . . .  
	}
	
	
	

	@Override
	public boolean dentroFigura(Point p) {
		return 
			cuadrados[0].dentroFigura(p)||
			cuadrados[1].dentroFigura(p)||
			cuadrados[2].dentroFigura(p)||
			cuadrados[3].dentroFigura(p)||
			enlaces[0].dentroFigura(p)||
			enlaces[1].dentroFigura(p)||
			enlaces[2].dentroFigura(p)
		;
	}

	@Override
	public void dibujar(Graphics g) {
		cuadrados[0].dibujar(g);
		cuadrados[1].dibujar(g);
		cuadrados[2].dibujar(g);
		cuadrados[3].dibujar(g);
		
		enlaces[0].dibujar(g);
		enlaces[1].dibujar(g);
		enlaces[2].dibujar(g);
		enlaces[3].dibujar(g);
		enlaces[4].dibujar(g);
		enlaces[5].dibujar(g);
		enlaces[6].dibujar(g);
		enlaces[7].dibujar(g);
		
		g.setColor(Color.BLACK);
		
		//Para el lenguaje Fuente
		g.drawString(lenguajeFuente, translacionPto(posicion, -40, 23).x,translacionPto(posicion, -40, 23).y);
		
		//Para el lenguaje objeto
		g.drawString(lenguajeObjeto, translacionPto(posicion, 50, 23).x,translacionPto(posicion, 50, 23).y);
		
		//Para el lenguaje Base
		g.drawString(lenguajeBase, translacionPto(posicion, 7, 65).x,translacionPto(posicion, 7, 65).y);
		
		
	}



	@Override
	public void bloquear() {
		
		
	}
	
	public int dentroCualFigura(Point p){
		return 0;
	}

}
*/