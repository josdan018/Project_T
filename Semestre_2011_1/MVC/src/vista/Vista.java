package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import modelo.Modelo;
import modelo.Figura;
import javax.swing.JPanel;


import controlador.Controlador;


public class Vista extends JPanel {
	static final long serialVersionUID = 0L;
	private Modelo modelo;
	public Controlador controlador;  //IMPORTANTE DEBE SER REGISTRADO O TODO FALLA
	
	public Vista(Dimension size, Modelo modelo){
		super();
		this.modelo=modelo;
		
		setPreferredSize(size);
		setBackground(Color.white);
		setFocusable(true);

		//Mejorable al 1000% solo por simplificacion realizado de esta forma
		MouseController mouseControl = new MouseController() {
			public void mouseClicked(MouseEvent event) {}
			public void mouseEntered(MouseEvent event) {}
			public void mouseExited(MouseEvent event) {}
			public void mouseMoved( MouseEvent evento )
			   {
			     /*System.out.println( "Se movió en [" + evento.getX() +
			         ", " + evento.getY() + "]" );*/
			   }
			public void mousePressed(MouseEvent event) {
			    eVmousePressed(event);	}
			public void mouseReleased(MouseEvent event) {
				eVmouseReleased(event);	}
			public void mouseDragged(MouseEvent event) {
				eVmouseDragged(event);	}
		};
		this.addMouseListener(mouseControl);
		this.addMouseMotionListener(mouseControl);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		pintarTodo(g2);
	}
	
	private void pintarTodo(Graphics2D g){
		pintar_rejilla(g);
		
		for (Figura elemento : modelo.getListado()) {
			elemento.dibujar(g);
		}
	}
	
	public void pintar_rejilla(Graphics2D g){
		g.setColor(Color.LIGHT_GRAY);
		int tamanio=40;
		int separacion=5;
		int tam_sep=tamanio+separacion;
		
		for(int i=0;i<this.getWidth()/tam_sep;i++){
			g.drawRect(i*tam_sep, 0, 0, this.getHeight());
			g.drawRect(i*tam_sep +separacion, 0, 0, this.getHeight());
		}
		
		for(int i=0;i<this.getHeight()/tam_sep;i++){
			g.drawRect(0,i*tam_sep,  this.getWidth(),0 );
			g.drawRect(0, i*tam_sep + separacion, this.getWidth(), 0);
		}
	}

	public void eVmousePressed(MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmousePressed(ev);
		}
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmouseDragged(ev);
		}
	}
	
	public void eVmouseReleased (MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmouseReleased(ev);
		}
	}
	
}


/**************************************************
* SOLO para ahorrar espacio y simplificar cosas
**************************************************/
class MouseController implements MouseListener, MouseMotionListener {
	public void mouseClicked(MouseEvent event) {}
	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}
	public void mousePressed(MouseEvent event) {}
	public void mouseReleased(MouseEvent event) {}
	public void mouseDragged(MouseEvent event) {}
	public void mouseMoved(MouseEvent event) {}
}
