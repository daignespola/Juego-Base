package principal.peticiones;

import principal.cs.ServerThread;

public class PeticionCrearPersonaje {//////////////FALTA IMPLEMENTARLA COMO PeticionLogueo/////////////////////
		private String id_usuario;
		private String nombre;
		private String raza;
		private String casta;
		private char sexo;
		
		private String respuesta;
		
		
		public PeticionCrearPersonaje(String id_usuario, String nombre, String raza, String casta, char sexo) {
			this.id_usuario = id_usuario;
			this.nombre = nombre;
			this.raza = raza;
			this.casta = casta;
			this.sexo = sexo;
		}


		public String getRespuesta() {
			return respuesta;
		}


		public String getId_usuario() {
			return id_usuario;
		}


		public String getNombre() {
			return nombre;
		}


		public String getRaza() {
			return raza;
		}


		public String getCasta() {
			return casta;
		}


		public char getSexo() {
			return sexo;
		}
		
		
	}
