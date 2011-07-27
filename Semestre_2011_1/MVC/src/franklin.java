import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import modelo.Modelo;

public class franklin extends JPanel{
	
	Modelo modelo;
	basededatos bd= new basededatos();
	JTextField archivo = new JTextField("Ingrese nombre de archivo");
	JButton guardar = new JButton("Guardar");
	JButton cargar = new JButton("Cargar");
	JButton eliminar = new JButton("Eliminar");
	JTextArea area = new JTextArea("Area de texto\n"); 
	
	public franklin(final Modelo m){
		
	modelo=m;
	this.setBackground(Color.YELLOW);
	this.add(archivo);
	this.add(guardar);
	this.add(cargar);
	this.add(eliminar);
	area.setText(bd.accessDb4o(modelo));
	this.add(area);
	//aqui seria el metodo listar para llenar el text area
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
