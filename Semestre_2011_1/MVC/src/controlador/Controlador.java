package controlador;

import java.awt.Point;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.util.ListIterator;

import vista.Vista;
import modelo.Figura;
import modelo.Modelo;
import modelo.compilador;
import modelo.enlace;
import modelo.maquina;
import modelo.programa;

public class Controlador {
	
	private Modelo modelo;
	private Vista vista;
	private Figura seleccionada;
	int tamanyoFig=40;
	boolean insercion;
	
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
		seleccionada=null;
		insercion=false;
	}
	
	public Figura obtenerFigura(Point posicion){
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			tmp.setSeleccionada(true);
	    			return tmp;
	    		}
		    }
	    return null;
	}
	
	public Figura obtenerFigura(int ID){
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.getID()==ID){
	    			tmp.setSeleccionada(true);
	    			return tmp;
	    		}
		    }
	    return null;
	}
	public int cuantasFiguras(Point posicion){
		ListIterator<Figura> it=modelo.getListado().listIterator();
		int k=0;
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			System.out.println("k aumento");
	    			k++;
	    		}
		    }
	    
	    return k;
	}

	public void cambiarPosicion(Figura f, Point p){
			f.setPosicion(limitar(p));
	}
	
	public Vista getVista(){
		return vista;
	}
	
	public void anyadirFigura(Figura f){
		modelo.anyadirFigura(f);
	}
	
	public Figura getFiguraEn(Point p){
		return modelo.getFiguraEn(p);
	}
	
	public void eVmousePressed(MouseEvent ev) {
		//System.out.println(ev.getPoint());
		//if(insercion){
		if(SwingUtilities.isLeftMouseButton(ev)){ 			//Click boton izquierdo selecciona figura
			if(this.obtenerFigura(ev.getPoint())==null){
				this.anyadirFigura(new programa(limitar(ev.getPoint()), 40,modelo.getListado().size()));
				//this.anyadirFigura(new maquina(limitar(ev.getPoint()),40));
				//this.anyadirFigura(new compilador(limitar(ev.getPoint()),40));
			}else{
				//System.out.println("ya hay: " + modelo.getListado().size());
				seleccionada=this.getFiguraEn(ev.getPoint());
			}
			if(this.getFiguraEn(ev.getPoint())!=null);
				//detectaEnlaces(ev.getPoint());
			
		}else if(SwingUtilities.isRightMouseButton(ev)){		//click boton izquierdo a�ade figura tipo cuadrado
			if(this.obtenerFigura(ev.getPoint())==null)
				this.anyadirFigura(new maquina(limitar(ev.getPoint()),40,modelo.getListado().size()));
							
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio a�ade figura tipo circulo
		{
			if(this.obtenerFigura(ev.getPoint())==null)
				this.anyadirFigura(new compilador(limitar(ev.getPoint()),40,modelo.getListado().size()));
		}
		vista.repaint();
		//}
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		if(this.obtenerFigura(ev.getPoint())==null){
			;
		}
		if(seleccionada!=null){
			
			int k=this.cuantasFiguras(limitar(ev.getPoint()));
			System.out.println(k+"             )");
			if(k==0){
				System.out.println("moviendo "+ev.getPoint()+" "+k);
				this.cambiarPosicion(seleccionada, ev.getPoint());
				vista.repaint();
			}
		}
	}

	public void eVmouseReleased (MouseEvent ev) {
		vista.repaint();
		if(seleccionada!=null){
			seleccionada.setSeleccionada(false);
			seleccionada=null;
			if(this.getFiguraEn(ev.getPoint())!=null)
				detectaEnlaces(ev.getPoint());
		}
	}
	
	public void detectaEnlaces(Point donde) {
		
		Point posicionFigura = this.getFiguraEn(donde).getPosicion();
		switch (this.getFiguraEn(donde).getTipoFigura()) {
		case Figura.COMPILADOR:
			System.out.println("primer entrar");
			modificarAlgo(donde, Figura.translacionPto(donde, -70, 0), 3);
			
			break;
		case Figura.PROGRAMA:
			//revisar por debajo
			break;
		case Figura.INTERPRETE:
			//revisar por arriba y por debajo
			break;
		case Figura.MAQUINA:
			//revisar por arriba
			break;
		default:
			break;
		}
		
		
	}
	
	public void modificarAlgo(Point figuraResidente, Point figuraVecina, int enlaceAfectado){
		Figura vecina = this.getFiguraEn(figuraVecina);
		Figura residente = this.getFiguraEn(figuraResidente);
		int tipoResidente = residente.getTipoFigura();	
		System.out.println("vecina: "+vecina);
		
		if(vecina!=null){
			for(int i=0; i < residente.numeroEnlaces ;i++)
				for(int j=0;j<vecina.numeroEnlaces;j++)
					if(residente.enlaces[enlaceAfectado].interseccionDeEnlaces(vecina.enlaces[j])
							&&
							residente.enlaces[enlaceAfectado].disponible()){
						System.out.println("entro");
						residente.enlaces[enlaceAfectado].setEstado(enlace.ENLACE_VOLATIL_CORRECTO);
						vecina.enlaces[enlaceAfectado].setEstado(enlace.ENLACE_VOLATIL_CORRECTO);
						
						
					}
			//if()
			
			
		}
		
		
	}
	
	public Point limitar(Point original){
		Point auxiliar=new Point();
		auxiliar.setLocation((int)original.x/45*45+5, (int)original.y/45*45+5);
		return auxiliar;
	} 

}
