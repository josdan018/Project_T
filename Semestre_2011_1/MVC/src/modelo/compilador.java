package modelo;

import java.awt.Graphics;
import java.awt.Point;

public class compilador extends Figura{
	Cuadrado cuadrados[];
	enlace enlaces[];
	String lenguajeObjeto,lenguajeFuente,lenguajeBase;
	
	public compilador(Point posicion,int ancho) {
		cuadrados=new Cuadrado[4];
		for(int i=0;i<4;i++){
			cuadrados[i]=new Cuadrado(posicion, ancho);
		}
		enlaces=new enlace[3];
		for(int i=0;i<3;i++){
			enlaces[i]=new enlace(posicion,ancho,ancho);
		}
		lenguajeBase=lenguajeObjeto=lenguajeFuente="";
	}
	
	
	

	@Override
	public boolean dentroFigura(Point p) {
		
		return false;
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
	}
	

}
