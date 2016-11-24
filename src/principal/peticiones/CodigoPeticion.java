package principal.peticiones;

public class CodigoPeticion {
		public static final int CONEXION_CON_SERVIDOR = 1000;

		
		public static final int LOGEO = 1;
		public static final int LOGEO_INCORRECTO = 10;
		public static final int LOGEO_CORRECTO = 11;

		
		public static final int REGISTRO = 2;	
		public static final int REGISTRO_CORRECTO = 21;
		public static final int REGISTRO_INCORRECTO_USER_YA_EXISTE = 200;
		public static final int REGISTRO_INCORRECTO = 201;
		
		
		public static final int PONER_EN_MAPA_JUGADOR = 3;
		public static final int PONER_EN_MAPA_JUGADOR_CORRECTO = 31;
		public static final int PONER_EN_MAPA_JUGADOR_INCORRECTO = 30;
		
		
		public static final int AGREGAR_JUGADOR = 4;
		public static final int AGREGAR_JUGADOR_CORRECTO = 41;
		public static final int AGREGAR_JUGADOR_INCORRECTO = 40;
		
		public static final int REGISTRO_PERSONAJE = 5;	
		public static final int REGISTRO_PERSONAJE_CORRECTO = 51;
		public static final int REGISTRO_PERSONAJE_INCORRECTO_YA_EXISTE = 500;
		public static final int REGISTRO_PERSONAJE_INCORRECTO = 501;				
		
		public static final int LISTAR_RAZAS = 9;
		public static final int LISTADO_CORRECTO = 91;
		public static final int LISTADO_INCORRECTO = 90;
}
