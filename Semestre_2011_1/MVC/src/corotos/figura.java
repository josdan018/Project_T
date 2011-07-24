package corotos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class figura implements valor{
	int ID;
	Point posicionAbsoluta;
	Point centro;
	Point posicionRelativa;
	boolean seleccionada;
	Rectangle region;
	Color color;
	
	
	public abstract boolean dentroFigura(Point p);
	public abstract void dibujar(Graphics g);
	
	public figura() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public Point getPosicionAbsoluta() {
		return posicionAbsoluta;
	}
	
	public void setPosicionAbsoluta(Point posicion) {
		this.posicionAbsoluta = posicion;
	}
	
	public Point getPosicionRelativa() {
		return posicionRelativa;
	}
	
	public void setPosicionRelativa(Point posicion) {
		this.posicionRelativa = posicion;
	}

	public Point getCentro() {
		return centro;
	}
	
	public void setCentro(Point centro) {
		this.centro = centro;
	}
	
	public boolean getSelecionada(){
		return seleccionada;
	}
	
	public void setSeleccionada(boolean seleccionada) {
		this.seleccionada = seleccionada;
	}
	
	public Rectangle getRegion() {
		return region;
	}
	
	public void setRegion(Rectangle region) {
		this.region = region;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
}
