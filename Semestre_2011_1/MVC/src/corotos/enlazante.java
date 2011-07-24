package corotos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class enlazante extends figura {
	tipoEnlace tipo;
	orientacionEnlace orientacion;
	lado lado;
	public enlazante(int ID, tipoEnlace tipo, orientacionEnlace orientacion, lado lado, Point posicionAbsoluta) {
		this.ID = ID;
		this.tipo = tipo;
		this.orientacion = orientacion;
		this.lado = lado;
		this.posicionAbsoluta=posicionAbsoluta;
		if(orientacion==orientacionEnlace.HORIZONTAL)
			setRegion(new Rectangle(posicionAbsoluta,new Dimension(G, P)));
		else
			setRegion(new Rectangle(posicionAbsoluta,new Dimension(P, G)));
			
		
		switch (tipo) {
		case SOLIDO:
			setColor(colorSolido);
			break;
		case OCIOSO:
			setColor(colorOcioso);
			break;
		case CORRECTO:
			setColor(colorCorrecto);
			break;
		case INCORRECTO:
			setColor(colorIncorrecto);
			break;
		case TRIANGULAR:
			setColor(colorSolido);
			break;
		default:
			break;
		}
		
		
		
		
		
		
		
	}
	
	

	@Override
	public boolean dentroFigura(Point p) {
		return region.contains(p);
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(color);
		if(tipoEnlace.TRIANGULAR==tipo){
			int[] x={posicionAbsoluta.x,posicionAbsoluta.x+region.width/2,posicionAbsoluta.x+region.width};
			int[] y={posicionAbsoluta.y,posicionAbsoluta.y+region.height,posicionAbsoluta.y};
			g.fillPolygon(x,y, 3);
		}else{
			g.fillRect(posicionAbsoluta.x,posicionAbsoluta.y,region.width,region.height);
		}
		
		
	}
	
	public void activar(boolean correcto){
		if(correcto){
			setColor(colorCorrecto);
			this.tipo=tipoEnlace.CORRECTO;
		}else {
			setColor(colorIncorrecto);
			this.tipo=tipoEnlace.INCORRECTO;
		}
	}

}
