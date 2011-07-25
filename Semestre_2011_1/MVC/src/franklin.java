import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import modelo.Modelo;
import vista.Vista;
import controlador.Controlador;
import com.db4o.*;

public class franklin extends JFrame {

	basededatos bd= new basededatos();
	JTextField archivo = new JTextField("te quiero");
	JButton guardar = new JButton("Guardar");
	JButton cargar = new JButton("Cargar");
	JButton eliminar = new JButton("Eliminar");
	JTextArea area = new JTextArea("Ingrese aqui nombre de archivo\n"); 
	
	public franklin(){
	this.setBackground(Color.YELLOW);
	this.add(archivo);
	this.add(guardar);
	this.add(cargar);
	this.add(eliminar);
	//this.add(area);
	guardar.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton()==1){
				explorer(1);
			}
		}	
		});
	cargar.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton()==1){
				explorer(2);
			}
		}	
		});
	eliminar.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton()==1){
				explorer(3);					
			}
		}	
		});
	}
	
	public void explorer(int i){
		if(i==1){
			//basededatos.guardar(objeto);
		}
		else if(i==2){
			//basededatos.cargar(objeto);
		}
		else{
			//basededatos.borrar(objeto);
		}
		
	}
	
}
