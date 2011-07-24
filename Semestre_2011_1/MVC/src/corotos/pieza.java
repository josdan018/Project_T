package corotos;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

public class pieza extends figura{
	Vector<cuadrada> cuadrados;
	tipoPieza identificador;
	
	public pieza(int ID, Rectangle region, tipoPieza identificador ) {
		super(ID, region);
		this.identificador=identificador;
		cuadrados=new Vector<cuadrada>(1, 1);
		switch (identificador) {
		case COMPILADOR:
			armarCompilador();
			break;
		case INTERPRETE:
			armarInterprete();
			break;
		case MAQUINA:
			armarMaquina();
			break;
		case PROGRAMA:
			armarPrograma();
		default:
			break;
		}
		
		
	}
	
	
	


	@Override
	public boolean dentroFigura(Point p) {
		if(region.contains(p))
			return true;
		for(cuadrada elemento:cuadrados){
			if(elemento.dentroFigura(p))
				return true;
		}
		return false;
	}

	@Override
	public void dibujar(Graphics g) {
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mover(Point p) {
		// TODO Auto-generated method stub
		
	}
	
	private void armarCompilador(){
		//-------centro del compilador----------------
		cuadrada aux=new cuadrada(ID, region.getLocation());
		aux.anyadirEnlazante(tipoEnlace.SOLIDO, lados.IZQUIERDA);
		aux.anyadirEnlazante(tipoEnlace.SOLIDO, lados.DERECHA);
		aux.anyadirEnlazante(tipoEnlace.SOLIDO, lados.ABAJO);
		cuadrados.add(aux);
		//-------izquierda del compilador----------------
		aux=new cuadrada(ID, translacionPto(region.getLocation(), -G-P, 0));
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.IZQUIERDA);
		cuadrados.add(aux);
		//-------derecha del compilador----------------
		aux=new cuadrada(ID, translacionPto(region.getLocation(), +G+P, 0));
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.DERECHA);
		cuadrados.add(aux);
		//-------abajo del compilador----------------
		aux=new cuadrada(ID, translacionPto(region.getLocation(), 0, +G+P));
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.IZQUIERDA);
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.DERECHA);
		aux.anyadirEnlazante(tipoEnlace.OCIOSO, lados.ABAJO);
		cuadrados.add(aux);
		
		
	}
	private void armarPrograma() {
		// TODO Auto-generated method stub
		
	}


	private void armarMaquina() {
		// TODO Auto-generated method stub
		
	}


	private void armarInterprete() {
		// TODO Auto-generated method stub
		
	}

}
