package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circulo extends Figura {

	private int radio;
	
	public void setRadio(int ancho){
		this.radio=ancho;
	}
	
	public int getRadio(){
		return radio;
	}
	
	public Circulo(Point posicion, int radio){
		this.posicion=posicion;
		this.radio=radio;
		this.seleccionada=false;  //Deberia estar en el constructor de figura pero por simplicidad
	}
	
	@Override
	public boolean dentroFigura(Point p) {
		System.out.println(radio/2 +" "+Math.sqrt( Math.pow( p.x - posicion.x - radio/2, 2 ) + Math.pow(p.y - posicion.y - radio/2, 2 )));
		if ( radio/2 >= Math.sqrt( Math.pow( p.x - posicion.x - radio/2, 2 ) + Math.pow(p.y - posicion.y- radio/2, 2 )))		
				return true;
		else
				return false;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval(this.getX(), this.getY(), this.getRadio(), this.getRadio());
		if(this.getSeleccionada()){
			g.setColor(Color.CYAN);
			g.drawOval(this.getX()+7, this.getY()+7, this.getRadio()-20, this.getRadio()-20);
		}
	}

}
