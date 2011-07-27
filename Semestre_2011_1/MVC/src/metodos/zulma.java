package metodos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import corotos.pieza;
import corotos.valor;

public class zulma extends JPanel{
	JTextArea t_area ;
	public zulma() {
		super(new FlowLayout());
		t_area = new JTextArea("  . . . . . Creando \n",10,80); 
		setOpaque(true);
		setBackground(Color.BLUE);
        add(new JLabel("Accion realizada:  ",10));
        add(t_area);

	}
	
	
	public void cuadro_informacion ( Vector<pieza> p){
        //Acciones
		int xx = 0;
		
        if(p.elementAt(0).getIdentificador()== valor.tipoPieza.COMPILADOR){

        	cuadro_informacion_compilador(p, 0);
        	
        	if(p.elementAt(1).getIdentificador()== valor.tipoPieza.COMPILADOR){
            	
            	cuadro_informacion_compilador(p, 1);
            	
            	if(p.elementAt(2).getIdentificador()== valor.tipoPieza.MAQUINA){
            		cuadro_informacion_maquina(p, 2);
            		if(p.elementAt(3).getIdentificador()== valor.tipoPieza.COMPILADOR){
                		cuadro_informacion_compilador(p, 3);
                	}
            		
            	}
            }
        	else if (p.elementAt(1).getIdentificador()== valor.tipoPieza.INTERPRETE){
        		cuadro_informacion_interprete (p, 1);
        		xx = 2;
        		while(p.elementAt(xx).getIdentificador()== valor.tipoPieza.INTERPRETE){
        			cuadro_informacion_interprete (p, xx);
        			xx = xx + 1;
        		}
        		if(p.elementAt(xx).getIdentificador()== valor.tipoPieza.COMPILADOR){
                	
                	cuadro_informacion_compilador(p, xx);
        		}
        	}
        	
        }
        else if(p.elementAt(0).getIdentificador()== valor.tipoPieza.PROGRAMA){
        	cuadro_informacion_compilador(p,0);
        	if(p.elementAt(1).getIdentificador()== valor.tipoPieza.COMPILADOR){
            	
            	cuadro_informacion_compilador(p,1);
            	
            	if(p.elementAt(2).getIdentificador()== valor.tipoPieza.MAQUINA){
            		cuadro_informacion_maquina(p, 2);
            		if(p.elementAt(3).getIdentificador()== valor.tipoPieza.PROGRAMA){
                		cuadro_informacion_programa(p, 3);
                	}
            	}
            }
        	else if (p.elementAt(1).getIdentificador()== valor.tipoPieza.INTERPRETE){
        		cuadro_informacion_interprete (p, 1);
        		xx = 2;
        		while(p.elementAt(xx).getIdentificador()== valor.tipoPieza.INTERPRETE){
        			
        			cuadro_informacion_interprete (p, xx);
        			xx = xx + 1;
        		}
        		
        		if(p.elementAt(xx).getIdentificador()== valor.tipoPieza.MAQUINA){
        			cuadro_informacion_maquina(p, xx);
        		}
        	}
        	

        }
        
        
	}
	public void cuadro_informacion_compilador (Vector<pieza> p,int i){
		
		t_area.setText(
    			t_area.getText()+
    			" Se tiene un compilador de: "+
    					p.elementAt(i).getCuadrados().elementAt(1).getNombre()+
    					" , a: "+p.elementAt(i).getCuadrados().elementAt(2).getNombre()+
    					", escrito en: "+
    					p.elementAt(i).getCuadrados().elementAt(3).getNombre()+" ("+(i+1)+") ");
    	
		
	}
	
	public void cuadro_informacion_maquina (Vector<pieza> p, int i){
		
		t_area.setText(
    			t_area.getText()+
    			" ejecutado en la Maquina: "+
    					p.elementAt(i).getCuadrados().elementAt(0).getNombre()+"\n");
	}
	public void cuadro_informacion_interprete (Vector<pieza> p, int i){
		
		t_area.setText(
    			t_area.getText()+
    			" con un interprete de: "+
    					p.elementAt(i).getCuadrados().elementAt(0).getNombre()+
    					", para: "+p.elementAt(i).getCuadrados().elementAt(1).getNombre());
	}
	
	public void cuadro_informacion_programa (Vector<pieza> p, int i){
		
		t_area.setText(
    			t_area.getText()+
    			" El programa: "+
    					p.elementAt(i).getCuadrados().elementAt(0).getNombre()+
    					", escrito en el lenguaje: "+p.elementAt(i).getCuadrados().elementAt(1).getNombre());
	}

}
