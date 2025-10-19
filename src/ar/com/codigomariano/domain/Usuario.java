package ar.com.codigomariano.domain;

public class Usuario {
	private int id;
	private String nombre;
	private String mail;
	private boolean esBecario;
	
	
	public Usuario(int id,String nombre,String mail, boolean becado) {
		this.id=id;
		this.nombre=nombre;
		this.mail=mail;
		this.esBecario=becado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String isEsBecario() {
		String becado=null;
		if(esBecario) {
			becado="si";
		}else {
			becado="no";
		}
		return becado;
	}
	
	public boolean getBecario() {
		return esBecario;
	}

	public void setEsBecario(boolean esBecario) {
		this.esBecario = esBecario;
	}

	public void mostrarDatos() {
		System.out.println("-------------------");
		System.out.println("idUsuario: "+id);
		System.out.println("Nombre: "+nombre);
		System.out.println("Correo electronico: "+mail);
		System.out.println("¿Es becario?: "+isEsBecario());
	}

}
