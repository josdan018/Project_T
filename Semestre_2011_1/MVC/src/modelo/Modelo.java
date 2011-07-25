package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
	String nombre="puto";
	
	private List<Pieza> listaFiguras;
	public Modelo(){
		listaFiguras = new ArrayList<Pieza>();
	}
	
	public void AnyadirFigura(Pieza f){
		listaFiguras.add(f);
	}
	
	public List<Pieza> getListado(){
		return listaFiguras;
	}
	
	public void anyadirFigura(Pieza f){
		listaFiguras.add(f);
	}
	
	public Pieza getFiguraEn(Point p){
		for (Pieza elemento : getListado()) {
			if(elemento.dentroFigura(p)){
				elemento.seleccionada=true;
				return elemento;				
			}
		}
		return null;
	}
}
