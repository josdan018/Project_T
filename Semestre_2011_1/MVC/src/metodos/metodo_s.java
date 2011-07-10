package metodos;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class metodo_s extends JPanel {
	
	JButton agregar_piezas= new JButton();
	JFrame ventana;
	
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
				new Object[] { "Compilador", "Interprete", "Maquina","Programa"},
				"Compilador");	
		if(seleccion.equals("Compilador")){
			String []lenguajes=new String[3];
			
			lenguajes[0]=componentes("Lenguaje Fuente");
			lenguajes[1]=componentes("Lenguaje Objeto");
			lenguajes[2]=componentes("Implementacion");			
		}else if(seleccion.equals("Interprete")){
			String []lenguajes=new String[3];
			
			lenguajes[0]=componentes("Lenguaje conector");
			lenguajes[1]=componentes("Lenguaje a interpretar");
			lenguajes[2]=null;			
		}else if(seleccion.equals("Maquina")){
			String []lenguajes=new String[3];
			
			lenguajes[0]=componentes("Lenguaje de la Maquina");
			lenguajes[1]=null;
			lenguajes[2]=null;
		}else if(seleccion.equals("Programa")){
			String []lenguajes=new String[3];
			
			lenguajes[0]=componentes("Nombre del Programa");
			lenguajes[1]=componentes("Lenguaje del Programa");
			lenguajes[2]=null;
		}
		
	}
	public String componentes(String lenguaje){
		String len = JOptionPane.showInputDialog(
				  ventana,
				  lenguaje,null);
		return len;
	}

}
