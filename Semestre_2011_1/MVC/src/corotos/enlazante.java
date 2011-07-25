package corotos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class enlazante extends figura {
	tipoEnlace tipo;
	orientacionEnlace orientacion;
	lados lado;
	public enlazante(int ID, tipoEnlace tipo, orientacionEnlace orientacion, lados lado, Point posicionAbsoluta) {
		super(
				ID,
				new Rectangle(posicionAbsoluta,
						(orientacion==orientacionEnlace.HORIZONTAL)?
								new Dimension(G, P):
								new Dimension(P, G)
								)
				);
		
		this.tipo = tipo;
		this.orientacion = orientacion;
		this.lado = lado;
		
			
		
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
			int[] x={region.x,region.x+region.width/2,region.x+region.width};
			int[] y={region.y,region.y+region.height,region.y};
			g.fillPolygon(x,y, 3);
		}else{
			g.fillRect(region.x,region.y,region.width,region.height);
		}
		
		
	}
	
	public void activar(boolean activo){
		if(!activo){
			setColor(colorOcioso);
			this.tipo=tipoEnlace.OCIOSO;
		}
	}
	
	public void corregir(boolean correcto){
		if(correcto){
			setColor(colorCorrecto);
			this.tipo=tipoEnlace.CORRECTO;
		}else{
			setColor(colorIncorrecto);
			this.tipo=tipoEnlace.INCORRECTO;
		}
	}



	@Override
	public void mover(Point p) {
		setPosicion(p);
		
	}

}
