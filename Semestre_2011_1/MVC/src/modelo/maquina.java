package modelo;

import java.awt.Graphics;
import java.awt.Point;

public class maquina extends Figura{
	Cuadrado cuadrados;
	enlace enlaces[];
	String lenguajeBase;
	
	public maquina(Point posicion,int ancho) {
		this.tipoFigura=Figura.MAQUINA;
		cuadrados=new Cuadrado(posicion, ancho);		
		enlaces=new enlace[2];
		enlaces[0]=new enlace(translacionPto(posicion, 0, 40),ancho,enlace.ENLACE_HORIZONTAL,enlace.ENLACE_TRIANGULAR);
		enlaces[1]=new enlace(translacionPto(posicion, 0, -5),ancho,enlace.ENLACE_HORIZONTAL,enlace.ENLACE_VOLATIL_NO_ACTIVO);
		
		lenguajeBase="";
	}
		
	@Override
	public void setPosicion(Point posicion) {
		super.setPosicion(posicion);
		cuadrados.setPosicion(posicion);		
		
		enlaces[0].setPosicion(translacionPto(posicion, 0, 40));
		enlaces[1].setPosicion(translacionPto(posicion, 0, -5));
		//deberian haber enlaces invisibles para poder activarlos digo no . . .  
	}
	
	
	

	@Override
	public boolean dentroFigura(Point p) {
		return 
			cuadrados.dentroFigura(p)||
			enlaces[0].dentroFigura(p)||
			enlaces[1].dentroFigura(p)
		;
	}

	@Override
	public void dibujar(Graphics g) {
		//System.out.println("creando cuadro 1");
		cuadrados.dibujar(g);

		//System.out.println("creando enlace 1");
		enlaces[0].dibujar(g);
		enlaces[1].dibujar(g);
		
	}


}
