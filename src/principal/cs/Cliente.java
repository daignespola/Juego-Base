package principal.cs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


import java.net.UnknownHostException;

import principal.peticiones.*;


public class Cliente{
	
	private Socket s;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private static String respuestaServer;
	private boolean estaConectado = false;
	private String nombreUsuario;

	
	
	public Cliente(String host){	
		try {
			s = new Socket(host, Server.PUERTO_POR_DEFECTO);
		} catch (UnknownHostException e) {
			System.out.println("Unknown host exception creando socket del lado cliente.");
		} catch (IOException e) {
			System.out.println("IOException creando socket del lado cliente");
		}
		try {
			ois = new ObjectInputStream(s.getInputStream());
		} catch (IOException e) {
			System.out.println("IOException creando OIS en el cliente");
		}
		try {
			oos = new ObjectOutputStream(s.getOutputStream());
		} catch (IOException e) {
			System.out.println("IOException creando OOS en el cliente");
		}
		estaConectado = true;
	}
	
	public boolean isEstaConectado() {
		return estaConectado;
	}

	public String getNombre() {
		return this.nombreUsuario;
	}	
	

	public int loguearse(PeticionLogueo petLog) {
		try {
			oos.writeObject(new Mensaje(CodigoPeticion.LOGEO,petLog));		//manda mje de login
			oos.flush();
		} catch (IOException e1) {
			System.out.println("Error en el login al enviar petición por IOException");
		}
		try {
			Mensaje respuestaSv = (Mensaje) ois.readObject();
			return respuestaSv.getCodigo();
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el login al recibir respuesta por ClassNotFound");
		} catch (IOException e) {
			System.out.println("Error en el login al recibir respuesta por IOException");
		}
		return CodigoPeticion.LOGEO_INCORRECTO;
	}
	
	public int registrarse(PeticionRegistro petReg) {
		try {
			oos.writeObject(new Mensaje(CodigoPeticion.REGISTRO,petReg));
			oos.flush();
		} catch (Exception e) {
			System.out.println("Error en el registro al enviar petición por IOException");
		}
		try {
			Mensaje respuestaSv = (Mensaje) ois.readObject();
			return respuestaSv.getCodigo();
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el registro al recibir respuesta por ClassNotFound");
		} catch (IOException e) {
			System.out.println("Error en el login al recibir respuesta por IOException");
		}
		return CodigoPeticion.REGISTRO_INCORRECTO;
	}
	
	public int crearPersonaje(PeticionCrearPersonaje petCrearPersonaje) {
		try {
			oos.writeObject(new Mensaje(CodigoPeticion.REGISTRO_PERSONAJE,petCrearPersonaje));
			oos.flush();
		} catch (Exception e) {
			System.out.println("Error en el registro al enviar petición por IOException");
		}
		try {
			Mensaje respuestaSv = (Mensaje) ois.readObject();
			return respuestaSv.getCodigo();
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el registro al recibir respuesta por ClassNotFound");
		} catch (IOException e) {
			System.out.println("Error en el login al recibir respuesta por IOException");
		}
		return CodigoPeticion.REGISTRO_PERSONAJE_INCORRECTO;
	}
	
	public Object listarRazas() {
		try {
			System.out.println("DAIANA");
			oos.writeObject(new Mensaje(CodigoPeticion.LISTAR_RAZAS,null));
			oos.flush();
		} catch (Exception e) {
			System.out.println("Error en el registro al enviar petición por IOException");
		}
		try {
			Mensaje respuestaSv = (Mensaje) ois.readObject();
			return respuestaSv.getObj();
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el registro al recibir respuesta por ClassNotFound");
		} catch (IOException e) {
			System.out.println("Error en el login al recibir respuesta por IOException ListarRazas");
		}
		return CodigoPeticion.LISTADO_INCORRECTO;
	}
	
}
	
