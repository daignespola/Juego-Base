package principal.entes.enemigos;

public class Lobo extends Enemigo {
int ataquesRecibidos;
	
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return 10 + ataquesRecibidos;
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= calcularPuntosDeAtaque();
	}

	@Override
	public void serAtacado(int dano) {
		super.serAtacado(dano);
		this.ataquesRecibidos++;
	}
}
