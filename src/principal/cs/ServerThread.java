package principal.cs;		
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import principal.peticiones.*;

public class ServerThread extends Thread{
	private Socket s;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Server sv;	

	public ServerThread(Socket s, Server sv) {
		super();
		this.sv = sv;
		this.s = s;
		try {
			this.oos = new ObjectOutputStream(s.getOutputStream());
		} catch (Exception e) {
			System.out.println("Problema generando el OOS");
		}
		try {
			this.ois = new ObjectInputStream(s.getInputStream());
		} catch (Exception e) {
			System.out.println("Problema generando el OIS");
		}
	}

	@Override
	public void run() {
		while(true){
			Mensaje mjeIn = null;
			try {
				mjeIn = (Mensaje) ois.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("El thread del sv no encontró la clase Mensaje al hacer readObject");
			} catch (IOException e) {
				System.out.println("IOException en el thread del server al recibir un mensaje");
				e.printStackTrace();
			}
			switch (mjeIn.getCodigo()){
			case CodigoPeticion.LOGEO:
				PeticionLogueo petLog = (PeticionLogueo) mjeIn.getObj();
				try {
					oos.writeObject(new Mensaje(sv.getConexionBD().login(petLog.getUsuario(), new String(petLog.getPassword())),null));		//manda mje con el código que devuelva el intento de login en la BD
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case CodigoPeticion.REGISTRO:
				PeticionRegistro petReg = (PeticionRegistro) mjeIn.getObj();
				try {
					oos.writeObject(new Mensaje(sv.getConexionBD().registro(petReg.getUsuario(),new String(petReg.getPassword()), petReg.getEmail()),
							null
							)
							);
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				/*case CodigoPeticion.REGISTROPERSONAJE:
				PeticionCrearPersonaje petCrearPersonaje = (PeticionCrearPersonaje) mjeIn.getObj();
				try {
					oos.writeObject(new Mensaje(sv.getConexionBD().registroPersonaje(petCrearPersonaje.getId_usuario(), petCrearPersonaje.getNombre(),petCrearPersonaje.getRaza(),petCrearPersonaje.getCasta(),petCrearPersonaje.getSexo(),null)));
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			case CodigoPeticion.LISTAR_RAZAS:
				PeticionListarRazas petListarRazas = (PeticionListarRazas) mjeIn.getObj();
				try{
					//ResultSet rs = sv.getConexionBD().listarRazas();
					ArrayList<String> listaRazas = sv.getConexionBD().listarRazas();
					//ArrayList<String> listaRazas = new ArrayList<String>();
					System.out.println("RESULT SET va a cargar");

					//if(rs.isAfterLast())
					if(!listaRazas.isEmpty())
					{
					Mensaje mensaje = new Mensaje(1,/*(Object)rs*/listaRazas);
					
					oos.writeObject(mensaje);
					JOptionPane.showMessageDialog(null, "pasa la conexion");
					oos.flush();
					}
					else{
						JOptionPane.showMessageDialog(null, "No se puede cargar las razas");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
	}
	}
	
		
}