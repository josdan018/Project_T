package corotos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;





public class cuadrada extends figura{
	Vector<enlazante> enlaces;
	//soy deLenguaje;
	int soy;
	String nombre;
	
	public cuadrada(int ID, Point posicionAbsoluta,Point posicionRelativa, String nombre/*,soy deLenguaje*/,int soy) {
		super(
				ID,
				new Rectangle(posicionAbsoluta,	new Dimension(G,G)),
				posicionRelativa
				);
		//this.deLenguaje=deLenguaje;
		this.soy=soy;
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
		g.setColor(Color.white);
		g.drawString(nombre, region.getLocation().x , region.getLocation().y + G/2);
		
	}
	
	public void anyadirEnlazante(tipoEnlace tipo, lados ladi){
		Point posicion=null;
		switch (ladi) {
		case ABAJO:
			posicion=translacionPto(region.getLocation(), 0, +G);
			enlaces.add(new enlazante(ID,tipo,orientacionEnlace.HORIZONTAL,ladi,posicion,new Point(0, +G)));
			break;
		case ARRIBA:
			posicion=translacionPto(region.getLocation(), 0, -P);
			enlaces.add(new enlazante(ID,tipo,orientacionEnlace.HORIZONTAL,ladi,posicion,new Point(0, -P)));
			break;
		case IZQUIERDA:
			posicion=translacionPto(region.getLocation(), -P, 0);
			enlaces.add(new enlazante(ID,tipo,orientacionEnlace.VERTICAL,ladi,posicion,new Point(-P,0)));
			break;
		case DERECHA:
			posicion=translacionPto(region.getLocation(), +G, 0);
			enlaces.add(new enlazante(ID,tipo,orientacionEnlace.VERTICAL,ladi,posicion,new Point(+G, 0)));
			break;
		default:
			break;
		}

	}

	@Override
	public void mover(Point p) {
		setPosicion(translacionPto(p, posicionRelativa.x, posicionRelativa.y));
		for (enlazante elemento : enlaces) {
			elemento.mover(region.getLocation());
		}
	}
	
	public boolean comparaLenguaje(){
		return false;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Vector<enlazante> getEnlaces() {
		return enlaces;
	}
	
	public int getSoy() {
		return soy;
	}
	
	public enlazante retornaEnlace(lados lado){
		for(enlazante enlace:enlaces){
			if(enlace.getLado()==lado)
				return enlace;
		}
		return null;
	}
	

}
