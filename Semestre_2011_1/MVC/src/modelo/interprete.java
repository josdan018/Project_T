package modelo;

import java.awt.Graphics;
import java.awt.Point;

public class interprete extends Figura{//un cuadrado (2 enlaces ocultos?)
	Cuadrado cuadrados;
	enlace enlaces[];
	String lenguajeFuente,lenguajeBase;
	
	public interprete(Point posicion,int ancho) {
		
		
		cuadrados=new Cuadrado(posicion, ancho);		
		
		lenguajeBase=lenguajeFuente="";
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
		//deberian haber enlaces invisibles para poder activarlos digo no . . .  
	}
	
	
	

	@Override
	public boolean dentroFigura(Point p) {
		return 
			cuadrados.dentroFigura(p);
		
	}

	@Override
	public void dibujar(Graphics g) {
		//System.out.println("creando cuadro 1");
		cuadrados.dibujar(g);
		//System.out.println("creando cuadro 2");
				
	}

}
