import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.Vector;

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
import corotos.*;
import corotos.valor.tipoPieza;


public class Figuras {
	
	public static void main(String[] args) {
		Vector <pieza> p = new Vector<pieza>() ;
		valor v;

		try{
			final JFrame frame = new JFrame();
			frame.setTitle("Ejemplo Modelo Vista Controlador (MVC) Comp�ladores e Interpretes UNET");
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
			JPanel b=new JPanel(),c=new JPanel(),d=new JPanel();
			
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
			
			//cuadro_informacion(guiobjects, p);
			
			final Controlador controlador = new Controlador(modelo,vista);
			vista.controlador=controlador; //Lo registro para su uso, deberia ser un metodo pero por simplificacion
			JScrollPane ModelScroll = new JScrollPane(controlador.getVista(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			guiobjects.add(ModelScroll,BorderLayout.CENTER);
			
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
	
	public static void cuadro_informacion (Container guiobjects, Vector<pieza> p){
		
		
		JPanel a=new JPanel();
		JTextArea t_area = new JTextArea("  . . . . . Creando Compilador \n",10,80); 
		a.setOpaque(true);
		a.setBackground(Color.BLUE);
		a = new JPanel(new FlowLayout());
        a.add(new JLabel("Acci�n Realizada:  ",10));
        
        //Acciones
        
        if(p.elementAt(0).getIdentificador()== tipoPieza.COMPILADOR){
        	
        	t_area.setText(
        			t_area.getText()+
        			" A partir de un compilador de: "+
        					p.elementAt(0).getCuadrados().elementAt(1).getNombre()+
        					" , a:"+p.elementAt(0).getCuadrados().elementAt(2).getNombre()+
        					", escrito en: "+
        					p.elementAt(0).getCuadrados().elementAt(3).getNombre());
        	
        	if(p.elementAt(1).getIdentificador()== tipoPieza.COMPILADOR){
            	
            	t_area.setText(
            			t_area.getText()+
            			" A partir de un compilador de: "+
            					p.elementAt(1).getCuadrados().elementAt(1).getNombre()+
            					" , a:"+p.elementAt(1).getCuadrados().elementAt(2).getNombre()+
            					", escrito en: "+
            					p.elementAt(1).getCuadrados().elementAt(3).getNombre());
            	
            		if(p.elementAt(2).getIdentificador()== tipoPieza.COMPILADOR){
                	
                	t_area.setText(
                			t_area.getText()+
                			" A partir de un compilador de: "+
                					p.elementAt(2).getCuadrados().elementAt(1).getNombre()+
                					" , a:"+p.elementAt(2).getCuadrados().elementAt(2).getNombre()+
                					", escrito en: "+
                					p.elementAt(2).getCuadrados().elementAt(3).getNombre());
            		}
            }
        }
        
        a.add(t_area);
	
        guiobjects.add(a,BorderLayout.SOUTH);
	}

}
