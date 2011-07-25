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

import metodos.metodo_s;
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
			JPanel c=new JPanel(),d=new JPanel();
			
<<<<<<< HEAD
			metodo_s b=new metodo_s(frame);
			
			/*b.setOpaque(true);
			b.setBa
			
			
			
			
			
			ckground(Color.GREEN);
=======
			JPanel a=new JPanel();
			JTextArea t_area = new JTextArea("  . . . . . Creando \n",10,80); 
			a.setOpaque(true);
			a.setBackground(Color.BLUE);
			a = new JPanel(new FlowLayout());
	        a.add(new JLabel("Acción Realizada:  ",10));
			
			b.setOpaque(true);
			b.setBackground(Color.GREEN);
>>>>>>> 0851eef423e046aa8f371a2b1fa29018b021f041
			b.add(new JButton("Listo"));
			b.add(new JLabel("Pon texto"));
	        b.add(new JTextField(25));
	        b.add(new JButton("Listo"));*/
			
			c.setOpaque(true);
			c.setBackground(Color.YELLOW);
			
			d.setOpaque(true);
			d.setBackground(Color.RED);
			
<<<<<<< HEAD
			//cuadro_informacion(guiobjects, p);
=======
			
>>>>>>> 0851eef423e046aa8f371a2b1fa29018b021f041
			
			final Controlador controlador = new Controlador(modelo,vista);
			vista.controlador=controlador; //Lo registro para su uso, deberia ser un metodo pero por simplificacion
			JScrollPane ModelScroll = new JScrollPane(controlador.getVista(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			guiobjects.add(ModelScroll,BorderLayout.CENTER);
		
			//cuadro_informacion(p, t_area);
			
			a.add(t_area);
			
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
	
	public static void cuadro_informacion ( Vector<pieza> p, JTextArea t_area){
        //Acciones
		int xx = 0;
		
        if(p.elementAt(0).getIdentificador()== tipoPieza.COMPILADOR){
        	
<<<<<<< HEAD
        	t_area.setText(t_area.getText()+" Se tiene un compilador de: "+p.elementAt(0)+" , a: +, ");
=======
        	cuadro_informacion_compilador(p, t_area, 0);
        	
        	if(p.elementAt(1).getIdentificador()== tipoPieza.COMPILADOR){
            	
            	cuadro_informacion_compilador(p, t_area, 1);
            	
            	if(p.elementAt(2).getIdentificador()== tipoPieza.MAQUINA){
            		cuadro_informacion_maquina(p, t_area, 2);
            	}
            }
        	else if (p.elementAt(1).getIdentificador()== tipoPieza.INTERPRETE){
        		cuadro_informacion_interprete (p, t_area, 1);
        		xx = 2;
        		while(p.elementAt(xx).getIdentificador()== tipoPieza.INTERPRETE){
        			cuadro_informacion_interprete (p, t_area, xx);
        			xx = xx + 1;
        		}
        		if(p.elementAt(xx).getIdentificador()== tipoPieza.COMPILADOR){
                	
                	cuadro_informacion_compilador(p, t_area, xx);
        		}
        	}
        	
        }
        else if(p.elementAt(0).getIdentificador()== tipoPieza.PROGRAMA){
        	cuadro_informacion_compilador(p, t_area,0);
        	if(p.elementAt(1).getIdentificador()== tipoPieza.COMPILADOR){
            	
            	cuadro_informacion_compilador(p, t_area,1);
            	
            	if(p.elementAt(2).getIdentificador()== tipoPieza.MAQUINA){
            		cuadro_informacion_maquina(p, t_area, 2);
            	}
            }
        	else if (p.elementAt(1).getIdentificador()== tipoPieza.INTERPRETE){
        		cuadro_informacion_interprete (p, t_area, 1);
        		xx = 2;
        		while(p.elementAt(xx).getIdentificador()== tipoPieza.INTERPRETE){
        			
        			cuadro_informacion_interprete (p, t_area, xx);
        			xx = xx + 1;
        		}
        		
        		if(p.elementAt(xx).getIdentificador()== tipoPieza.MAQUINA){
        			cuadro_informacion_maquina(p, t_area, xx);
        		}
        	}
        	
>>>>>>> 0851eef423e046aa8f371a2b1fa29018b021f041
        }
        
        
	}
	public static void cuadro_informacion_compilador (Vector<pieza> p, JTextArea t_area, int i){
		
		t_area.setText(
    			t_area.getText()+
    			" A partir de un compilador de: "+
    					p.elementAt(i).getCuadrados().elementAt(1).getNombre()+
    					" , a:"+p.elementAt(i).getCuadrados().elementAt(2).getNombre()+
    					", escrito en: "+
    					p.elementAt(i).getCuadrados().elementAt(3).getNombre());
    	
		
	}
	
	public static void cuadro_informacion_maquina (Vector<pieza> p, JTextArea t_area, int i){
		
		t_area.setText(
    			t_area.getText()+
    			" Ejecutado en la Maquina: "+
    					p.elementAt(i).getCuadrados().elementAt(0).getNombre());
	}
	public static void cuadro_informacion_interprete (Vector<pieza> p, JTextArea t_area, int i){
		
		t_area.setText(
    			t_area.getText()+
    			" Interprete de: "+
    					p.elementAt(i).getCuadrados().elementAt(0).getNombre()+
    					", para: "+p.elementAt(i).getCuadrados().elementAt(1).getNombre());
	}
	
	public static void cuadro_informacion_programa (Vector<pieza> p, JTextArea t_area, int i){
		
		t_area.setText(
    			t_area.getText()+
    			" El programa: "+
    					p.elementAt(i).getCuadrados().elementAt(0).getNombre()+
    					", Escrito en el lenguaje: "+p.elementAt(i).getCuadrados().elementAt(1).getNombre());
	}
	
	

}
