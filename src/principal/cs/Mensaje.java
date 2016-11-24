package principal.cs;

import java.io.Serializable;

public class Mensaje implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private Object obj;
	
	public Mensaje(int c, Object o){
		this.codigo = c;
		this.obj = o;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
	public Object getObj(){
		return this.obj;
	}
	
}
