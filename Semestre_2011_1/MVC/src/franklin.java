import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import modelo.Modelo;

public class franklin extends JFrame {
	
	Modelo modelo;
	JTextField archivo = new JTextField("Ingrese nombre de archivo");
	JButton guardar = new JButton("Guardar");
	JButton cargar = new JButton("Cargar");
	JButton eliminar = new JButton("Eliminar");
	JTextArea area = new JTextArea("Area de texto\n"); 
	
	public franklin(Modelo m){
	modelo=m;
	basededatos bd= new basededatos();
	this.setBackground(Color.YELLOW);
	this.add(archivo);
	this.add(guardar);
	this.add(cargar);
	this.add(eliminar);
	this.add(area);
	//aqui seria el metodo listar para llenar el text area
	guardar.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton()==1){
				accion(1);
			}
		}	
		});
	cargar.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton()==1){
				accion(2);
			}
		}	
		});
	eliminar.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton()==1){
				accion(3);					
			}
		}	
		});
	}
	
	public void accion(int i){
		if(i==1){
		//	basededatos.accesdb4o(modelo,i);
		}
		else if(i==2){
		//	basededatos.accesdb4o(modelo,i);
		}
		else{
		//	basededatos.borrar(modelo,i);
		}
		
	}
	
}
