package controlador;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.SwingUtilities;


import corotos.cuadrada;
import corotos.enlazante;
import corotos.figura;
import corotos.pieza;
import corotos.valor.lados;
import corotos.valor.tipoEnlace;
import corotos.valor.tipoPieza;

import java.awt.event.MouseEvent;
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
	vectorDeVectores superv;
	
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
		seleccionada=null;
		insercion=false;
		superv=new vectorDeVectores();
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
		superv.añadir(obtenerFigura(f.getID()));
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
				vec.add("dos");
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
		
		desactivarVecinos();
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
					lados vecinoDebeSer = enlace.getTipoEnlaceContrario();
					switch (enlace.getLado()) {
						case ARRIBA:
							tentando=new Point(figura.translacionPto(enlace.getRegion().getLocation(), 0, -figura.G));
							break;
						case ABAJO:
							tentando=new Point(figura.translacionPto(enlace.getRegion().getLocation(), 0, +figura.G));
							break;
						case IZQUIERDA:
							tentando=new Point(figura.translacionPto(enlace.getRegion().getLocation(), -figura.G , 0));
							break;
						case DERECHA:
							tentando=new Point(figura.translacionPto(enlace.getRegion().getLocation(),+figura.G , 0));
							break;
						default:
								break;
					}
					
					adyacente=getFiguraEn(tentando );
					if(adyacente!=null){
						cuadrada cuadroAdyacente = adyacente.retornaCuadrada(tentando);
						boolean correcto=cuadroAdyacente.getNombre().compareTo(cuadro.getNombre())==0;
						
						enlazante enlaceAVecinar=cuadroAdyacente.retornaEnlace(vecinoDebeSer);
						if(enlaceAVecinar!=null){
							if(enlaceAVecinar.getTipo()==tipoEnlace.OCIOSO){
								aVecinar(enlace, correcto, adyacente.getID(), cuadroAdyacente.getSoy());
								aVecinar(enlaceAVecinar, correcto, seleccionada.getID(), cuadro.getSoy());
								}
							}
						}
					}
				}
			}
		
	}
	
	private void aVecinar(enlazante enlace,boolean correcto, int IDVecino, int IDCuadroVecino ) {
		enlace.corregir(correcto);
		enlace.setIDVecino(IDVecino);
		enlace.setIDCuadroVecino(IDCuadroVecino);
	}
	
	public void desactivarVecinos(){
		for(cuadrada cuadrito:seleccionada.getCuadrados()){
			for(enlazante enlacito:cuadrito.getEnlaces()){
				if(enlacito.getIDCuadroVecino()!=-1&&enlacito.getIDVecino()!=-1){
					cuadrada cuadroV = obtenerFigura(enlacito.getIDVecino()).getCuadrados().get(enlacito.getIDCuadroVecino());
					for(enlazante enlaceV:cuadroV.getEnlaces()){
						if(enlaceV.getLado()==enlacito.getTipoEnlaceContrario()){
							enlaceV.desactivar();
							enlacito.desactivar();
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
	
	class vectorDeVectores {
		Vector<pieza> supervector;
		public vectorDeVectores() {
			supervector=new Vector<pieza>(1, 1);
			// //vector grande creado;
		}
		
		public void añadir(pieza p){
		}

		
		private boolean maquinaBusca(int index) {
			
			return false;
		}
		
		private boolean interpreteBusca(int index) {
			return false;
		}
		
		private boolean compiladorBusca(int index) {
			return false;
		}
		
		
		
		
	
	}
}
