package metodos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import corotos.pieza;
import corotos.valor;


public class metodo_s extends JPanel {
	
	JButton agregar_piezas= new JButton();
	JFrame ventana;
	Vector<String> lenguajes;
	int im = 0;
 	
	
	public metodo_s(JFrame ventana){
		
		
		setOpaque(true);
		setBackground(Color.RED);
		setPreferredSize(new Dimension(200,1000));
		//setBounds(0, 0, 400,1000);
		//ssContainer guiobjects = this.getRootPane();
		this.ventana=ventana;
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

		agregar_piezas.setText("   Agregar   ");
		//agregar_piezas.setAlignmentX(CENTER_ALIGNMENT);
		//agregar_piezas.setBounds(0, 0, 110, 1000);
				
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
			
			pieza imag1= new pieza(0,new Rectangle(valor.G+20,0,0,0),valor.tipoPieza.COMPILADOR,lenguajes);
			im = im + 1;
			dibujo(imag1);
			
		}else if(seleccion.equals("INTERPRETE")){
			lenguajes=new Vector<String>(1, 1);
			
			lenguajes.add(componentes("Lenguaje conector"));
			lenguajes.add(componentes("Lenguaje a interpretar"));

			pieza imag1= new pieza(0,new Rectangle(valor.G+20,0,0,0),valor.tipoPieza.INTERPRETE,lenguajes);
			im = im + 1;
			dibujo(imag1);
						
		}else if(seleccion.equals("MAQUINA")){
			lenguajes=new Vector<String>(1, 1);
			
			lenguajes.add(componentes("Lenguaje de la Maquina"));

			pieza imag1= new pieza(0,new Rectangle(valor.G+20,0,0,0),valor.tipoPieza.MAQUINA,lenguajes);					
			im = im + 1;
			dibujo(imag1);
			
		}else if(seleccion.equals("PROGRAMA")){
			lenguajes=new Vector<String>(1, 1);
			
			lenguajes.add(componentes("Nombre del Programa"));
			lenguajes.add(componentes("Lenguaje del Programa"));

			pieza imag1= new pieza(0,new Rectangle(valor.G+20,0,0,0),valor.tipoPieza.PROGRAMA,lenguajes);			
			im = im + 1;
			dibujo(imag1);
		}		
	}
	
	public void dibujo(final pieza imag1){
		JLabel imagen= new JLabel(){

			@Override			
			public void paint(Graphics g) {
				imag1.dibujar(g);
			}
		};
		
		imagen.setOpaque(true);
		imagen.setBackground(Color.black);
		System.out.println("cantidad en el vector: "+ im);
		imagen.setBounds(0,(90 * im), 1000, 1000);
		imagen.setLayout(null);
		imagen.setVisible(true);
		
		
		this.add(imagen);
		//imagen.repaint();
		//System.out.println("hizo algoooooooo");
		
	}
	public String componentes(String lenguaje){
		String len = JOptionPane.showInputDialog(
				  ventana,
				  lenguaje,null);
		return len;
	}

}
