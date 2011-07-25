package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import corotos.pieza;


public class Modelo {
	String nombre="puto";
	
	private List<pieza> listaFiguras;
	public Modelo(){
		listaFiguras = new ArrayList<pieza>();
	}
	
	public void AnyadirFigura(pieza f){
		listaFiguras.add(f);
	}
	
	public List<pieza> getListado(){
		return listaFiguras;
	}
	
	public void anyadirFigura(pieza f){
		listaFiguras.add(f);
	}
	
	public pieza getFiguraEn(Point p){
		for (pieza elemento : getListado()) {
			if(elemento.dentroFigura(p)){
				elemento.setSeleccionada(true);
				return elemento;				
			}
		}
		return null;
	}
}
