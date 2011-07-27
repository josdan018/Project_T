package controlador;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.SwingUtilities;


import corotos.cuadrada;
import corotos.enlazante;
import corotos.figura;
import corotos.pieza;
import corotos.valor;
import corotos.valor.lados;
import corotos.valor.tipoEnlace;
import corotos.valor.tipoPieza;

import java.awt.event.MouseEvent;
import java.util.ListIterator;
import java.util.Vector;

import vista.Vista;

import metodos.metodo_s;
import metodos.zulma;
import modelo.Modelo;

public class Controlador {
	
	private Modelo modelo;
	private Vista vista;
	private pieza seleccionada;
	int tamanyoFig=40;
	boolean insercion;
	vectorDeVectores superv;
	zulma a;
	metodo_s meto;
	
	public Controlador(Modelo modelo, Vista vista, metodo_s metodo){
		this.modelo=modelo;
		this.vista=vista;
		seleccionada=null;
		insercion=false;
		superv=new vectorDeVectores();
		meto=metodo;
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
		if(f.getIdentificador()==tipoPieza.MAQUINA)
			superv.anyadir(obtenerFigura(f.getID()));
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
				
				//this.anyadirFigura(new pieza(getListadoSize(), new Rectangle(limitar(ev.getPoint())), tipoPieza.COMPILADOR, vec));
				pieza piie=meto.getpiezas();
				if(piie!=null){
				piie.setID(getListadoSize());
				piie.setRegion(new Rectangle(limitar(ev.getPoint()),new Dimension(0, 0)));
				
				this.anyadirFigura(piie);
				meto.nullvar();
				}

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
			superv.verificar();
			
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
		Vector<pieza> maquinas,vectorPosible;
		
		public vectorDeVectores() {
			maquinas=new Vector<pieza>(1, 1);
			vectorPosible=new Vector<pieza>(1, 1);
			// //vector grande creado;
		}

		public void anyadir(pieza p){
			maquinas.add(p);
		}

		public void verificar() {
			System.out.println("revizando maquinas "+maquinas.size());
			for(pieza maquinaI:maquinas){
				vectorPosible.removeAllElements();
				vectorPosible.add(0,maquinaI);
				System.out.println(verificandoMaquina(0, maquinaI.getID()));
				if(verificandoMaquina(0, maquinaI.getID())){
					System.out.println("ojo correcto . . . . ");

				}
			}

		}

		private boolean verificandoMaquina(int index,int ID) {
			pieza actual=obtenerFigura(ID);
			if(actual!=null){
				vectorPosible.add(0,actual);
				enlazante enlace=actual.getCuadrados().get(0).getEnlaces().get(0);
				if(enlace.getTipo()==tipoEnlace.CORRECTO){
					switch (obtenerFigura(enlace.getIDVecino()).getIdentificador()) {
					case COMPILADOR:
						return verificandoCompilador(0, enlace.getIDVecino());
					case INTERPRETE:
						return verificandoInterprete(0, enlace.getIDVecino());
					case PROGRAMA:
						return verificandoPrograma(0, enlace.getIDVecino());
					default:
						return false;
					}

				}
			}
			return false;
		}

		private boolean verificandoInterprete(int index,int ID) {
			pieza actual=obtenerFigura(ID);
			if(actual!=null){
				vectorPosible.add(0,actual);
				enlazante enlace=actual.getCuadrados().get(1).getEnlaces().get(0);
				if(enlace.getTipo()==tipoEnlace.CORRECTO){
					switch (obtenerFigura(enlace.getIDVecino()).getIdentificador()) {
					case COMPILADOR:
						return verificandoCompilador(0, enlace.getIDVecino());
					case INTERPRETE:
						return verificandoInterprete(0, enlace.getIDVecino());
					case PROGRAMA:
						if(verificandoPrograma(0, enlace.getIDVecino())){
							return true;
						}
						break;
					default:
						return false;
					}

				}
			}
			return false;
		}

		private boolean verificandoCompilador(int index,int ID) {
			pieza actual=obtenerFigura(ID);
			if(actual!=null){
				vectorPosible.add(0,actual);
				enlazante enlace = null;
				if(index==0)
					enlace=actual.getCuadrados().get(1).getEnlaces().get(0);
				if(index==1){
					System.out.println("compilacion correcta del programa");
					return true;
				}
					//enlace=actual.getCuadrados().get(1).getEnlaces().get(0);//todavia tiene que verificar?
				if(enlace.getTipo()==tipoEnlace.CORRECTO){					
					switch (obtenerFigura(enlace.getIDVecino()).getIdentificador()) {
					case COMPILADOR:
						if(verificandoCompilador(1, enlace.getIDVecino())&&
								obtenerFigura(pieza.translacionPto(actual.getRegion().getLocation(),+2*(valor.G+valor.P),-(valor.P+valor.G)))==null){
							System.out.println("compilacion correcta del programa");
							Vector< String > aux=new Vector<String>(1, 1);
							System.out.println("");
							System.out.println(obtenerFigura(enlace.getIDVecino()).getCuadrados().get(1).getNombre());
							System.out.println(obtenerFigura(enlace.getIDVecino()).getCuadrados().get(2).getNombre());
							System.out.println(actual.getCuadrados().get(2).getNombre());
							aux.add(obtenerFigura(enlace.getIDVecino()).getCuadrados().get(1).getNombre());
							aux.add(obtenerFigura(enlace.getIDVecino()).getCuadrados().get(2).getNombre());
							aux.add(actual.getCuadrados().get(2).getNombre());

							pieza nueva = new pieza(
									getListadoSize(),
									new Rectangle(
											pieza.translacionPto(actual.getRegion().getLocation(),+2*(valor.G+valor.P),-(valor.P+valor.G)),
											new Dimension(0,0)), 
									tipoPieza.COMPILADOR,
									aux);
							anyadirFigura(nueva);
							vectorPosible.add(nueva);
							a.cuadro_informacion(vectorPosible);
							//TODO: llamar al metodo de zulma
							
							
						return true;
						}
						break;
					/*case INTERPRETE:
						return verificandoInterprete(0, enlace.getIDVecino());*///puede haber interprete?
					case PROGRAMA:
						if(verificandoPrograma(0, enlace.getIDVecino())&&
								obtenerFigura(pieza.translacionPto(actual.getRegion().getLocation(),+2*(valor.G+valor.P),0))==null){
							System.out.println("compilacion correcta del programa");
							Vector< String > aux=new Vector<String>(1, 1);
							aux.add(actual.getCuadrados().get(1).getNombre());
							aux.add(obtenerFigura(enlace.getIDVecino()).getCuadrados().get(1).getNombre());

							pieza nueva = new pieza(
									getListadoSize(),
									new Rectangle(
											pieza.translacionPto(actual.getRegion().getLocation(),+2*(valor.G+valor.P),0),
											new Dimension(0,0)), 
									tipoPieza.PROGRAMA,
									aux);
							vectorPosible.add(nueva);
							anyadirFigura(nueva);
							//TODO: llamar al metodo de zulma
							
						return true;
						}
						break;
					default:
						return false;
					}

				}
			}
			return false;
		}

		private boolean verificandoPrograma(int index,int ID) {
			pieza actual=obtenerFigura(ID);
			vectorPosible.add(0,actual);
			return true;
		}





	}

	public void addzulma(zulma a) {
		this.a=a;
		// TODO Auto-generated method stub
		
	}
}
