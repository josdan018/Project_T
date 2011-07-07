package modelo;

import java.awt.Graphics;
import java.awt.Point;

public class compilador extends Figura{
	Cuadrado cuadrados[];
	enlace enlaces[];
	String lenguajeObjeto,lenguajeFuente,lenguajeBase;
	
	public compilador(Point posicion,int ancho) {
		cuadrados=new Cuadrado[4];
		
		cuadrados[0]=new Cuadrado(posicion, ancho);		
		cuadrados[1]=new Cuadrado(translacionPto(posicion, 45, 0), ancho);
		cuadrados[2]=new Cuadrado(translacionPto(posicion, -45, 0), ancho);
		cuadrados[3]=new Cuadrado(translacionPto(posicion, 0, 45), ancho);
		
		enlaces=new enlace[3];
		
		enlaces[0]=new enlace(translacionPto(posicion, -5, 0),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_SOLIDO);
		enlaces[1]=new enlace(translacionPto(posicion, 40, 0),ancho,enlace.ENLACE_VERTICAL,enlace.ENLACE_SOLIDO);
		enlaces[2]=new enlace(translacionPto(posicion, 0, 40),ancho,enlace.ENLACE_HORIZONTAL,enlace.ENLACE_SOLIDO);
		lenguajeBase=lenguajeObjeto=lenguajeFuente="";
	}
	
	Point translacionPto(Point posicion,int dx, int dy){
		//System.out.println(posicion);
		Point aMover=new Point(posicion);
		aMover.translate(dx, dy);
		return aMover;
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
		//System.out.println("creando cuadro 1");
		cuadrados[0].dibujar(g);
		//System.out.println("creando cuadro 2");
		cuadrados[1].dibujar(g);
		//System.out.println("creando cuadro 3");
		cuadrados[2].dibujar(g);
		//System.out.println("creando cuadro 4");
		cuadrados[3].dibujar(g);
		
		//System.out.println("creando enlace 1");
		enlaces[0].dibujar(g);
		//System.out.println("creando enlace 2");
		enlaces[1].dibujar(g);
		//System.out.println("creando enlace 3");
		enlaces[2].dibujar(g);
		
	}
	

}
