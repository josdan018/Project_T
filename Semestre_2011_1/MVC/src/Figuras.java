import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


import metodos.metodo_s;
import modelo.Modelo;
import vista.Vista;
import controlador.Controlador;
import corotos.pieza;
import corotos.valor;

//import com.db4o.*;

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
			//franklin c= new franklin();
			Vista vista = new Vista(new Dimension(1000,800),modelo);
			JPanel d=new JPanel();
			

			metodo_s b=new metodo_s(frame);
			JPanel a=new JPanel();
			JTextArea t_area = new JTextArea("  . . . . . Creando \n",10,80); 
			a.setOpaque(true);
			a.setBackground(Color.BLUE);
			a = new JPanel(new FlowLayout());
	        a.add(new JLabel("Accion realizada:  ",10));

			d.setOpaque(true);
			d.setBackground(Color.RED);
			
			//cuadro_informacion(guiobjects, p);
			

			
			final Controlador controlador = new Controlador(modelo,vista);
			vista.controlador=controlador; //Lo registro para su uso, deberia ser un metodo pero por simplificacion
			JScrollPane ModelScroll = new JScrollPane(controlador.getVista(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			guiobjects.add(ModelScroll,BorderLayout.CENTER);
		
			guiobjects.add(b,BorderLayout.WEST);
			//guiobjects.add(c,BorderLayout.EAST);
			
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
		
        if(p.elementAt(0).getIdentificador()== valor.tipoPieza.COMPILADOR){
        	

        	t_area.setText(t_area.getText()+" Se tiene un compilador de: "+p.elementAt(0)+" , a: +, ");

        	cuadro_informacion_compilador(p, t_area, 0);
        	
        	if(p.elementAt(1).getIdentificador()== valor.tipoPieza.COMPILADOR){
            	
            	cuadro_informacion_compilador(p, t_area, 1);
            	
            	if(p.elementAt(2).getIdentificador()== valor.tipoPieza.MAQUINA){
            		cuadro_informacion_maquina(p, t_area, 2);
            	}
            }
        	else if (p.elementAt(1).getIdentificador()== valor.tipoPieza.INTERPRETE){
        		cuadro_informacion_interprete (p, t_area, 1);
        		xx = 2;
        		while(p.elementAt(xx).getIdentificador()== valor.tipoPieza.INTERPRETE){
        			cuadro_informacion_interprete (p, t_area, xx);
        			xx = xx + 1;
        		}
        		if(p.elementAt(xx).getIdentificador()== valor.tipoPieza.COMPILADOR){
                	
                	cuadro_informacion_compilador(p, t_area, xx);
        		}
        	}
        	
        }
        else if(p.elementAt(0).getIdentificador()== valor.tipoPieza.PROGRAMA){
        	cuadro_informacion_compilador(p, t_area,0);
        	if(p.elementAt(1).getIdentificador()== valor.tipoPieza.COMPILADOR){
            	
            	cuadro_informacion_compilador(p, t_area,1);
            	
            	if(p.elementAt(2).getIdentificador()== valor.tipoPieza.MAQUINA){
            		cuadro_informacion_maquina(p, t_area, 2);
            	}
            }
        	else if (p.elementAt(1).getIdentificador()== valor.tipoPieza.INTERPRETE){
        		cuadro_informacion_interprete (p, t_area, 1);
        		xx = 2;
        		while(p.elementAt(xx).getIdentificador()== valor.tipoPieza.INTERPRETE){
        			
        			cuadro_informacion_interprete (p, t_area, xx);
        			xx = xx + 1;
        		}
        		
        		if(p.elementAt(xx).getIdentificador()== valor.tipoPieza.MAQUINA){
        			cuadro_informacion_maquina(p, t_area, xx);
        		}
        	}
        	

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
