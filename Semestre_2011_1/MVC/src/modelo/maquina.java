package modelo;

import java.awt.Graphics;
import java.awt.Point;

public class maquina extends Figura{
	Cuadrado cuadrados;
	enlace enlaces;
	String lenguajeBase;
	
	public maquina(Point posicion,int ancho) {
				
		cuadrados=new Cuadrado(posicion, ancho);		

		enlaces=new enlace(translacionPto(posicion, 0, 40),ancho,enlace.ENLACE_HORIZONTAL,enlace.ENLACE_TRIANGULAR);
		
		lenguajeBase="";
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
		cuadrados.setPosicion(posicion);		
		
		enlaces.setPosicion(translacionPto(posicion, 0, 40));
		//deberian haber enlaces invisibles para poder activarlos digo no . . .  
	}
	
	
	

	@Override
	public boolean dentroFigura(Point p) {
		return 
			cuadrados.dentroFigura(p)||
			enlaces.dentroFigura(p)
		;
	}

	@Override
	public void dibujar(Graphics g) {
		//System.out.println("creando cuadro 1");
		cuadrados.dibujar(g);

		//System.out.println("creando enlace 1");
		enlaces.dibujar(g);
		
	}


}
