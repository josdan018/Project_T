package corotos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class enlazante extends figura {
	tipoEnlace tipo;
	orientacionEnlace orientacion;
	lados lado;
	int IDVecino;
	int IDCuadroVecino;
	int IDEnlaceEnlazante;
	boolean aBloquear; 
	public enlazante(int ID, tipoEnlace tipo, orientacionEnlace orientacion, lados lado, Point posicionAbsoluta,Point posicionRelativa) {
		super(
				ID,
				new Rectangle(posicionAbsoluta,
						(orientacion==orientacionEnlace.HORIZONTAL)?
								new Dimension(G, P):
								new Dimension(P, G)
								)
				,posicionRelativa
				
				);
		
		this.tipo = tipo;
		this.orientacion = orientacion;
		this.lado = lado;
		IDVecino=-1;
		IDCuadroVecino=-1;
		aBloquear=false;
			
		
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
	
	public void desactivar(){
		if(!aBloquear){
			setColor(colorOcioso);
			this.tipo=tipoEnlace.OCIOSO;
		}
		
	}
	
	public void corregir(boolean correcto){
		if(correcto){
			setColor(colorCorrecto);
			this.tipo=tipoEnlace.CORRECTO;
		}else {
			setColor(colorIncorrecto);
			this.tipo=tipoEnlace.INCORRECTO;
		}
	}



	@Override
	public void mover(Point p) {
		setPosicion(translacionPto(p, posicionRelativa.x, posicionRelativa.y));
		
	}
	
	public tipoEnlace getTipo() {
		return tipo;
	}
	
	public lados getLado() {
		return lado;
	}
	
	public void setIDVecino(int iDVecino) {
		IDVecino = iDVecino;
	}
	
	public int getIDVecino() {
		return IDVecino;
	}
	
	public int getIDCuadroVecino() {
		return IDCuadroVecino;
	}
	
	public int getIDEnlaceEnlazante() {
		return IDEnlaceEnlazante;
	}
	
	public void setIDCuadroVecino(int iDCuadroVecino) {
		IDCuadroVecino = iDCuadroVecino;
	}
	public void setIDEnlaceEnlazante(int iDEnlaceEnlazante) {
		IDEnlaceEnlazante = iDEnlaceEnlazante;
	}

}
