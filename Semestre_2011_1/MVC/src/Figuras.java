import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

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



public class Figuras {
	
	public static void main(String[] args) {
		try{
			final JFrame frame = new JFrame();
			frame.setTitle("Ejemplo Modelo Vista Controlador (MVC) Compíladores e Interpretes UNET");
			//Set the window initial Size & default close operation
			frame.setVisible(true);
			Dimension fullscreen = Toolkit.getDefaultToolkit().getScreenSize();
			fullscreen.width=fullscreen.width-400;
			fullscreen.height=fullscreen.height-400;
			frame.setBounds(50,50,fullscreen.width,fullscreen.height);
			frame.getContentPane().setPreferredSize(fullscreen);
			frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		    Container guiobjects = frame.getContentPane();
		    guiobjects.setLayout(new BorderLayout());
			Modelo modelo = new Modelo();
			
			Vista vista = new Vista(new Dimension(1000,800),modelo);
			JPanel a=new JPanel(),b=new JPanel(),c=new JPanel(),d=new JPanel();
			a.setOpaque(true);
			a.setBackground(Color.BLUE);
			a = new JPanel(new FlowLayout());
	        //a.setBackground(Color.yellow);
	        a.add(new JLabel("Acción Realizada"));
	        a.add(new JTextArea("hola", 10, 100));
			
			b.setOpaque(true);
			b.setBackground(Color.GREEN);
			b.add(new JButton("Listo"));
			b.add(new JLabel("Pon texto"));
	        b.add(new JTextField(25));
	        b.add(new JButton("Listo"));
			
			c.setOpaque(true);
			c.setBackground(Color.YELLOW);
			
			d.setOpaque(true);
			d.setBackground(Color.RED);
			
			
			
			final Controlador controlador = new Controlador(modelo,vista);
			vista.controlador=controlador; //Lo registro para su uso, deberia ser un metodo pero por simplificacion
			JScrollPane ModelScroll = new JScrollPane(controlador.getVista(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			guiobjects.add(ModelScroll,BorderLayout.CENTER);
			guiobjects.add(a,BorderLayout.SOUTH);
			guiobjects.add(b,BorderLayout.WEST);
			guiobjects.add(c,BorderLayout.EAST);
			
			/*ModelScroll.repaint();
			 * v.getContentPane().setLayout(new BorderLayout()); 
			v.getContentPane().add(scroll,BorderLayout.CENTER);
			v.getContentPane().add(panelSuperior,BorderLayout.NORTH);
			v.getContentPane().add(panelInferior,BorderLayout.SOUTH);
			v.getContentPane().add(panelIzquierdo,BorderLayout.WEST);
			v.getContentPane().add(panelDerecho,BorderLayout.EAST);
			 */
			frame.repaint();//*/
			frame.pack();
		}catch (RuntimeException e){
			exitApplication();
		}

	}


	public static void exitApplication() {
		   System.out.println("Saliendo Adios...");
		   System.exit(0);
        }

}
