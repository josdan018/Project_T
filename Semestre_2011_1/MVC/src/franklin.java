import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelo.Modelo;
import vista.Vista;

public class franklin extends JPanel{
	
	Modelo modelo;
	basededatos bd= new basededatos();
	JTextField archivo = new JTextField("Ingrese nombre de archivo");
	JButton guardar = new JButton("Guardar");
	JButton cargar = new JButton("Cargar");
	JButton eliminar = new JButton("Eliminar");
	JTextArea area = new JTextArea("Area de texto\n");
	Vista centro;
	
	public franklin(final Modelo m,Vista centro){
		
		this.centro=centro;
	modelo=m;
	this.setBackground(Color.YELLOW);
	this.add(archivo);
	this.add(guardar);
	this.add(cargar);
	this.add(eliminar);
	area.setText(bd.accessDb4o(modelo));
	this.add(area);
	this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	guardar.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton()==1){
				accion(1,m);
			}
		}	
		});
	cargar.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton()==1){
				accion(2,m);
				franklin.this.centro.repaint();
			}
		}	
		});
	eliminar.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton()==1){
				accion(3,m);					
			}
		}	
		});
	}
	
	public void accion(int i, Modelo m){
		m=bd.accessDb4o(modelo, i,archivo.getText());
		area.setText(bd.accessDb4o(modelo));
	}
}
