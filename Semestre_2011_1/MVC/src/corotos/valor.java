package corotos;

import java.awt.Color;


public interface valor {
	public enum tipoPieza{
		COMPILADOR,
		PROGRAMA,
		MAQUINA,
		INTERPRETE
	}
	
	public enum tipoEnlace{
		SOLIDO,
		OCIOSO,
		CORRECTO,
		INCORRECTO,
		TRIANGULAR
	}
	
	public enum orientacionEnlace{
		HORIZONTAL,
		VERTICAL
	}
	
	public enum lados{
		DERECHA,
		IZQUIERDA,
		ARRIBA,
		ABAJO
	}
	
	
	
	static public int G=40;
	static public int P=8;
	
	public Color colorSolido=new Color(0F, 0F, 1F, 0F);
	public Color colorOcioso=new Color(0.1F, 0.1F, 0.1F, 0.1F);
	public Color colorCorrecto=new Color(0F, 1F, 0F, 0F);
	public Color colorIncorrecto=new Color(1F, 0F, 0F, 0F);
}
