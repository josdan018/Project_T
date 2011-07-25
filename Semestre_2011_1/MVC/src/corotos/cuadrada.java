package corotos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

public class cuadrada extends figura{
	Vector<enlazante> enlaces;
	
	String nombre;
	
	public cuadrada(int ID, Point posicionAbsoluta, String nombre) {
		super(
				ID,
				new Rectangle(posicionAbsoluta,	new Dimension(G,G))
				);
		enlaces=new Vector<enlazante>(1, 1);
		this.nombre=nombre;
		this.color=colorSolido;
	}
	
	@Override
	public boolean dentroFigura(Point p) {
		
		for (figura elemento : enlaces) {
			if(elemento.dentroFigura(p))
				return true;
		}
		return region.contains(p);
	}

	@Override
	public void dibujar(Graphics g) {
		for (figura elemento : enlaces) {
			elemento.dibujar(g);
		}
		g.setColor(color);
		g.fillRect(region.getLocation().x, region.getLocation().y, region.width, region.height);
		
	}
	
	public void anyadirEnlazante(tipoEnlace tipo, lados ladi){
		Point posicion=null;
		switch (ladi) {
		case ABAJO:
			posicion=translacionPto(region.getLocation(), 0, +G);
			enlaces.add(new enlazante(ID,tipo,orientacionEnlace.HORIZONTAL,ladi,posicion));
			break;
		case ARRIBA:
			posicion=translacionPto(region.getLocation(), 0, -P);
			enlaces.add(new enlazante(ID,tipo,orientacionEnlace.HORIZONTAL,ladi,posicion));
			break;
		case IZQUIERDA:
			posicion=translacionPto(region.getLocation(), -P, 0);
			enlaces.add(new enlazante(ID,tipo,orientacionEnlace.VERTICAL,ladi,posicion));
			break;
		case DERECHA:
			posicion=translacionPto(region.getLocation(), +G, 0);
			enlaces.add(new enlazante(ID,tipo,orientacionEnlace.VERTICAL,ladi,posicion));
			break;
		default:
			break;
		}
		
		
		
	}

	@Override
	public void mover(Point p) {
		setPosicion(p);
		for (enlazante elemento : enlaces) {
			elemento.setPosicion(p);
		}
	}
	
	public boolean comparaLenguaje(){
		return false;
	}
	
	public String getNombre() {
		return nombre;
	}

}
