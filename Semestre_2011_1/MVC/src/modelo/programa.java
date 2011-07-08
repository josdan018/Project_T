package modelo;

import java.awt.Graphics;
import java.awt.Point;

public class programa extends Figura{ //un cuadro, un enlace (3 ocultos) y un  circulo
	Cuadrado cuadrados;
	enlace enlaces[];
	Circulo circulos;
	String nombrePrograma,lenguajeBase;
	int ancho;
	
	public programa(Point posicion,int ancho) {
		this.tipoFigura=Figura.PROGRAMA;
		
		
		cuadrados=new Cuadrado(posicion, ancho);
		circulos=new Circulo(translacionPto(posicion, -5, -(ancho+5)), ancho+ancho/4);
		this.ancho=ancho;
				
		enlaces=new enlace[4];
		
		enlaces[0]=new enlace(translacionPto(posicion, 0, -5),ancho,enlace.ENLACE_HORIZONTAL,enlace.ENLACE_SOLIDO);
		enlaces[1]=new enlace(translacionPto(posicion, -5, 0),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_VOLATIL_NO_ACTIVO);
		enlaces[2]=new enlace(translacionPto(posicion, 40, 0),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_VOLATIL_NO_ACTIVO);
		enlaces[3]=new enlace(translacionPto(posicion, 0, 40),ancho,enlace.ENLACE_HORIZONTAL,enlace.ENLACE_VOLATIL_NO_ACTIVO);
		lenguajeBase=nombrePrograma="";
	}
	
	
	
	@Override
	public void setPosicion(Point posicion) {
		super.setPosicion(posicion);
		cuadrados.setPosicion(posicion);		
		
		
		circulos.setPosicion(translacionPto(posicion,-5, -(ancho+5)));
		enlaces[0].setPosicion(translacionPto(posicion, 0, -5));
		enlaces[1].setPosicion(translacionPto(posicion, -5, 0));
		enlaces[2].setPosicion(translacionPto(posicion, 40, 0));
		enlaces[3].setPosicion(translacionPto(posicion, 0, 40));
		//deberian haber enlaces invisibles para poder activarlos digo no . . .  
	}
	
	
	

	@Override
	public boolean dentroFigura(Point p) {
		return 
			cuadrados.dentroFigura(p)||
			enlaces[0].dentroFigura(p)||
			circulos.dentroFigura(p)
			
		;
	}

	@Override
	public void dibujar(Graphics g) {
		//System.out.println("creando cuadro 1");
		cuadrados.dibujar(g);
		circulos.dibujar(g);
		enlaces[0].dibujar(g);
		enlaces[1].dibujar(g);
		enlaces[2].dibujar(g);
		enlaces[3].dibujar(g);
		
		
	}
}
