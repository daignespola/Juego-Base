package principal.entes.personajes;

public class Ladron extends Especialidad{
	
	protected int evasion=5;
	protected int da�oCritico=0;
	private int anularDefensa=0;
	
	public Ladron(){
		
		this.energia=-3;
		this.salud=3;
		this.agilidad=3;
		
		this.nombre="Ladron";
		
		this.descripcion="\nAgilidad y riesgo son ambos excelentes rasgos para el ladron, y su confluencia puede crear espectaculares proezas de acrobacia."
				+ "\nCuando pilla a su oponente en un momento en que sea incapaz de defenderse eficazmente de su ataque, el ladron puede alcanzar un punto vital para infligir mayor da�o."
				+ "\nAdemas, el ladron puede echar a rodar para apartarse de un golpe mortal y hacer que �ste le inflija menor da�o";
	}
	
	public void da�oCritico(int anularDefensa){
		
		this.da�oCritico=20;
		this.anularDefensa=anularDefensa;
	}
	
	public void salirDa�oCritico(){
		
		this.da�oCritico=0;
	}
	
	@Override
	public int calcularPuntosDeAtaque() {
		
		int aux = ((int)(Math.random()*da�oCritico));
		
		System.out.println("\nEl da�o critico es de: " + aux);
		
		return (15 + aux);
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		
		if(this.da�oCritico == 0)
			return (-6 + ((int)(Math.random()*evasion))); //la idea es que evasion se incremente con cada subida de nivel//
		else
			return (-this.anularDefensa); //le deja la defensa en cero por estar en modo da�oCritico//
	}
	
}
