package metodos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import corotos.cuadrada;
import corotos.pieza;
import corotos.valor;

public class metodo_s extends JPanel {
	
	JButton agregar_piezas= new JButton();
	JFrame ventana;
	Vector<String> lenguajes;
	
	
	public metodo_s(JFrame ventana){
		
		this.setOpaque(true);
		this.setBackground(Color.GREEN);
		
		this.ventana=ventana;
		
		agregar_piezas.setText("Agregar");
		
		agregar_piezas.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana_emergente();								
			}
		});
		
		this.add(agregar_piezas);		
	}
	
	public void ventana_emergente(){
		
				
		Object seleccion = JOptionPane.showInputDialog(
				ventana,
				"Seleccione un tipo de Componente",
				"Componentes",
				JOptionPane.QUESTION_MESSAGE,
				null, 
				new Object[] { "COMPILADOR", "INTERPRETE", "MAQUINA","PROGRAMA"},
				"COMPILADOR");	
		if(seleccion.equals("COMPILADOR")){
			lenguajes=new Vector<String>(1, 1);
			
			lenguajes.add(componentes("Lenguaje Fuente"));
			lenguajes.add(componentes("Lenguaje Objeto"));
			lenguajes.add(componentes("Implementacion"));
			
			pieza imag1= new pieza(0,new Rectangle(0,0,0,0),valor.tipoPieza.COMPILADOR,lenguajes);			
			dibujo();
			
		}else if(seleccion.equals("INTERPRETE")){
			lenguajes=new Vector<String>(1, 1);
			
			lenguajes.add(componentes("Lenguaje conector"));
			lenguajes.add(componentes("Lenguaje a interpretar"));

			pieza imag1= new pieza(0,new Rectangle(0,0,0,0),valor.tipoPieza.INTERPRETE,lenguajes);			
			dibujo();
						
		}else if(seleccion.equals("MAQUINA")){
			lenguajes=new Vector<String>(1, 1);
			
			lenguajes.add(componentes("Lenguaje de la Maquina"));

			pieza imag1= new pieza(0,new Rectangle(0,0,0,0),valor.tipoPieza.MAQUINA,lenguajes);			
			dibujo();
			
		}else if(seleccion.equals("PROGRAMA")){
			lenguajes=new Vector<String>(1, 1);
			
			lenguajes.add(componentes("Nombre del Programa"));
			lenguajes.add(componentes("Lenguaje del Programa"));

			pieza imag1= new pieza(0,new Rectangle(0,0,0,0),valor.tipoPieza.PROGRAMA,lenguajes);			
			dibujo();
		}		
	}
	
	public void dibujo(){
		JLabel imagen= new JLabel(){
			pieza imag;
			@Override			
			public void paint(Graphics g) {
				imag.dibujar(g);
			}
		};
	}
	public String componentes(String lenguaje){
		String len = JOptionPane.showInputDialog(
				  ventana,
				  lenguaje,null);
		return len;
	}

}
