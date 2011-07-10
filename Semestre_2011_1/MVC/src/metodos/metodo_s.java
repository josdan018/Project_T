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
				
	/*	String seleccion = JOptionPane.showInputDialog(
				ventana,
				"Seleccione opcion",
				"Selector de opciones",
				JOptionPane.QUESTION_MESSAGE,
				null, 
				new Object[] { "opcion 1", "opcion 2", "opcion 3" },
				"opcion 1");	*/	
	}

}
