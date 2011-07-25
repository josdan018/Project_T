package controlador;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.SwingUtilities;


import corotos.cuadrada;
import corotos.enlazante;
import corotos.figura;
import corotos.pieza;
import corotos.utilesEscolares;
import corotos.valor.lados;
import corotos.valor.tipoEnlace;
import corotos.valor.tipoPieza;

import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import vista.Vista;

import modelo.Modelo;

public class Controlador {
	
	private Modelo modelo;
	private Vista vista;
	private pieza seleccionada;
	int tamanyoFig=40;
	boolean insercion;
	
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
		seleccionada=null;
		insercion=false;
	}
	
	public pieza obtenerFigura(Point posicion){
		ListIterator<pieza> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	pieza tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			tmp.setSeleccionada(true);
	    			return tmp;
	    		}
		    }
	    return null;
	}
	
	public pieza obtenerFigura(int ID){
		ListIterator<pieza> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	pieza tmp=it.next();
	    		if(tmp.getID()==ID){
	    			tmp.setSeleccionada(true);
	    			return tmp;
	    		}
		    }
	    return null;
	}
	public int cuantasFiguras(Point posicion){
		ListIterator<pieza> it=modelo.getListado().listIterator();
		int k=0;
	    while (it.hasNext()) {
	    	pieza tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			System.out.println("k aumento");
	    			k++;
	    		}
		    }
	    
	    return k;
	}

	public void cambiarPosicion(pieza f, Point p){
			
			f.mover(limitar(p));
	}
	
	public Vista getVista(){
		return vista;
	}
	
	public void anyadirFigura(pieza f){
		modelo.anyadirFigura(f);
	}
	
	public pieza getFiguraEn(Point p){
		return modelo.getFiguraEn(p);
	}
	
	public int getListadoSize(){
		return modelo.getListado().size();
	}
	
	public void eVmousePressed(MouseEvent ev) {
		
		if(SwingUtilities.isLeftMouseButton(ev)){ 			//Click boton izquierdo selecciona figura
			if(this.obtenerFigura(ev.getPoint())==null){
				Vector<String> vec=new Vector<String>(1, 1);
				vec.add("uno");
				vec.add("uno");
				vec.add("uno");
				
				this.anyadirFigura(new pieza(getListadoSize(), new Rectangle(limitar(ev.getPoint())), tipoPieza.COMPILADOR, vec));

			}
			
		}else if(SwingUtilities.isRightMouseButton(ev)){		//click boton izquierdo añade figura tipo cuadrado
			Vector<String> vec=new Vector<String>(1, 1);
			vec.add("uno");
			vec.add("uno");
			vec.add("uno");
			
			if(this.obtenerFigura(ev.getPoint())==null)
				this.anyadirFigura(new pieza(getListadoSize(), new Rectangle(limitar(ev.getPoint())), tipoPieza.MAQUINA, vec));
							
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio añade figura tipo circulo
		{
			Vector<String> vec=new Vector<String>(1, 1);
			vec.add("uno");
			vec.add("uno");
			vec.add("uno");
			if(this.obtenerFigura(ev.getPoint())==null)
				this.anyadirFigura(new pieza(getListadoSize(), new Rectangle(limitar(ev.getPoint())), tipoPieza.PROGRAMA, vec));
		}
		seleccionada=this.getFiguraEn(limitar(ev.getPoint()));
		vista.repaint();
		//}
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		
		if(seleccionada!=null)
			this.cambiarPosicion(seleccionada, ev.getPoint());
		vista.repaint();
		
	}

	public void eVmouseReleased (MouseEvent ev) {
		vista.repaint();
		if(seleccionada!=null){
			seleccionada.setSeleccionada(false);

			if(this.getFiguraEn(ev.getPoint())!=null){
				//System.out.println("entro aqui");
				detectaEnlaces();
			}
			seleccionada=null;
		}
	}
	
	public void detectaEnlaces() {
		pieza adyacente;
		for(cuadrada cuadro:seleccionada.getCuadrados()){
			for(enlazante enlace:cuadro.getEnlaces()){
				if(enlace.getTipo()!=tipoEnlace.SOLIDO&&enlace.getTipo()!=tipoEnlace.TRIANGULAR) {
					Point tentando = null;
					lados vecinoDebeSer = null;
					switch (enlace.getLado()) {
						case ARRIBA:
							vecinoDebeSer=lados.ABAJO;
							tentando=new Point(figura.translacionPto(enlace.getRegion().getLocation(), 0, -figura.G));
							break;
						case ABAJO:
							vecinoDebeSer=lados.ARRIBA;
							tentando=new Point(figura.translacionPto(enlace.getRegion().getLocation(), 0, +figura.G));
							break;
						case IZQUIERDA:
							vecinoDebeSer=lados.DERECHA;
							tentando=new Point(figura.translacionPto(enlace.getRegion().getLocation(), -figura.G , 0));
							break;
						case DERECHA:
							vecinoDebeSer=lados.IZQUIERDA;
							tentando=new Point(figura.translacionPto(enlace.getRegion().getLocation(),+figura.G , 0));
							break;
						default:
								break;
					} 
					adyacente=getFiguraEn(tentando );
					if(adyacente!=null){
						cuadrada cuadroAdyacente = adyacente.retornaCuadrada(tentando);
						
						
						
						if (cuadroAdyacente.getNombre().compareTo(cuadro.getNombre())==0) {
							enlazante enlaceAVecinar=cuadroAdyacente.retornaEnlace(vecinoDebeSer);
							if(enlaceAVecinar!=null){
								if(enlaceAVecinar.getTipo()!=tipoEnlace.SOLIDO&&enlaceAVecinar.getTipo()!=tipoEnlace.TRIANGULAR&&enlaceAVecinar.getTipo()!=tipoEnlace.BLOQUEADO){
									System.out.println("ennnnnnnnnnnnntttttttrrrrrrrrrroooooo");
									enlace.corregir(true);
									enlaceAVecinar.corregir(true);
									
									enlace.setIDVecino(adyacente.getID());
									enlaceAVecinar.setIDVecino(seleccionada.getID());
									
									enlace.setIDCuadroVecino(cuadroAdyacente.getSoy());
									enlaceAVecinar.setIDCuadroVecino(cuadro.getSoy());
								}
								
							}
						}else{
							enlazante enlaceAVecinar=cuadroAdyacente.retornaEnlace(vecinoDebeSer);
							if(enlaceAVecinar!=null){
								enlace.corregir(false);
								enlaceAVecinar.corregir(false);
								
								enlace.setIDVecino(adyacente.getID());
								enlaceAVecinar.setIDVecino(seleccionada.getID());
								
								enlace.setIDCuadroVecino(cuadroAdyacente.getSoy());
								enlaceAVecinar.setIDCuadroVecino(cuadro.getSoy());
								
								
							}
							
						}
						
						
						
					}else{
						if(enlace.getIDVecino()!=-1){
							
							pieza YaNoVecina=obtenerFigura(enlace.getIDVecino());
							
							if(YaNoVecina!=null){
								enlazante YaNoVecino = YaNoVecina.getCuadrados().get(enlace.getIDCuadroVecino()).retornaEnlace(vecinoDebeSer);
								
								enlace.setIDVecino(-1);
								YaNoVecino.setIDVecino(-1);
								
								enlace.setIDCuadroVecino(-1);
								YaNoVecino.setIDCuadroVecino(-1);
								
								YaNoVecino.desactivar();
								enlace.desactivar();
							}
						}
					}
				}
			}
		}
		
	}
	
	public void modificarAlgo(Point figuraResidente, Point figuraVecina, int enlaceAfectado){
		
		
	}
	
	public Point limitar(Point original){
		Point auxiliar=new Point();
		auxiliar.setLocation((int)original.x/45*45+5, (int)original.y/45*45+5);
		return auxiliar;
	} 

}
